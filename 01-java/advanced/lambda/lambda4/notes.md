# Functional Interface

## 함수형 인터페이스란

함수형 인터페이스는 추상 메서드가 하나만 있는 인터페이스이다.

람다는 함수형 인터페이스를 기반으로 동작한다.

즉, 람다는 단독으로 존재하는 것이 아니라  
어떤 함수형 인터페이스의 구현체처럼 사용된다.

예시

@FunctionalInterface
interface MyFunction {
    int apply(int a, int b);
}

사용

MyFunction function = (a, b) -> a + b;

int result = function.apply(10, 20);

---

## @FunctionalInterface

@FunctionalInterface는 해당 인터페이스가 함수형 인터페이스임을 표시하는 애노테이션이다.

추상 메서드가 2개 이상이면 컴파일 오류가 발생한다.

장점

- 함수형 인터페이스 조건을 컴파일 시점에 검사할 수 있다.
- 실수를 줄일 수 있다.
- 람다와 함께 사용할 의도를 명확하게 드러낸다.

---

# 함수형 인터페이스와 제네릭

함수형 인터페이스에 제네릭을 도입하면  
다양한 타입에 재사용할 수 있다.

---

## 제네릭을 사용하지 않는 경우

interface StringFunction {
    String apply(String value);
}

interface IntegerFunction {
    Integer apply(Integer value);
}

문제점

- 타입마다 인터페이스를 따로 만들어야 한다.
- 코드 중복이 많아진다.
- 재사용성이 떨어진다.

---

## 제네릭을 사용하는 경우

@FunctionalInterface
interface MyFunction<T, R> {
    R apply(T value);
}

사용

MyFunction<String, Integer> function = value -> value.length();

int result = function.apply("hello");

결과

5

---

## 제네릭 함수형 인터페이스의 장점

- 여러 타입에 재사용 가능
- 타입 안전성 보장
- 코드 중복 감소
- 람다와 함께 사용하면 코드가 간결해짐

---

# 람다와 타겟 타입

람다는 그 자체만으로는 타입이 없다.

람다는 대입되는 함수형 인터페이스 타입을 보고  
어떤 메서드를 구현해야 하는지 결정된다.

이때 람다가 대입되는 타입을 타겟 타입이라고 한다.

---

## 타겟 타입 예시

@FunctionalInterface
interface MyFunction {
    int apply(int a, int b);
}

MyFunction function = (a, b) -> a + b;

여기서 타겟 타입은 MyFunction이다.

람다는 MyFunction의 추상 메서드인 apply(int a, int b)에 맞춰 해석된다.

---

## 같은 람다, 다른 타겟 타입

람다는 타겟 타입에 따라 의미가 결정된다.

예시

@FunctionalInterface
interface AddFunction {
    int apply(int a, int b);
}

@FunctionalInterface
interface CompareFunction {
    boolean apply(int a, int b);
}

AddFunction add = (a, b) -> a + b;

CompareFunction compare = (a, b) -> a > b;

람다는 함수형 인터페이스의 추상 메서드 시그니처와 맞아야 한다.

---

## 타겟 타입이 필요한 이유

람다의 매개변수 타입과 반환 타입은  
함수형 인터페이스의 추상 메서드 시그니처를 보고 추론된다.

따라서 람다를 사용할 때는  
어떤 함수형 인터페이스에 대입되는지가 중요하다.

---

# 기본 함수형 인터페이스

자바는 자주 사용하는 함수형 인터페이스를 java.util.function 패키지로 제공한다.

직접 함수형 인터페이스를 만들 수도 있지만  
이미 제공되는 기본 함수형 인터페이스를 활용하면 더 편리하다.

대표 인터페이스

- Function
- Consumer
- Supplier
- Predicate
- UnaryOperator
- BinaryOperator

---

# Function<T, R>

Function은 입력값을 받아 결과를 반환하는 함수형 인터페이스이다.

형태

T → R

예시

Function<String, Integer> function = value -> value.length();

Integer result = function.apply("hello");

결과

5

---

## Function 사용 목적

값을 다른 값으로 변환할 때 사용한다.

예시

- 문자열을 길이로 변환
- 회원을 회원 이름으로 변환
- 숫자를 문자열로 변환

---

# Consumer<T>

Consumer는 입력값을 받지만 결과를 반환하지 않는 함수형 인터페이스이다.

형태

T → void

예시

Consumer<String> consumer = value -> System.out.println(value);

consumer.accept("hello");

---

## Consumer 사용 목적

값을 소비하고 끝나는 동작에 사용한다.

예시

- 출력
- 저장
- 로그 남기기
- 리스트 요소 처리

---

# Supplier<T>

Supplier는 입력값 없이 결과를 반환하는 함수형 인터페이스이다.

형태

() → T

예시

Supplier<String> supplier = () -> "hello";

String result = supplier.get();

---

## Supplier 사용 목적

