package com.szh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author szh
 * @Date 2022/7/26 14:38
 * @PackageName:com.szh.pojo
 * @ClassName: Student
 * @Description: TODO
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    private Integer stuId;
    private String stuNum;
    private String stuName;
    private String stuGender;
    private Integer stuAge;
}
