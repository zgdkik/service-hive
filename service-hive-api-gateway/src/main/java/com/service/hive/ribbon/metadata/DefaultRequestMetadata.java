package com.service.hive.ribbon.metadata;

import java.util.Map;

/**
 * 使用哈希表存储当前线程的数据，在HTTP请求时注入元数据，后续的HTTP请求处理使用该元数据。
 */
public class DefaultRequestMetadata  implements RequestMetadata{
    /**
     * 初始化（清理）当前线程的元数据。
     * @return
     */
    @Override
    public RequestMetadata init() {
        ThreadContext.clearContext();
        return this;
    }

    /**
     * 加元数据到当前线程。
     * @param key
     * @param value
     * @return
     */
    @Override
    public RequestMetadata add(String key, String value) {
        ThreadContext.put(key, value);
        return this;
    }

    /**
     * 获取当前线程的所有元数据。
     * @return
     */
    @Override
    public Map<String, String> metadatas() {
        return ThreadContext.unmodifiableMap();
    }

}
