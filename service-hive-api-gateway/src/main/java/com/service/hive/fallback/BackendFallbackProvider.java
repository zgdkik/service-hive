package com.service.hive.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * 后端服务异常、连接拒绝、超时或者熔断时的降级处理逻辑。
 */
@Component
public class BackendFallbackProvider implements ZuulFallbackProvider {

    /**
     * 所有的路由均使用该降级处理逻辑。
     *
     * @return
     */
    @Override
    public String getRoute() {
        return "*";
    }

    /**
     * 降级处理HTTP响应。
     *
     * @return
     */
    @Override
    public ClientHttpResponse fallbackResponse() {

        return new ClientHttpResponse() {

            /**
             * 服务降级时返回503（SERVICE_UNAVAILABLE）状态码。
             * @return
             * @throws IOException
             */
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.SERVICE_UNAVAILABLE;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return this.getStatusCode().value();
            }

            @Override
            public String getStatusText() throws IOException {
                return this.getStatusCode().getReasonPhrase();
            }

            @Override
            public void close() {

            }

            /**
             * 服务降级时返回相应内容。
             * @return
             * @throws IOException
             */
            @Override
            public InputStream getBody() throws IOException {
                System.out.println(FallbackInfo.instance().toString());
                return new ByteArrayInputStream(FallbackInfo.instance().toString().getBytes());
            }

            /**
             *
             * @return
             */
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                MediaType mt = new MediaType("application", "json", Charset.forName("UTF-8"));
                headers.setContentType(mt);
                return headers;
            }
        };
    }
}
