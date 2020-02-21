package com.itheima.ssm.service;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;

import java.util.List;

/**
 * @Classname RoleService
 * @Description TODO
 * @Date 2020/2/16 16:29
 * @Created wenjunpei
 */

public interface RoleService {
    List<Role> findAll();

    void save(Role role);

    Role findById(String roleId);

    List<Permission> findOtherPermissions(String roleId);

    void addPermissionToRole(String roleId, String[] permissionsId);
}
