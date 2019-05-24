package com.lisg.sharding.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: sharding-jdbc-dbt
 * @description: Goods
 * @author: Reagan Li
 * @create: 2019-05-24 10:54
 **/
@Entity
@Table(name="goods")
@Data
public class Goods {

    @Id
    private Long goodsId;

    private String goodsName;

    private Long goodsType;

}
