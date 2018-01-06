package com.service.hive.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AccessTokenFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(AccessTokenFilter.class);

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        Object token = request.getHeaders("token");

        //校验token
        if (token == null || "".equals(token)) {
            logger.info("token为空，禁止访问!");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        } else {
            ctx.setSendZuulResponse(true);
            ctx.setResponseStatusCode(200);
        }

        //添加Basic Auth认证信息
        ctx.addZuulRequestHeader("Authorization", "Basic " + getBase64Credentials("app01", "*****"));

        return null;
    }

    private String getBase64Credentials(String username, String password) {
        String plainCreds = username + ":" + password;
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        return new String(base64CredsBytes);
    }
}