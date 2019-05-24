package com.lisg.sharding.config;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.SingleKeyDatabaseShardingAlgorithm;
import com.google.common.collect.Range;
import com.lisg.sharding.database.Database0Config;
import com.lisg.sharding.database.Database1Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * @program: sharding-jdbc-dbt
 * @description: DatabaseShardingAlgorithm
 * @author: Reagan Li
 * @create: 2019-05-24 11:07
 **/

/**
 * 这里使用的都是单键分片策略
 * 示例分库策略是：
 * GoodsId<=20使用database0库
 * 其余使用database1库
 */
@Component
public class DatabaseShardingAlgorithm implements SingleKeyDatabaseShardingAlgorithm<Long> {

    @Autowired
    private Database0Config database0Config;

    @Autowired
    private Database1Config database1Config;

    /**
     * SQL中==的规则。
     * @param availableTargetNames
     * @param shardingValue
     * @return
     */
    @Override
    public String doEqualSharding(Collection<String> availableTargetNames, ShardingValue<Long> shardingValue) {
        Long value = shardingValue.getValue();
        if (value <= 20L) {
            return database0Config.getDatabaseName();
        } else {
            return database1Config.getDatabaseName();
        }
    }

    /**
     * SQL中in的规则。
     * @param availableTargetNames
     * @param shardingValue
     * @return
     */
    @Override
    public Collection<String> doInSharding(Collection<String> availableTargetNames, ShardingValue<Long> shardingValue) {
        Collection<String> result = new LinkedHashSet<>(availableTargetNames.size());
        for (Long value : shardingValue.getValues()) {
            if (value <= 20L) {
                result.add(database0Config.getDatabaseName());
            } else {
                result.add(database1Config.getDatabaseName());
            }
        }
        return result;
    }

    /**
     * SQL中between的规则。
     * @param availableTargetNames
     * @param shardingValue
     * @return
     */
    @Override
    public Collection<String> doBetweenSharding(Collection<String> availableTargetNames,
                                                ShardingValue<Long> shardingValue) {
        Collection<String> result = new LinkedHashSet<>(availableTargetNames.size());
        Range<Long> range = shardingValue.getValueRange();
        for (Long value = range.lowerEndpoint(); value <= range.upperEndpoint(); value++) {
            if (value <= 20L) {
                result.add(database0Config.getDatabaseName());
            } else {
                result.add(database1Config.getDatabaseName());
            }
        }
        return result;
    }
}
