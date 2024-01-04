package ch07;

/**
 * 생성자가 private인 class는 다른 클래스의 조상이 될 수 없다.
 * (자손 클래스를 생성할 때 조상 클래스의 생성자를 호출해야만 하는데, private이기 때문에 호출이 불가능)
 * 그래서 class 선언부에 상속할 수 없다는 의미로 'final'를 추가해서 알리는 것이 좋다.
 */
final class Singletone {
    /**
     * 외부에서 인스턴스를 생성할 수 없기 때문에 getInstance() 에서 사용될 수 있도록 인스턴스를 미리 생성
     */
    private static Singletone s = new Singletone();

    /**
     * 생성자에 private -> 외부에서 인스턴스 생성 불가능, 이 클래스를 상속 불가능
     */
    private Singletone() {
        // ...
    }

    /**
     * 내부에서 생성된 인스턴스를 외부에서 사용할 수 있도록 반환하는 메서드
     * -> 외부에서 사용할 수 있는 인스턴스의 개수를 제한하고, 이 메서드를 통해서만 접근 가능
     * - 이 메서드는 public인 동시에 static이어야 한다. (외부에서 접근 가능, 인스턴스 생성 없이 사용)
     */
    public static Singletone getInstance() {
        if (s == null) s = new Singletone();
        return s;
    }
}
class SingletonTest {
    public static void main(String args[]) {
        /**
         * Singletone 인스턴스를 생성할 수 없으며, 내부에서 생성되어 있는 인스턴스만 사용 가능
         */
//        Singletone s = new Singletone();
        Singletone s = Singletone.getInstance();
    }
}
