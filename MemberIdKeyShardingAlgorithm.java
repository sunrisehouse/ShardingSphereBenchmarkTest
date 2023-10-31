package com.example.shardingsphereserver;

import java.util.Collection;

import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;

public class MemberIdKeyShardingAlgorithm implements StandardShardingAlgorithm<String> {

    @Override
    public String doSharding(
        Collection<String> availableTargetNames,
        PreciseShardingValue<String> shardingValue
    ) {
        final int numOfShard = availableTargetNames.size();
        final String shardingKey = shardingValue.getValue();
        for (String each: availableTargetNames) {
            if (each.endsWith(String.valueOf(
                Integer.valueOf(shardingKey) % numOfShard + 1
            ))) {
                return each;
            }
        }
        return null;
    }

    @Override
    public Collection<String> doSharding(
        Collection<String> availableTargetNames,
        RangeShardingValue<String> shardingValue
    ) {
        // don't use the range sharding
        return availableTargetNames;
    }

}
