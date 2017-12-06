package com.service.hive.handler;

/**
 * 处理HTTP请求，日志记录请求URI信息，往响应头添加事务流水号，检查请求头是否带有效的令牌。
 *
 * @author kenly
 */
public interface HttpHandler {

    /**
     * 产生新的事务流水号。
     *
     * @return
     */
    String newTransationSN();

    /**
     * 日志记录请求URI信息。
     */
    void logRequest();

    /**
     * 日志记录请求URI信息。
     *
     * @param newTransationSN
     */
    void logRequest(String newTransationSN);

    /**
     * 检查请求头是否带有效的令牌。
     *
     * @return
     */
    boolean validateToken(TokenValidator validator);

    /**
     * 往响应头添加事务流水号。
     *
     * @param transationSN
     */
    void addResponseTransationSN(String transationSN);

    /**
     * 如果请求头里存在事务流水号，往响应头添加事务流水号。
     */
    void addResponseTransationSN();


    /**
     * 获取请求头里的事务流水号。
     *
     * @return
     */
    String getRequestTransationSN();

    /**
     * 获取响应头里的事务流水号。
     *
     * @return
     */
    String getResponseTransationSN();

    /**
     * 获取请求头里的令牌。
     *
     * @return
     */
    String getRequestToken();

}