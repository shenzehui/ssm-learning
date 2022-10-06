package com.qfedu.dao;

import com.qfedu.pojo.Clazz;

/**
 * @Author szh
 * @Date 2022/7/27 16:39
 * @PackageName:com.qfedu.dao
 * @ClassName: ClazzDao
 * @Description: TODO
 * @Version 1.0
 */
public interface ClazzDao {

    Clazz queryClazzById(String classId);

}
