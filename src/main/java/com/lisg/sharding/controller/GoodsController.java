package com.lisg.sharding.controller;

import com.dangdang.ddframe.rdb.sharding.keygen.KeyGenerator;
import com.lisg.sharding.entity.Goods;
import com.lisg.sharding.repository.GoodsRepository;
import com.lisg.sharding.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: sharding-jdbc-dbt
 * @description: GoodsController
 * @author: Reagan Li
 * @create: 2019-05-24 11:10
 **/
@RestController
public class GoodsController {
    @Autowired
    private KeyGenerator keyGenerator;

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private GoodsService goodsService;

    @GetMapping("save")
    public String save(){
        for(int i= 1 ; i <= 40 ; i ++){
            Goods goods = new Goods();
            goods.setGoodsId((long) i);
            goods.setGoodsName( "shangpin" + i);
            goods.setGoodsType((long) (i+1));
            //goodsRepository.save(goods);
            goodsService.insert(goods);
        }
        return "success";
    }

    @GetMapping("select")
    public List<Goods> select(){
        //return goodsRepository.findAll().toString();
        return goodsService.selectAll();
    }

    @GetMapping("delete")
    public int delete(){
        //goodsRepository.deleteAll();
        return goodsService.deleteAll();
    }

    @GetMapping("queryBetween")
    public List<Goods> query1(){
        //return goodsRepository.findAllByGoodsIdBetween(10L, 30L);
        return goodsService.findAllByGoodsIdBetween(10L, 30L);
    }

    @GetMapping("queryIn")
    public Object query2(){
        List<Long> goodsIds = new ArrayList<>();
        goodsIds.add(10L);
        goodsIds.add(15L);
        goodsIds.add(20L);
        goodsIds.add(25L);
        //return goodsRepository.findAllByGoodsIdIn(goodsIds);
        return goodsService.findAllByGoodsIdIn(goodsIds);
    }
}
