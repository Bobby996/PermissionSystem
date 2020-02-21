package com.itheima.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Classname BCryptPasswordEncoderUtils
 * @Description TODO
 * @Date 2020/2/16 13:27
 * @Created wenjunpei
 */
public class BCryptPasswordEncoderUtils {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String password = "123";
        String password1 = encodePassword(password);
        System.out.println(password1);
    }

}