package com.service.hive.fallback;

import com.google.gson.Gson;
import org.springframework.http.HttpStatus;

/**
 * 服务降级时返回相应内容。
 */
public class FallbackInfo {

    private String serviceId;
    private HttpStatus status;
    private int code;
    private String message;

    public static FallbackInfo instance(String serviceId) {
        return instance().serviceId(serviceId);
    }

    public static FallbackInfo instance() {
        return new FallbackInfo()
                .message("BACKEND SERVICE UNAVAILABLE, PLEASE RETRY LATER. ")
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .code(HttpStatus.SERVICE_UNAVAILABLE.value());
    }

    public String getServiceId() {
        return serviceId;
    }

    public FallbackInfo serviceId(String serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public FallbackInfo status(HttpStatus status) {
        this.status = status;
        return this;
    }

    public int getCode() {
        return code;
    }

    public FallbackInfo code(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public FallbackInfo message(String message) {
        this.message = message;
        return this;
    }

    /**
     * toJson
     *
     * @return
     */
    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }


}
