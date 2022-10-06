package com.qfedu.dao;

import com.qfedu.pojo.Clazz;

/**
 * @Author szh
 * @Date 2022/7/28 14:14
 * @PackageName:com.qfedu.dao
 * @ClassName: ClazzDao
 * @Description: TODO
 * @Version 1.0
 */
public interface ClazzDao {
    Clazz queryClazzByCid(int cid);
}
