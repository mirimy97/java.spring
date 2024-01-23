# 목차

1. [객체 지향 설계와 스프링](#1-객체-지향-설계와-스프링)

2. [스프링 핵심 원리의 이해](#2-스프링-핵심-원리-이해)

3. [컴포넌트 스캔](#3-컴포넌트-스캔)

---

# 1. 객체 지향 설계와 스프링

## 💡 스프링이란?

### 스프링 프레임워크

![Untitled](/pic/1.png)

- 핵심 기술: 스프링 DI 컨테이너, AOP, 이벤트, 기타
- 웹 기술: 스프링 MVC, 스프링 WebFlux
- 데이터 접근 기술: 트랜잭션, JDBC, ORM 지원, XML 지원
- 기술 통합: 캐시, 이메일, 원격접근, 스케줄링
- 테스트: 스프링 기반 테스트 지원
- 언어: 코틀린, 그루비
- 최근에는 스프링 부트를 통해서 스프링 프레임워크의 기술들을 편리하게 사용

### 스프링 부트

- **스프링을 편리하게 사용할 수 있도록 지원, 최근에는 기본으로 사용**
- 단독으로 실행할 수 있는 스프링 애플리케이션을 쉽게 생성
- Tomcat 같은 웹 서버를 내장해서 별도의 웹 서버를 설치하지 않아도 됨
- 손쉬운 빌드 구성을 위한 starter 종속성 제공
- 스프링과 3rd party(외부) 라이브러리 자동 구성
- 메트릭, 상태 확인, 외부 구성 같은 프로덕션 준비 기능 제공
- 관례에 의한 간결한 설정

## 💡 왜 만들었나? (핵심 개념)

- 스프링은 **좋은 객체 지향** 애플리케이션을 개발할 수 있도록 도와주는 프레임워크

## 💡 객체 지향 특징

- 추상화
- 캡슐화
- 상속
- **다형성**

## 💡 객체 지향 프로그래밍

- 컴퓨터 프로그램을 명령어의 목록으로 보는 시각에서 벗어나 여러 개의 독립된 단위, 즉 **객체들의 모임**으로 파악하고자 하는 것.
- 각각의 **객체**는 **메시지**를 주고받고, 데이터를 처리할 수 있다 **(협력)**
- 객체 지향 프로그래밍은 프로그램을 **유연하고 변경이 용이**하게 만들기 때문에 대규모 소프트웨어 개발에 많이 사용된다.

### \* 유연하고 변경 용이하다? ⇒ “다형성”

- 물건의 부품을 갈아 끼우듯이, 컴포넌트를 쉽고 유연하게 변경하면서 개발할 수 있는 방법을 뜻함.

## 💡 역할과 구현을 분리

**역할(인터페이스)**와 **구현(구현체)**으로 구분하면 세상이 단순해지고, 유연해지며 변경도 편리해진다.

- 클라이언트는 대상의 역할만 알면 된다.
- 클라이언트는 구현 대상의 내부 구조를 몰라도 된다.
- 클라이언트는 구현 대상의 내부 구조가 변경되어도 영향을 받지 않는다.
- 클라이언트는 구현 대상 자체를 변경해도 영향을 받지 않는다.

### 자바 언어에서는 ?

- 역할 = 인터페이스
- 구현 = 인터페이스를 구현한 클래스
- 객체를 설계할 때 역할과 구현을 명확히 분리

## 💡 다형성의 본질

- 인터페이스를 구현한 객체 인스턴스를 **실행 시점에 유연하게 변경**할 수 있다.
- **클라이언트를 변경하지 않고, 서버의 구현 기능을 유연하게 변경할 수 있다.**

## 💡 스프링과 객체 지향

- 다형성이 가장 중요하다!
- 스프링은 다형성을 극대화해서 이용할 수 있게 도와준다.
- 스프링에서의 제어의 역전(IoC), 의존관계 주입(DI)은 다형성을 활용하여 역할과 구현을 편리하게 다룰 수 있도록 지원한다.

## 💡 SOLID

클린코드로 유명한 로버트 마틴이 좋은 객체 지향 설계의 5가지 원칙을 정리

- SRP: 단일 책임 원칙(single responsibility principle)
- OCP: 개방-폐쇄 원칙 (Open/closed principle)
- LSP: 리스코프 치환 원칙 (Liskov substitution principle)
- ISP: 인터페이스 분리 원칙 (Interface segregation principle)
- DIP: 의존관계 역전 원칙 (Dependency inversion principle)

### SRP 단일 책임 원칙

- 한 클래스는 하나의 책임만 가져야 한다.
- 하나의 책임이라는 것은 모호하다.
  - 큰가, 작은가?
  - 문맥과 상황에 따라 다름
- 중요한 기준은 **변경**. 변경이 있을 때 파급 효과가 적으면 단일 책임 원칙을 잘 따른 것
- ex) UI 변경, 객체의 생성과 사용을 분리

### OCP 개방-폐쇄 원칙

- 소프트웨어 요소는 **확장에는 열려** 있으나, **변경에는 닫혀** 있어야 한다.
- 확장 = 기존 인터페이스를 구현한 클래스를 새로 작성하여 확장
- 변경 = 다형성을 활용하여 기존 코드에는 변경 x

### LSP 리스코프 치환 원칙

- 프로그램의 객체는 프로그램의 정확성을 깨뜨리지 않으면서 하위 타입의 인스턴스로 바꿀 수 있어야 한다.
- 다형성에서 하위 클래스는 인터페이스 규약을 다 지켜야 함.
- 다형성을 지원하기 위해 인터페이스를 구현한 구현체를 믿고 사용하려면, 이 원칙이 필요하다.
- 단순 컴파일 성공을 넘어, 기능을 충실히 구현해야 한다는 이야기
- ex ) 자동차 인터페이스의 엑셀은 앞으로 가라는 기능이다. 뒤로 가게 구현한다면 LSP를 위반한다.

### ISP 인터페이스 분리 원칙

- 특정 클라이언트를 위한 인터페이스 여러 개가 범용 인터페이스 하나보다 낫다.
- 인터페이스를 분리함으로써 기능이 명확해지고, 대체 가능성이 높아진다
- ex )
  - 자동차 인터페이스 → 운전 인터페이스 / 정비 인터페이스로 분리
  - 사용자 인터페이스 → 운잔저 인터페이스 / 정비사 인터페이스로 분리
  - 분리하면 정비 인터페이스 자체가 변해도 운전자 클라이언트에는 영향이 없다.

