# Lambda

## 람다가 필요한 이유

기존 자바에서는 동작을 전달하려면 클래스를 만들어야 했다.

예를 들어 어떤 계산 로직을 전달하고 싶다면  
인터페이스를 만들고, 구현 클래스를 만들고, 객체를 생성해야 했다.

이 방식은 코드가 길고 복잡하다.

람다는 이런 문제를 해결하기 위해 등장했다.

람다를 사용하면 메서드에 전달할 동작을 간단하게 표현할 수 있다.

---

## 기존 방식의 문제점

예시

interface Procedure {
    void run();
}

class HelloProcedure implements Procedure {
    @Override
    public void run() {
        System.out.println("hello");
    }
}

사용

Procedure procedure = new HelloProcedure();

procedure.run();

문제점

- 클래스를 따로 만들어야 한다.
- 코드가 길어진다.
- 핵심 로직보다 부가 코드가 많다.
- 단순한 동작 하나를 전달하기 위해 구조가 복잡하다.

---

# 함수 vs 메서드

## 함수

함수는 입력을 받아 결과를 반환하는 독립적인 코드 조각이다.

특징

- 독립적으로 존재할 수 있다.
- 입력과 출력이 중요하다.
- 특정 객체에 소속되지 않아도 된다.

예시 개념

add(1, 2) → 3

---

## 메서드

메서드는 클래스나 객체에 소속된 함수이다.

특징

- 클래스나 객체에 포함된다.
- 객체의 상태를 사용할 수 있다.
- 자바에서는 기본적으로 클래스 안에 메서드를 작성한다.

예시

member.getName();

---

## 자바에서의 함수와 메서드

자바는 기본적으로 모든 코드를 클래스 안에 작성한다.

따라서 전통적인 자바에서는 독립적인 함수보다는  
클래스나 객체에 소속된 메서드를 사용했다.

람다를 사용하면 동작을 값처럼 다룰 수 있다.

---

# 람다 시작

람다는 익명 함수처럼 사용할 수 있는 문법이다.

메서드에 전달할 동작을 간단하게 표현할 수 있다.

기존 익명 클래스

Procedure procedure = new Procedure() {
    @Override
    public void run() {
        System.out.println("hello");
    }
};

람다

Procedure procedure = () -> System.out.println("hello");

---

# 람다 정의

람다는 다음 형태로 작성한다.

(매개변수) -> { 실행 코드 }

예시

() -> System.out.println("hello")

(int a, int b) -> {
    return a + b;
}

---

## 람다 기본 문법

매개변수가 없는 경우

() -> System.out.println("hello")

매개변수가 하나인 경우

x -> x * 2

매개변수가 여러 개인 경우

(a, b) -> a + b

실행문이 여러 줄인 경우

(a, b) -> {
    int result = a + b;
    return result;
}

---

# 람다와 값 대입

람다는 변수에 대입할 수 있다.

단, 아무 변수에나 대입할 수 있는 것은 아니고  
함수형 인터페이스 타입의 변수에 대입해야 한다.

예시

MyFunction function = (a, b) -> a + b;

int result = function.apply(10, 20);

결과

30

---

# 함수형 인터페이스

함수형 인터페이스는 추상 메서드가 하나만 있는 인터페이스이다.

람다는 함수형 인터페이스에만 대입할 수 있다.

예시

@FunctionalInterface
interface MyFunction {
    int apply(int a, int b);
}

---

## @FunctionalInterface

@FunctionalInterface는 함수형 인터페이스임을 표시하는 애노테이션이다.

추상 메서드가 2개 이상이면 컴파일 오류가 발생한다.

예시

@FunctionalInterface
interface MyFunction {
    int apply(int a, int b);
}

장점

- 함수형 인터페이스 조건을 컴파일 시점에 검사할 수 있다.
- 실수를 줄일 수 있다.

---

# 람다와 시그니처

람다는 함수형 인터페이스의 추상 메서드 시그니처와 맞아야 한다.

시그니처란 메서드의 형태를 의미한다.

포함 요소

- 매개변수 개수
- 매개변수 타입
- 반환 타입

---

## 시그니처 예시

함수형 인터페이스

interface MyFunction {
    int apply(int a, int b);
}

람다

(a, b) -> a + b

해석

- 매개변수 2개
- int, int
- 반환 타입 int

따라서 MyFunction에 대입할 수 있다.

---

## 시그니처가 맞지 않는 경우

interface MyFunction {
    int apply(int a, int b);
}

