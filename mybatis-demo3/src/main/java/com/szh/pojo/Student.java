package com.szh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author szh
 * @Date 2022/7/27 16:35
 * @PackageName:com.szh.pojo
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
}
