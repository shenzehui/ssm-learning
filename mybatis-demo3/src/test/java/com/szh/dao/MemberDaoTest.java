package com.szh.dao;

import com.szh.pojo.Member;
import com.szh.pojo.MemberSearchCondition;
import com.szh.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @Author szh
 * @Date 2022/7/27 20:46
 * @PackageName:com.szh.dao
 * @ClassName: MemberDaoTest
 * @Description: TODO
 * @Version 1.0
 */
public class MemberDaoTest {

    @Test
    public void queryMemberBy() {
        HashMap<String,Object> params = new HashMap<>();
        params.put("gender","女");
        params.put("minAge",18);
        params.put("maxAge",25);
        params.put("city","杭州");

        //---------------------------------------------------------------------------
        MemberSearchCondition params2 = new MemberSearchCondition();
        params2.setGender("女");
        params2.setMinAge(20);
//        params2.setMaxAge(25);
//        params2.setCity("杭州");

        //===========================================================================

        MemberDao memberDao = MyBatisUtil.getMapper(MemberDao.class);
        List<Member> members = memberDao.queryMemberBy(params2);
        for (Member member : members) {
            System.out.println(member);
        }
    }

    @Test
    public void testQueryMemberByCity() {
        List<String> cities = new ArrayList<>();
        cities.add("杭州");
        cities.add("深圳");
        MemberDao memberDao = MyBatisUtil.getMapper(MemberDao.class);
        List<Member> members = memberDao.queryMemberByCity(cities);
        for (Member member : members) {
            System.out.println(member);
        }
    }

    @Test
    public void testSearchMemberByNick(){
        MemberDao memberDao = MyBatisUtil.getMapper(MemberDao.class);
        List<Member> members = memberDao.searchMemberByNick("小");
        for (Member member : members) {
            System.out.println(member);
        }
    }

    @Test
    public void testQueryMemberById(){
        SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
        /*多个SqlSession对象必须来自于同一个SqlSessionFactory*/
        SqlSession sqlSession1= sqlSessionFactory.openSession();
        SqlSession sqlSession2= sqlSessionFactory.openSession();


//        SqlSession sqlSession1 = MyBatisUtil.getSqlSession();
//        SqlSession sqlSession2 = MyBatisUtil.getSqlSession();
        MemberDao memberDao = sqlSession1.getMapper(MemberDao.class);
        Member member = memberDao.queryMemberById(1);
        System.out.println(member);

//        member.setMemberAge(99);
        //MyBatisUtil.close(); //关闭sqlSession
        //sqlSession1.clearCache();
//        int i = memberDao.updateMember(1, 22);
        sqlSession1.commit();  //第一次查询之后，执行 sqlSession1.commit() 会将当前sqlSession的查询结果缓存到二级缓存
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        MemberDao memberDao2 = sqlSession2.getMapper(MemberDao.class);
        Member member1 = memberDao2.queryMemberById(1);
        System.out.println(member1);
    }


}