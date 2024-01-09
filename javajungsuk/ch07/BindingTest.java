package ch07;

/**
 * 멤버변수가 조상과 자손 클래스에 중복 정의된 경우,
 * 인스턴스 참조변수의 타입(조상 or 자손)에 따라 사용되는 변수가 달라진다.
 */
public class BindingTest {
    public static void main(String[] args) {
        /**
         * 1-1. 멤버 변수가 중복정의된 경우
         *     : 참조변수의 타입에 따라 사용하는 멤버 변수가 달라진다.
         * 1-2. 메서드가 중복정의된 (오버라이딩) 경우
         *     : 참조변수 타입에 관계없이 오버라이딩된(자손의) 메서드를 사용한다.
         */
        Parent1 p1 = new Child1();
        Child1 c1 = new Child1();

        System.out.println("p1.x = " + p1.x);    // p1.x = 100
        p1.method();    // Child Method
        System.out.println("c1.x = " + c1.x);    // c1.x = 200
        c1.method();    // Child Method

        /**
         * 2. 조상 클래스에만 멤버가 정의된 경우
         *    : 참조변수 타입에 관계없이 조상의 멤버를 사용한다.
         */
        Parent1 p2 = new Child2();
        Child2 c2 = new Child2();

        System.out.println("p2.x = " + p2.x);    // p2.x = 100
        p2.method();    // Parent Method
        System.out.println("c2.x = " + c2.x);    // c2.x = 100
        c2.method();    // Parent Method
    }

}
class Parent1 {
    int x = 100;

    void method() {
        System.out.println("Parent Method");
    }
}

class Child1 extends Parent1 {
    int x = 200;

    void method() {
        System.out.println("Child Method");
    }
}

class Child2 extends Parent1 {
}
