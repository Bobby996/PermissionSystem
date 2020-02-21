package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Route;

import java.util.List;

/**
 * @Classname RouteDao
 * @Description TODO
 * @Date 2020/2/8 13:25
 * @Created wenjunpei
 */
public interface RouteDao {
    int findTotalCount(int cid, String rname);

    List<Route> findByPage(int cid, int start, int pageSize, String rname);

    Route findOne(int rid);
}
