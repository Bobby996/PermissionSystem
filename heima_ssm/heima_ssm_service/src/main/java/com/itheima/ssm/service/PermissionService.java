package com.itheima.ssm.service;

import com.itheima.ssm.domain.Permission;

import java.util.List;

/**
 * @Classname PermissionService
 * @Description TODO
 * @Date 2020/2/16 16:48
 * @Created wenjunpei
 */
public interface PermissionService {
    List<Permission> findAll();

    void save(Permission permission);

    Permission findById(String id);

    void deletePermissionById(String id);
}
