package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "memeber_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    /**
     * 나는 연관관계의 주인이 아니다.
     * Order Table에 있는 "member" 필드에 의해 mapped 된 것이다.
     */
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();


}
