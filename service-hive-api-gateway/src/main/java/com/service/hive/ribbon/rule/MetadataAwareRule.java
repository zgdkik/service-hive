package com.service.hive.ribbon.rule;

import com.netflix.loadbalancer.AbstractServerPredicate;
import com.netflix.loadbalancer.AvailabilityPredicate;
import com.netflix.loadbalancer.CompositePredicate;
import com.netflix.loadbalancer.PredicateBasedRule;

import java.util.Objects;

/**
 * 元数据负载均衡策略，优先匹配元数据选择服务端。
 */
public class MetadataAwareRule extends PredicateBasedRule {

    private final CompositePredicate predicate;

    public MetadataAwareRule(){
        this(new MetadataAwarePredicate());
    }

    /**
     * 元数据负载均衡策略，优先匹配元数据选择服务端。
     * @param metadataAwarePredicate
     */
    public MetadataAwareRule(MetadataAwarePredicate metadataAwarePredicate) {
        Objects.requireNonNull(metadataAwarePredicate);
        this.predicate = createCompositePredicate(metadataAwarePredicate,
                new AvailabilityPredicate(this, null));
    }

    /**
     * 返回负载均衡器选择断言，组合两种断言。。
     * @return
     */
    @Override
    public AbstractServerPredicate getPredicate() {
        return predicate;
    }

    /**
     * 组合两种断言，优先执行元数据断言。
     * @param metadataAwarePredicate
     * @param availabilityPredicate
     * @return
     */
    private CompositePredicate createCompositePredicate(MetadataAwarePredicate metadataAwarePredicate,
                                                        AvailabilityPredicate availabilityPredicate) {
        return CompositePredicate.withPredicates(metadataAwarePredicate, availabilityPredicate)
                .build();
    }
}
