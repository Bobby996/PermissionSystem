package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlInOutParameter;

import java.util.Date;

/**
 * @Classname FavoriteDaoImpl
 * @Description TODO
 * @Date 2020/2/9 12:30
 * @Created wenjunpei
 */
public class FavoriteDaoImpl implements FavoriteDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public Favorite findByRidAndUid(int rid, int uid) {
        String sql = " select * from tab_favorite where rid = ? and uid = ?";
        Favorite favorite = null;
        try {
            favorite = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Favorite>(Favorite.class), rid, uid);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return favorite;
    }

    @Override
    public int findCountByRid(int rid) {
        String sql = "select count(*) from tab_favorite where rid = ?";
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class, rid);
        return integer;
    }

    @Override
    public void add(int rid, int uid) {
        String sql = "insert into tab_favorite values(?,?,?)";
        int update = jdbcTemplate.update(sql, rid,new Date(), uid);
        System.out.println(update);
    }
}
