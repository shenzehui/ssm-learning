package com.szh.dao;

import com.szh.pojo.Clazz;

/**
 * @Author szh
 * @Date 2022/7/27 16:39
 * @PackageName:com.szh.dao
 * @ClassName: ClazzDao
 * @Description: TODO
 * @Version 1.0
 */
public interface ClazzDao {

    Clazz queryClazzById(String classId);

}
