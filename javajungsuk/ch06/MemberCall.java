package ch06;

/**
 * - 클래스 멤버와 인스턴스 멤버간 참조, 호출
 * 하나의 인스턴스 멤버가 존재한다는 것은 그 인스턴스가 이미 생성되었다는 의미이다.
 * 그러므로 인스턴스 멤버는 다른 인스턴스 변수/메서드를 호출 가능하다.
 * 하지만 클래스 멤버가 생성되었을 때, 인스턴스 멤버가 생성되었을 지는 알 수 없기 때문에
 * 클래스 멤버가 인스턴스 멤버를 호출할 수는 없다.
 * 호출하기 위해서는 객체 생성이 필요하다.
 */

public class MemberCall {
    int iv = 10;
    static int cv = 20;

    int iv2 = cv;
//    static int cv2 = iv;    클래스 변수 -> 인스턴스 변수 (X)
    static int cv2 = new MemberCall().iv;    // 이처럼 객체를 생성해야 사용 가능

    // 클래스 메서드 -> 변수 참조
    static void staticMethod1() {
        System.out.println(cv);    // 클래스 메서드 -> 클래스 변수 (O)
//        System.out.println(iv);    클래스 메서드 -> 인스턴스 변수 (X)
        MemberCall c = new MemberCall();
        System.out.println(c.iv);    // 객체 생성 후 클래스 메서드 -> 인스턴스 변수 (O)
    }

    // 인스턴스 메서드 -> 변수 참조
    void instanceMethod1() {
        System.out.println(cv);    // 인스턴스 메서드 -> 클래스 변수 (O)
        System.out.println(iv);    // 인스턴스 메서드 -> 인스턴스 메서드 (O)
    }

    // 클래스 메서드 -> 메서드 참조
    static void staticMethod2() {
        staticMethod1();    // 클래스 메서드 -> 클래스 메서드 (O)
//        instanceMethod1();   // 클래스 메서드 -> 인스턴스 메서드 (X)
        MemberCall c = new MemberCall();
        c.instanceMethod1();    // 객체 생성 후 클래스 메서드 -> 인스턴스 메서드 (O)
    }

    // 인스턴스 메서드 -> 메서드 참조
    void instanceMethod2() {
        staticMethod1();    // 인스턴스 메서드 -> 클래스 메서드 (O)
        instanceMethod1();     // 인스턴스 메서드 -> 인스턴스 메서드 (O)
    }
}
