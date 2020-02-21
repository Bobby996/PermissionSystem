package com.itheima;

import com.itheima.domain.Customer;
import com.itheima.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Classname JpaTest
 * @Description TODO
 * @Date 2020/2/21 13:37
 * @Created wenjunpei
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootJpaApplication.class)
public class JpaTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void findAll() {
        List<Customer> all = customerRepository.findAll();
        for (Customer customer : all) {
            System.out.println(customer);
            System.out.println("hahahahahahah");
            System.out.println("我被修改啦");
        }
    }

}
