package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    /*
    * Spring container 등록 방법
    * 1. 계층 역할에 맞는 어노테이션 작성(@Controller, @Service, @Repository)
    * 2. 생성자 작성
    * 3. @Autowired : 해당 클래스의 memberService를 Spring이  spring 컨테이너의 MemberService와 연결해줌 (=> 의존성 주입, DI)
    */
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
