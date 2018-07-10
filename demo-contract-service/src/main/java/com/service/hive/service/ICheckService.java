package com.service.hive.service;

import com.service.hive.domain.CheckResult;
import com.service.hive.domain.ClientInfo;

public interface ICheckService {

    CheckResult check(ClientInfo client);
}
