package com.szh.ioc.bean;

import com.sun.javafx.image.IntPixelGetter;

import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * @Author szh
 * @Date 2022/7/28 20:54
 * @PackageName:com.szh.ioc.bean
 * @ClassName: Student
 * @Description: TODO
 * @Version 1.0
 */
public class Student {
    private String stuNum;
    private String stuName;
    private String stuGender;
    private int stuAge;
    private Date enterenceTime; //入学日期
    private Clazz clazz;
    private List<String> hobbies;
    private Properties properties;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Student(String stuNum, String stuName, String stuGender, int stuAge, Date enterenceTime, Clazz clazz, List<String> hobbies, Properties properties) {
        this.stuNum = stuNum;
        this.stuName = stuName;
        this.stuGender = stuGender;
        this.stuAge = stuAge;
        this.enterenceTime = enterenceTime;
        this.clazz = clazz;
        this.hobbies = hobbies;
        this.properties = properties;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNum='" + stuNum + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuGender='" + stuGender + '\'' +
                ", stuAge=" + stuAge +
                ", enterenceTime=" + enterenceTime +
                ", clazz=" + clazz +
                ", hobbies=" + hobbies +
                ", properties=" + properties +
                '}';
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuGender() {
        return stuGender;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public Date getEnterenceTime() {
        return enterenceTime;
    }

    public void setEnterenceTime(Date enterenceTime) {
        this.enterenceTime = enterenceTime;
    }
}
