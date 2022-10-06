package com.qfedu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @Author szh
 * @Date 2022/7/27 16:35
 * @PackageName:com.qfedu.pojo
 * @ClassName: Student
 * @Description: TODO
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    private String stuId;
    private String stuName;
    private int stuAge;
    //private Clazz clazz; //学生所在的班级
//    private List<Course> courses; //学生所选的课程
}
