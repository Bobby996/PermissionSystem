package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname ProductDao
 * @Description TODO
 * @Date 2020/2/15 13:27
 * @Created wenjunpei
 */
public interface ProductDao {
    /*
     * @Description 查询所有商品信息
     * @param
     * @return java.util.List<com.itheima.ssm.domain.Product>
     * @date 2020/2/15 13:28
     * @auther wenjunpei
     */
    @Select("select * from product")
    public List<Product> findAll();


    @Insert("insert into product(productNum,productName,departureTime,cityName,productPrice,productStatus,productDesc) " +
            "values(#{productNum},#{productName},#{departureTime},#{cityName},#{productPrice},#{productStatus},#{productDesc})")
    void save(Product product);

    @Select("select * from product where id = #{id}")
    public Product findById(String id);
}
