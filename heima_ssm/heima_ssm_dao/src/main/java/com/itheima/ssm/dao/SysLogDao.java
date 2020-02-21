package com.itheima.ssm.dao;

import com.itheima.ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Classname SysLogDao
 * @Description TODO
 * @Date 2020/2/17 13:16
 * @Created wenjunpei
 */
public interface SysLogDao {

    @Insert("insert into sysLog(executionTime,ip,method,url,username,visitTime) values(#{executionTime},#{ip},#{method},#{url},#{username},#{visitTime})")
    void save(SysLog syslog);

    @Select("select * from sysLog")
    List<SysLog> findAll();

}
