package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Delivery {

    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded
    private Address address;

    /**
     * enum 타입을 필드로 쓸 때, @Enumerated 어노테이션 사용
     * EnumType을 지정해주어야 하는데, STRING을 사용해야 한다.
     *
     * Ordinary type이 기본값인데, index(순서)로 저장하기 때문에
     * 예를 들어 1,2,3 상태에서 중간에 다른 값이 들어가 1,2,3,4가 되면
     * 3이였던 값들이 4로 업데이트되지 않고 그대로 3으로 남아있어 다른 value를 가지게 된다.
     */
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;  // READY, COMP
}
