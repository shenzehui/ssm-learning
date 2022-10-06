package com.szh.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author szh
 * @Date 2022/8/1 0:18
 * @PackageName:com.szh.utils
 * @ClassName: MyDateConverter
 * @Description: TODO
 * @Version 1.0
 */
//泛型说明：将前端传递过来的String转成Date类型

/**
 * 1.创建一个类实现Converter接口，泛型指定从什么类型转化成什么类型
 * 2.实现convert转化方法
  */
public class MyDateConverter implements Converter<String, Date> {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");

    /**
     * @param s 前端传过来的值
     * @return
     */
    @Override
    public Date convert(String s) {
        Date date = null;
        try {
            //解析字符串
            date = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
