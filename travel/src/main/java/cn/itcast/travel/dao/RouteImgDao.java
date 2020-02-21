package cn.itcast.travel.dao;

import cn.itcast.travel.domain.RouteImg;

import java.util.List;

/**
 * @Classname RouteImgDao
 * @Description TODO
 * @Date 2020/2/8 18:29
 * @Created wenjunpei
 */
public interface RouteImgDao {
    List<RouteImg> findList(int rid);
}
