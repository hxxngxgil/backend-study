# Method Reference

## 메서드 참조란

메서드 참조(Method Reference)는 이미 존재하는 메서드를 람다 대신 간결하게 참조하는 문법이다.

람다로 작성한 코드가 단순히 특정 메서드를 호출하는 역할만 한다면  
메서드 참조로 더 간단하게 표현할 수 있다.

---

## 메서드 참조가 필요한 이유

람다는 동작을 간단하게 전달할 수 있지만,  
람다 내부에서 이미 존재하는 메서드를 그대로 호출하는 경우가 많다.

예시

value -> Integer.parseInt(value)

이 경우 람다가 하는 일은  
Integer.parseInt() 메서드를 호출하는 것뿐이다.

이럴 때 메서드 참조를 사용하면 더 간결하게 작성할 수 있다.

예시

Integer::parseInt

---

# 메서드 참조의 장점

## 간결성

람다식을 더 짧게 표현할 수 있다.

람다

value -> Integer.parseInt(value)

메서드 참조

Integer::parseInt

불필요한 매개변수와 호출 코드를 줄일 수 있다.

---

## 가독성

이미 이름이 잘 지어진 메서드를 참조하면  
코드의 의도가 더 명확해진다.

예시

value -> value.toUpperCase()

보다

String::toUpperCase

가 더 직관적일 수 있다.

---

## 유연성

메서드를 값처럼 전달할 수 있다.

따라서 filter, map, sort 같은 곳에  
필요한 동작을 쉽게 전달할 수 있다.

---

## 재사용성

이미 만들어둔 메서드를 다시 사용할 수 있다.

같은 로직을 람다 안에 반복해서 작성하지 않고  
기존 메서드를 참조해서 사용할 수 있다.

---

# 메서드 참조 - 시작

메서드 참조는 람다를 더 간결하게 표현하는 문법이다.

람다

Function<String, Integer> function = value -> Integer.parseInt(value);

메서드 참조

Function<String, Integer> function = Integer::parseInt;

사용

Integer result = function.apply("100");

결과

100

---

# 람다와 메서드 참조 관계

메서드 참조는 람다를 대체할 수 있다.

단, 모든 람다를 메서드 참조로 바꿀 수 있는 것은 아니다.

람다 내부에서 하는 일이 단순히 특정 메서드를 호출하는 것이라면  
메서드 참조로 바꿀 수 있다.

---

## 메서드 참조로 바꾸기 좋은 경우

람다

value -> method(value)

메서드 참조

this::method

또는

ClassName::method

---

## 메서드 참조로 바꾸기 어려운 경우

람다 내부 로직이 복잡하면 메서드 참조로 바꾸기 어렵다.

예시

value -> {
    int result = value * 2;
    return result + 10;
}

이런 경우는 람다나 별도 메서드를 사용하는 것이 좋다.

---

# 메서드 참조 유형

메서드 참조에는 대표적으로 다음 유형이 있다.

| 유형 | 문법 | 예시 |
|------|------|------|
| 정적 메서드 참조 | 클래스명::정적메서드명 | Integer::parseInt |
| 특정 객체의 인스턴스 메서드 참조 | 객체명::인스턴스메서드명 | System.out::println |
| 생성자 참조 | 클래스명::new | Member::new |
| 임의 객체의 인스턴스 메서드 참조 | 클래스명::인스턴스메서드명 | String::toUpperCase |

---

# 정적 메서드 참조

정적 메서드 참조는 static 메서드를 참조하는 방식이다.

문법

클래스명::정적메서드명

---

## 정적 메서드 참조 예시

람다

Function<String, Integer> function = value -> Integer.parseInt(value);

메서드 참조

Function<String, Integer> function = Integer::parseInt;

사용

Integer result = function.apply("100");

---

## 정적 메서드 참조 의미

Integer::parseInt

은 다음 람다와 같다.

value -> Integer.parseInt(value)

즉, 입력값을 받아서 정적 메서드에 전달한다.

---

# 특정 객체의 인스턴스 메서드 참조

