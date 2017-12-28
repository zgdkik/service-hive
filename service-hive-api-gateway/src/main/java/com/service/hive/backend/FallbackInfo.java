package com.service.hive.backend;

import com.google.gson.Gson;

/**
 * 服务降级时返回相应内容。
 */
public class FallbackInfo {

    private String errorCode;
    private String reasonPhrase;

    public String getErrorCode() {
        return errorCode;
    }

    public FallbackInfo errorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }

    public FallbackInfo reasonPhrase(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
        return this;
    }

    public static FallbackInfo instance(){
        return new FallbackInfo().reasonPhrase("BACKEND SERVICE UNAVAILABLE, PLEASE RETRY LATER. ");
    }

    /**
     * toJson
     * @return
     */
    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
