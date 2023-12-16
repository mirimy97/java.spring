package ch06;

public class InitBlock {
    int count;
    int num;
    String color;

    {
        /**
         * 인스턴스 초기화 블록.
         * 아래 생성자들에서 인스턴스 초기화할 때 중복되는 코드를 추출하여 공통으로 사용할 수 있다.
         */
        count++;
        num = count;
    }

    InitBlock() {
//        count++;
//        num = count;
        color = "White";
    }
    InitBlock(String color) {
//        count++;
//        num = count;
        this.color = color;
    }
}
