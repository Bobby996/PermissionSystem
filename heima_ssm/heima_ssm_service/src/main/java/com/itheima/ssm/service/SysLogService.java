package com.itheima.ssm.service;

import com.itheima.ssm.domain.SysLog;

import java.util.List;

/**
 * @Classname SysLogService
 * @Description TODO
 * @Date 2020/2/17 13:15
 * @Created wenjunpei
 */
public interface SysLogService {

    public void save(SysLog syslog);

    List<SysLog> findAll();

}
