package com.szh.ioc.bean;

import java.util.List;

/**
 * @Author szh
 * @Date 2022/7/28 21:52
 * @PackageName:com.szh.ioc.bean
 * @ClassName: Clazz
 * @Description: TODO
 * @Version 1.0
 */
public class Clazz {
    private int classId;
    private String className;

    @Override
    public String toString() {
        return "Clazz{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                '}';
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
