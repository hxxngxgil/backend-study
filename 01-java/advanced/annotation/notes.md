# Annotation

## 애노테이션이란

애노테이션은 코드에 추가 정보를 붙이는 문법이다.

자바 코드에 특별한 의미를 부여하거나  
프레임워크, 컴파일러, 런타임 도구가 사용할 정보를 제공한다.

예시

@Override

@Deprecated

@Test

---

## 애노테이션이 필요한 이유

일반적인 코드만으로는 클래스, 메서드, 필드에 대한 부가 정보를 표현하기 어렵다.

예를 들어 어떤 필드는 null이면 안 된다거나,  
어떤 메서드는 특정 URL 요청을 처리한다는 정보를 코드에 표시하고 싶을 수 있다.

이런 정보를 애노테이션으로 표현할 수 있다.

---

## 애노테이션 사용 예시

@Override
public String toString() {
    return "hello";
}

여기서 @Override는  
부모 클래스나 인터페이스의 메서드를 재정의했다는 의미를 가진다.

컴파일러는 이 정보를 보고  
오버라이딩이 제대로 되었는지 검사할 수 있다.

---

# 애노테이션 정의

직접 애노테이션을 만들 때는 @interface를 사용한다.

예시

public @interface MyAnnotation {
}

---

## 애노테이션 속성

애노테이션은 속성을 가질 수 있다.

예시

public @interface MyAnnotation {
    String value();
    int count();
}

사용 예시

@MyAnnotation(value = "hello", count = 10)

---

## value 속성

속성 이름이 value 하나만 있으면  
사용할 때 속성 이름을 생략할 수 있다.

예시

public @interface MyAnnotation {
    String value();
}

사용 예시

@MyAnnotation("hello")

---

## 기본값 설정

애노테이션 속성은 default 값을 가질 수 있다.

예시

public @interface MyAnnotation {
    String value() default "default";
    int count() default 0;
}

사용 예시

@MyAnnotation

---

## 애노테이션 속성 타입

애노테이션 속성에는 사용할 수 있는 타입이 제한된다.

사용 가능한 타입

- 기본형
- String
- Class
- enum
- annotation
- 위 타입들의 배열

예시

public @interface MyAnnotation {
    String name();
    int age();
    Class<?> type();
}

---

# 메타 애노테이션

메타 애노테이션은 애노테이션에 붙는 애노테이션이다.

즉, 직접 만든 애노테이션의 동작 방식을 설정할 때 사용한다.

대표 메타 애노테이션

- @Retention
- @Target
- @Documented
- @Inherited

---

## @Retention

@Retention은 애노테이션이 언제까지 유지될지 지정한다.

종류

- RetentionPolicy.SOURCE
- RetentionPolicy.CLASS
- RetentionPolicy.RUNTIME

---

## RetentionPolicy.SOURCE

소스 코드에만 존재한다.

컴파일 후에는 사라진다.

예시

@Override

---

## RetentionPolicy.CLASS

컴파일된 class 파일까지는 남아있지만  
런타임에는 사용할 수 없다.

---

## RetentionPolicy.RUNTIME

런타임까지 애노테이션 정보가 유지된다.

리플렉션으로 애노테이션 정보를 조회할 수 있다.

프레임워크나 검증기처럼 실행 중에 애노테이션을 읽어야 한다면  
RUNTIME을 사용해야 한다.

예시

@Retention(RetentionPolicy.RUNTIME)

---

## @Target

@Target은 애노테이션을 어디에 붙일 수 있는지 지정한다.

대표 위치

- ElementType.TYPE
- ElementType.FIELD
- ElementType.METHOD
- ElementType.PARAMETER
- ElementType.CONSTRUCTOR

---

## @Target 사용 예시

@Target(ElementType.FIELD)

의미

필드에만 붙일 수 있는 애노테이션이다.

예시

@Target({ElementType.TYPE, ElementType.METHOD})

