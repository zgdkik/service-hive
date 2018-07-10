package com.service.hive.domain;

public class ClientInfo {

    String clientId;
    Integer loanAmount;

    public String getClientId() {
        return clientId;
    }

    public ClientInfo clientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    public Integer getLoanAmount() {
        return loanAmount;
    }

    public ClientInfo loanAmount(Integer loanAmount) {
        this.loanAmount = loanAmount;
        return this;
    }

}
