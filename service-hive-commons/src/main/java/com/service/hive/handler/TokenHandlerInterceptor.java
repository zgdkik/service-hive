package com.service.hive.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 令牌处理拦截器，检查请求头是否带有效的令牌。
 *
 * @author kenly
 */
public class TokenHandlerInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private TokenValidator validator;

    public TokenHandlerInterceptor() {

    }

    /**
     * 拦截HTTP请求，日志记录请求URI信息，检查请求头是否带有效的令牌。
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        HttpHandler httpHandler = new HttpHeaderHandler(request, response);

        // 日志记录请求URI信息
        httpHandler.logRequest();

        // 检查请求头是否带有效的令牌
        if (!httpHandler.validateToken(this.validator)) {
            return false;
        }

        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

        HttpHandler httpHandler = new HttpHeaderHandler(request, response);
        httpHandler.addResponseTransationSN();

        super.postHandle(request, response, handler, modelAndView);
    }

}
