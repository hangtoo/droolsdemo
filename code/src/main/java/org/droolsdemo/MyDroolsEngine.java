package org.droolsdemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.ReleaseId;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

public class MyDroolsEngine {

    private KieContainer kieContainer;
    private ThreadLocal<KieSession> threadLocal = new ThreadLocal<>();


    public void loadRules(String... filenames) {
        KieServices ks = KieServices.Factory.get();
        KieRepository kr = ks.getRepository();
        KieFileSystem kfs = ks.newKieFileSystem();

        for(String filename : filenames){
            try {
                String rule = getRuleContent(filename);
                Resource ressource = ks.getResources().newByteArrayResource(rule.getBytes("UTF-8"), "UTF-8");
                ressource.setTargetPath("src/main/resources/" + filename + ".drl");
                kfs.write(ressource);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }            
        }

        KieBuilder kb = ks.newKieBuilder(kfs);
        kb.buildAll();
        ReleaseId releaseId = kr.getDefaultReleaseId();
        this.kieContainer = ks.newKieContainer(releaseId);
    }

    public long run(Object message) {
        KieSession kieSession = getSession();
        long start = System.nanoTime();

        FactHandle factHandle = kieSession.insert(message);

        kieSession.fireAllRules();

        kieSession.delete(factHandle);

        long end = System.nanoTime();
        return end - start;
    }


    protected KieSession getSession() {
        KieSession kieSession = null;

        if (threadLocal.get() == null) {
            synchronized (threadLocal) {
                kieSession = kieContainer.newKieSession();
                threadLocal.set(kieSession);
            }
        } else {
            kieSession = threadLocal.get();
        }

        return kieSession;
    }

    private String getRuleContent(String filename) throws IOException, FileNotFoundException {
        String rule = IOUtils.toString(new FileInputStream(new File(getClass().getResource(filename).getFile())));
        return rule;
    }

}
