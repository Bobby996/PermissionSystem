package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Classname TravellerDao
 * @Description TODO
 * @Date 2020/2/15 19:55
 * @Created wenjunpei
 */
public interface TravellerDao {

    @Select("select * from orders,traveller,order_traveller where orders.id = order_traveller.orderId and order_traveller.travellerId = traveller.id and orders.id = #{ordersId}")
    public List<Traveller> findByOrdersId(String ordersId);
}
