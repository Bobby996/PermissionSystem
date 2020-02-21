package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname PermissionDao
 * @Description TODO
 * @Date 2020/2/16 15:37
 * @Created wenjunpei
 */
public interface PermissionDao {

    @Select("select * from permission where id in (select permissionId from  role_permission where roleId = #{roleId})")
    List<Permission> findAllByRoleId(String roleId);


    @Select("select * from permission")
    List<Permission> findAll();


    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void save(Permission permission);


    @Select("select * from permission where id = #{id}")
    Permission findById(String id);


    @Delete("delete from permission where id = #{id}")
    void deletePermissionById(String id);
}
