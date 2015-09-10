package org.droolsdemo.processflow.rules;

import org.droolsdemo.MyDroolsEngine;

public class ProcessFlowWithRuleEngine {

    private MyDroolsEngine ruleEngine;

    protected MyDroolsEngine getEngine() {
        if (ruleEngine == null) {
            ruleEngine = new MyDroolsEngine();
        }
        ruleEngine.loadRules("ruleProcessFlow.drl");
        return ruleEngine;
    }

    public boolean canReachGate1(ProcessDataRequest input) {

        getEngine().run(input);

        return input.isCanReachGate1();
    }
}