의미

클래스와 메서드에 붙일 수 있는 애노테이션이다.

---

## @Documented

@Documented는 자바 문서 생성 시  
해당 애노테이션 정보를 문서에 포함하도록 한다.

---

## @Inherited

@Inherited는 부모 클래스에 붙은 애노테이션을  
자식 클래스가 상속받을 수 있게 한다.

주의

- 클래스 레벨 애노테이션에서만 동작한다.
- 메서드나 필드에 붙은 애노테이션은 상속되지 않는다.
- 인터페이스에는 적용되지 않는다.

---

# 애노테이션과 상속

애노테이션은 기본적으로 상속되지 않는다.

부모 클래스에 애노테이션이 붙어 있어도  
자식 클래스에서 자동으로 조회되지 않는다.

하지만 @Inherited를 사용하면  
클래스 레벨 애노테이션은 자식 클래스에서 조회할 수 있다.

---

## 애노테이션 상속 예시

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MyAnnotation {
}

@MyAnnotation
public class Parent {
}

public class Child extends Parent {
}

Child.class에서 MyAnnotation을 조회할 수 있다.

---

## 애노테이션 상속 주의점

@Inherited는 클래스에 붙은 애노테이션에만 적용된다.

적용 안 되는 경우

- 필드 애노테이션
- 메서드 애노테이션
- 생성자 애노테이션
- 파라미터 애노테이션
- 인터페이스 애노테이션

---

# 애노테이션 활용 - 검증기

애노테이션은 검증 로직을 만들 때 활용할 수 있다.

예를 들어 회원 객체의 필드에  
검증 조건을 애노테이션으로 표시할 수 있다.

---

## 검증 애노테이션 예시

@NotNull

@Range(min = 1, max = 100)

---

## NotNull 애노테이션

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface NotNull {
    String message() default "값이 null이면 안 됩니다.";
}

---

## Range 애노테이션

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Range {
    int min();
    int max();
    String message() default "범위를 벗어났습니다.";
}

---

## 검증 대상 객체 예시

public class Member {
    
    @NotNull
    private String name;

    @Range(min = 1, max = 100)
    private int age;
}

---

## 검증기 동작 흐름

1. 객체의 Class 정보를 얻는다.
2. getDeclaredFields()로 필드 목록을 조회한다.
3. 각 필드에 붙은 애노테이션을 확인한다.
4. setAccessible(true)로 private 필드에 접근한다.
5. 필드 값을 읽는다.
6. 애노테이션 조건에 맞게 검증한다.
7. 검증 실패 시 오류 메시지를 반환한다.

---

## 리플렉션과 애노테이션

애노테이션 자체는 정보를 표시하는 역할만 한다.

실제로 애노테이션을 읽고 동작하게 만들려면  
리플렉션이 필요하다.

예시

Field field = clazz.getDeclaredField("name");

NotNull notNull = field.getAnnotation(NotNull.class);

---

# 자바 기본 애노테이션

자바는 기본적으로 여러 애노테이션을 제공한다.

대표 애노테이션

- @Override
- @Deprecated
- @SuppressWarnings
- @FunctionalInterface
- @SafeVarargs

---

## @Override

부모 클래스나 인터페이스의 메서드를 재정의했음을 나타낸다.

장점

- 오버라이딩 실수를 컴파일 시점에 잡을 수 있다.
- 메서드 이름이나 파라미터가 틀리면 컴파일 오류가 발생한다.

예시

@Override
public String toString() {
    return "hello";
}

---

## @Deprecated

더 이상 사용하지 않는 코드임을 표시한다.

기존 코드를 바로 삭제하면 호환성 문제가 생길 수 있다.

그래서 당장은 남겨두지만  
앞으로 사용하지 말라는 의미로 @Deprecated를 붙인다.

---

## @SuppressWarnings

컴파일 경고를 숨길 때 사용한다.

