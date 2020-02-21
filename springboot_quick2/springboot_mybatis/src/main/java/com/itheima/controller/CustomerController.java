package com.itheima.controller;

import com.itheima.domain.Customer;
import com.itheima.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Classname CustomerController
 * @Description TODO
 * @Date 2020/2/21 13:06
 * @Created wenjunpei
 */
@RestController
public class CustomerController {

    @Autowired
    private CustomerMapper customerMapper;

    @RequestMapping("/findAll")
    public List<Customer> findAll() {
        return  customerMapper.findAll();
    }
}
