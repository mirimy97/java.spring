package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

/*
* 모듈 static import 하는 법
* import할 부분만 끊어서 커서 위치 두고
* Alt + Enter ->  Add on-demand static import~
*/
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    /*
     * 테스트 생성 Tip : Service Class에서 ctrl + shift + T -> 클래스 단위로 테스트 자동 생성
     * */

    MemberService memberService;
    MemoryMemberRepository repository;

    @BeforeEach // test가 동작하기 전 수행
    public void beforeEach() {
        // 1. MemoryMemberRepository 인스턴스 생성
        repository = new MemoryMemberRepository();
        // 2. 생성한 repository 인스턴스를 MemberService에 주입
        memberService = new MemberService(repository);
        // 3. 그러면, MemberService와 MemberServiceTest에서 같은 repository를 상용한다.
    }

    //    각 테스트 메서드는 순서가 보장되지 않기 때문에, 각각의 로직 이후에 데이터를 초기화해주는 과정이 필요하다.
    @AfterEach    // 각 메서드가 끝날 때마다 수행
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("spring");

        // when
        Long savedId = memberService.join(member);

        // then
        Member findedMember = memberService.findOne(savedId).get();
        assertThat(member.getName()).isEqualTo(findedMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
//        1. try - catch 문법
//        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다3.");
//        }

//        2. assertThrows()
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

    @Test
    void findMember() {
    }

    @Test
    void findOne() {
    }
}