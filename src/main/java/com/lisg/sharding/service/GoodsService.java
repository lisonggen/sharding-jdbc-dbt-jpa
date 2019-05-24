package com.lisg.sharding.service;

import com.lisg.sharding.entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsService {
    void insert(Goods goods);

    List<Goods> selectAll();

    int deleteAll();

    List<Goods> findAllByGoodsIdBetween(Long id0, Long id1);

    List<Goods> findAllByGoodsIdIn(List<Long> goodsIds);
}
