package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        /**
         * ( 스프링으로 전환 )
         * ApplicationContext = 스프링 컨테이너 / Config를 관리해줌
         * applicationContext.getBean("메서드 이름", 클래스.class) -> 스프링 컨테이너로부터 객체를 받아옴
         */
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        // 저장됐는지 확인
        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());   // new member = memberA
        System.out.println("find member = " + findMember.getName());   // find member = memberA
    }
}
