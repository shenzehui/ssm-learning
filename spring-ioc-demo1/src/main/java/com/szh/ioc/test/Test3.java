package com.szh.ioc.test;

import javax.xml.parsers.DocumentBuilder;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.logging.Filter;

/**
 * @Author szh
 * @Date 2022/7/28 21:30
 * @PackageName:com.szh.ioc.test
 * @ClassName: Test3
 * @Description: 通过反射说明spring容器DI注入的底层
 * @Version 1.0
 */
public class Test3 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        String classPath = "com.szh.ioc.bean.Student";
        Class<?> clazz = Class.forName(classPath);
        //通过反射创建对象
        Object object = clazz.newInstance();
        System.out.println(object);
        //通过反射获取类中的属性
        Field[] fields = clazz.getDeclaredFields();
        //属性赋值
        for (Field field : fields) {
            String fieldName = field.getName(); //stuNum ------ setStuNum
            String setMethodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

            if(fieldName.equals("stuNum")){
                //参数 方法名和方法返回类型
                Method setMethod = clazz.getDeclaredMethod(setMethodName, field.getType()); //获取set方法
                setMethod.invoke(object,"1001");
            }
        }
        System.out.println(object);
    }
}
