package com.qfedu.dao;

import com.qfedu.pojo.Course;

/**
 * @Author szh
 * @Date 2022/7/27 20:09
 * @PackageName:com.qfedu.dao
 * @ClassName: CourseDao
 * @Description: TODO
 * @Version 1.0
 */
public interface CourseDao {

    Course queryCourseById(int courseId);
}
