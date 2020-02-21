package com.itheima.ssm.service;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @Classname UserService
 * @Description TODO
 * @Date 2020/2/16 12:14
 * @Created wenjunpei
 */
public interface UserService extends UserDetailsService {
    List<UserInfo> findAll();

    void save(UserInfo userInfo);

    UserInfo findById(String userId);

    List<Role> findOtherRoles(String userId);

    void addRoleToUser(String userId, String[] rolesID);
}
