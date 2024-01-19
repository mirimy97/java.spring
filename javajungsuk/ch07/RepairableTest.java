package ch07;

/**
 * Marine, SCV, Tank -> GroundUnit
 * Dropship -> AirUnit
 * 이처럼 상속관계가 결정되어 있는 상태에서,
 * SCV는 Tank와 DropShip 유닛을 수리하는 메서드를 만들고 싶다.
 * 다형성을 이용하여 조상 클래스를 매개변수로 설정해서 메서드를 오버로딩하지않고 하나로 압축하고 싶은데
 * Tank와 AirUnit은 다른 조상을 상속받고 있다.
 * 이럴 때, 기능을 없지만 Repairable이라는 의미상의 인터페이스를 하나 정의하여
 * SCV, Tank, DropShip을 하나로 묶음으로써 다형성에서 조상클래스의 역할을 대신할 수 있다.
 */
public class RepairableTest {
    public static void main(String[] args) {
        Tank tank = new Tank();
        Dropship dropship = new Dropship();

        Marine marine = new Marine();
        SCV scv = new SCV();

        scv.repair(tank);    // Tank의 수리가 끝났습니다.
        scv.repair(dropship);    // Dropship의 수리가 끝났습니다.
//        scv.repair(marine);    // 에러 발생
    }
}

interface Repairable {}

class Unit {
    int hitPoint;
    final int MAX_HP;

    Unit(int hp) {
        MAX_HP = hp;
    }
    // ...
}

class GroundUnit extends Unit {
    GroundUnit(int hp) {
        super(hp);
    }
}

class AirUnit extends Unit {
    AirUnit(int hp) {
        super(hp);
    }
}

class Tank extends GroundUnit implements Repairable {
    Tank() {
        super(150);
        hitPoint = MAX_HP;
    }

    public String toString() {
        return "Tank";
    }
    // ...
}

class Dropship extends AirUnit implements Repairable {
    Dropship() {
        super(125);
        hitPoint = MAX_HP;
    }

    public String toString() {
        return "Dropship";
    }
    // ...
}

class Marine extends GroundUnit {
    Marine() {
        super(40);
        hitPoint = MAX_HP;
    }
    // ...
}

class SCV extends GroundUnit implements Repairable {
    SCV() {
        super(60);
        hitPoint = MAX_HP;
    }

    /**
     * SCV가 Tank 혹은 Dropship 유닛을 수리하는 메서드
     * 다형성에 따라 매개변수를 공통으로 구현한 인터페이스, Repairable로 설정했다.
     */
    void repair(Repairable r) {
        if (r instanceof Unit) {
            /**
             * Repairable 인터페이스에는 멤버가 없어 실제로 참조변수인 r이 할 수 있는 일은 없으므로,
             * instanceof 연산자로 타입을 체크한 뒤 Unit 으로 캐스팅하여 정의된 멤버변수 (hitPoint, MAX_HP)를 사용할 수 있게 했다
             */
            Unit u = (Unit) r;
            while (u.hitPoint != u.MAX_HP) {
                u.hitPoint++;
            }
            System.out.println(u.toString() + "의 수리가 끝났습니다.");
        }
    }
}