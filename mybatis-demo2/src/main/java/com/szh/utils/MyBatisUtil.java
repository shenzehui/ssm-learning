package com.szh.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author szh
 * @Date 2022/7/26 19:36
 * @PackageName:com.szh.utils
 * @ClassName: MyBatisUtil
 * @Description: TODO
 * @Version 1.0
 */
public class MyBatisUtil {

    private static SqlSessionFactory sqlSessionFactory;

    private static final ThreadLocal<SqlSession> local = new ThreadLocal<SqlSession>();

    static {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    private static SqlSession getSqlSession(boolean isAutoCommit) {
        SqlSession sqlSession = local.get();
        if (sqlSession == null) {
            sqlSession = sqlSessionFactory.openSession(isAutoCommit);
            local.set(sqlSession);
        }
        return sqlSession;
    }

    public static SqlSession getSqlSession() {
        return getSqlSession(false);
    }

    public static <T extends Object> T getMapper(Class<T> c) {
        SqlSession sqlSession = getSqlSession(true);
        return sqlSession.getMapper(c);
    }
}
