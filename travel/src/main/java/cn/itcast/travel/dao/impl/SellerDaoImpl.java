package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.SellerDao;
import cn.itcast.travel.domain.Seller;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Classname SellerDaoImpl
 * @Description TODO
 * @Date 2020/2/8 18:31
 * @Created wenjunpei
 */
public class SellerDaoImpl implements SellerDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public Seller findOne(int sid) {
        String sql = "select * from tab_seller where sid = ?";
        Seller seller = null;
        try {
            seller = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Seller>(Seller.class),sid);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return seller;
    }
}
