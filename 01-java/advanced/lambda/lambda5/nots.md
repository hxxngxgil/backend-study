# Lambda Practical

## 람다 활용

이번 단원에서는 람다를 실제로 활용해서  
필터, 맵, 스트림 구조를 직접 만들어보는 방법을 학습했다.

학습 흐름

1. 필터 만들기
2. 맵 만들기
3. 필터와 맵 활용
4. 스트림 만들기

---

# 필터 만들기

## filter란?

filter는 조건에 맞는 데이터만 걸러내는 기능이다.

리스트에 여러 데이터가 있을 때  
필요한 데이터만 추려낼 때 사용한다.

예시

숫자 목록

1, 2, 3, 4, 5

조건

짝수만 선택

결과

2, 4

---

## 기존 방식의 문제점

조건이 달라질 때마다  
필터링 메서드를 새로 만들어야 한다.

예시

- 짝수만 필터링
- 홀수만 필터링
- 10보다 큰 값만 필터링
- 특정 문자열이 포함된 값만 필터링

조건만 다르고 반복 구조는 비슷하다.

---

## 람다를 사용한 필터

람다를 사용하면  
변하는 조건만 외부에서 전달할 수 있다.

필터 메서드는 반복 구조를 담당하고  
조건은 람다로 전달한다.

---

## Predicate

필터에는 Predicate를 사용할 수 있다.

Predicate는 값을 하나 받아서  
boolean 결과를 반환하는 함수형 인터페이스이다.

형태

T → boolean

예시

Predicate<Integer> predicate = value -> value % 2 == 0;

---

## filter 구조

static List<Integer> filter(List<Integer> list, Predicate<Integer> predicate) {
    List<Integer> result = new ArrayList<>();

    for (Integer value : list) {
        if (predicate.test(value)) {
            result.add(value);
        }
    }

    return result;
}

사용 예시

filter(numbers, value -> value % 2 == 0);

filter(numbers, value -> value > 10);

---

## filter의 핵심

filter는 조건을 외부에서 전달받는다.

즉, 필터링 기준이 바뀌어도  
filter 메서드 자체는 변경하지 않는다.

변하는 부분

조건

변하지 않는 부분

반복하면서 조건을 만족하는 값만 결과에 추가하는 구조

---

# 맵 만들기

## map이란?

map은 데이터를 다른 형태로 변환하는 기능이다.

리스트의 각 요소를 하나씩 변환해서  
새로운 리스트를 만든다.

예시

숫자 목록

1, 2, 3

변환

각 숫자에 2를 곱하기

결과

2, 4, 6

---

## 기존 방식의 문제점

변환 로직이 달라질 때마다  
새로운 메서드를 만들어야 한다.

예시

- 숫자를 2배로 변환
- 숫자를 문자열로 변환
- 문자열을 길이로 변환
- 회원 객체를 회원 이름으로 변환

반복 구조는 같고 변환 로직만 다르다.

---

## 람다를 사용한 map

람다를 사용하면  
변환 로직만 외부에서 전달할 수 있다.

map 메서드는 반복 구조를 담당하고  
변환 방식은 람다로 전달한다.

---

## Function

map에는 Function을 사용할 수 있다.

Function은 값을 하나 받아서  
다른 값을 반환하는 함수형 인터페이스이다.

형태

T → R

예시

Function<String, Integer> function = value -> value.length();

---

## map 구조

static List<Integer> map(List<Integer> list, Function<Integer, Integer> function) {
    List<Integer> result = new ArrayList<>();

    for (Integer value : list) {
        result.add(function.apply(value));
    }

    return result;
}

사용 예시

map(numbers, value -> value * 2);

map(numbers, value -> value + 10);

---

## 제네릭을 적용한 map

map은 입력 타입과 결과 타입이 다를 수 있다.

예시

String → Integer

Integer → String

Member → String

따라서 제네릭을 적용하면 더 유연하게 만들 수 있다.

구조

static <T, R> List<R> map(List<T> list, Function<T, R> function) {
    List<R> result = new ArrayList<>();

    for (T value : list) {
        result.add(function.apply(value));
    }

    return result;
}

사용 예시

map(names, name -> name.length());

map(numbers, number -> "number = " + number);

---

# 필터와 맵 활용

filter와 map을 함께 사용하면  
데이터를 먼저 걸러내고, 그 결과를 원하는 형태로 변환할 수 있다.

---

## filter와 map 조합 예시

목표

숫자 목록에서 짝수만 고르고  
그 값을 2배로 변환한다.

원본

1, 2, 3, 4, 5

filter

2, 4

map

4, 8

---

## 코드 흐름

List<Integer> filtered = filter(numbers, value -> value % 2 == 0);

List<Integer> mapped = map(filtered, value -> value * 2);

---

## filter와 map을 나누는 이유

filter는 조건에 맞는 데이터를 추려내는 역할이다.

map은 데이터를 다른 형태로 변환하는 역할이다.

역할을 나누면 코드의 의도가 명확해진다.

---

## filter와 map의 차이

| 기능 | 역할 | 함수형 인터페이스 | 형태 |
|------|------|-------------------|------|
| filter | 조건에 맞는 요소만 선택 | Predicate<T> | T → boolean |
| map | 요소를 다른 값으로 변환 | Function<T, R> | T → R |

---

# 스트림 만들기

