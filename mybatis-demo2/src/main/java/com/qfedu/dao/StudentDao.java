package com.qfedu.dao;

import com.qfedu.pojo.Student;

import java.util.List;

/**
 * @Author szh
 * @Date 2022/7/27 16:52
 * @PackageName:com.qfedu.dao
 * @ClassName: StudentDao
 * @Description: TODO
 * @Version 1.0
 */
public interface StudentDao {

    //List<Student> queryStudentByCid(String cid);

    Student queryStudentBySid(String sid);

    List<Student> queryStudentByCid(String cid);


}
