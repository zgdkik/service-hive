package com.service.hive.handler;

/**
 * 简单令牌验证，只用于测试。
 *
 * @author kenly
 */
public class SimpleTokenValidator implements TokenValidator {

    @Override
    public boolean validate(Object token) {
        if (null == token) {
            return false;
        }

        return true;
    }

}
