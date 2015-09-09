package org.droolsdemo.processflow.rules;

import org.droolsdemo.MyDroolsEngine;
import org.droolsdemo.processflow.ProcessData;

public class ProcessFlowWithRuleEngine {

    private MyDroolsEngine ruleEngine;

    protected MyDroolsEngine getEngine() {
        if (ruleEngine == null) {
            ruleEngine = new MyDroolsEngine();
        }
        ruleEngine.loadRules("");
        return ruleEngine;
    }

    public boolean canReachGate1(ProcessData input) {
        getEngine().run(input);
        return false;
    }
}
