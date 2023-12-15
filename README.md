# 목차

---

1. [클래스와 인스턴스](#1-클래스와-인스턴스)

2. [변수와 메서드](#2-변수와-메서드)





# 1. 클래스와 인스턴스

---

## 💡객체 지향 언어

- 객체 지향 이론의 기본 개념은 **“실제 세계는 사물(객체)로 이루어져 있으며, 발생하는 모든 사건들은 사물간의 상호작용”** 이라는 것이다.
- 객체 지향 언어의 장점 : 코드의 재사용성이 높고 유지보수가 용이하다.
  - 재사용성
  - 유지보수
  - 중복된 코드의 제거



## 💡클래스와 객체, 객체와 인스턴스

객체 지향 관점에서 클래스는 **“객체를 정의해 놓은 설계도”** 이다.

붕어빵 틀로 붕어빵을 찍어내는 것처럼, 클래스를 사용해서 객체를 만들 수 있다.

클래스로부터 객체를 만드는 과정을 **클래스의 인스턴스화(instantiate)**라 한다.

객체와 인스턴스는 유사하나, 객체가 좀 더 포괄적인 의미를 지닌다.



## 💡객체의 구성요소

객체는 `**속성**`과 `**기능**` 으로 구성되며, 객체가 갖고 있는 속성과 기능을 그 객체의 `**멤버**`라 한다.

예를들어

- 객체 = Tv
  - 속성 = 크기, 길이, 높이, 채널, 볼륨 등
  - 기능 = 끄기, 켜기, 볼륨 높이기, 낮추기, 채널 올리기, …

프로그래밍을 할 때는 속성 ⇒ `멤버변수(member variable)`, 기능 ⇒ `메서드(method)`로 주로 사용한다.



## 💡인스턴스의 생성과 사용

- 인스턴스는 참조변수를 통해서만 다룰 수 있으며, 참조변수의 타입은 인스턴스의 타입과 일치해야한다.
- 참조변수가 없는 인스턴스는 가비지컬렉터(GC)에 의해 정리된다.

### 실습 코드

```java
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
```



## 💡클래스의 또 다른 정의

- 객체 지향 이론의 관점에서 클래스 = 객체를 생성하기 위한 틀
- 프로그래밍적 관점에서의 클래스 = 변수(데이터)와 함수를 하나의 클래스에 정의하여 함께 다루게 한 것
  - 서로 관련된 변수들을 정의하고, 이들에 대한 작업을 수행하는 함수들을 함께 정의한 것
  - 기본적으로 제공하는 자료형 외에, 프로그래머가 서로 관련된 변수들을 묶어 하나의 타입으로 새로 추가하는 **“사용자 정의 타입”** 형태로 사용할 수 있다.

### 사용자 정의 타입 실습 (시 + 분 + 초 ⇒ Time)

```java
import java.time.Duration;
import java.time.LocalTime;

public class Time {
    private int hour;
    private int minute;
    private int second;

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public void setHour(int hour) {
        if (hour < 0 || hour > 23) return;
        this.hour = hour;
    }

    public void setMinute(int minute) {
        if (minute < 0 || minute > 59) return;
        this.minute = minute;
    }

    public void setSecond(int second) {
        if (second < 0 || second > 59) return;
        this.second = second;
    }

}

class TimeTest {
    public static void main(String args[]) {
        Time t1 = new Time();
        Time t2 = new Time();

        t1.setHour(3);
        t1.setMinute(32);
        t1.setSecond(58);
        System.out.println("t1은 현재 " + t1.getHour() + "시 " + t1.getMinute() + "분 " + t1.getSecond() + "초입니다.");

        t2.setHour(5);
        t2.setMinute(22);
        t2.setSecond(52);
        System.out.println("t2는 현재 " + t2.getHour() + "시 " + t2.getMinute() + "분 " + t2.getSecond() + "초입니다.");

        diff(t1, t2);
    }

    // 심화) 시간의 차 구하는 메서드
    public static void diff(Time t1, Time t2) {
        int h1 = t1.getHour();
        int m1 = t1.getMinute();
        int s1 = t1.getSecond();
        int h2 = t2.getHour();
        int m2 = t2.getMinute();
        int s2 = t2.getSecond();

        LocalTime t1ToTime = LocalTime.of(h1, m1, s1);
        LocalTime t2ToTime = LocalTime.of(h2, m2, s2);
        Duration diff = Duration.between(t1ToTime, t2ToTime);

        System.out.println("시간 차이는 " + diff + "입니다.");
    }
}
```

 

# 2. 변수와 메서드

---

## 💡 변수의 종류

### 선언 위치에 따라

- 클래스 영역
  - **클래스 변수** : `static int cv;`
    - 한 클래스의 모든 인스턴스들이 공통적인 값을 유지해야하는 속성의 경우
    - 선언할 때, 앞에 `static` 을 붙인다.
    - 인스턴스를 생성하지 않고 `클래스명.클래스변수명` 의 형식으로 사용할 수 있다.
    - `인스턴스 참조변수.클래스변수명` 으로도 사용할 수 있지만, 인스턴스 변수로 오해할 수 있기때문에 클래스 명으로 접근하는 것이 좋다.
  - **인스턴스 변수** : `int iv;`
    - 인스턴스마다 고유한 상태를 유지해야 하는 속성의 경우
    - 인스턴스 생성을 해야지만 사용할 수 있다.
- 메서드 영역
  - **지역 변수** : `int lv;`
    - 메서드 내에 선언되어 메서드 내에서만 사용 가능하며, 메서드가 종료되면 소멸한다.
    - `for`문이나 `while`문 블럭 내에 선언된 지역변수도, 블럭 `{ }` 내에서만 사용 가능하다.
      
      

## 💡 메서드 선언과 구현

```java
// 반환타입, 메서드 이름, 매개변수 선언(입력)
int add (int x, int y) {
    int result = x + y;

    return result;
}
```

- 반환 타입
  - 작업 수행 결과 반환(메서드에서 `return` 할 데이터)의 타입을 적는다.
  - 반환값이 없는 경우, `void` 로 작성
- 메서드 이름
  - 주로 동사 형태로, 메서드의 기능을 알기 쉽게 명명한다.
- 매개변수
  - 입력값(=인자)의 타입을 지정한다.
  - 쉼표로 구분하며, 같은 타입이라도 각각 변수마다 타입을 작성해야 한다. (`int x, y` (x) )
  - **호출할 때 (인자) ⇒ 선언된 타입(매개 변수)는 일치하거나, 자동 형변환이 가능해야 한다.**



## 💡 return 문

- 실행 중인 메서드를 종료한다.

- 반환값 유무에 상관없이, 모든 메서드에는 `return;` 문이 있어야 한다.

- 하지만 `void` 반환 타입인 경우, 생략해도 되는 이유는 컴파일러가 자동으로 return 문을 추가해주기 때문이다.

- `if ()` 문과 같이, 조건에 따라 분기되는 상황에서는 모든 조건에 return문이 있어야 한다.
  
  ```java
  int max(int a, int b) {
      if (a > b) return a;
      else return b;    // else 블럭 추가
  }
  ```



## 💡 메서드 작성 시 주의점

### 매개변수의 유효성 검사

메서드를 작성할 때, 매개 변수의 타입이나 값에 대해 가능한 모든 경우의 수를 고민하고 대비한 코드를 작성해야 한다.

적절하지 않은 값이 넘어온다면 매개변수의 값을 보정하고, 불가능하다면 return 문을 사용해서 작업을 중단해야 프로그램의 비정상적인 종료를 방지할 수 있다.



## 💡 JVM의 메모리 구조

응용 프로그램이 실행되면, JVM은 시스템으로부터 프로그램을 수행하는 데 필요한 메모리를 할당받고, 이 메모리를 용도에 따라 여러 영역으로 나누어 관리한다.

그 중 3가지 주요 영역은 아래와 같다.

### 메서드 영역 (method area)

클래스에 대한 정보(클래스 데이터), 클래스 변수

### 힙 (heap)

인스턴스 생성, 인스턴스 변수

### 호출 스택(call stack 또는 execution stack)

메서드의 작업에 필요한 메모리 공간

메서드가 호출되면 여기에 호출 메서드를 수행하기 위한 메모리가 할당된다.

메서드가 작업을 수행하는 동안 지역 변수(매개 변수 등)들과 연산 중간 결과 등을 저장하는 데 사용.

메서드가 종료되면 할당되었던 메모리 공간이 반환되어 비워진다.

### 메서드의 수행 순서

1. 메서드를 호출하면 호출 스택의 가장 밑에 메모리 공간이 마련된다.
2. 메서드 수행 중에 다른 메서드를 호출하면, 첫번째 메서드의 바로 위 공간을 할당받고, 첫번째 메서드는 잠시 중단되고 위에 있는 두번째 메서드를 실행한다.
3. 두번째 메서드의 작업이 끝나면 할당된 메모리가 반환되고, 다시 첫번째 메서드가 호출스택의 가장 위에 있게 되어 작업이 진행된다.

**⇒ 이런 성격(First-in Last-out)에 따라 stack 이라는 이름이 붙은 듯하다.**

**⇒ 호출 스택의 가장 위에 있는 메서드가 현재 실행 중인 메서드이다.**

**⇒ 아래에 있는 메서드가 바로 위에 있는 메서드를 호출한 메서드이다.**



## 💡 기본형 매개변수와 참조형 매개변수

메서드를 호출할 때, 매개변수로 지정한 값을 메서드에 복사해서 넘겨준다.

매개변수의 타입에 따라,

### 기본형 매개변수 = `read only`

값 자체를 복사해서 넘겨준다.

복사본을 다루기 때문에, 원본의 값은 바꿀 수 없다.

### 참조형 매개변수 = `read & write`

인스턴스의 주소를 복사해서 넘겨준다.

복사한 주소를 가지고 원본값이 저장된 곳을 찾아갈 수 있기 때문에, 값을 바꿀 수 있다.