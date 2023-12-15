package ch06;

public class Factorial {
    public static void main(String args[]) {
        int n = 13;
        int result = 0;

        for (int i = 0; i <= n; i++) {
            result = factorial(i);

            if (result == -1) {
                System.out.println("유효하지 않은 값입니다. (0 < n <= 12)");
            } else System.out.println(i + "! = " + result);
        }
    }

    static int factorial(int n) {
        if (n <= 0 || n > 12) return -1;
        if (n == 1) return 1;

        return n * factorial(n - 1);
    }
}
