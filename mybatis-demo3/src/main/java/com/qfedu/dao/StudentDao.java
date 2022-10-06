package com.qfedu.dao;

import com.qfedu.pojo.Student;

import java.util.List;

/**
 * @Author szh
 * @Date 2022/7/28 14:13
 * @PackageName:com.qfedu.dao
 * @ClassName: StudentDao
 * @Description: TODO
 * @Version 1.0
 */
public interface StudentDao {

    //根据班级编号查询这个班级下所有的学生
    List<Student> queryStudentByCid(int cid);
}
