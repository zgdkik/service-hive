package com.service.hive.ribbon.metadata;

import org.junit.Assert;
import org.junit.Test;

public class DefaultRequestMetadataTest {

    @Test
    public void init() throws Exception {

        RequestMetadata requestMetadata = RequestMetadata.getCurrent().init();
        String key = "key-DefaultRequestMetadata-init";

        requestMetadata.add(key, "value1");
        String v = requestMetadata.metadatas().get(key);
        Assert.assertNotNull(v);

        requestMetadata.init();
        v = requestMetadata.metadatas().get(key);
        Assert.assertNull(v);
    }

    @Test
    public void add() throws Exception {
        RequestMetadata requestMetadata = RequestMetadata.getCurrent().init();
        String key = "key-DefaultRequestMetadata-add";

        requestMetadata.add(key, "value1");
        String v = requestMetadata.metadatas().get(key);
        Assert.assertEquals("value1", v);
    }

    @Test
    public void metadatas() throws Exception {
        RequestMetadata requestMetadata = RequestMetadata.getCurrent().init();
        String key = "key-DefaultRequestMetadata-metadatas";

        requestMetadata.add(key, "value1");
        String v = requestMetadata.metadatas().get(key);
        Assert.assertEquals("value1", v);
    }

}