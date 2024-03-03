package jpabook.jpashop.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    /**
     * 1대1 관계 (@OneToOne)에서 FK를 어디에 둘것이냐?
     * -> 액세스가 많이 되는 Entity에 위치 (개발자의 선택)
     *
     * 연관관계의 주인(FK가 있는 Entity)에서는 @JoinColumn(name = "반대편식별자")
     * FK가 없는 Entity에서는 @OnetoOne(mappedBy = "주인쪽에서 나를 mapping하는 컬럼 이름")
     */
    @OneToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate; // 주문시간

    @Enumerated(EnumType.STRING)
    private OrderStatus status; // 주문 상태 enum [Order, Cancel]

}
