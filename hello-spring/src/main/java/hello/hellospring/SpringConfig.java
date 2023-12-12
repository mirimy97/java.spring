package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
* @Autowired 대신, 수동으로 스프링 Bean 등록하는 방법
*/
@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        // MemberService 생성할 때, MemberRepository 필요함
        // 따라서 아래 메서드를 호출해서 MemberService 생성자에 주입
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