### DIP 의존관계 역전 원칙

- 프로그래머는 “추상화(인터페이스)에 의존해야하지, 구체화(구현체)에 의존하면 안된다.”
- 역할(Role)에 의존하게 해야 한다.
- 객체 세상도 클라이언트가 인터페이스에 의존해야 유연하게 구현체를 변경할 수 있다.

### 문제점

```java
public class MemberService {
    // 기존 코드
    // private MemberRepository memberRepository = new MemoryMemberRepository();
    // 변경 코드
    private MemberRepository memberRepository = new JdbcMemberRepository();
}
```

- **OCP 위반**
  - `MemberService` 클라이언트가 구현 클래스를 직접 선택 (`MemoryMemberRepository` / `JdbcMemberRepository`)
  - 다형성을 사용했지만, 구현 객체를 변경하기 위해 클라이언트 코드 변경이 필요하다.
  - 어떻게 해결 ? → 객체를 생성, 연관 관계를 맺어주는 별도의 조립, 설정자가 필요하다 → 이것이 spring
- **DIP 위반**
  - `MemberService` 클라이언트가 구현체인 `MemoryMemberRepository`, `JdbcMemberRepository`까지 알고 있다. (코드로 작성했기 때문에)

⇒ 위 코드는 다형성을 지키고 있지만, **다형성만으로는 OCP, DIP를 지킬 수 없다.**

⇒ 뭔가 더 필요하다.

## 💡 다시 스프링으로

### 스프링 이야기에 왜 객체 지향이 나오는가?

- **스프링은 다음 기술로 다형성 + OCP, DIP를 가능하게 지원**
  - DI(Dependency Ingection) : 의존관계, 의존성 주입
  - DI 컨테이너 제공
- 클라이언트 코드의 변경 없이 기능 확장
- 쉽게 부품 교체하듯 개발 가능

---

# 2. 스프링 핵심 원리 이해

## 💡 제어의 역전 IoC (Inversion of Control)

- 기존 프로그램은 클라이언트 구현 객체가 스스로 필요한 서버 구현 객체를 생성하고, 연결하고, 실행했다. 한마디로 구현 객체가 프로그램의 제어 흐름을 스스로 조종했다. 개발자 입장에서는 자연스러운 흐름이다.
- 반면에 `AppConfig`가 등장한 이후에 구현 객체는 자신의 로직을 실행하는 역할만 담당한다. 프로그램의 제어 흐름은 이제 `AppConfig`가 가져간다. 예를 들어서 `OrderServiceImpl` 은 필요한 인터페이스들을 호출하지만 어떤 구현 객체들이 실행될지 모른다.
- 프로그램에 대한 제어 흐름에 대한 권한은 모두 `AppConfig`가 가지고 있다. 심지어 `OrderServiceImpl` 도 `AppConfig`가 생성한다. 그리고 `AppConfig`는 `OrderServiceImpl` 이 아닌 `OrderService` 인터페이스의 다른 구현 객체를 생성하고 실행할 수 도 있다. 그런 사실도 모른체 `OrderServiceImpl` 은 묵묵히 자신의 로직을 실행할 뿐이다.
- 이렇듯 프로그램의 제어 흐름을 직접 제어하는 것이 아니라 외부에서 관리하는 것을 **제어의 역전(IoC)**이라 한다.