## 스트림이 필요한 이유

filter와 map을 각각 메서드로 사용하면  
중간 결과를 변수로 계속 저장해야 한다.

예시

List<Integer> filtered = filter(numbers, value -> value % 2 == 0);

List<Integer> mapped = map(filtered, value -> value * 2);

이 방식도 동작하지만  
연산이 많아질수록 코드가 길어진다.

---

## 스트림 방식

스트림을 만들면 filter와 map을 연결해서 사용할 수 있다.

예시

MyStream.of(numbers)
        .filter(value -> value % 2 == 0)
        .map(value -> value * 2)
        .toList();

---

## 스트림의 핵심

스트림은 데이터를 처리하는 흐름을 표현한다.

데이터를 가지고

1. 필터링하고
2. 변환하고
3. 최종 결과로 만든다.

이런 흐름을 메서드 체이닝으로 표현할 수 있다.

---

## MyStream 구조

직접 만든 스트림은 내부에 리스트를 가지고 있다.

예시

class MyStream<T> {
    private List<T> list;

    private MyStream(List<T> list) {
        this.list = list;
    }

    public static <T> MyStream<T> of(List<T> list) {
        return new MyStream<>(list);
    }
}

---

## filter 만들기

filter는 조건에 맞는 요소만 남긴  
새로운 MyStream을 반환한다.

구조

public MyStream<T> filter(Predicate<T> predicate) {
    List<T> result = new ArrayList<>();

    for (T value : list) {
        if (predicate.test(value)) {
            result.add(value);
        }
    }

    return new MyStream<>(result);
}

---

## map 만들기

map은 각 요소를 변환한  
새로운 MyStream을 반환한다.

입력 타입과 결과 타입이 달라질 수 있으므로  
제네릭 R을 사용한다.

구조

public <R> MyStream<R> map(Function<T, R> function) {
    List<R> result = new ArrayList<>();

    for (T value : list) {
        result.add(function.apply(value));
    }

    return new MyStream<>(result);
}

---

## toList 만들기

toList는 스트림 내부의 리스트를 최종 결과로 반환한다.

구조

public List<T> toList() {
    return list;
}

---

# 메서드 체이닝

스트림은 메서드가 자기 자신 또는 새로운 스트림을 반환하기 때문에  
메서드를 연속해서 호출할 수 있다.

예시

MyStream.of(numbers)
        .filter(value -> value % 2 == 0)
        .map(value -> value * 2)
        .toList();

---

## 메서드 체이닝의 장점

- 처리 흐름이 위에서 아래로 읽힌다.
- 중간 변수를 줄일 수 있다.
- 코드가 간결해진다.
- 데이터 처리 의도가 명확해진다.

---

# 직접 만든 스트림과 자바 Stream

직접 만든 MyStream은  
자바 Stream의 기본 원리를 이해하기 위한 학습용이다.

자바에서 제공하는 Stream도 비슷한 방식으로 사용한다.

예시

numbers.stream()
        .filter(value -> value % 2 == 0)
        .map(value -> value * 2)
        .toList();

---

## 자바 Stream과 연결되는 개념

이번 단원에서 직접 만든 기능들은  
자바 Stream API의 핵심 개념과 연결된다.

직접 만든 기능

- filter()
- map()
- toList()

자바 Stream

- filter()
- map()
- toList()
- collect()
- reduce()
- sorted()

---

# filter, map, stream 정리

## filter

조건을 만족하는 데이터만 남긴다.

사용 함수형 인터페이스

Predicate<T>

형태

T → boolean

---

## map

데이터를 다른 값으로 변환한다.

사용 함수형 인터페이스

Function<T, R>

형태

T → R

---

## stream

데이터 처리 흐름을 연결해서 표현한다.

주요 장점

- 메서드 체이닝 가능
- 코드 간결
- 가독성 향상
- 데이터 처리 흐름 명확

---

# 람다 활용의 장점

람다를 활용하면 변하는 로직을 외부에서 전달할 수 있다.

filter에서는 조건을 전달하고  
map에서는 변환 로직을 전달한다.

장점

- 코드 중복 감소
- 코드 간결성 향상
- 가독성 향상
- 재사용성 증가
- 유연한 로직 변경 가능
- 함수형 프로그래밍 스타일로 작성 가능

---

# 핵심 정리

1. filter는 조건에 맞는 요소만 걸러내는 기능이다.
2. filter에는 Predicate<T>를 사용할 수 있다.
3. Predicate<T>는 T를 받아 boolean을 반환한다.
4. map은 요소를 다른 값으로 변환하는 기능이다.
5. map에는 Function<T, R>을 사용할 수 있다.
6. Function<T, R>은 T를 받아 R을 반환한다.
7. filter와 map을 조합하면 데이터를 걸러낸 뒤 변환할 수 있다.
8. 스트림은 데이터 처리 흐름을 표현하는 구조이다.
9. 스트림을 사용하면 filter, map 같은 기능을 메서드 체이닝으로 연결할 수 있다.
10. 직접 MyStream을 만들어보면 자바 Stream API의 기본 원리를 이해할 수 있다.
11. 람다를 활용하면 변하는 조건과 변환 로직을 외부에서 전달할 수 있다.
12. 람다와 스트림을 사용하면 코드가 간결해지고 가독성과 재사용성이 좋아진다.
