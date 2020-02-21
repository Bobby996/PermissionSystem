package com.itheima;

import com.itheima.domain.Customer;
import com.itheima.mapper.CustomerMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Classname MybatisTest
 * @Description TODO
 * @Date 2020/2/21 13:19
 * @Created wenjunpei
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootMybatisApplication.class)
public class MybatisTest {

    @Autowired
    private CustomerMapper customerMapper;

    @Test
    public void findAll() {
        List<Customer> all = customerMapper.findAll();
        for (Customer customer : all) {
            System.out.println(customer);
        }
    }
}
