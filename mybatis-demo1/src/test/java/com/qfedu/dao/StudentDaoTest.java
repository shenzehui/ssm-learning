package com.qfedu.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.cj.Session;
import com.qfedu.pojo.Student;
import com.qfedu.utils.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author szh
 * @Date 2022/7/26 14:54
 * @PackageName:com.qfedu.dao
 * @ClassName: StudentDaoTest
 * @Description: TODO
 * @Version 1.0
 */
public class StudentDaoTest {

    @Test
    public void insertStudent() {
        SqlSession session = MyBatisUtil.getSqlSession();
        //1.当我们获取SqlSession对象时，就默认开启了事务
        try {
            //通过会话回去Dao对象
            StudentDao studentDao = session.getMapper(StudentDao.class);
            //测试StudentDao中的方法
            Student student = new Student(null, "1222", "张学友", "男", 50);
            int result = studentDao.insertStudent(student);  //操作1：如果是自动提交事务，则操作一执行完成后就会提交事务，违反事务一致性规定，因此这里应该设置为手动提交
            studentDao.updateStudent(student);  //操作2
            System.out.println("result = " + result);
            //主键回填
            System.out.println(student);
            //2.操作完成并成功后，需要手动提交
            session.commit();
        } catch (Exception e) {
            //3.当操作出现异常，调用rollback进行回滚
            session.rollback();
        }
    }

    @Test
    public void testDeleteStudent() {
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        int i = studentDao.deleteStudent("12");
        System.out.println(i);
    }

    @Test
    public void testUpdateStudent() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession();  // sqlSessionFactory.openSession(isAutoCommit); 默认false
            StudentDao studentDao = session.getMapper(StudentDao.class);
            int i = studentDao.updateStudent(new Student(null, "12", "李梓萌", "男", 60));
            session.commit();
            Assert.assertEquals(1, i);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListStudent() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            List<Student> students = studentDao.listStudent();
            for (Student student : students) {
                System.out.println(student);
            }
            Assert.assertNotNull(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryStudent() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            Student student = studentDao.queryStudent("12");
            System.out.println(student);
            Assert.assertNotNull(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetCount() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            int count = studentDao.getCount();
            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void listStudentByPage() {
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//            SqlSession session = sqlSessionFactory.openSession();
//            StudentDao studentDao = session.getMapper(StudentDao.class);
//            List<Student> students = studentDao.listStudentByPage(0, 5);
//            for (Student student : students) {
//                System.out.println(student);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        StudentDao mapper = MyBatisUtil.getMapper(StudentDao.class);
        List<Student> students = mapper.listStudent();
        System.out.println(students);
    }

    @Test
    public void listStudentByPagePro(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);  //sqlSession
        PageHelper.startPage(1,1);
        List<Student> students = studentDao.listStudentByGender("女");
        PageInfo<Student> pageInfo = new PageInfo<Student>(students);
        //PageInfo中就包含了数据及分页信息
        List<Student> list = pageInfo.getList();
        for (Student student : list) {
            System.out.println(student);
        }
    }
}