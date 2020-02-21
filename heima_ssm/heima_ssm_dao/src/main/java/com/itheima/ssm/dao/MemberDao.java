package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Member;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @Classname MemberDao
 * @Description TODO
 * @Date 2020/2/15 17:53
 * @Created wenjunpei
 */
public interface MemberDao {

    @Select("select * from member where id = #{id}")
//    @Results({
//            @Result(id = true,property = "id",column = "id"),
//            @Result(property = "name",column = "NAME"),
//            @Result(property = "nickname",column = "nickname"),
//            @Result(property = "phoneNum",column = "phoneNum"),
//            @Result(property = "email",column = "email")
//    })
    public Member findById(String id);
}
