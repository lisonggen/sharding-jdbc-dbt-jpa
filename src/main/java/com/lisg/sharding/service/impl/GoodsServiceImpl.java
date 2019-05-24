package com.lisg.sharding.service.impl;

import com.lisg.sharding.entity.Goods;
import com.lisg.sharding.mapper.GoodsMapper;
import com.lisg.sharding.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: sharding-jdbc-dbt
 * @description: GoodsServiceImpl
 * @author: Reagan Li
 * @create: 2019-05-24 13:55
 **/
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public void insert(Goods goods) {
        goodsMapper.insert(goods);
    }

    @Override
    public List<Goods> selectAll() {
        return goodsMapper.selectAll();
    }

    @Override
    public int deleteAll() {
        return goodsMapper.deleteAll();
    }

    @Override
    public List<Goods> findAllByGoodsIdBetween(Long id0, Long id1) {
        return goodsMapper.findAllByGoodsIdBetween(id0, id1);
    }

    @Override
    public List<Goods> findAllByGoodsIdIn(List<Long> goodsIds) {
        return goodsMapper.findAllByGoodsIdIn(goodsIds);
    }
}
