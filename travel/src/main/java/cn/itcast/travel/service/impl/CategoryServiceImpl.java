package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.dao.impl.CategoryDaoImpl;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Classname CategoryServiceImpl
 * @Description TODO
 * @Date 2020/2/8 10:52
 * @Created wenjunpei
 */
public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao = new CategoryDaoImpl();
    @Override
    public List<Category> findAll() {
        Jedis jedis = JedisUtil.getJedis();
        List<Category> list = null;
        Set<Tuple> set = jedis.zrangeWithScores("categorySortedSet", 0, -1);
        if(set == null || set.size() == 0) {
            list = categoryDao.findAll();
            for (Category category : list) {
                jedis.zadd("categorySortedSet",category.getCid(),category.getCname());
            }
            System.out.println("从数据库中查询");
        }else {
            list = new ArrayList<Category>();
            for (Tuple tuple : set) {
                Category category = new Category();
                category.setCname(tuple.getElement());
                category.setCid((int)tuple.getScore());
                list.add(category);
            }
            System.out.println("从redis缓存中查询");
        }
        return list;
    }
}
