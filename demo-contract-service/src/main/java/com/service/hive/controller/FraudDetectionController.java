package com.service.hive.controller;

import com.service.hive.domain.CheckResult;
import com.service.hive.domain.ClientInfo;
import com.service.hive.service.ICheckService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/check")
public class FraudDetectionController {

    @Autowired
    ICheckService checkService;

    @ApiOperation(value = "欺诈检测")
    @ApiImplicitParams({@ApiImplicitParam(name = "client", value = "客户ID及负债", required = true, dataType = "ClientInfo", paramType = "body")})
    @PutMapping("/fraudcheck")
    public CheckResult fraudcheck(@RequestBody ClientInfo client) {

        return checkService.check(client);
    }

}
