package com.service.hive.handler;

/**
 * 令牌验证。
 *
 * @author kenly
 */
public interface TokenValidator {
    boolean validate(Object token);
}
