package com.hello.core;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import com.hello.core.member.MemberService;
import com.hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
     /*
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        //memberService에는 MemberServiceImpl이 들어가게 된다.
    */
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // AppConfig에서 생성한 객체를 관리 해준다 - Spring
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        // Bean으로 등록된 memberService를 memberService에 저장한다.

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("new Member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
