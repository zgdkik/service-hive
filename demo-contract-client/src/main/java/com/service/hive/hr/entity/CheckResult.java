package com.service.hive.hr.entity;

public class CheckResult {

    String fraudCheckStatus;
    String rejectionReason;

    public String getFraudCheckStatus() {
        return fraudCheckStatus;
    }

    public void setFraudCheckStatus(String fraudCheckStatus) {
        this.fraudCheckStatus = fraudCheckStatus;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

}
