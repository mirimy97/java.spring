package jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

/**
 * 값 타입은 변경이 불가능하게 설계하는 것이 좋다.
 * 따라서 @Setter는 쓰지 않으며, 생성자에서 값을 모두 초기화하여 변경 불가능하게 만든다.
 */
@Embeddable
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    /**
     * * JPA 스펙상 Entity나 Embedded타입(@Embeddable)은 자바 기본 생성자를
     *  * public 또는 protected로 설정해야 한다.
     *  * public보다는 protected로 설정하는 것이 더 안전하다.
     *  * 이런 제약을 두는 이유는 JPA 구현 라이브러리가 객체를 생성할 때 리플랙션 같은 기술을
     *  * 사용할 수 있도록 지원해야 하기 때문이다.
     *  */
    protected Address() {
    }
    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
