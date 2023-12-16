package ch06;

public class CarTest {
    public static void main(String[] args) {
        Car c1 = new Car();
        Car c2 = new Car("blue");

        System.out.println("c1 정보 = " + c1.color + ", " + c1.gearType + ", " + c1.door);
        System.out.println("c2 정보 = " + c2.color + ", " + c2.gearType + ", " + c2.door);
    }
}

class Car {
    /**
     * 인스턴스 변수
     */
    String color;
    String gearType;
    int door;


    /**
     * 생성자
     */
    Car() {
        // this()는 첫 줄에 호출해야 한다.
        this("white", "auto", 4);
    }

    Car(String color) {
        this(color, "auto", 4);
    }

    Car(String color, String gearType, int door) {
//        인스턴스 변수와 매개 변수의 이름이 같을 때, 구분하기 위해 `this.인스턴스변수` 를 사용한다.
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }

//    아래와 같이 인스턴스 변수와 매개변수의 이름을 달리하면 this.를 쓸 필요가 없지만,
//    this.를 쓰는 편이 의미를 알아차리기 쉽기 때문에 아래와 같은 방법은 지양한다.
//    Car(String c, String g, int d) {
//        color = c;
//        gearType = g;
//        door = d;
//    }
}