값을 공급할 때 사용한다.

예시

- 기본값 생성
- 객체 생성
- 현재 시간 반환
- 랜덤 값 생성

---

# Predicate<T>

Predicate는 입력값을 받아 boolean 결과를 반환하는 함수형 인터페이스이다.

형태

T → boolean

예시

Predicate<Integer> predicate = value -> value > 10;

boolean result = predicate.test(20);

결과

true

---

## Predicate 사용 목적

조건 검사에 사용한다.

예시

- 값이 특정 조건을 만족하는지 확인
- 필터링 조건
- 검증 조건

---

# UnaryOperator<T>

UnaryOperator는 입력 타입과 반환 타입이 같은 Function이다.

형태

T → T

예시

UnaryOperator<Integer> operator = value -> value * 2;

Integer result = operator.apply(10);

결과

20

---

## UnaryOperator 사용 목적

같은 타입의 값을 변환할 때 사용한다.

예시

- 숫자 2배 만들기
- 문자열 앞뒤 공백 제거
- 회원 정보 수정 후 반환

---

# BinaryOperator<T>

BinaryOperator는 같은 타입의 값 2개를 받아  
같은 타입의 결과를 반환하는 함수형 인터페이스이다.

형태

(T, T) → T

예시

BinaryOperator<Integer> operator = (a, b) -> a + b;

Integer result = operator.apply(10, 20);

결과

30

---

## BinaryOperator 사용 목적

같은 타입의 값 2개를 하나로 합칠 때 사용한다.

예시

- 두 숫자의 합
- 두 문자열 연결
- 두 값 중 큰 값 선택
- reduce 연산

---

# 기본 함수형 인터페이스 정리

| 인터페이스 | 형태 | 메서드 | 사용 목적 |
|------------|------|--------|-----------|
| Function<T, R> | T → R | apply() | 변환 |
| Consumer<T> | T → void | accept() | 소비 |
| Supplier<T> | () → T | get() | 공급 |
| Predicate<T> | T → boolean | test() | 조건 검사 |
| UnaryOperator<T> | T → T | apply() | 같은 타입 변환 |
| BinaryOperator<T> | (T, T) → T | apply() | 같은 타입 두 값 연산 |

---

# 특화 함수형 인터페이스

기본 함수형 인터페이스는 제네릭을 사용한다.

하지만 제네릭은 기본형을 직접 사용할 수 없기 때문에  
int, long, double 같은 기본형은 래퍼 타입으로 처리된다.

예시

Function<Integer, Integer>

여기서 int가 아니라 Integer를 사용한다.

이 과정에서 오토박싱과 언박싱이 발생할 수 있다.

---

## 특화 함수형 인터페이스가 필요한 이유

기본형을 자주 다루는 경우  
불필요한 박싱과 언박싱 비용을 줄이기 위해  
기본형에 특화된 함수형 인터페이스를 사용할 수 있다.

---

## int 특화 인터페이스 예시

IntPredicate

- int 값을 받아 boolean 반환
- 조건 검사

예시

IntPredicate predicate = value -> value > 10;

boolean result = predicate.test(20);

---

## IntFunction<R>

int 값을 받아 R 타입 결과를 반환한다.

형태

int → R

예시

IntFunction<String> function = value -> "number = " + value;

String result = function.apply(10);

---

## IntConsumer

int 값을 받아 소비하고 반환값은 없다.

형태

int → void

예시

IntConsumer consumer = value -> System.out.println(value);

consumer.accept(10);

---

## IntSupplier

입력 없이 int 값을 반환한다.

형태

() → int

예시

IntSupplier supplier = () -> 100;

int result = supplier.getAsInt();

---

## IntUnaryOperator

int 값을 받아 int 값을 반환한다.

형태

int → int

예시

IntUnaryOperator operator = value -> value * 2;

int result = operator.applyAsInt(10);

---

## IntBinaryOperator

int 값 2개를 받아 int 값을 반환한다.

형태

(int, int) → int

예시

IntBinaryOperator operator = (a, b) -> a + b;

int result = operator.applyAsInt(10, 20);

---

## 특화 함수형 인터페이스 정리

| 인터페이스 | 형태 | 사용 목적 |
|------------|------|-----------|
| IntPredicate | int → boolean | int 조건 검사 |
| IntFunction<R> | int → R | int를 다른 타입으로 변환 |
| IntConsumer | int → void | int 소비 |
| IntSupplier | () → int | int 공급 |
| IntUnaryOperator | int → int | int 변환 |
| IntBinaryOperator | (int, int) → int | int 두 값 연산 |

---

# 기타 함수형 인터페이스

java.util.function 외에도 자바에는 다양한 함수형 인터페이스가 있다.

---

## Runnable

Runnable은 입력값도 없고 반환값도 없는 함수형 인터페이스이다.

형태

() → void

예시

Runnable runnable = () -> System.out.println("hello");

runnable.run();

