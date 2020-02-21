package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.*;
import cn.itcast.travel.dao.impl.*;
import cn.itcast.travel.domain.*;
import cn.itcast.travel.service.RouteService;

import java.util.List;

/**
 * @Classname RouteServiceImpl
 * @Description TODO
 * @Date 2020/2/8 13:27
 * @Created wenjunpei
 */
public class RouteServiceImpl implements RouteService {
    private RouteDao routeDao = new RouteDaoImpl();
    private RouteImgDao routeImgDao = new RouteImgDaoImpl();
    private SellerDao sellerDao = new SellerDaoImpl();
    private CategoryDao categoryDao = new CategoryDaoImpl();
    private FavoriteDao favoriteDao = new FavoriteDaoImpl();
    @Override
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname) {
        PageBean<Route> pageBean = new PageBean<Route>();
        int totalCount = routeDao.findTotalCount(cid,rname);
        int start = (currentPage - 1) * pageSize;
        List<Route> list = routeDao.findByPage(cid,start,pageSize,rname);
        pageBean.setCurrentPage(currentPage);
        pageBean.setList(list);
        pageBean.setTotalCount(totalCount);
        pageBean.setTotalPage((int)Math.ceil(Double.valueOf(totalCount/pageSize)));
        pageBean.setPageSize(pageSize);
        return pageBean;
    }

    @Override
    public Route findOne(int rid) {
        Route route = routeDao.findOne(rid);
        Category category = categoryDao.findOne(route.getCid());
        List<RouteImg> routeImg = routeImgDao.findList(route.getRid());
        Seller seller = sellerDao.findOne(route.getSid());
        int count  = favoriteDao.findCountByRid(rid);
        route.setCategory(category);
        route.setSeller(seller);
        route.setRouteImgList(routeImg);
        route.setCount(count);
        return route;
    }
}
