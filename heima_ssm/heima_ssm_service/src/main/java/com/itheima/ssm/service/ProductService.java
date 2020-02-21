package com.itheima.ssm.service;

import com.itheima.ssm.domain.Product;

import java.util.List;

/**
 * @Classname ProductService
 * @Description TODO
 * @Date 2020/2/15 13:30
 * @Created wenjunpei
 */
public interface ProductService {

    public List<Product> findAll();

    void save(Product product);
}
