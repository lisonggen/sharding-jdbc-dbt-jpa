package com.lisg.sharding.repository;

import com.lisg.sharding.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: sharding-jdbc-dbt
 * @description: GoodsRepository
 * @author: Reagan Li
 * @create: 2019-05-24 10:56
 **/
public interface GoodsRepository extends JpaRepository<Goods, Long> {

    List<Goods> findAllByGoodsIdBetween(Long goodsId1,Long goodsId2);

    List<Goods> findAllByGoodsIdIn(List<Long> goodsIds);

}