사용 예시

- 스레드 실행 작업
- 단순 실행 로직

---

## Callable<V>

Callable은 입력값은 없고 결과를 반환하는 함수형 인터페이스이다.

형태

() → V

예시

Callable<Integer> callable = () -> 100;

Integer result = callable.call();

특징

- 결과를 반환할 수 있다.
- 예외를 던질 수 있다.
- ExecutorService와 함께 자주 사용된다.

---

## Comparator<T>

Comparator는 두 값을 비교하는 함수형 인터페이스이다.

형태

(T, T) → int

예시

Comparator<Integer> comparator = (a, b) -> a.compareTo(b);

사용 예시

List<Integer> numbers = Arrays.asList(3, 1, 2);

numbers.sort(comparator);

---

## Comparator 사용 목적

정렬 기준을 전달할 때 사용한다.

예시

- 숫자 오름차순 정렬
- 문자열 길이 기준 정렬
- 회원 나이 기준 정렬
- 회원 이름 기준 정렬

---

# 어떤 함수형 인터페이스를 선택해야 할까?

함수형 인터페이스는 단순히 시그니처만 맞는 것을 고르는 것이 아니라  
의도를 명확하게 드러내는 것을 선택하는 것이 중요하다.

---

## 선택 기준

조건 검사라면 Predicate

Predicate<Integer> predicate = value -> value > 10;

값 변환이라면 Function

Function<String, Integer> function = value -> value.length();

값 소비라면 Consumer

Consumer<String> consumer = value -> System.out.println(value);

값 공급이라면 Supplier

Supplier<String> supplier = () -> "hello";

같은 타입 변환이라면 UnaryOperator

UnaryOperator<Integer> operator = value -> value * 2;

같은 타입 두 값 연산이라면 BinaryOperator

BinaryOperator<Integer> operator = (a, b) -> a + b;

정렬 기준이라면 Comparator

Comparator<String> comparator = (a, b) -> a.length() - b.length();

---

# 람다와 함수형 인터페이스를 활용하는 이유

람다와 함수형 인터페이스를 활용하면  
동작을 값처럼 전달할 수 있다.

장점

- 코드가 간결해진다.
- 가독성이 높아진다.
- 중복 코드가 줄어든다.
- 동작을 쉽게 교체할 수 있다.
- 제네릭을 도입하면 재사용성이 높아진다.
- 타입 안전성을 확보할 수 있다.
- 함수형 인터페이스 이름을 통해 의도를 명확하게 표현할 수 있다.

---

# 함수형 인터페이스와 전략 패턴

함수형 인터페이스와 람다는 전략 패턴을 간단하게 구현할 수 있게 해준다.

기존 방식

- 전략 인터페이스 생성
- 전략 구현 클래스 생성
- 객체 생성 후 전달

람다 사용 방식

calculate(10, 20, (a, b) -> a + b);

calculate(10, 20, (a, b) -> a * b);

변하는 동작만 람다로 전달할 수 있다.

---

# filter, map, reduce와 함수형 인터페이스

## filter

조건을 받아 요소를 걸러낸다.

사용하기 좋은 인터페이스

Predicate<T>

예시

Predicate<Integer> even = value -> value % 2 == 0;

---

## map

값을 다른 값으로 변환한다.

사용하기 좋은 인터페이스

Function<T, R>

예시

Function<String, Integer> length = value -> value.length();

---

## reduce

여러 값을 하나의 값으로 누적한다.

사용하기 좋은 인터페이스

BinaryOperator<T>

예시

BinaryOperator<Integer> sum = (a, b) -> a + b;

---

# 핵심 정리

1. 함수형 인터페이스는 추상 메서드가 하나만 있는 인터페이스이다.
2. 람다는 함수형 인터페이스에 대입할 수 있다.
3. 람다는 타겟 타입을 보고 매개변수와 반환 타입을 추론한다.
4. 함수형 인터페이스에 제네릭을 도입하면 재사용성과 타입 안전성을 확보할 수 있다.
5. Function은 값을 변환할 때 사용한다.
6. Consumer는 값을 소비할 때 사용한다.
7. Supplier는 값을 공급할 때 사용한다.
8. Predicate는 조건을 검사할 때 사용한다.
9. UnaryOperator는 같은 타입의 값을 변환할 때 사용한다.
10. BinaryOperator는 같은 타입의 두 값을 연산할 때 사용한다.
11. 특화 함수형 인터페이스는 기본형 처리 시 박싱, 언박싱 비용을 줄일 수 있다.
12. Runnable, Callable, Comparator도 자주 사용하는 함수형 인터페이스이다.
13. 함수형 인터페이스는 시그니처만 보고 고르는 것이 아니라 의도를 명확하게 드러내는 것을 선택해야 한다.
14. 람다와 함수형 인터페이스를 활용하면 코드가 간결해지고 가독성과 재사용성이 좋아진다.
