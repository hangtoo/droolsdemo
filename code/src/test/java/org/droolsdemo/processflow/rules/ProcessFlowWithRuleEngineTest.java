package org.droolsdemo.processflow.rules;

import org.apache.log4j.Logger;
import org.droolsdemo.processflow.ProcessData;
import org.junit.Assert;
import org.junit.Test;

public class ProcessFlowWithRuleEngineTest {

    private Logger LOG = Logger.getLogger(getClass());

    @Test
    public void testCanReachGate1() {
        ProcessFlowWithRuleEngine cut = new ProcessFlowWithRuleEngine();

        ProcessData processData = new ProcessData();
        processData.setBonusAvailable(true);
        processData.setBusinessCustomer(false);
        processData.setGate(2);

        boolean result = cut.canReachGate1(new ProcessDataRequest(processData));
        Assert.assertTrue(result);
    }
}