예시

@SuppressWarnings("unchecked")

주의

경고를 무조건 숨기는 것은 좋지 않다.

정말 문제가 없다는 것이 명확할 때만 사용해야 한다.

---

## @FunctionalInterface

함수형 인터페이스임을 표시한다.

함수형 인터페이스는 추상 메서드가 하나만 있는 인터페이스이다.

람다에서 사용할 수 있다.

예시

@FunctionalInterface
public interface MyFunction {
    void call();
}

추상 메서드가 2개 이상이면 컴파일 오류가 발생한다.

---

## @SafeVarargs

제네릭 가변 인자 사용 시 발생할 수 있는 경고를 억제한다.

정말 안전하다는 것이 보장될 때만 사용해야 한다.

---

# 애노테이션 사용 시 주의점

애노테이션은 코드에 부가 정보를 제공하는 강력한 기능이다.

하지만 애노테이션만 붙인다고 기능이 자동으로 실행되는 것은 아니다.

애노테이션을 읽고 처리하는 코드가 있어야 실제 기능이 동작한다.

---

## 애노테이션을 남용하면 안 되는 이유

애노테이션을 너무 많이 사용하면  
코드의 실제 동작 흐름이 숨겨질 수 있다.

일반 코드보다 동작 과정을 추적하기 어려울 수 있다.

특히 리플렉션과 함께 사용하면  
컴파일 시점에 오류를 잡기 어렵고  
런타임에 문제가 발생할 수 있다.

---

## 애노테이션을 사용하기 좋은 경우

- 여러 클래스에 공통 규칙을 적용할 때
- 검증 로직을 공통화할 때
- 프레임워크가 클래스 정보를 분석해야 할 때
- 설정 정보를 코드 가까이에 표현하고 싶을 때
- 반복되는 코드를 줄이고 싶을 때

---

# 리플렉션과 애노테이션 관계

리플렉션은 클래스, 메서드, 필드 정보를 런타임에 조회하는 기능이다.

애노테이션은 코드에 부가 정보를 붙이는 기능이다.

프레임워크는 보통 리플렉션으로 애노테이션을 읽고  
그 정보를 기준으로 객체 생성, 의존관계 주입, 검증, 요청 매핑 등을 수행한다.

예시

- 스프링의 @Controller
- 스프링의 @Service
- 스프링의 @Autowired
- 스프링 MVC의 @RequestMapping
- 검증 관련 @NotNull

---

# 핵심 정리

1. 애노테이션은 코드에 부가 정보를 붙이는 문법이다.
2. 애노테이션은 @interface로 정의한다.
3. 애노테이션은 속성을 가질 수 있다.
4. value 속성 하나만 있으면 사용할 때 이름을 생략할 수 있다.
5. 메타 애노테이션은 애노테이션에 붙는 애노테이션이다.
6. @Retention은 애노테이션 유지 범위를 지정한다.
7. @Target은 애노테이션을 붙일 수 있는 위치를 지정한다.
8. RUNTIME 유지 정책이어야 리플렉션으로 조회할 수 있다.
9. @Inherited는 클래스 레벨 애노테이션 상속에만 적용된다.
10. 애노테이션은 기본적으로 기능을 실행하지 않고 정보를 표시한다.
11. 애노테이션을 실제로 활용하려면 리플렉션으로 읽고 처리하는 코드가 필요하다.
12. 검증기 예제에서는 필드에 붙은 애노테이션을 읽어서 검증 로직을 수행한다.
13. @Override는 오버라이딩 실수를 컴파일 시점에 잡아준다.
14. @Deprecated는 더 이상 사용하지 않는 코드를 표시한다.
15. @FunctionalInterface는 함수형 인터페이스 조건을 검사한다.
16. 애노테이션은 공통 처리나 프레임워크 개발에 유용하지만 남용하면 코드 흐름을 이해하기 어려워질 수 있다.
