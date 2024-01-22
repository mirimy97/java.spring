package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        // 여기만 FixDiscountPolicy <-> RateDiscountPolicy로 할인 정책 변경하면 다른 코드 변경 없이 사용할 수 있다.
        return new OrderServiceImpl(new MemoryMemberRepository(), new RateDiscountPolicy());
    }
}
