package cn.itcast.travel.service;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;

/**
 * @Classname RouteService
 * @Description TODO
 * @Date 2020/2/8 13:26
 * @Created wenjunpei
 */
public interface RouteService {
    PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname);

    Route findOne(int rid);

}
