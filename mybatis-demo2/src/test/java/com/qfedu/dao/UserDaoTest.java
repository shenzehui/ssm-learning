package com.qfedu.dao;

import com.qfedu.pojo.*;
import com.qfedu.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.security.PublicKey;

import static org.junit.Assert.*;

/**
 * @Author szh
 * @Date 2022/7/27 13:51
 * @PackageName:com.qfedu.dao
 * @ClassName: UserDaoTest
 * @Description: TODO
 * @Version 1.0
 */
public class UserDaoTest {

    @Test
    public void insertUser() {
        //多个数据库操作，应该用手动提交
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        User user = new User(0, "sst", "sst123", "沈思甜", "default.jpg",null);
        Detail detail = new Detail(0,"浙江杭州","13738214633","有个性才签名",0);
        int i = 0;
        try {
            DetailDao detailDao = sqlSession.getMapper(DetailDao.class);
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            i = userDao.insertUser(user);
            detail.setUserId(user.getUserId());
            i = detailDao.insertDetail(detail) * i;
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }
        System.out.println(i);
    }

    @Test
    public void testQueryUserByUserName(){
        UserDao userDao = MyBatisUtil.getMapper(UserDao.class);
        User user = userDao.queryUser("szh");
        System.out.println(user);
    }

    @Test
    public void testQueryClassByCid(){
        ClazzDao clazzDao = MyBatisUtil.getMapper(ClazzDao.class);
        Clazz clazz = clazzDao.queryClazzById("1");
        System.out.println(clazz);
    }

    @Test
    public void testQueryStudentById(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        Student student = studentDao.queryStudentBySid("10001");
        System.out.println(student);
    }

    @Test
    public void testQueryCourseById(){
        CourseDao courseDao = MyBatisUtil.getMapper(CourseDao.class);
        Course course = courseDao.queryCourseById(2);
        System.out.println(course);
    }
}