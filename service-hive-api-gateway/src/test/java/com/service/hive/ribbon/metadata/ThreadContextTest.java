package com.service.hive.ribbon.metadata;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ThreadContextTest {

    @Test
    public void putParallel() throws Exception {
        String key = "key-put";
        String v = "value-put";
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            map.put(key + i, v + i);
        }
        //并行加入线程的变量中
        map.entrySet().parallelStream().forEach(e -> ThreadContext.put(e.getKey(), e.getValue()));

        //获取当前线程的变量（哈希表）
        Map<String, String> resultMap = ThreadContext.unmodifiableMap();
        System.out.println("resultMap.size()="+resultMap.size());
        Assert.assertEquals(true, resultMap.size()>0);

        //判断当前线程的变量（哈希表）的正确性
        resultMap.entrySet().stream().forEach(e -> Assert.assertEquals(e.getKey().charAt(e.getKey().length()-1), e.getValue().charAt(e.getValue().length()-1)));
    }

    @Test
    public void putAndGet() throws Exception {
        String key = "key-get";
        ThreadContext.put(key, "value1");
        String v = ThreadContext.get(key);

        Assert.assertEquals("value1", v);
    }

    @Test
    public void remove() throws Exception {
        String key = "key-remove";
        ThreadContext.put(key, "value1");
        ThreadContext.remove(key);
        String v = ThreadContext.get(key);

        Assert.assertEquals(null, v);
    }

    @Test
    public void clearContext() throws Exception {
        String key = "key-clearContext";
        ThreadContext.put(key, "value1");
        ThreadContext.clearContext();
        String v = ThreadContext.get(key);

        Assert.assertEquals(null, v);
    }

    @Test
    public void unmodifiableMap() throws Exception {
        String key = "key-get";
        ThreadContext.put(key, "value1");
        Boolean v = ThreadContext.unmodifiableMap().containsKey(key);

        Assert.assertEquals(true, v);
    }

}