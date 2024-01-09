# 목차

1. [클래스와 인스턴스](#1-클래스와-인스턴스)

   - [객체 지향 언어](#객체-지향-언어)

   - [클래스와 객체, 객체와 인스턴스](#클래스와-객체-객체와-인스턴스)

   - [인스턴스의 생성과 사용](#인스턴스의-생성과-사용)

   - [클래스의 또 다른 정의](#클래스의-또-다른-정의)

2. [변수와 메서드](#2-변수와-메서드)

   - [변수의 종류](#-변수의-종류)

   - [메서드 선언과 구현](#-메서드-선언과-구현)

   - [return 문](#-return-문)

   - [메서드 작성 시 주의점](#-메서드-작성-시-주의점)

   - [JVM의 메모리 구조](#-jvm의-메모리-구조)

   - [기본형 매개변수와 참조형 매개변수](#-기본형-매개변수와-참조형-매개변수)

   - [클래스(static) 메서드와 인스턴스 메서드](#-클래스static-메서드와-인스턴스-메서드)

3. [오버로딩(overloading)](#3-오버로딩overloading)

   - [오버로딩](#-오버로딩)

   - [가변인자(vararges)](#-가변인자vararges)

4. [생성자(Constructor)](#4-생성자constructor)

   - [생성자](#-생성자)

   - [기본 생성자](#-기본-생성자)

   - [this()와 this](#-this와-this)

   - [생성자를 이용한 인스턴스 복사](#-생성자를-이용한-인스턴스-복사)

5. [변수의 초기화](#5-변수의-초기화)

   - [변수의 초기화란?](#-변수의-초기화란)

   - [지역변수의 초기화](#-지역변수의-초기화)

   - [멤버변수의 초기화](#-멤버변수의-초기화)

6. [상속(inheritance)](#6-상속inheritance)

   - [클래스간의 관계 - 상속](#-클래스간의-관계--상속)

   - [클래스간의 관계 - 포함관계](#-클래스간의-관계---포함관계)

   - [클래스간 관계 결정하기](#-클래스간-관계-결정하기)

   - [단일 상속](#-단일-상속)

   - [Object클래스](#-object클래스)

7. [오버라이딩(overriding)](#7-오버라이딩overriding)

   - [오버라이딩](#-오버라이딩)

   - [super - 조상 클래스의 멤버](#-super---조상-클래스의-멤버)

   - [super() - 조상 클래스의 생성자](#-super---조상-클래스의-생성자)

8. [package와 import](#8-package와-import)

   - [패키지(pakage)](#-패키지package)

   - [import문](#-import문)

   - [static import문](#-static-import문)

9. [제어자(modifier)](#9-제어자modifier)

   - [제어자란?](#-제어자란)

   - [그 외 제어자 (static, final, abstract)](#-그-외-제어자-static-final-abstract)

   - [접근 제어자(access modifier)](#-접근-제어자access-modifier)

   - [제어자의 조합](#-제어자의-조합)

10. [다형성(polymorphism)](#10-다형성polymorphism)

- [다형성이란?](#-다형성이란)

- [참조변수의 형변환](#-참조변수의-형변환)

- [instanceof 연산자](#-instanceof-연산자)

- [참조변수와 인스턴스의 연결](#-참조변수와-인스턴스의-연결)

# 1. 클래스와 인스턴스

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

## 💡 클래스(static) 메서드와 인스턴스 메서드

- 인스턴스 메서드

  - 인스턴스 변수를 이용해서 메서드 작업을 실행한다.
  - 객체 생성 후에만 호출이 가능하다.

  ```java
  // MyMath라는 클래스가 있다고 가정 ~
  MyMath mm = new MyMath();
  mm.add();    // 객체 생성 후 참조변수를 통해 호출
  ```

- 클래스 메서드

  - 인스턴스 변수 없이 매개 변수만으로 작업이 가능하다.

  ```java
  MyMath.add(3, 5);    // 인스턴스 생성 없이 바로 호출 가능
  ```

그렇다면 클래스 메서드(static 메서드)와 인스턴스 메서드는 어떤 상황에서 사용해야 할까?

- **메서드 내에서 인스턴스 변수를 사용해야 할 때**
  - 클래스 메서드는 인스턴스 생성 없이 바로 사용할 수 있다. 그러나 인스턴스 변수는 인스턴스를 생성해야 사용할 수 있기 때문에, 클래스 메서드에서는 인스턴스 변수 사용을 금지한다.
  - 따라서 인스턴스 변수를 사용해야 할 때는 인스턴스 메서드를 사용한다.
- **인스턴스 변수를 사용하지 않을 때**
  - 이 때는 `static`을 붙여 클래스 메서드로 사용하면 메서드 호출시간이 짧아져 성능이 향상된다.
  - \*\* 인스턴스 메서드는 실행 시 호출되어야 할 메서드를 찾는 과정이 추가적으로 필요하다.

### 클래스 멤버, 인스턴스 멤버 간 참조와 호출

```java
class TestClass {
    int iv;
    static int cv;
    void instanceMethod() {}
    static void staticMethod() {}

    void instanceMethod2() {    // 인스턴스 메서드
        instanceMethod();    // 다른 인스턴스 메서드 호출 O
        staticMethod();    // 다른 static 메서드 호출 O
        System.out.println(iv);    // 인스턴스 변수 사용 O
        System.out.println(cv);    // 클래스 변수 사용 O
    }

    static void staticMethod2() {    // static 메서드
        instanceMethod();    // error !!! 다른 인스턴스 메서드 호출 X
        staticMethod();    // 다른 static 메서드 호출 O
        System.out.println(iv);    // error !!! 인스턴스 변수 사용 X
        System.out.println(cv);    // 클래스 변수 사용 O
    }
}
```

인스턴스 멤버가 존재하는 시점에 클래스 멤버는 항상 존재한다.

하지만 클래스 멤버가 존재하는 시점에 인스턴스 멤버가 존재하는지는 알 수 없다.

⇒ **그러므로, static 메서드가 인스턴스 변수나 인스턴스 메서드를 호출하고자 할 때는 인스턴스를 생성해야 한다.**

# 3. 오버로딩(overloading)

## 💡 오버로딩

### 오버로딩이란?

- **오버로딩 (overloading) = ‘과적하다’,** 많이 싣는 것.
- 자바에서는 한 클래스 내에서 같은 메서드 이름을 갖더라도 매개변수의 개수나 타입이 다르다면 같은 이름을 가진 메서드를 여러개 정의할 수 있다.
- 하나의 메서드 이름은 하나의 기능만을 구현해야 하지만, 여러 기능을 구현하는 것을 `메서드 오버로딩` 또는 `오버로딩` 이라고 한다.
- 주로 같은 일을 하지만 매개 변수를 달리해야 하는 상황에서 활용한다.

### 오버로딩의 조건

```java
1. 메서드 이름이 같아야 한다.
2. 매개변수의 개수 또는 타입이 달라야 한다.
```

** 2를 만족하지 않으면 오버로딩이 아니라 **메서드 중복 정의\*\*로 간주되어 컴파일 시 에러가 발생.

** 오버로딩된 메서드들은 **매개변수에 의해서만 구별**되며, **반환 타입은 아무런 영향을 주지 못한다.\*\*

\*\* **매개변수 타입의 순서가 다른 경우**는 매개변수에 의해 호출 메서드가 구별되므로 오버로딩으로 본다. (`add(long a, int b)` & `add(int a, long b)` ⇒ 오버로딩)

### 오버로딩의 장점

같은 기능을 하지만 다른 매개변수를 사용해야 하는 상황에서,

- 구현하는 입장에서
  - 메서드 이름을 짓는 고민을 덜 수 있다.
- 사용하는 입장에서
  - 여러 메서드의 이름을 모두 외울 필요 없이 기능 단위로 외워서 편하다.

## 💡 가변인자(vararges)

### 가변인자

JDK1.5부터 매개변수 개수를 동적으로 지정해 줄 수 있으며, 이 기능을 `가변인자(variable arguments)`라고 한다.

### 선언

```java
String concatenate(String... str) { ... }
```

- 위와 같이 `타입... 변수명` 의 형식으로 선언한다.
- 가변인자는 **항상 마지막 매개변수**여야 한다.

### 호출

```java
concatenate();    // 인자가 없음
concatenate("a");    // 인자가 하나
concatenate("a", "b");    // 인자가 여러개
concatenate(new String[]{"a", "b"};    // 배열
```

- 가변인자가 매개변수로 있을 때, 위의 모든 상황이 가능하다.
- 가변인자는 내부적으로 배열을 이용하며, 메서드가 호출될 때마다 배열이 새로 생성된다.
  - 그러므로 배열을 새로 생성해야 하는 비효율을 감안하고 사용하자.

### 배열 매개변수와의 차이

```java
String concatenate(String[] str) { ... }

concatenate();    // error !!! 인자가 필요함.
```

- 매개 변수 타입이 배열일 때는 `null`이나 길이 0인 배열 `new String[0]` 등 반드시 인자를 지정해주어야 하는 불편함이 있다.

### 주의점

```java
static String concatenate(String delim, String... args) { ... }
static String concatenate(String... args) { ... }

concatenate("-", "100", "200", "300");
```

- 위와 같은 상황에서 두 메서드 중 어느 것을 호출할 것인지 구분되지 않는다.
- 그러므로 가능하면 **가변인자를 사용한 메서드는 오버로딩 하지 않는 것이 좋다.**

# 4. 생성자(Constructor)

## 💡 생성자

### 생성자란?

- 인스턴스가 생성될 때 호출되는 **인스턴스 초기화 메서드**
- 인스턴스 변수의 초기화 작업에 주로 사용된다.
- 인스턴스를 생성하기 위해 사용했던 `클래스이름()`이 바로 생성자이며, 인스턴스를 생성할 때는 반드시 클래스 내에 정의된 생성자 중 하나를 선택하여 지정해주어야 한다.

### 생성자의 조건

1. 생성자의 이름은 클래스의 이름과 같다.
2. 생성자는 return 값이 없다 (`void`도 사용하지 않는다.)

## 💡 기본 생성자

- 모든 클래스에는 반드시 하나 이상의 생성자가 정의되어야 한다.
- 우리가 생성자를 정의하지 않고 인스턴스를 생성할 수 있었던 이유는 컴파일러가 제공하는 `기본 생성자(default constructor)` 덕분이다.
- **생성자가 하나도 정의되지 않은 경우**, 컴파일러는 `ClassName() { }` 과 같은 기본 생성자를 추가하여 컴파일한다.
  - 생성자가 하나라도 정의되었다면, 기본 생성자는 추가되지 않는다.
- 그러므로 특별히 인스턴스 초기화 작업이 필요없다면, 생성자를 정의하지 않아도 괜찮다.

## 💡 this()와 this

### 생성자 간 호출 - `this()`

- `클래스이름()` 대신 `this()` 를 사용한다.
- 반드시 첫 줄에서만 호출이 가능하다.
  - 작업 도중에 호출한다면, 이전 인스턴스 초기화 작업이 무의미해지기 때문이다.

### 사용법

```java
class Car {
    ...
    Car() {
        // this()는 첫 줄에 호출해야 한다.
        this("white", "auto", 4);
    }

    Car(String color, String gearType, int door) {
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }
}
```

### 인스턴스 자신을 가리키는 참조변수 - `this`

- 생성자에서 인스턴스 변수를 초기화할 때 받는 매개변수와 인스턴스 변수는 의미상 일치하므로, 같은 이름을 사용하는 경우가 많다.
- 이럴 때, 인스턴스 변수를 구분하기 위해 `this.인스턴스변수`의 형태로 사용한다.
- 이 때 `this`는 인스턴스의 참조변수이다.

```java
Car(String color, String gearType, int door) {
//  인스턴스 변수와 매개 변수의 이름이 같을 때, 구분하기 위해 `this.인스턴스변수` 를 사용한다.
    this.color = color;
    this.gearType = gearType;
    this.door = door;
}

//    아래와 같이 인스턴스 변수와 매개변수의 이름을 달리하면 this.를 쓸 필요가 없지만,
//    this.를 쓰는 편이 의미를 알아차리기 쉽기 때문에 아래와 같은 방법은 지양한다.

//    Car(String c, String g, int d) {
//        color = c;
//        gearType = g;
//        door = d;
//    }
```

### 정리

같은 `this`를 사용하고 있지만, `this()`는 생성자, `this`는 인스턴스의 참조변수이다.

## 💡 생성자를 이용한 인스턴스 복사

- 생성자의 매개변수를 클래스의 참조변수로 선언한다.

```java
// 생성자
Car(Car c) {
    color = c.color;
    gearType = c.gearType;
    door = c.door;
}

// 인스턴스 생성
Car c1 = new Car();
Car c2 = new Car(c1);    // c1의 복사본 c2를 생성
```

# 5. 변수의 초기화

## 💡 변수의 초기화란?

변수를 선언하고 처음으로 값을 저장하는 것.

- 멤버변수 : 초기화하지 않아도 자동적으로 변수의 자료형에 맞는 기본값으로 초기화 됨
- 지역변수 : 사용하기 전에 반드시 초기화해야 함

## 💡 지역변수의 초기화

```java
int i=10;
int i=10, j=10;    // 같은 타입의 변수는 ,를 사용해서 함께 선언/초기화 가능

int i=10;
int j=i;    // 다른 변수의 값으로 초기화 가능
```

## 💡 멤버변수의 초기화

명시적 초기화, 생성자, 초기화 블럭 방법이 있다.

### 명시적 초기화(explicit initialization)

- 변수를 선언과 동시에 초기화
  - 기본형 : `int door = 4;`
  - 참조형 : `Engine e = new Engine();`
- 가장 기본적이면서 간단하므로, 가장 우선적으로 고려한다.

### 초기화 블럭(initialization block)

```java
class InitBlock {
        static { /* 클래스 초기화블럭 */ }

    { /* 인스턴스 초기화 블럭 */ }
}
```

- **클래스 초기화 블럭** : 클래스 변수의 복잡한 초기화에 사용
  - `static { }`
  - 클래스가 메모리에 처음 로딩될 때 한번만 수행
- **인스턴스 초기화 블럭** : 인스턴스 변수의 복잡한 초기화에 사용
  - `{ }`
  - 인스턴스를 생성할 때 마다 수행되며, 생성자보다 먼저 수행된다.
  - 인스턴스 변수 초기화는 주로 생성자를 사용하고, 모든 생성자에서 공통으로 사용되는 코드를 초기화 블럭에 작성한다.

### 멤버변수의 초기화 순서

- 클래스 변수 : 기본값 → 명시적 초기화 → 클래스 초기화 블럭
- 인스턴스 변수 : 기본값 → 명시적 초기화 → 인스턴스 초기화 블럭 → 생성자

# 6. 상속(inheritance)

## 💡 클래스간의 관계 -상속

### 상속이란?

- 기존 클래스를 재사용하여 새로운 클래스를 작성하는 것
- 자손 클래스는 조상 클래스의 모든 멤버를 상속받으며, 생성자와 초기화 블럭은 상속되지 않음
- 접근 제어자가 `private` 또는 `default`인 멤버는 상속되지만, 자손 클래스에서 접근이 제한됨
- 코드 재사용성 높임
- 코드의 중복 제거 (자손 클래스의 중복된 코드를 조상 클래스에 작성)

### 사용법

```java
class Parent {}
class Child extends Parent {}
class GrandChild extends Child {}

Child c = new Chile();
```

자손 클래스의 인스턴스를 생성하면 **조상 클래스의 멤버와 자손 클래스의 멤버가 합쳐진 하나의 인스턴스**로 생성된다.

### 활용

전체 프로그램을 구성하는 클래스들을 면밀히 분석하여 클래스 간 상속관계를 적절히 맺어 주는 것이 객체지향 프로그래밍에서 중요하다.

## 💡 클래스간의 관계 - 포함관계

- 상속 이외에 클래스를 재사용하는 또 다른 방법이다.
- 한 클래스의 멤버변수로 다른 클래스 타입의 참조변수를 선언하는 것

### 사용법

```java
class Point {
    int x;
    int y;
}

class Circle {
        Point c = new Point();
        int r;
}
```

`Circle`클래스에 필요한 x, y(좌표), r(반지름) 멤버변수를 모두 작성하기보다, 추후 재사용될 수 있는 좌표 클래스 `Point`를 선언하고 `Circle` 클래스에서 멤버변수로 선언해서 포함시켰다.

## 💡 클래스간 관계 결정하기

상속과 포함 관계는 결과적으로 기능상 별 차이는 없다.

의미상 동등 관계인지, 포함 관계인지 따져서 결정한다.

```java
// 1. 원(Circle)은 점(Point)이다. -> 동등 관계 - 상속
class Circle extends Point {}

// 2. 원(Circle)은 점(Point)를 가지고 있다 -> 포함 관계
class Circle {
    Point c = new Point();
    ...
}
```

- 말로 풀어보면 `Circle`과 `Point`는 의미상 2번(포함 관계)가 더 적절함을 알 수 있다.
- `SportsCar` 클래스와 `Car` 클래스는 상속이 적절할 것이다.

## 💡 단일 상속

- Java에서는 오직 **단일 상속**만을 허용한다.
  `class Child extends Parent1, Parent2 {} (x)`
- 다중 상속을 허용하는 경우, 선언부(이름과 매개변수)가 같은 상속된 메서드를 구별할 방법이 없다.
- 따라서 Java는 다중 상속의 장점을 포기하고, 클래스 간의 관계가 보다 명확해지고 코드를 신뢰할 수 있게 만들어주는 단일 상속만을 허용한다.

## 💡 Object클래스

- Object클래스는 모든 클래스의 조상이다.
- 다른 클래스의 상속을 받지 않는 클래스는 자동적으로 `extends Objcet` 하게 된다.
- 상속을 받는 경우라도, 조상 클래스로 거슬러 올라가면 결국 Object를 상속하므로, 모든 클래스의 최상위 조상은 Object 클래스이다.
- Object 클래스에는 `toString()`, `equals()` 와 같은 메서드가 정의되어 있어 우리는 따로 정의없이 이런 메서드들을 사용할 수 있다.

# 7. 오버라이딩(overriding)

## 💡 오버라이딩

### 오버라이딩이란?

조상 클래스로부터 상속받은 메서드의 내용을 변경하는 것

### 오버라이딩의 조건

- 선언부가 일치해야 한다
  - 이름
  - 매개변수
  - 반환타입
- **접근 제어자**와 **예외**는 제한된 조건 하에 변경할 수 있다.
  - 접근 제어자 : 조상 클래스의 메서드보다 좁은 범위일 수 없다.
    - 넓 `public` > `protected` > `(default)` > `private` 좁
  - 예외 : 조상 클래스의 메서드보다 많은 수의 예외를 선언할 수 없다.

### 오버로딩 vs 오버라이딩

- 오버로딩(overloading) : 기존에 없는 새로운 메서드를 정의 (new)
- 오버라이딩(overriding) : 상속받은 메서드의 내용을 변경 (modify)

```java
class Parent {
		void parentMethod() {}
}

class Chile extends Parent {
		void parentMethod() {}    // 오버라이딩
		void parentMethod(int i) {}    // 오버로딩

		void childMethod() {}
		void childMethod(int i) {}    // 오버로딩
}
```

## 💡 super - 조상 클래스의 멤버

조상 클래스의 멤버와 자손 클래스의 멤버가 중복 정의되어 구변해야 하는 경우 `super` 사용

### `super` & `this`

- **공통점**
  - 인스턴스의 참조변수
  - 인스턴스 메서드에서만 사용할 수 있다 (static(클래스) 메서드는 인스턴스와 관련 없기 때문에 인스턴스 변수와 무언가를 구별할 필요가 없다.)
- **차이점**
  | super | 조상의 멤버(super)와 자신의 멤버를 구별 |
  | ----- | --------------------------------------- |
  | this | 매개 변수와 인스턴스 변수(this)를 구별 |

### 활용

```java
class Parent {
    int x=10;

		String getNum() {
        return "x :" + x;
    }
}

class Child extends Parent {
    int x=20;

    void method() {
        System.out.println("x=" + x);               // x=20
        System.out.println("this.x=" + this.x);     // this.x=20
        System.out.println("super.x=" + super.x);   // super.x=10
    }

    String getNum() {                               // 오버라이딩
        return super.getNum() + ", x:" + x;         // 조상의 메서드에 작업 덧붙이기
    }
}
```

## 💡 super() - 조상 클래스의 생성자

- Object 클래스를 제외한 **모든 클래스의 생성자 첫 줄에 `생성자`, `this()`, 또는 `super()`를 호출해야 한다.** (조상 클래스의 멤버를 초기화하기 위함)
- `super()`는 extends 받은 조상 클래스의 생성자를 호출하는 메서드이다.

### 상속 관계에서 super()의 사용과 생성자 호출 과정 실습 → [🔗링크](https://github.com/mirimy97/java.spring/blob/master/javajungsuk/ch07/PointTest.java)

어떤 클래스의 인스턴스를 생성하면 **자손(자신) ~ 조상 ~ … ~ Object 클래스**까지의 생성자가 순차적으로 호출된다.

# 8. package와 import

## 💡 패키지(package)

### 패키지란?

- 서로 관련된 클래스들끼리의 묶음
- 클래스 또는 인터페이스를 포함시킬 수 있음
- 패키지끼리도 포함될 수 있다.
- 서로 다른 패키지에 존재한다면 클래스는 같은 이름을 가질 수 있다.

### 패키지의 선언

```java
// 위치 : 클래스나 인터페이스 소스파일(.java)의 맨 위
package 패키지명;
```

## 💡 import문

- 소스파일에 사용된 클래스의 패키지 정보를 컴파일러에게 제공한다.
- 소스코드에서 클래스의 패키지명을 생략할 수 있다.
  - `java.util.Date` → `Date`

### import문 선언

```java
// package문

// import문 선언 위치
import 패키지명.클래스명;   // 특정 클래스만
import 패키지명.*;          // 전체

// 클래스 선언
```

- `.*` 는 패키지 내의 모든 클래스를 포함할 수 있으나, **패키지를 포함할 수 는 없다.**
- 매우 빈번히 사용되는 `java.lang.*` 패키지는 모든 소스파일에 묵시적으로 선언되어 있다.

## 💡 static import문

- 특정 **클래스의 static 멤버를 사용할 때,** 클래스 정보를 컴파일러에게 제공한다.
- static 멤버의 클래스명을 생략할 수 있다.

  ```java
  import static java.lang.Integer.*;    // Integer클래스의 모든 static 멤버
  import static java.lang.Math.random;  // Math 클래스의 random() 메서드만
  import static java.lang.System.out;   // System 클래스의 클래스 변수 out

  // System.out.println(Math.random());
  out.println(random());   // System과 Math 클래스이름을 생략했다.
  ```

# 9. 제어자(modifier)

## 💡 제어자란?

- 클래스/변수/메서드의 선언부에 함께 사용되어 부가적인 의미를 부여한다.
- 종류
  - **접근 제어자** : `public` `protected` `default` `private`
  - 그 외 제어자 : `static` `final` `abstract` `native` `transient` `synchronized` `volatile` `strictfp`
- 여러 제어자를 조합하여 사용할 수 있으나, 접근 제어자는 하나만 선택해야 한다.

## 💡 그 외 제어자 (static, final, abstract)

### `static` - 클래스의, 공통적인

- 사용될 수 있는 곳 - 멤버변수, 메서드, 초기화 블럭
  - static 멤버 변수 : 모든 인스턴스에 공통적으로 사용
  - static 메서드 : 인스턴스 생성 없이 사용할 수 있으며, 인스턴스 멤버를 사용하지 않는다.

### `final` - 마지막의, 변경될 수 없는

- 사용될 수 있는 곳 - 클래스, 메서드, 멤버변수, 지역변수

  - 변수(멤버변수/지역변수) : 값을 변경할 수 없는 상수가 됨

    - 상수이므로, 일반적으로 선언과 초기화를 동시에 함
      ```java
      final int NUMBER = 10;
      ```
    - 인스턴스 변수의 경우, 인스턴스 생성 시 생성자에서 초기화 되도록 할 수 있다.

      ```java
      class Number {
          final int NUM;    // 참조변수.NUM = 20; 과 같이 값 변경 X

          Number(int num) {
              NUM = num;    // 인스턴스 변수 초기화
          }
      }
      ```

  - 메서드 : 오버라이딩하여 변경할 수 없는 메서드
  - 클래스 : 자신을 확장하는 자손 클래스를 정의할 수 없게 됨

### `abstract` - 추상의, 미완성의

- 사용될 수 있는 곳 - 클래스, 메서드
  - 클래스 : 클래스 내에 추상 메서드가 선언되어 있음
    - 인스턴스를 생성할 수 없다 (인스턴스를 생성해도 할 수 있는 것이 없음)
  - 메서드 : 선언부만 작성한 상태 (추상 메서드임)

## 💡 접근 제어자(access modifier)

- 사용될 수 있는 곳 - 클래스, 멤버변수, 메서드, 생성자
  - 클래스 : `public` `(default)`
  - 메서드, 멤버변수 : `public` `protected` `(default)` `private`
  - 지역변수 : 없음
- 접근 범위

|           | 같은 클래스 | 같은 패키지 | 자손 클래스 | 전체 |
| --------- | ----------- | ----------- | ----------- | ---- |
| public    | O           | O           | O           | O    |
| protected | O           | O           | O           |      |
| (default) | O           | O           |             |      |
| private   | O           |             |             |      |

### 접근 제어자를 이용한 캡슐화 ⇒ **[🔗 실습 예시](https://github.com/mirimy97/java.spring/blob/master/javajungsuk/ch07/Time.java)**

- 외부로부터 데이터를 감추어 보호할 수 있다.
- 외부에는 불필요한, 내부적으로만 사용되는 멤버들을 private으로 감출 수 있다.
- (예시) 멤버 변수에 접근 제어자 `private` 또는 `protected`를 지정하고, setter 메서드를 통해서 멤버 변수의 값을 변경 할 수 있게 한다. → 멤버 변수을 `public` 으로 지정하면 조건에 맞는 값인지 검사할 수 없기 때문이다.

### 생성자의 접근 제어자 ⇒ [🔗 실습 예시](https://github.com/mirimy97/java.spring/blob/master/javajungsuk/ch07/SingletonTest.java)

- 생성자에 접근 제어자를 사용하여 인스턴스의 생성을 제한할 수 있다.
- 대신 내부에서 인스턴스를 생성하고, `public` 메서드를 통해 인스턴스에 접근하게 함으로써 사용할 수 있는 **인스턴스의 개수를 제한**할 수 있다.

## 💡 제어자의 조합

### 정리

| 대상     | 사용가능한 제어자                         |
| -------- | ----------------------------------------- |
| 클래스   | public, (defualt), final, abstract        |
| 메서드   | 모든 접근 제어자, final, abstract, static |
| 멤버변수 | 모든 접근 제어자, final, static           |
| 지역변수 | final                                     |

### 주의

1. 메서드에 `static` 과 `abstract`를 함께 사용할 수 없음
   - static 메서드는 몸통이 있는 메서드에만 사용할 수 있고, abstract는 구현부가 없다.
2. 클래스에 `abstract`와 `final`을 동시에 사용할 수 없음
   - final은 클래스를 확장(자손) 할 수 없고, abstract는 상속을 통해 완성되어야 한다.
3. `abstract` 메서드의 접근 제어자가 `private` 일 수 없음
   - private은 자손클래스에서 접근이 불가능하고, abstract는 상속을 통해 구현되어야 한다.
4. 메서드에 `private`와 `final`을 같이 사용할 필요는 없음.
   - 둘 다 오버라이딩X, 외부 접근X 이기 때문에 의미가 중복된다.

# 10. 다형성(polymorphism)

## 💡 다형성이란?

- 객체 지향 개념에서 : 여러 가지 형태를 가질 수 있는 능력

```java
class Tv {}    // 조상 메서드
class CaptionTv extends Tv {}    // 자손 메서드

// 인스턴스 생성
CaptionTv c = new CaptionTv();
Tv t = new CaptionTv();    // (o)
// CaptionTv c1 = new Tv();    // (x) -> 참조변수가 사용할 수 있는 멤버 개수가 더 많기 때문
```

- Java에서는 조상클래스 타입의 참조변수(`t`)로 자손클래스의 인스턴스를 참조할 수 있게 했다.
- 이 경우에 인스턴스 생성은 되지만 자손클래스 `CaiptionTv` 에 별도로 선언된 멤버는 사용할 수 없고, 조상클래스에서 상속받은 멤버에만 접근할 수 있다.
- **참조변수의 타입이 사용할 수 있는 멤버 개수 ≤ 인스턴스의 멤버 개수**
  - `=`를 기준으로 좌측 `Tv t`은 인스턴스에 접근하는 역할, 우측 `new CaptionTv();`은 실제 메모리에 인스턴스를 생성하는 역할으로 이해하자.

## 💡 참조변수의 형변환

**✅ 참조변수의 형변환을 통해 참조하고 있는 인스턴스에서 사용할 수 있는 멤버의 범위를 조절한다.**

- 종류
  - (Up-casting) 자손타입 → 조상타입 : 형변환 생략 가능
  - (Down-cansting) 조상타입 → 자손타입 : 형변환 생략 불가

### 사용법

```java
Parent parent = null;
Child child = new Child();
Child child2 = null;

// parent = (Parent) child;
parent = child;    // 자손 -> 조상 (형변환 생략 가능)
child2 = (Child) parent;    // 조상 -> 자손 (형변환 생략 불가)
```

- 형변환 생략 가능 여부에 대한 이유
  - (가능한 경우) `parent` 참조변수가 다룰 수 있는 멤버는 `child`가 참조하고 있는 인스턴스의 멤버와 같거나 적을 것이 분명하기 때문이다.
  - (불가능한 경우) `parent` → `child`로 참조변수를 형변환했을 때, `parent`가 가지고 있는 인스턴스의 멤버보다 `child` 가 다루는 멤버가 더 많을 가능성이 있다.

## 💡 instanceof 연산자

참조변수와 인스턴스의 타입이 꼭 일치하지는 않는다.

그래서 인스턴스의 실제 타입을 알아보기 위해, 주로 조건문에서 사용된다.

### 사용법

```java
if (c instanceof Parent) {}    // true / false
```

- 값이 `true`로 반환된다면, **참조변수가 검사한 타입으로 형변환 될 수 있다**는 의미이다.
- 경우의 수
  - 같은 타입 (`c instanceof Child`)
    - 모든 경우에서 `true`
  - 자손 → 조상 (`c instanceof Parent`)
    - 모든 경우에서 `true` : 참조변수의 개수가 `c` ≥ `Parent`
  - 조상 → 자손 (`p instanceof Chlid`)
    - `true` 경우 : 참조변수의 개수가 `p` = `Child`
    - `false` 경우 : 참조변수의 개수가 `p` < `Child`

### 사용법

```java
Parent parent = null;
Child child = new Child();
Child child2 = null;

// parent = (Parent) child;
parent = child;    // 자손 -> 조상 (형변환 생략 가능)
child2 = (Child) parent;    // 조상 -> 자손 (형변환 생략 불가)
```

- 형변환 생략 가능 여부에 대한 이유
  - (가능한 경우) `parent` 참조변수가 다룰 수 있는 멤버는 `child`가 참조하고 있는 인스턴스의 멤버와 같거나 적을 것이 분명하기 때문이다.
  - (불가능한 경우) `parent` → `child`로 참조변수를 형변환했을 때, `parent`가 가지고 있는 인스턴스의 멤버보다 `child` 가 다루는 멤버가 더 많을 가능성이 있다.

### 활용1 : 매개변수의 다형성

하나의 조상을 상속받은 여러 자손 클래스들의 인스턴스를 한 번에 처리하는 메서드를 만드려고 할 때, 다형성을 이용할 수 있다. → [🔗 예제 실습 링크](https://github.com/mirimy97/java.spring/blob/babdedeff00e7ccfd537d29ab09d823fce3e4546/javajungsuk/ch07/PolyArgumentTest.java)

### 활용2 : 객체 배열 다루기

```java
Parent p[] = new Parent[n];

p[0] = new Child1();
p[1] = new Child2();
```

공통의 조상 `Parent`를 가진 서로 다른 객체들을 배열로 묶어 사용할 수 있다.

## 💡 instanceof 연산자

참조변수와 인스턴스의 타입이 꼭 일치하지는 않는다.

그래서 인스턴스의 실제 타입을 알아보기 위해, 주로 조건문에서 사용된다.

### 사용법

```java
if (c instanceof Parent) {}    // true / false
```

- 값이 `true`로 반환된다면, **참조변수가 검사한 타입으로 형변환 될 수 있다**는 의미이다.
- 경우의 수
  - 같은 타입 (`c instanceof Child`)
    - 모든 경우에서 `true`
  - 자손 → 조상 (`c instanceof Parent`)
    - 모든 경우에서 `true` : 참조변수의 개수가 `c` ≥ `Parent`
  - 조상 → 자손 (`p instanceof Chlid`)
    - `true` 경우 : 참조변수의 개수가 `p` = `Child`
    - `false` 경우 : 참조변수의 개수가 `p` < `Child`

## 💡 참조변수와 인스턴스의 연결

조상 클래스와 자손 인스턴스에 **중복된 멤버변수를 선언**하여 자손 인스턴스를 사용하는 경우

- 조상타입의 참조변수 `Parent p = new Child();` → 조상 클래스에 선언된 멤버변수 사용
- 자손타입의 참조변수 `Child c = new Child();` → 자손 클래스에 선언된 멤버변수 사용

단, 중복된 메서드(오버라이딩)의 경우는 참조변수 타입 관계없이 자손의 메서드를 사용한다.

[🔗 예제 실습 링크](https://github.com/mirimy97/java.spring/blob/8468466339efc2077fafe0b0120026aeeda4794c/javajungsuk/ch07/BindingTest.java)
