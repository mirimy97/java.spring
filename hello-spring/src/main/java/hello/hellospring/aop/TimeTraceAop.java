package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * AOP를 사용하는 이유
 * - 예를 들어 회원 가입, 회원 목록 조회 등 특수화된 기능을 '핵심 관심 사항',
 *   메서드 시간 측정과 같이 공통적으로 필요로 하는 기능을 "공통 관심 사항" 이라 한다.
 * - 프로젝트 내 공통의 관심 사항을 곳곳에 구현하지 x ,하나만 구현하고, 여러군데에 적용하기 위해서 AOP를 사용한다.
 */

@Aspect
@Component
// @Component 써도 되지만, AOP처럼 틀별한건 SpringConfig에 직접 Bean 등록을 추천!
public class TimeTraceAop {

    // 어디에 적용할 지 타겟팅 (hello.hellospring 하위 모두 적용 / 커스텀 가능)
    @Around("execution(* hello.hellospring..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END : " + joinPoint.toString() + " " + timeMs + "ms");
        }

    }

    /**
     * 이런 식으로 Console log 찍힌다 ! -> 병목 현상 캐치 가능
     * START: execution(String hello.hellospring.controller.MemberController.list(Model))
     * START: execution(List hello.hellospring.service.MemberService.findMember())
     * START: execution(List org.springframework.data.repository.ListCrudRepository.findAll())
     * Hibernate: select m1_0.id,m1_0.name from member m1_0
     * END : execution(List org.springframework.data.repository.ListCrudRepository.findAll()) 106ms
     * END : execution(List hello.hellospring.service.MemberService.findMember()) 107ms
     * END : execution(String hello.hellospring.controller.MemberController.list(Model)) 122ms
     */


}
