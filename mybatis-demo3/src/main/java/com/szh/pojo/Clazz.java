package com.szh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @Author szh
 * @Date 2022/7/27 16:35
 * @PackageName:com.szh.pojo
 * @ClassName: Clazz
 * @Description: TODO
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Clazz {
    private int classId;
    private String className;
    private String classDesc;
    private List<Student> stus;
}
