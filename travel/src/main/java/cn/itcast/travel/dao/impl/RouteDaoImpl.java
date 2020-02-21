package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname RouteDaoImpl
 * @Description TODO
 * @Date 2020/2/8 13:26
 * @Created wenjunpei
 */
public class RouteDaoImpl implements RouteDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public int findTotalCount(int cid, String rname) {
//        String sql = "select count(*) from tab_route where cid = ?";
        String sql = "select count(*) from tab_route where 1=1 ";
        StringBuilder stringBuilder = new StringBuilder(sql);
        List list = new ArrayList();
        if(cid != 0) {
            stringBuilder.append(" and cid = ?");
            list.add(cid);
        }
        if(rname  != null && rname.length() > 0) {
            stringBuilder.append(" and rname like ?");
            list.add("%"+rname+"%");
        }
        sql = stringBuilder.toString();
        return  jdbcTemplate.queryForObject(sql, Integer.class, list.toArray());

    }

    @Override
    public List<Route> findByPage(int cid, int start, int pageSize, String rname) {
//        String sql = "select * from tab_route where cid = ? limit ?,?";
        String sql = "select * from tab_route where 1=1 ";
        StringBuilder stringBuilder = new StringBuilder(sql);
        List params = new ArrayList();
        if(cid != 0) {
            stringBuilder.append(" and cid = ?");
            params.add(cid);
        }
        if(rname  != null && rname.length() > 0) {
            stringBuilder.append(" and rname like ?");
            params.add("%"+rname+"%");
        }
        stringBuilder.append(" limit ? , ?");
        params.add(start);
        params.add(pageSize);
        sql = stringBuilder.toString();
        List<Route> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Route>(Route.class), params.toArray());
        return list;
    }

    @Override
    public Route findOne(int rid) {
        String sql = "select * from tab_route where rid = ?";
        Route route = null;
        try{
            route = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Route>(Route.class), rid);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return route;
    }
}
