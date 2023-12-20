package ch07;

public class PointTest {
    public static void main(String args[]) {
        Point3D p3 = new Point3D();
        System.out.println("p3.x = " + p3.x);
        System.out.println("p3.y = " + p3.y);
        System.out.println("p3.z = " + p3.z);
    }
}

class Point {
    int x = 10;
    int y = 20;

    Point(int x, int y) {
        /**
         * 생성자의 첫 줄에서 다른 생성자를 호출하지 않으므로
         * 컴파일러가 super();를 호출하고, 이는 즉 Object 클래스의 생성자를 의미한다.
         */
        this.x = x;
        this.y = y;
    }
}

class Point3D extends Point {
    int z=30;

    Point3D() {
        this(100, 200, 300);
    }

    Point3D(int x, int y, int z) {
        /**
         * - 주의 ) 만약 super(x, y)를 쓰지 않는다면?
         * 1. 컴파일러가 super();를 자동으로 추가한다.
         * 2. super(); 는 즉, Point();를 호출한다.
         * 3. Point 클래스에 Point() 생성자가 없고, 다른 생성자가 있기 때문에 기본 생성자로서 자동으로 생성되지도 않으므로
         *    Point() 생성자를 찾을 수 없다.
         * 4. 컴파일 에러가 발생한다.
         */
        super(x, y);
        this.z = z;
    }
}