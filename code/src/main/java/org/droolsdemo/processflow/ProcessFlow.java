package org.droolsdemo.processflow;

public class ProcessFlow {

    public boolean canReachGate1(ProcessData input) {
        boolean result = false;
        if (input.isBonusAvailable() && !input.isBusinessCustomer()) {
            if (input.getGate() >= 1 && input.getGate() < 5) {
                result = true;
            }
        }
        return result;
    }

    public boolean canReachGate2(ProcessData input) {
        boolean result = false;
        if (canReachGate1(input)) {
            if (!input.isPayloadAvailable()) {
                result = true;
            }
        }
        return result;
    }

    public boolean canReachGate3(ProcessData input){
        boolean result = true;
        if(canReachGate1(input) && canReachGate2(input)){
            result = false;
        }
        return result;
    }
}
