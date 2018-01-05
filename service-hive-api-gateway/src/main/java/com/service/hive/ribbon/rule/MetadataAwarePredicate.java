package com.service.hive.ribbon.rule;

import com.netflix.loadbalancer.AbstractServerPredicate;
import com.netflix.loadbalancer.PredicateKey;
import com.netflix.niws.loadbalancer.DiscoveryEnabledServer;
import com.service.hive.ribbon.metadata.RequestMetadata;
import java.util.Map;
import java.util.Set;

/**
 * 根据服元数据选择服务实例的断言。
 */
public class MetadataAwarePredicate extends AbstractServerPredicate {

    /**
     * 执行断言，判断该服务实例是否满足条件。
     * @param input 服务实例。
     * @return
     */
    @Override
    public boolean apply(PredicateKey input) {
        return input != null
                && input.getServer() instanceof DiscoveryEnabledServer
                && apply((DiscoveryEnabledServer) input.getServer());
    }

    /**
     * 执行断言，判断该服务实例是否满足条件。
     * @param server
     * @return
     */
    protected boolean apply(DiscoveryEnabledServer server) {
        RequestMetadata requestMetadata=RequestMetadata.getCurrent();
        //当前线程的元数据。
        final Set<Map.Entry<String, String>> attributes = requestMetadata.metadatas().entrySet();

        //服务实例的元数据。
        final Map<String, String> metadata = server.getInstanceInfo().getMetadata();
        return metadata.entrySet().containsAll(attributes);
    }
}
