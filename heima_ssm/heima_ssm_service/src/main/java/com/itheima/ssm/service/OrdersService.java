package com.itheima.ssm.service;

import com.itheima.ssm.domain.Orders;

import java.util.List;

/**
 * @Classname OrdersService
 * @Description TODO
 * @Date 2020/2/15 17:12
 * @Created wenjunpei
 */

public interface OrdersService {

    public List<Orders> findAll(Integer pageNum, Integer pageSize);

    public Orders findById(String id);
}
