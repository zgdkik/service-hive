package com.service.hive.ribbon.metadata;

import java.util.Map;

/**
 * 使用哈希表存储当前线程的数据，在HTTP请求时注入元数据，后续的HTTP请求处理使用该元数据。
 */
public interface RequestMetadata {

    /**
     *创建RequestMetadata实例，处理当前线程的元数据。
     * @return
     */
    static RequestMetadata getCurrent() {
        return new DefaultRequestMetadata();
    }

    /**
     *初始化（清理）当前线程的元数据。
     * @return
     */
    RequestMetadata init();

    /**
     *添加元数据到当前线程。
     * @param key
     * @param value
     * @return
     */
    RequestMetadata add(String key, String value);

    /**
     *获取当前线程的所有元数据。
     * @return
     */
    Map<String, String> metadatas();
}
