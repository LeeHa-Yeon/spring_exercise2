package com.example.demo.ex75;

import com.example.demo.ex73.Member;
import com.example.demo.ex73.MemberDao;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainEx7_5 {
    private static MemberDao memberDao;

    public static void main(String[] args) {
        AbstractApplicationContext ctx =
                new GenericXmlApplicationContext("classpath:appCtx7_3.xml");
        memberDao = ctx.getBean("memberDao", MemberDao.class);
        Member member = memberDao.selectByEmail("gkdus@naver.com");
        try {
            member.changePassword("2222", "abcd");
        }catch (Exception e){ e.printStackTrace(); }
        memberDao.update(member);
        member = memberDao.selectByEmail("gkdus@naver.com");
        System.out.println(member.getPassword());
        ctx.close();

    }
}