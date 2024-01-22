package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    /**
     * DIP 위반 (구체가 아니라 추상에만 의존해야 한다.)
     *  - FixDiscountPolicy, RateDiscountPolicy는 구체이다.
     * OCP 위반 (확장에는 열려있고, 변경에는 닫혀있어야 한다.)
     *  - 할인 정책 변경 시 OrderServiceImpl의 코드 변경이 불가피하다.
     */
    //    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
