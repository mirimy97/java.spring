package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        // 새 멤버 생성하여 DB 저장
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        // 저장됐는지 확인
        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());   // new member = memberA
        System.out.println("find member = " + findMember.getName());   // find member = memberA
    }
}
