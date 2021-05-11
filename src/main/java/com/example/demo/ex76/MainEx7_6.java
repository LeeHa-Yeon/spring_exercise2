package com.example.demo.ex76;

import com.example.demo.ex73.Member;
import com.example.demo.ex73.MemberDao;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Date;

public class MainEx7_6 {
    private static MemberDao memberDao;

    public static void main(String[] args) {
        AbstractApplicationContext ctx =
                new GenericXmlApplicationContext("classpath:appCtx7_3.xml");
        memberDao = ctx.getBean("memberDao", MemberDao.class);
        Member member = new Member("new2@gmail.com","1212","Mr.Kim",new Date());
        memberDao.insert(member);
        System.out.println(member.getId());
        ctx.close();

    }
}