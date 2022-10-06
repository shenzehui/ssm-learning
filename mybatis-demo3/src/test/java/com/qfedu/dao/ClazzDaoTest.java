package com.qfedu.dao;

import com.qfedu.pojo.Clazz;
import com.qfedu.utils.MyBatisUtil;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author szh
 * @Date 2022/7/28 14:19
 * @PackageName:com.qfedu.dao
 * @ClassName: ClazzDaoTest
 * @Description: TODO
 * @Version 1.0
 */
public class ClazzDaoTest {

    /*延迟加载*/
    @Test
    public void queryClazzByCid() {
        ClazzDao clazzDao = MyBatisUtil.getMapper(ClazzDao.class);
        Clazz clazz = clazzDao.queryClazzByCid(1);
        System.out.println(clazz.getClassName());
        System.out.println("------------------------------------");
        System.out.println(clazz.getStus());
    }
}