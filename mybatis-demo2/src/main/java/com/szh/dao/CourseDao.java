package com.szh.dao;

import com.szh.pojo.Course;

/**
 * @Author szh
 * @Date 2022/7/27 20:09
 * @PackageName:com.szh.dao
 * @ClassName: CourseDao
 * @Description: TODO
 * @Version 1.0
 */
public interface CourseDao {

    Course queryCourseById(int courseId);
}
