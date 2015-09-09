package org.droolsdemo.processflow;

public class ProcessData {

    private int gate;
    private boolean payloadAvailable;
    private boolean businessCustomer;
    private boolean bonusAvailable;

    public int getGate() {
        return gate;
    }

    public void setGate(int gate) {
        this.gate = gate;
    }

    public boolean isPayloadAvailable() {
        return payloadAvailable;
    }

    public void setPayloadAvailable(boolean payloadAvailable) {
        this.payloadAvailable = payloadAvailable;
    }

    public boolean isBusinessCustomer() {
        return businessCustomer;
    }

    public void setBusinessCustomer(boolean businessCustomer) {
        this.businessCustomer = businessCustomer;
    }

    public boolean isBonusAvailable() {
        return bonusAvailable;
    }

    public void setBonusAvailable(boolean bonusAvailable) {
        this.bonusAvailable = bonusAvailable;
    }

}
