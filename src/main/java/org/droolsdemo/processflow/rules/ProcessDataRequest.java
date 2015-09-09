package org.droolsdemo.processflow.rules;

import org.droolsdemo.processflow.ProcessData;

public class ProcessDataRequest {

    private ProcessData input;

    private boolean canReachGate1;
    private boolean canReachGate2;
    private boolean canReachGate3;

    public ProcessDataRequest(ProcessData input) {
        this.input = input;
    }

    public ProcessData getInput() {
        return input;
    }

    public void setInput(ProcessData input) {
        this.input = input;
    }

    public boolean isCanReachGate1() {
        return canReachGate1;
    }

    public void setCanReachGate1(boolean canReachGate1) {
        this.canReachGate1 = canReachGate1;
    }

    public boolean isCanReachGate2() {
        return canReachGate2;
    }

    public void setCanReachGate2(boolean canReachGate2) {
        this.canReachGate2 = canReachGate2;
    }

    public boolean isCanReachGate3() {
        return canReachGate3;
    }

    public void setCanReachGate3(boolean canReachGate3) {
        this.canReachGate3 = canReachGate3;
    }

}
