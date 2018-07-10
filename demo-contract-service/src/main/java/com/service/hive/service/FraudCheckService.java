package com.service.hive.service;

import com.service.hive.domain.CheckResult;
import com.service.hive.domain.ClientInfo;
import org.springframework.stereotype.Service;

@Service
public class FraudCheckService implements ICheckService {

    @Override
    public CheckResult check(ClientInfo client) {
        if (client == null || client.getClientId() == null || client.getClientId().isEmpty()) {
            return null;
        }

        CheckResult result = new CheckResult();
        if ("1234567890".equals(client.getClientId()) && client.getLoanAmount() == 99999) {
            result.setFraudCheckStatus("FRAUD");
            result.setRejectionReason("Amount too high");
        }

        return result;
    }
}
