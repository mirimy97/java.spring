package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    /**
     * ( DIP, OCP 위반 문제를 해결하려면 누군가 클라이언트인 'OrderServiceImpl'에 'DiscountPoilcy' 구현 객체를 "누군가" 대신 생성하고 주입해주어야 한다. )
     * 1. OrderServiceImpl은 추상(DiscountPolicy)에만 의존하도록 코드 변경
     * 2. 필요한 구현 객체는 AppConfig를 통해 생성자 주입 받는다.
     */
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
