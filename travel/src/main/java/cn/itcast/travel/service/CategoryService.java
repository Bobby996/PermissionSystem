package cn.itcast.travel.service;

import cn.itcast.travel.domain.Category;

import java.util.List;

/**
 * @Classname CategoryService
 * @Description TODO
 * @Date 2020/2/8 10:52
 * @Created wenjunpei
 */
public interface CategoryService {
    List<Category> findAll();
}
