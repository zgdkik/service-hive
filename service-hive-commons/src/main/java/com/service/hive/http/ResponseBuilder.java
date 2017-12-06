package com.service.hive.http;

import org.springframework.http.HttpStatus;

import com.service.hive.http.BadResponse.BadResponseBuilder;
import com.service.hive.http.OkResponse.OkResponseBuilder;

/**
 * @author kenly
 */
public class ResponseBuilder {

    public static BadResponseBuilder bad(HttpStatus status) {
        return BadResponse.status(status);
    }

    public static BadResponseBuilder bad() {
        return ResponseBuilder.bad(HttpStatus.BAD_REQUEST);
    }

    public static OkResponseBuilder ok(HttpStatus status) {
        return OkResponse.status(status);
    }

    public static OkResponseBuilder ok() {
        return ResponseBuilder.ok(HttpStatus.OK);
    }

}
