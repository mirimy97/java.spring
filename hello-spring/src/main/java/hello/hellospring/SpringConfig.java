package hello.hellospring;

import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
* @Autowired 대신, 수동으로 스프링 Bean 등록하는 방법
*/
@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {

        return new MemberService(memberRepository);
    }

    // Spring data jpa는 JpaRepository를 상속한 인터페이스를 만들면 repository 구현체를 자동으로 bean에 등록해주기때문에, 아래 코드는 필요없다.
//    @Bean
//    public MemberRepository memberRepository() {
//        1. 메모리 데이터
//        return new MemoryMemberRepository();
//        2. H2, Jpa 사용
//        return new JpaMemberRepository(em);
//    }
}
