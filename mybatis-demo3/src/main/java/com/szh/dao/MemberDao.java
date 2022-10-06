package com.szh.dao;

import com.szh.pojo.Member;
import com.szh.pojo.MemberSearchCondition;
import org.apache.ibatis.annotations.Param;
import org.w3c.dom.ls.LSInput;

import java.util.HashMap;
import java.util.List;

/**
 * @Author szh
 * @Date 2022/7/27 20:44
 * @PackageName:com.szh.dao
 * @ClassName: MemberDao
 * @Description: TODO
 * @Version 1.0
 */
public interface MemberDao {

    //在多条件查询中，如果查询条件不确定，可以直接使用HashMap作为参数
    //优点：无需单独定义传递查询条件的类
    //缺点：当向Map中存放参数时，key必须与动态sql保持一致（）
//    List<Member> queryMemberBy(HashMap<String,Object> params);


    //也可以定义专门用于存放查询条件的实体类存放参数
    //优点：设置参数时无需关注属性名
    //缺点：需要单独定义一个类来封装参数
    List<Member> queryMemberBy(MemberSearchCondition params);

    List<Member> queryMemberByCity(List<String> cities);

    //根据昵称查询用户信息——模糊查询
    //默认查询需要使用${}取值，与sql进行拼接
    // 在使用${}时，即使只有一个参数也需要使用@Param注解声明参数的key(非String对象参数可以不用声明)
    List<Member> searchMemberByNick(@Param("keyWord") String keyWord);

    Member queryMemberById(int mid);

    int updateMember(@Param("mid") int mid,@Param("age") int age);
}
