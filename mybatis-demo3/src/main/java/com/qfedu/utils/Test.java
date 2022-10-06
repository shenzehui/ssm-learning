package com.qfedu.utils;

import com.qfedu.dao.MemberDao;
import com.qfedu.pojo.Member;

import java.util.List;

/**
 * @Author szh
 * @Date 2022/7/27 23:24
 * @PackageName:com.qfedu.utils
 * @ClassName: Test
 * @Description: TODO
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        MemberDao memberDao = MyBatisUtil.getMapper(MemberDao.class);
        List<Member> members = memberDao.searchMemberByNick("小");
        for (Member member : members) {
            System.out.println(member);
        }
    }
}
