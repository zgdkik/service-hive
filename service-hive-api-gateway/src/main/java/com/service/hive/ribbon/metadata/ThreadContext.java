package com.service.hive.ribbon.metadata;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 使用哈希表存储当前线程的数据，在某个时机时注入数据，后续的处理中使用该数据。
 */
public class ThreadContext {

    /**
     * 线程本地变量，用于存储当前线程的数据，每个线程独立存储。
     */
    private static final ThreadLocal<Map<String, String>> threadLocal = new InheritableThreadLocal<Map<String, String>>() {
        @Override
        protected Map<String, String> initialValue() {
            return new HashMap<String, String>();
        }
    };

    /**
     * 获取当前线程关联的哈希表。
     * @return
     */
    private static Map<String, String> getCurrentMap() {
        return threadLocal.get();
    }

    /**
     * 往当前线程关联的哈希表添加键值对。
     * @param key
     * @param value
     * @return
     */
    public static String put(String key, String value) {
        return getCurrentMap().put(key, value);
    }

    /**
     * 根据键从当前线程关联的哈希表获取一个值。
     * @param key
     * @return
     */
    public static String get(String key) {
        return getCurrentMap().get(key);
    }

    /**
     * 从当前线程关联的哈希表移除一个键值对。
     * @param key
     * @return
     */
    public static String remove(String key) {
        return getCurrentMap().remove(key);
    }

    /**
     * 删除当前线程关联的哈希表。
     */
    public static void clearContext() {
        threadLocal.remove();
    }

    /**
     * 获取当前线程关联的哈希表，并转换成不可修改哈希表。
     * @return
     */
    public static Map<String, String> unmodifiableMap() {
        return Collections.unmodifiableMap(getCurrentMap());
    }
}
