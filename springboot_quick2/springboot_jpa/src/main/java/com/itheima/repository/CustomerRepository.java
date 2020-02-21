package com.itheima.repository;

import com.itheima.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Classname CustomerRepository
 * @Description TODO
 * @Date 2020/2/21 13:35
 * @Created wenjunpei
 */
public interface CustomerRepository extends JpaRepository<Customer,Long>, JpaSpecificationExecutor<Customer> {
}