잘못된 람다

() -> 10

이유

- 인터페이스는 매개변수 2개를 요구한다.
- 람다는 매개변수가 없다.
- 시그니처가 맞지 않는다.

---

# 람다와 생략

람다는 문맥을 통해 타입을 추론할 수 있기 때문에  
여러 부분을 생략할 수 있다.

---

## 타입 생략

기본 형태

(int a, int b) -> a + b

생략

(a, b) -> a + b

자바가 함수형 인터페이스의 메서드 시그니처를 보고  
a와 b가 int라는 것을 추론한다.

---

## 괄호 생략

매개변수가 하나면 괄호를 생략할 수 있다.

기본 형태

(x) -> x * 2

생략

x -> x * 2

---

## 중괄호와 return 생략

실행 코드가 한 줄이고 바로 반환하는 경우  
중괄호와 return을 생략할 수 있다.

기본 형태

(a, b) -> {
    return a + b;
}

생략

(a, b) -> a + b

---

## 생략할 수 없는 경우

실행 코드가 여러 줄이면 중괄호를 사용해야 한다.

(a, b) -> {
    int result = a + b;
    return result;
}

중괄호를 사용하면 return이 필요한 경우 명시해야 한다.

---

# 람다의 전달

람다는 메서드의 인자로 전달할 수 있다.

즉, 메서드에 값뿐만 아니라 동작도 전달할 수 있다.

---

## 람다 전달 예시

interface MyFunction {
    int apply(int a, int b);
}

static int calculate(int a, int b, MyFunction function) {
    return function.apply(a, b);
}

사용

int result1 = calculate(10, 20, (a, b) -> a + b);

int result2 = calculate(10, 20, (a, b) -> a * b);

결과

result1 = 30

result2 = 200

---

## 람다 전달의 장점

메서드 내부 로직은 고정하고  
변하는 동작만 외부에서 전달할 수 있다.

장점

- 코드 중복 감소
- 유연성 증가
- 전략 패턴을 간결하게 구현 가능
- 동작을 쉽게 교체 가능

---

# 메서드 전달

자바에서는 메서드 자체를 직접 전달하는 것이 아니라  
함수형 인터페이스를 통해 동작을 전달한다.

람다는 함수형 인터페이스의 구현체처럼 동작한다.

예시

calculate(10, 20, (a, b) -> a + b);

여기서

(a, b) -> a + b

는 MyFunction 인터페이스의 apply() 메서드를 구현한 것처럼 동작한다.

---

# 람다 반환

람다는 메서드의 반환값으로도 사용할 수 있다.

즉, 메서드가 새로운 함수를 만들어서 반환할 수 있다.

---

## 람다 반환 예시

interface MyFunction {
    int apply(int value);
}

static MyFunction createAdder(int n) {
    return value -> value + n;
}

사용

MyFunction add10 = createAdder(10);

int result = add10.apply(5);

결과

15

---

## 람다 반환의 의미

입력값에 따라 다른 동작을 하는 함수를 만들어 반환할 수 있다.

예시

createAdder(10)

→ 10을 더하는 함수 반환

createAdder(20)

→ 20을 더하는 함수 반환

---

# 고차 함수

고차 함수는 함수를 인자로 받거나 함수를 반환하는 함수이다.

자바에서는 함수형 인터페이스와 람다를 사용해서 고차 함수를 구현할 수 있다.

---

## 고차 함수 예시

함수를 인자로 받는 경우

static int calculate(int a, int b, MyFunction function) {
    return function.apply(a, b);
}

함수를 반환하는 경우

static MyFunction createAdder(int n) {
    return value -> value + n;
}

---

# 고차 함수에서 자주 등장하는 패턴

자바에서 고차 함수를 구현할 때 자주 등장하는 패턴이 있다.

대표 패턴

- filter
- map
- reduce
- 함수를 반환
- 함수 합성

---

# filter

filter는 조건을 나타내는 함수를 인자로 받아  
리스트에서 필요한 요소만 추려내는 패턴이다.

---

## filter 예시

목표

숫자 리스트에서 짝수만 추출한다.

개념

numbers = [1, 2, 3, 4, 5]

조건

number % 2 == 0

결과

[2, 4]

---

## filter 코드 예시

static List<Integer> filter(List<Integer> list, MyPredicate predicate) {
    List<Integer> result = new ArrayList<>();

    for (Integer value : list) {
        if (predicate.test(value)) {
            result.add(value);
        }
    }

    return result;
}

사용

