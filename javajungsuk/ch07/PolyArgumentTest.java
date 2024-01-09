package ch07;

public class PolyArgumentTest {
    public static void main(String[] args) {
        Buyer b = new Buyer();

        b.buy(new Tv());
        b.buy(new Computer());

        System.out.println("현재 남은 돈은 " + b.money + "만원입니다.");
        System.out.println("현재 보너스점수는 " + b.bonusPoint + "점입니다.");

        /**
         * Tv을/를 구입하셨습니다.
         * Computer을/를 구입하셨습니다.
         * 현재 남은 돈은 700만원입니다.
         * 현재 보너스점수는 30점입니다.
         */
    }
}

class Product {
    int price;    // 제품 가격
    int bonusPoint;    // 제품 구매 시 제공하는 보너스 포인트

    Product(int price) {
        this.price = price;
        bonusPoint = (int) (price / 10.0);
    }
}

class Tv extends Product {
    /**
     * 생성자 : 조상클래스(Product)의 생성자를 호출
     */
    Tv() {
        super(100);    // 인스턴스 변수 price를 100으로 설정
    }

    // Object 클래스의 toString()을 오버라이딩
    public String toString() {
        return "Tv";
    }
}

class Computer extends Product {
    Computer() {
        super(200);
    }

    public String toString() {
        return "Computer";
    }
}

class Buyer {
    int money = 1000;    // 소지금액
    int bonusPoint = 0;    // 보너스점수

    /**
     * 매개변수를 모든 상품(Tv, Computer...)의 조상 클래스인 Product로 하여
     * 하나의 메서드로 Product를 상속받은 모든 타입의 인스턴스를 처리할 수 있다.
     * 왜냐하면, Parent p = new Child(); 가 가능하기 때문이다 (다형성)
     */
    void buy(Product p) {
        if (money < p.price) {
            System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
            return;
        }
        money -= p.price;
        bonusPoint += p.bonusPoint;
        System.out.println(p + "을/를 구입하셨습니다.");
    }
}