package ch06;

public class ReturnTest {
    /**
     * 메서드는 단 하나의 값을 반환하지만, 참조형 매개변수의 성질을 이용하면 여러개의 값을 얻을 수도 있다.
     */
    public static void main(String args[]) {
        int[] result = {0, 0};
        // x + y와 x - y를 한 번에 계산할 수 있는 메서드를 만들려고 한다.
        plusAndMinus(5, 3, result);

        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    static void plusAndMinus(int x, int y, int[] result) {
        result[0] = x + y;
        result[1] = x - y;
    }

}
