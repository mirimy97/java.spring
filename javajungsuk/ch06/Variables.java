package ch06;

public class Variables {
    /**
     * 클래스 영역
     */
    // 인스턴스 변수 (인스턴스가 생성되었을 때 생성)
    int iv;
    // 클래스 변수, 공유 변수 (클래스가 메모리에 올라갈 때 생성)
    static int cv;

    void method() {
        /**
         * 메서드 영역
         */
        // 지역 변수 (변수 선언문이 수행되었을 때 생성)
        int lv = 0;
    }
}
