package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Category;

import java.util.List;

/**
 * @Classname CategoryDao
 * @Description TODO
 * @Date 2020/2/8 10:51
 * @Created wenjunpei
 */
public interface CategoryDao {


    List<Category> findAll();

    Category findOne(int cid);

}