특정 객체의 인스턴스 메서드 참조는 이미 존재하는 특정 객체의 메서드를 참조하는 방식이다.

문법

객체명::인스턴스메서드명

---

## 특정 객체의 인스턴스 메서드 참조 예시

람다

Consumer<String> consumer = value -> System.out.println(value);

메서드 참조

Consumer<String> consumer = System.out::println;

사용

consumer.accept("hello");

---

## 특정 객체의 인스턴스 메서드 참조 의미

System.out::println

은 다음 람다와 같다.

value -> System.out.println(value)

여기서 System.out은 이미 존재하는 특정 객체이다.

---

# 생성자 참조

생성자 참조는 객체를 생성하는 생성자를 참조하는 방식이다.

문법

클래스명::new

---

## 기본 생성자 참조

Supplier<Member> supplier = Member::new;

사용

Member member = supplier.get();

의미

() -> new Member()

---

## 매개변수가 있는 생성자 참조

Function<String, Member> function = Member::new;

사용

Member member = function.apply("memberA");

의미

name -> new Member(name)

---

## 생성자 참조의 핵심

생성자 참조는 함수형 인터페이스의 메서드 시그니처에 따라  
어떤 생성자를 호출할지 결정된다.

예시

Supplier<Member>

- 입력 없음
- 반환 Member
- 기본 생성자 호출 가능

Function<String, Member>

- String 입력
- 반환 Member
- String을 받는 생성자 호출 가능

---

# 임의 객체의 인스턴스 메서드 참조

임의 객체의 인스턴스 메서드 참조는  
특정 객체가 아니라, 매개변수로 전달된 객체의 인스턴스 메서드를 호출하는 방식이다.

문법

클래스명::인스턴스메서드명

---

## 임의 객체의 인스턴스 메서드 참조 예시 1

람다

Function<String, String> function = value -> value.toUpperCase();

메서드 참조

Function<String, String> function = String::toUpperCase;

사용

String result = function.apply("hello");

결과

HELLO

---

## 임의 객체의 인스턴스 메서드 참조 의미

String::toUpperCase

은 다음 람다와 같다.

value -> value.toUpperCase()

여기서 value는 String 타입의 임의 객체이다.

즉, 메서드 참조의 첫 번째 매개변수가  
메서드를 호출하는 대상 객체가 된다.

---

## 임의 객체의 인스턴스 메서드 참조 예시 2

람다

BiFunction<String, String, Boolean> function =
        (a, b) -> a.equals(b);

메서드 참조

BiFunction<String, String, Boolean> function = String::equals;

사용

boolean result = function.apply("java", "java");

결과

true

---

## 임의 객체의 인스턴스 메서드 참조 예시 3

람다

Comparator<String> comparator =
        (a, b) -> a.compareToIgnoreCase(b);

메서드 참조

Comparator<String> comparator = String::compareToIgnoreCase;

---

# 메서드 참조와 매개변수

메서드 참조는 함수형 인터페이스의 추상 메서드 시그니처에 맞게 동작한다.

즉, 매개변수 개수와 반환 타입은  
대입되는 함수형 인터페이스를 기준으로 결정된다.

---

## 매개변수 1개인 경우

Function<String, Integer> function = Integer::parseInt;

의미

String value를 받아서  
Integer.parseInt(value)를 호출한다.

람다로 표현하면

value -> Integer.parseInt(value)

---

## 매개변수 2개인 경우

BiFunction<Integer, Integer, Integer> function = Math::max;

의미

두 개의 Integer 값을 받아서  
Math.max(a, b)를 호출한다.

람다로 표현하면

(a, b) -> Math.max(a, b)

---

## 반환값이 없는 경우

Consumer<String> consumer = System.out::println;

의미

String value를 받아서  
System.out.println(value)를 호출한다.

람다로 표현하면

value -> System.out.println(value)

---

# 메서드 참조와 타겟 타입

메서드 참조도 람다처럼 타겟 타입이 필요하다.

타겟 타입은 메서드 참조가 대입되는 함수형 인터페이스이다.

