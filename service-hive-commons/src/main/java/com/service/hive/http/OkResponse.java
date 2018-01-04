package com.service.hive.http;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author kenly
 */
public class OkResponse {
    private String status;
    private Object result;

    private ResponseEntity<Object> response;

    private OkResponse(OkResponseBuilder builder) {
        this.setStatus("success");
        this.setResult(builder.getResult());
        this.setResponse(ResponseEntity.status(builder.getStatus()).body(this));
    }

    public static OkResponseBuilder status(HttpStatus status) {
        return new OkResponseBuilder().status(status);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    private ResponseEntity<Object> getResponse() {
        return response;
    }

    private void setResponse(ResponseEntity<Object> response) {
        this.response = response;
    }

    public static class OkResponseBuilder {
        private HttpStatus status;
        private Object result;

        public HttpStatus getStatus() {
            return status;
        }

        public OkResponseBuilder status(HttpStatus status) {
            this.status = status;
            return this;
        }

        public Object getResult() {
            return result;
        }

        public OkResponseBuilder result(Object result) {
            this.result = result;
            return this;
        }

        public OkResponse build() {
            return new OkResponse(this);
        }

        public ResponseEntity<Object> buildEntity() {
            return new OkResponse(this).getResponse();
        }

    }

}
