package hello.core.member;

public class MemberServiceImpl implements MemberService{

    /**
     * 기존 MemberServiceImpl에서 직접 MemoryMemberRepository 객체를 생성해서 사용하던 방식에서,
     * 생성자의 매개변수를 통해 AppConfig에서 MemoryMemberRepository 객체를 주입받는 방식으로 바꾸어
     * MemberServiceImpl 클래스 내부의 코드에서는 추상(MemberRepository)에만 의존하게 되었다.
     */
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
