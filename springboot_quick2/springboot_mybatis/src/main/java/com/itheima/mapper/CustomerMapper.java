package com.itheima.mapper;

import com.itheima.domain.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Classname CustomerMapper
 * @Description TODO
 * @Date 2020/2/21 12:54
 * @Created wenjunpei
 */
@Mapper
public interface CustomerMapper {

    public List<Customer> findAll();
}
