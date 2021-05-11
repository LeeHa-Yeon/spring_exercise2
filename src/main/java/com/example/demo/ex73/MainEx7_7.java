package com.example.demo.ex73;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainEx7_7 {
    private static MemberDao memberDao;

    public static void main(String[] args) {
        AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx7_7.xml");
        ChangePasswordService cps = ctx.getBean("changePwdSvc", ChangePasswordService.class);
        try {
            cps.changePassword("gkdus@naver.com", "abcd", "aaaa"); System.out.println("암호를 변경했습니다.");
        } catch (MemberNotFoundException e) { System.out.println("회원 데이터가 존재하지 않습니다.");
        } catch (IdPasswordNotMatchingException e) { System.out.println("암호가 올바르지 않습니다.");
        }
        // ctx.close();
}
}