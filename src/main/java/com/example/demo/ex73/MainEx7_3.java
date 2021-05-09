package com.example.demo.ex73;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainEx7_3 {
    private static MemberDao memberDao;

    public static void main(String[] args) {
        AbstractApplicationContext ctx =
                new GenericXmlApplicationContext("classpath:appCtx7_3.xml");
        memberDao = ctx.getBean("memberDao", MemberDao.class);
        Member mem = memberDao.selectByEmail("sheril0284@skuniv.ac.kr");
        System.out.println(mem.getName());
        ctx.close();

    }
}