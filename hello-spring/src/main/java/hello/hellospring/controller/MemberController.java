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

    /*
    * 2. 에 대한 보충
    * 3가지 의존성 주입 방법 중 왜 '생성자 주입'방법을 사용하는가?
    * - 의존관계가 실행 중에 동적으로 변하는 경우는 거의 없으므로, 초기 setting 후 고정되는 생성자 주입 방법을 권장한다.
    * - setter 방식은 외부에서 다른 개발자가 .set 메서드에 접근할 수 있어 위험하다.
    */
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
