package com.itheima.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname QuickController
 * @Description TODO
 * @Date 2020/2/21 10:54
 * @Created wenjunpei
 */
@RestController
@ConfigurationProperties(prefix = "person")
public class QuickController {

    private String name;
    private Integer age;
    private String address;

    @RequestMapping("/quick2")
    public String quick() {
        return name+"-----"+age+"-------"+address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
