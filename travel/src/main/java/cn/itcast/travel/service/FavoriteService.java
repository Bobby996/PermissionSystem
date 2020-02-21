package cn.itcast.travel.service;

/**
 * @Classname FavoriteService
 * @Description TODO
 * @Date 2020/2/9 12:30
 * @Created wenjunpei
 */
public interface FavoriteService {
    boolean isFavorite(int rid, int uid);
    void add(int rid,int uid);
}
