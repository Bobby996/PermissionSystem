package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.dao.impl.FavoriteDaoImpl;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.service.FavoriteService;

/**
 * @Classname FavoriteServiceImpl
 * @Description TODO
 * @Date 2020/2/9 12:30
 * @Created wenjunpei
 */
public class FavoriteServiceImpl implements FavoriteService {
    private FavoriteDao favoriteDao = new FavoriteDaoImpl();
    @Override
    public boolean isFavorite(int rid, int uid) {
        Favorite flag = favoriteDao.findByRidAndUid(rid, uid);
        if(flag == null) {
            return false;
        }else {
            return true;
        }
    }

    @Override
    public void add(int rid, int uid) {
        favoriteDao.add(rid,uid);
    }
}
