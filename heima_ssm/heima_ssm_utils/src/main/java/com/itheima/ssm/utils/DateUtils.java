package com.itheima.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Classname DateUtils
 * @Description TODO
 * @Date 2020/2/15 14:33
 * @Created wenjunpei
 */
public class DateUtils {

    //日期转字符串
    public static String date2String(Date date,String patt) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patt);
        String format = simpleDateFormat.format(date);
        return format;
    }

    //字符串转日期
    public static Date string2Date(String str,String patt) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patt);
        Date parse = simpleDateFormat.parse(str);
        return parse;
    }
}