예시

Function<String, Integer> function = Integer::parseInt;

여기서 타겟 타입은 Function<String, Integer>이다.

자바는 Function의 apply(String value) 메서드 시그니처를 보고  
Integer.parseInt(String value)를 연결할 수 있다고 판단한다.

---

## 타겟 타입이 중요한 이유

같은 메서드 참조도  
어떤 함수형 인터페이스에 대입되는지에 따라 해석이 달라질 수 있다.

메서드 참조는 반드시 함수형 인터페이스의 추상 메서드와  
매개변수와 반환 타입이 맞아야 한다.

---

# 메서드 참조 - 활용

메서드 참조는 람다와 함께  
Stream, Optional, 정렬, 객체 생성 등에서 자주 사용된다.

---

## Stream map 활용

람다

List<Integer> result = names.stream()
        .map(name -> name.length())
        .toList();

메서드 참조

List<Integer> result = names.stream()
        .map(String::length)
        .toList();

---

## Stream forEach 활용

람다

names.forEach(name -> System.out.println(name));

메서드 참조

names.forEach(System.out::println);

---

## 정렬 활용

람다

names.sort((a, b) -> a.compareToIgnoreCase(b));

메서드 참조

names.sort(String::compareToIgnoreCase);

---

## 객체 생성 활용

람다

Supplier<Member> supplier = () -> new Member();

메서드 참조

Supplier<Member> supplier = Member::new;

---

# 람다와 메서드 참조 선택 기준

## 메서드 참조를 사용하면 좋은 경우

- 람다가 단순히 기존 메서드만 호출할 때
- 메서드 이름이 의도를 잘 드러낼 때
- 코드가 더 짧고 읽기 쉬워질 때
- 기존 메서드를 재사용할 때

---

## 람다를 사용하는 것이 좋은 경우

- 로직이 직접 보이는 것이 더 이해하기 쉬울 때
- 여러 연산을 조합해야 할 때
- 조건문이나 계산식이 포함될 때
- 메서드 참조보다 람다가 더 명확할 때

---

## 선택 예시

메서드 참조가 좋은 경우

names.forEach(System.out::println);

String::length

Integer::parseInt

Member::new

람다가 좋은 경우

value -> value * 2 + 10

value -> value > 10 && value % 2 == 0

member -> member.getAge() >= 20

---

# 메서드 참조 사용 시 주의점

메서드 참조는 코드를 간결하게 만들지만  
무조건 사용하는 것이 좋은 것은 아니다.

메서드 참조를 봤을 때 어떤 동작인지 바로 이해하기 어렵다면  
람다를 사용하는 것이 더 좋다.

중요한 것은 짧은 코드가 아니라  
읽기 쉬운 코드이다.

---

# 핵심 정리

1. 메서드 참조는 이미 존재하는 메서드를 람다 대신 참조하는 문법이다.
2. 람다가 단순히 메서드 하나를 호출하는 경우 메서드 참조로 바꿀 수 있다.
3. 메서드 참조는 코드의 간결성, 가독성, 유연성, 재사용성을 높일 수 있다.
4. 정적 메서드 참조 문법은 클래스명::정적메서드명이다.
5. 특정 객체의 인스턴스 메서드 참조 문법은 객체명::인스턴스메서드명이다.
6. 생성자 참조 문법은 클래스명::new이다.
7. 임의 객체의 인스턴스 메서드 참조 문법은 클래스명::인스턴스메서드명이다.
8. 임의 객체의 인스턴스 메서드 참조에서는 첫 번째 매개변수가 메서드를 호출하는 대상 객체가 된다.
9. 메서드 참조도 람다처럼 타겟 타입이 필요하다.
10. 함수형 인터페이스의 시그니처와 메서드 참조의 매개변수, 반환 타입이 맞아야 한다.
11. Stream의 map, forEach, sort, 객체 생성 등에서 메서드 참조를 자주 사용한다.
12. 메서드 참조보다 람다가 더 명확한 경우에는 람다를 사용하는 것이 좋다.
