package com.szh.utils;

import com.szh.dao.MemberDao;
import com.szh.pojo.Member;

import java.util.List;

/**
 * @Author szh
 * @Date 2022/7/27 23:24
 * @PackageName:com.szh.utils
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
