package ch06;

public class Tv {
    //    속성
    String color;
    boolean power;
    int channel;

    //    기능
    void power() { power = !power; }
    void channelUp() { ++channel; }
    void channelDown() { --channel; }
}

class TvTest {
    public static void main(String args[]) {
        // 1. 참조변수 t 선언 (객체의 주소를 저장하기 위한 공간)
        Tv t;
        // 2. Tv 인스턴스 생성하여 t에 주소 저장
        t = new Tv();
        // 3. Tv 인스턴스의 멤버변수 channel 값을 7로 설정
        t.channel = 7;
        // 4. Tv 인스턴스의 메서드 channelDown() 호출
        t.channelDown();

        System.out.println("현재 채널은 " + t.channel + "입니다.");
    }
}
