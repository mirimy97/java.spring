package ch07;

public class SuperTest {
    public static void main(String args[]) {
        Child c = new Child();
        c.method();
    }
}

class Parent {
    int x=10;
}

class Child extends Parent {
    int x=20;
    void method() {
        /**
         * - 같은 이름의 멤버 변수를 조상 / 자손 클래스에 중복 정의가 가능하며, 아래와 같이 구분한다.
         * 자손 클래스에 선언된 멤버 변수 : x / this.x
         * 상속받은 멤버 변수 : super.x
         */
        System.out.println("x=" + x);
        System.out.println("this.x=" + this.x);
        System.out.println("super.x=" + super.x);
    }
}