### 프레임워크 vs 라이브러리

- 프레임워크가 내가 작성한 코드를 제어하고, 대신 실행하면 그것은 프레임워크가 맞다. (JUnit)
- 반면에 내가 작성한 코드가 직접 제어의 흐름을 담당한다면 그것은 프레임워크가 아니라 라이브러리다.

## 💡 의존관계 주입 DI(Dependency Injection)

- `OrderServiceImpl` 은 `DiscountPolicy` 인터페이스에 의존한다. 실제 어떤 구현 객체가 사용될지는 모른다.
- 의존관계는 정적인 클래스 의존 관계와, 실행 시점에 결정되는 동적인 객체(인스턴스) 의존 관계 둘을 분리해서 생각해야 한다.

### 정적인 클래스 의존관계

클래스가 사용하는 import 코드만 보고 의존관계를 쉽게 판단할 수 있다. 정적인 의존관계는 애플리케이션을 실행하지 않아도 분석할 수 있다. 클래스 다이어그램을 보자
`OrderServiceImpl` 은 `MemberRepository` , `DiscountPolicy` 에 의존한다는 것을 알 수 있다.
그런데 이러한 클래스 의존관계 만으로는 실제 어떤 객체가 `OrderServiceImpl` 에 주입 될지 알 수 없

### IoC 컨테이너, DI 컨테이너

- `AppConfig` 처럼 객체를 생성하고 관리하면서 의존관계를 연결해 주는 것을 IoC 컨테이너 또는 **DI 컨테이너**라 한다.
- 의존관계 주입에 초점을 맞추어 최근에는 주로 DI 컨테이너라 한다.
- 또는 어샘블러, 오브젝트 팩토리 등으로 불리기도 한다.

## 💡 스프링 컨테이너

- `ApplicationContext` 를 스프링 컨테이너라 한다.
- 기존에는 개발자가 `AppConfig` 를 사용해서 직접 객체를 생성하고 DI를 했지만, 이제부터는 스프링 컨테이너를 통해서 사용한다.
- 스프링 컨테이너는 `**@Configuration` 이 붙은** `AppConfig` 를 설정(구성) 정보로 사용한다. 여기서 `**@Bean` 이라 적힌 메서드를 모두 호출해서 반환된 객체를 스프링 컨테이너에 등록**한다. 이렇게 스프링 컨테이너에 등록된 객체를 **스프링 빈\*\*이라 한다.
- 스프링 빈은 `@Bean` 이 붙은 메서드의 명을 스프링 빈의 이름으로 사용한다. ( `memberService` ,
  `orderService` )
- 이전에는 개발자가 필요한 객체를 `AppConfig` 를 사용해서 직접 조회했지만, 이제부터는 스프링 컨테이너를 통해서 필요한 스프링 빈(객체)를 찾아야 한다. 스프링 빈은 `applicationContext.getBean()` 메서드를 사용해서 찾을 수 있다.
- 기존에는 개발자가 직접 자바코드로 모든 것을 했다면 이제부터는 스프링 컨테이너에 객체를 스프링 빈으로 등록하고, 스프링 컨테이너에서 스프링 빈을 찾아서 사용하도록 변경되었다.
- 코드가 약간 더 복잡해진 것 같은데, 스프링 컨테이너를 사용하면 어떤 장점이 있을까?

## 💡 BeanFactory와 ApplicationContext

### 상속 관계

`AnnotationConfigApplicationContext` → `<<interface>>ApplicationContext` → `<<interface>>BeanFactory`

### BeanFactory

- 스프링 컨테이너의 최상위 인터페이스다.
- 스프링 빈을 관리하고 조회하는 역할을 담당한다.
- `getBean()` 을 제공한다.
- 지금까지 우리가 사용했던 대부분의 기능은 BeanFactory가 제공하는 기능이다.

### ApplicationContext

- BeanFactory 기능을 모두 상속받아서 제공한다.
- 빈을 관리하고 검색하는 기능을 BeanFactory가 제공해주는데, 그러면 둘의 차이가 뭘까?
- 애플리케이션을 개발할 때는 빈을 관리하고 조회하는 기능은 물론이고, 수 많은 부가기능이 필요하다.
  - **메시지소스를 활용한 국제화 기능** : 예를 들어서 한국에서 들어오면 한국어로, 영어권에서 들어오면 영어로 출력
  - **환경변수** : 로컬, 개발, 운영등을 구분해서 처리
  - **애플리케이션 이벤트** : 이벤트를 발행하고 구독하는 모델을 편리하게 지원
  - **편리한 리소스 조회** : 파일, 클래스패스, 외부 등에서 리소스를 편리하게 조회

