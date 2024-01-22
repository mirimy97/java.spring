package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.AppConfig;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        // 새 멤버 생성하여 DB 저장
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        // 저장됐는지 확인
        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());   // new member = memberA
        System.out.println("find member = " + findMember.getName());   // find member = memberA
    }
}
