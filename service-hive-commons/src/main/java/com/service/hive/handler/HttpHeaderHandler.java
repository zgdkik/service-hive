package com.service.hive.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;


/**
 * 处理HTTP请求，日志记录请求URI信息，往响应头添加事务流水号，检查请求头是否带有效的令牌。
 *
 * @author kenly
 */
public class HttpHeaderHandler implements HttpHandler {

    private static Logger log = LoggerFactory.getLogger(HttpHeaderHandler.class);
    private HttpServletRequest request;
    private HttpServletResponse response;

    public HttpHeaderHandler(HttpServletRequest request, HttpServletResponse response) {
        prepareHttp(request, response);
    }

    private void prepareHttp(HttpServletRequest request, HttpServletResponse response) {
        if (null == request) {
            throw new IllegalArgumentException("Please provide argument request!");
        }

        if (null == response) {
            throw new IllegalArgumentException("Please provide argument response!");
        }

        this.request = request;
        this.response = response;
    }

    /**
     * 产生新的事务流水号。
     */
    @Override
    public String newTransationSN() {
        return UUID.randomUUID().toString();
    }

    /**
     * 日志记录请求URI信息。
     */
    @Override
    public void logRequest(String newTransationSN) {
        String queryString = request.getQueryString();
        StringBuilder content = new StringBuilder();
        content.append(String.format("%s request to %s", request.getMethod(), request.getRequestURI()));
        if (null != queryString) {
            content.append("?" + queryString);
        }

        String transationSN = (newTransationSN != null) ? newTransationSN : getRequestTransationSN();
        content.append(". " + ExtendedHeaders.TRANS_SN + ":" + transationSN);

        String token = getRequestToken();
        content.append(", " + ExtendedHeaders.AUTH_TOKEN + ":" + token);

        log.info(content.toString());
    }

    /**
     * 日志记录请求URI信息。
     */
    @Override
    public void logRequest() {
        String newTransationSN = null;
        this.logRequest(newTransationSN);
    }

    /**
     * 检查请求头是否带有效的令牌。
     *
     * @return
     */
    @Override
    public boolean validateToken(TokenValidator validator) {
        if (null == validator) {
            throw new IllegalArgumentException("Please provide argument validator!");
        }

        String token = getRequestToken();
        if (!validator.validate(token)) {
            response.setStatus(401);
            log.info("Token from the request is invalid! " + ExtendedHeaders.AUTH_TOKEN + ":" + token);
            return false;
        }

        return true;
    }

    /**
     * 往响应头添加事务流水号。
     */
    @Override
    public void addResponseTransationSN(String transationSN) {
        response.addHeader(ExtendedHeaders.TRANS_SN, transationSN);
        log.info(String.format("Append %s to response: %s.", ExtendedHeaders.TRANS_SN, transationSN));
    }

    /**
     * 如果请求头里存在事务流水号，往响应头添加事务流水号。
     */
    @Override
    public void addResponseTransationSN() {
        String transationSN = this.getRequestTransationSN();
        if (null == transationSN) {
            return;
        }

        if (null == getResponseTransationSN()) {
            addResponseTransationSN(transationSN);
        }
    }

    /**
     * 获取请求头里的事务流水号。
     */
    @Override
    public String getRequestTransationSN() {
        return getRequestHeader(ExtendedHeaders.TRANS_SN);
    }

    /**
     * 获取响应头里的事务流水号。
     */
    @Override
    public String getResponseTransationSN() {
        return getResponseHeader(ExtendedHeaders.TRANS_SN);
    }

    /**
     * 获取请求头里的令牌。
     */
    @Override
    public String getRequestToken() {
        return getRequestHeader(ExtendedHeaders.AUTH_TOKEN);
    }

    /**
     * @param key
     * @return
     */
    public String getRequestHeader(String key) {
        if (null == key) {
            return null;
        }

        return request.getHeader(key);
    }

    /**
     * @param key
     * @return
     */
    public String getResponseHeader(String key) {
        if (null == key) {
            return null;
        }

        return response.getHeader(key);
    }

}
