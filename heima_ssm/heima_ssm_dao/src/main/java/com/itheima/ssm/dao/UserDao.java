package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Classname UserDao
 * @Description TODO
 * @Date 2020/2/16 12:32
 * @Created wenjunpei
 */
public interface UserDao {

    @Select("select * from users where username = #{username}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "PASSWORD"),
            @Result(property = "email",column = "email"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "STATUS"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,
                many = @Many(select = "com.itheima.ssm.dao.RoleDao.findByUserId"))
    })
    public UserInfo findByUsername(String username);

    @Select("select * from users ")
    List<UserInfo> findAll();

    @Insert("insert into users(username,password,email,status,phoneNum) values(#{username},#{password},#{email},#{status},#{phoneNum})")
    void save(UserInfo userInfo);


    @Select("select * from users where id = #{userId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "PASSWORD"),
            @Result(property = "email",column = "email"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "STATUS"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,
                    many = @Many(select = "com.itheima.ssm.dao.RoleDao.findByUserId"))
    })
    UserInfo findById(String userId);


    @Select("select * from role where id not in (select roleId from users_role where userId = #{userId})")
    List<Role> findOtherRoles(String userId);

    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId,@Param("roleId") String roleId);
}
