package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    /*
    * ctrl + shift + T : 클래스 단위로 테스트 생성
    * */

    private final MemberRepository memberRepository;
    // constructor 사용 : memberRepository를 new로 직접 생성하는 게 아니라 외부에서 주입하도록 변경

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
     * 회원 가입
     * */

    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원 x
        validateDuplicateMember(member);
        /*
         * .ifPresent() : null이 아니면 동작함
         * Optional로 감싸고 있을 때 쓸 수 있다.
         * */

        memberRepository.save(member);
        return member.getId();
    }

    /*
    * 로직을 메서드로 뽑기 (Extract Method : ctrl + Alt + M)
    * */
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /*
    * 전체 회원 조회
    */
    public List<Member> findMember() {
        return memberRepository.findAll();
    }

    /*
    * 회원 id 조회
    */
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }


}
