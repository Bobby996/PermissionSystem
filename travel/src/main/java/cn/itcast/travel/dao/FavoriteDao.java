package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Favorite;

/**
 * @Classname FavoriteDao
 * @Description TODO
 * @Date 2020/2/9 12:30
 * @Created wenjunpei
 */
public interface FavoriteDao {
    Favorite findByRidAndUid(int rid, int uid);

    int findCountByRid(int rid);

    void add(int rid,int uid);
}
