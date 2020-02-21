package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Seller;

/**
 * @Classname SellerDao
 * @Description TODO
 * @Date 2020/2/8 18:31
 * @Created wenjunpei
 */
public interface SellerDao {
    Seller findOne(int sid);
}
