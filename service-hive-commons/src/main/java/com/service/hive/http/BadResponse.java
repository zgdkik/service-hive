package com.service.hive.http;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author kenly
 */
public class BadResponse {
    private String status;
    private ErrorMessage error;
    private ResponseEntity<Object> response;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ErrorMessage getError() {
        return error;
    }

    public void setError(ErrorMessage erroe) {
        this.error = erroe;
    }

    private ResponseEntity<Object> getResponse() {
        return response;
    }

    private void setResponse(ResponseEntity<Object> response) {
        this.response = response;
    }

    private BadResponse(BadResponseBuilder builder) {
        this.setStatus("failed");
        this.setError(new ErrorMessage());
        this.getError().setCode(builder.getCode());
        this.getError().setMessge(builder.getMessge());
        this.setResponse(ResponseEntity.status(builder.getStatus()).body(this));
    }

    public static BadResponseBuilder status(HttpStatus status) {
        return new BadResponseBuilder().status(status);
    }

    public static class BadResponseBuilder {
        private HttpStatus status;
        private String code;
        private String messge;

        public HttpStatus getStatus() {
            return status;
        }

        public BadResponseBuilder status(HttpStatus status) {
            this.status = status;
            return this;
        }

        public String getCode() {
            return code;
        }

        public BadResponseBuilder code(String code) {
            this.code = code;
            return this;
        }

        public String getMessge() {
            return messge;
        }

        public BadResponseBuilder messge(String messge) {
            this.messge = messge;
            return this;
        }

        public BadResponse build() {
            return new BadResponse(this);
        }

        public ResponseEntity<Object> buildEntity() {
            return new BadResponse(this).getResponse();
        }
    }

}