filter(numbers, value -> value % 2 == 0);

---

# map

map은 변환 로직을 나타내는 함수를 인자로 받아  
리스트의 각 요소를 다른 형태로 바꾸는 패턴이다.

---

## map 예시

목표

숫자 리스트의 모든 값을 2배로 변환한다.

개념

numbers = [1, 2, 3]

변환

value * 2

결과

[2, 4, 6]

---

## map 코드 예시

static List<Integer> map(List<Integer> list, MyMapper mapper) {
    List<Integer> result = new ArrayList<>();

    for (Integer value : list) {
        result.add(mapper.map(value));
    }

    return result;
}

사용

map(numbers, value -> value * 2);

---

# reduce

reduce는 누적 로직을 나타내는 함수를 인자로 받아  
리스트의 모든 요소를 하나의 값으로 축약하는 패턴이다.

---

## reduce 예시

목표

숫자 리스트의 합계를 구한다.

개념

numbers = [1, 2, 3, 4]

누적

sum + value

결과

10

---

## reduce 코드 예시

static int reduce(List<Integer> list, int initialValue, MyReducer reducer) {
    int result = initialValue;

    for (Integer value : list) {
        result = reducer.reduce(result, value);
    }

    return result;
}

사용

reduce(numbers, 0, (sum, value) -> sum + value);

---

# 함수를 반환

입력값에 따라 새로운 함수를 만들어 반환할 수 있다.

---

## 함수를 반환하는 예시

static MyFunction createMultiplier(int n) {
    return value -> value * n;
}

사용

MyFunction multiplyBy2 = createMultiplier(2);

MyFunction multiplyBy10 = createMultiplier(10);

결과

multiplyBy2.apply(5) = 10

multiplyBy10.apply(5) = 50

---

# 함수 합성

함수 합성은 두 함수를 이어 붙여  
하나의 새로운 함수를 만드는 패턴이다.

---

## 함수 합성 예시

함수 1

value -> value * 2

함수 2

value -> value + 1

합성 결과

value -> (value * 2) + 1

---

## 함수 합성 코드 예시

static MyFunction compose(MyFunction first, MyFunction second) {
    return value -> second.apply(first.apply(value));
}

사용

MyFunction multiplyBy2 = value -> value * 2;

MyFunction add1 = value -> value + 1;

MyFunction composed = compose(multiplyBy2, add1);

int result = composed.apply(10);

결과

21

---

# 람다와 전략 패턴

람다는 전략 패턴을 간단하게 구현할 수 있게 해준다.

기존 전략 패턴은 동작마다 클래스를 만들어야 했다.

하지만 람다를 사용하면 동작을 바로 전달할 수 있다.

예시

calculate(10, 20, (a, b) -> a + b);

calculate(10, 20, (a, b) -> a * b);

동일한 calculate 메서드에  
다른 전략을 람다로 전달할 수 있다.

---

# 람다 사용 시 주의점

람다는 코드를 간결하게 만들지만  
너무 복잡한 로직을 람다 안에 넣으면 오히려 가독성이 떨어질 수 있다.

람다는 짧고 명확한 동작을 표현할 때 적합하다.

복잡한 로직은 별도의 메서드나 클래스로 분리하는 것이 좋다.

---

# 핵심 정리

1. 람다는 동작을 간단하게 표현하는 문법이다.
2. 람다는 함수형 인터페이스에 대입할 수 있다.
3. 함수형 인터페이스는 추상 메서드가 하나만 있는 인터페이스이다.
4. 람다는 함수형 인터페이스의 메서드 시그니처와 맞아야 한다.
5. 람다는 변수에 대입할 수 있다.
6. 람다는 메서드의 인자로 전달할 수 있다.
7. 람다는 메서드의 반환값으로 사용할 수 있다.
8. 고차 함수는 함수를 인자로 받거나 함수를 반환하는 함수이다.
9. 자바에서는 함수형 인터페이스와 람다로 고차 함수를 구현한다.
10. filter는 조건에 맞는 요소만 추려내는 패턴이다.
11. map은 각 요소를 다른 형태로 변환하는 패턴이다.
12. reduce는 여러 요소를 하나의 값으로 축약하는 패턴이다.
13. 함수를 반환하면 입력값에 맞는 새로운 동작을 만들 수 있다.
14. 함수 합성은 여러 함수를 이어 붙여 새로운 함수를 만드는 것이다.
15. 람다는 전략 패턴을 간결하게 구현하는 데 도움이 된다.
