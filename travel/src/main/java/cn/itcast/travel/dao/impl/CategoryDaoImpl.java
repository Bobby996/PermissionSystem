package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;
import java.util.Map;

/**
 * @Classname CategoryDaoImpl
 * @Description TODO
 * @Date 2020/2/8 10:51
 * @Created wenjunpei
 */
public class CategoryDaoImpl implements CategoryDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Category> findAll() {
        String sql = "select * from tab_category ";
        List<Category> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
        return list;
    }

    @Override
    public Category findOne(int cid) {
        String sql = "select * from tab_category where cid = ?";
        Category category = null;
        try {
            category = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Category>(Category.class), cid);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return category;
    }
}
