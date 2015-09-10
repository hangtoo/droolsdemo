package org.droolsdemo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyDroolsEngineTest {

    private MyDroolsEngine cut;

    @Before
    public void setup() {
        cut = new MyDroolsEngine();
    }

    @Test
    public void testAclPositive() {
        cut.loadRules("acl.drl");

        AclRequest request = new AclRequest();
        request.setUsername("mike.miller");
        request.setResourceId("login");
        cut.run(request);

        Assert.assertTrue(request.isGranted());

    }

    @Test
    public void testAclNegative() {
        cut.loadRules("acl.drl");

        AclRequest request = new AclRequest();
        request.setUsername("mad.max");
        request.setResourceId("login");
        cut.run(request);

        Assert.assertFalse(request.isGranted());

    }

    @Test
    public void testRuleCompilationError() {
        cut.loadRules("ruleCompilationError.drl");

        AclRequest request = new AclRequest();
        request.setUsername("mike.miller");
        request.setResourceId("login");
        long duration = cut.run(request);

        Assert.assertTrue(request.isGranted());

    }


}
