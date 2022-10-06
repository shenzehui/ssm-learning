package com.szh.dao;

import com.google.protobuf.ExperimentalApi;
import com.szh.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author szh
 * @Date 2022/7/26 14:41
 * @PackageName:com.szh.dao
 * @ClassName: StudentDao
 * @Description: TODO
 * @Version 1.0
 */
public interface StudentDao {

    //Mybatis进行条件查询操作：
    // 1.如果操作方法只有一个简单类型或者字符串类型的参数，在Mapper配置中可以直接通过#{key}直接获取
    // 2.如果操作方法有一个对象类型的参数，在Mapper配置中可以直接通过#{attrName}获取对象的指定属性值，attrName必须是参数对象的属性
    // 3.如果操作方法有一个Map类型的参数，在Mapper配置中可以直接通过#{key}获取key对应的value
    // 4.如果操作方法有多个参数，该如何处理呢？

    int insertStudent(Student student);

    int deleteStudent(String stuNum);

    int updateStudent(Student student);

    List<Student> listStudent();

    Student queryStudent(String stuNum);

    int getCount();

    List<Student> listStudentByPage(@Param("start") int start, @Param("pageSize") int pageSize);

    public List<Student> listStudentByGender(String gender);
}