### 정리

- ApplicationContext는 BeanFactory의 기능을 상속받는다.
- ApplicationContext는 빈 관리기능 + 편리한 부가 기능을 제공한다.
- BeanFactory를 직접 사용할 일은 거의 없다. 부가기능이 포함된 ApplicationContext를 사용한다.
- BeanFactory나 ApplicationContext를 스프링 컨테이너라 한다

---

# 3. 컴포넌트 스캔

## 💡 컴포넌트 스캔과 의존관계 자동 주입

- 지금까지 스프링 빈을 등록할 때는 자바 코드의 `@Bean`이나 XML의 `<bean>` 등을 통해 설정 정보에 직접 등록할 스프링 빈을 나열했다.
- 스프링에서는 설정 정보가 없어도 자동으로 스프링 빈을 등록하는 컴포넌트 스캔이라는 기능을 제공한다.
- 또, 의존관계도 자동으로 주입하는 `@Autowired`라는 기능도 제공한다.

### 1. `@ComponentScan`

- `@ComponentScan` 은 `@Component` 가 붙은 모든 클래스를 스프링 빈으로 등록한다.
- 이때 스프링 빈의 기본 이름은 클래스명을 사용하되 맨 앞글자만 소문자를 사용한다.
  - **빈 이름 기본 전략**: `MemberServiceImpl` 클래스 → `memberServiceImpl`
  - **빈 이름 직접 지정**: 만약 스프링 빈의 이름을 직접 지정하고 싶으면 `@Component("memberService2")` 이런식으로 이름을 부여하면 된다

### 2. `@Autowired`

- 생성자에 `@Autowired` 를 지정하면, 스프링 컨테이너가 자동으로 해당 스프링 빈을 찾아서 주입한다.
- 이때 기본 조회 전략은 스프링 빈 컨테이너(저장소)에서 **타입이 같은 빈**을 찾아서 주입한다.
  - **getBean(MemberRepository.class)** 와 동일하다고 이해하면 된다.
  - 만약 같은 타입이 두 개 이상 있다면 ? 더 자세한 내용은 뒤에서 설명한다.

## 💡 탐색 위치 지정

```java
@ComponentScan(
				basePackages = "hello.core",
)
```

- `basePackages` : 탐색할 패키지의 시작 위치를 지정한다. 이 패키지를 포함해서 하위 패키지를 모두 탐색한다.
- `basePackages = {"hello.core", "hello.service"}` 이렇게 여러 시작 위치를 지정할 수도
  있다.
- `basePackageClasses`: 지정한 클래스의 패키지를 탐색 시작 위치로 지정한다.
- 만약 지정하지 않으면 `@ComponentScan` 이 붙은 설정 정보 클래스의 패키지가 시작 위치가 된다

### 권장하는 방법

패키지 위치를 지정하지 않고, 설정 정보 클래스 위치를 프로젝트 최상단으로 하는 것을 추천.

최근 스프링 부트도 이 방법을 기본으로 제공한다. (`@SpringBootApplication`의 위치)

### 컴포넌트 스캔 기본 대상

- `@Component` : 컴포넌트 스캔에서 사용
- `@Controller` : 스프링 MVC 컨트롤러에서 사용
- `@Service` : 스프링 비즈니스 로직에서 사용
- `@Repository` : 스프링 데이터 접근 계층에서 사용
- `@Configuration` : 스프링 설정 정보에서 사용

## 💡 필터

```java
AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);

@Configuration
@ComponentScan(includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class),
            excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class))
static class ComponentFilterAppConfig { }
```

- `includeFilters` : 컴포넌트 스캔 대상을 추가로 지정한다.
- `excludeFilters` : 컴포넌트 스캔에서 제외할 대상을 지정한다.

### FilterType 옵션

- `ANNOTATION`: 기본값, 애노테이션을 인식해서 동작한다.
  - ex) `org.example.SomeAnnotation`
- `ASSIGNABLE_TYPE`: 지정한 타입과 자식 타입을 인식해서 동작한다.
  - ex) `org.example.SomeClass`
- `ASPECTJ`: AspectJ 패턴 사용
  - ex) `org.example..*Service+*`
- _`REGEX`: 정규 표현식_
  - _ex) `org\.example\.Default.`_
- `CUSTOM`: TypeFilter 이라는 인터페이스를 구현해서 처리
  - ex) `org.example.MyTypeFilter`
