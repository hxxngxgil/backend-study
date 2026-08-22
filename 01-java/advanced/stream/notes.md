# Stream API

## 스트림 API 시작

스트림 API는 컬렉션이나 배열 같은 데이터를 함수형 스타일로 처리할 수 있게 해주는 자바 API이다.

기존에는 데이터를 처리할 때 for문을 많이 사용했다.

예시

List<Integer> result = new ArrayList<>();

for (Integer number : numbers) {
    if (number % 2 == 0) {
        result.add(number * 2);
    }
}

이 방식은 동작은 하지만  
필터링, 변환, 결과 저장 로직이 한 곳에 섞여 있다.

스트림을 사용하면 데이터 처리 흐름을 더 명확하게 표현할 수 있다.

예시

List<Integer> result = numbers.stream()
        .filter(number -> number % 2 == 0)
        .map(number -> number * 2)
        .toList();

---

## 스트림 API란?

Stream API는 데이터를 처리하는 흐름을 표현하는 API이다.

스트림은 데이터를 저장하는 자료구조가 아니다.

컬렉션, 배열, 파일, 범위 등 다양한 데이터 소스로부터  
데이터를 하나씩 흘려보내면서 처리하는 흐름이다.

---

## 스트림의 핵심 특징

- 원본 데이터를 변경하지 않는다.
- 데이터 처리 과정을 파이프라인으로 표현한다.
- 중간 연산과 최종 연산으로 구성된다.
- 중간 연산은 지연 연산된다.
- 람다와 함수형 인터페이스를 적극적으로 사용한다.
- 코드가 간결해지고 가독성이 좋아진다.

---

## 스트림을 사용하는 이유

스트림을 사용하면 데이터 처리 로직을 선언적으로 표현할 수 있다.

즉, 어떻게 반복할지보다  
무엇을 할지에 집중할 수 있다.

기존 for문

- 반복문 작성
- 조건문 작성
- 결과 리스트 생성
- 결과 추가

스트림

- filter로 조건 표현
- map으로 변환 표현
- toList로 결과 생성

---

# 파이프라인 구성

스트림은 파이프라인 구조로 동작한다.

파이프라인은 데이터 소스에서 시작해서  
중간 연산을 거쳐  
최종 연산으로 끝난다.

구성

데이터 소스 → 중간 연산 → 중간 연산 → 최종 연산

예시

numbers.stream()
        .filter(number -> number % 2 == 0)
        .map(number -> number * 2)
        .toList();

---

## 데이터 소스

스트림의 시작점이다.

예시

- 컬렉션
- 배열
- 파일
- 직접 생성한 값
- 숫자 범위

---

## 중간 연산

중간 연산은 스트림을 변환하거나 필터링하는 연산이다.

특징

- Stream을 반환한다.
- 여러 개 연결할 수 있다.
- 지연 연산된다.
- 최종 연산이 실행되기 전까지 실제로 동작하지 않는다.

예시

filter()

map()

flatMap()

distinct()

sorted()

limit()

skip()

---

## 최종 연산

최종 연산은 스트림 처리를 끝내고 결과를 만든다.

특징

- Stream이 아닌 결과를 반환한다.
- 최종 연산이 실행되어야 중간 연산도 함께 실행된다.
- 최종 연산 이후 스트림은 다시 사용할 수 없다.

예시

toList()

forEach()

count()

reduce()

collect()

findFirst()

anyMatch()

---

# 지연 연산

스트림의 중간 연산은 바로 실행되지 않는다.

최종 연산이 호출될 때까지 실행을 미룬다.

이것을 지연 연산이라고 한다.

---

## 지연 연산 예시

Stream<Integer> stream = numbers.stream()
        .filter(number -> number % 2 == 0)
        .map(number -> number * 2);

이 코드만으로는 filter와 map이 실제로 실행되지 않는다.

최종 연산이 호출되어야 실행된다.

예시

List<Integer> result = stream.toList();

---

## 지연 연산이 필요한 이유

지연 연산 덕분에 스트림은 필요한 순간에만 데이터를 처리할 수 있다.

장점

- 불필요한 연산을 줄일 수 있다.
- 중간 결과를 매번 만들지 않아도 된다.
- 최적화가 가능하다.
- 무한 스트림도 필요한 만큼만 처리할 수 있다.

---

# 지연 연산과 최적화

스트림은 지연 연산을 사용하기 때문에  
전체 데이터를 무조건 끝까지 처리하지 않아도 된다.

특히 limit, findFirst, anyMatch 같은 연산과 함께 사용하면  
필요한 만큼만 처리하고 종료할 수 있다.

---

## short-circuit 연산

short-circuit 연산은 조건이 만족되면  
더 이상 전체 데이터를 처리하지 않고 중간에 끝낼 수 있는 연산이다.

예시

- limit()
- findFirst()
- findAny()
- anyMatch()
- allMatch()
- noneMatch()

---

## 최적화 예시

List<Integer> result = numbers.stream()
        .filter(number -> number % 2 == 0)
        .limit(2)
        .toList();

이 경우 짝수 2개를 찾으면  
나머지 데이터는 더 이상 처리하지 않을 수 있다.

---

## 반복문과 스트림의 차이

for문은 개발자가 직접 반복 흐름을 제어한다.

스트림은 데이터 처리 흐름을 선언하고  
실제 반복과 최적화는 Stream API가 처리한다.

---

# 스트림 생성

스트림은 다양한 방식으로 생성할 수 있다.

---

## 컬렉션에서 스트림 생성

List<String> names = List.of("A", "B", "C");

Stream<String> stream = names.stream();

---

## 배열에서 스트림 생성

String[] names = {"A", "B", "C"};

Stream<String> stream = Arrays.stream(names);

---

## Stream.of()

Stream<String> stream = Stream.of("A", "B", "C");

---

## 숫자 범위 스트림

IntStream.range(1, 5);

결과

1, 2, 3, 4

IntStream.rangeClosed(1, 5);

결과

1, 2, 3, 4, 5

---

## 무한 스트림

Stream.generate(() -> "hello");

Stream.iterate(1, value -> value + 1);

무한 스트림은 끝이 없기 때문에  
limit() 같은 연산으로 제한해서 사용해야 한다.

예시

Stream.iterate(1, value -> value + 1)
        .limit(5)
        .toList();

---

# 중간 연산

중간 연산은 스트림을 다른 스트림으로 변환한다.

중간 연산은 여러 개 연결할 수 있고  
최종 연산이 실행될 때 함께 동작한다.

---

## filter()

filter는 조건에 맞는 요소만 남긴다.

사용 함수형 인터페이스

Predicate<T>

형태

T → boolean

예시

numbers.stream()
        .filter(number -> number % 2 == 0)
        .toList();

---

## map()

map은 각 요소를 다른 값으로 변환한다.

사용 함수형 인터페이스

Function<T, R>

형태

T → R

예시

names.stream()
        .map(name -> name.length())
        .toList();

---

## distinct()

distinct는 중복을 제거한다.

예시

numbers.stream()
        .distinct()
        .toList();

---

## sorted()

sorted는 정렬한다.

기본 정렬

numbers.stream()
        .sorted()
        .toList();

정렬 기준 전달

names.stream()
        .sorted((a, b) -> a.length() - b.length())
        .toList();

메서드 참조 활용

names.stream()
        .sorted(String::compareTo)
        .toList();

---

## limit()

limit은 앞에서부터 지정한 개수만 가져온다.

예시

numbers.stream()
        .limit(3)
        .toList();

---

## skip()

skip은 앞에서부터 지정한 개수만 건너뛴다.

예시

numbers.stream()
        .skip(3)
        .toList();

---

## peek()

peek은 중간에 값을 확인할 때 사용할 수 있다.

예시

numbers.stream()
        .peek(number -> System.out.println("before = " + number))
        .map(number -> number * 2)
        .peek(number -> System.out.println("after = " + number))
        .toList();

주의

peek은 디버깅 용도로 사용하는 것이 좋다.  
실제 비즈니스 로직을 넣는 것은 권장하지 않는다.

---

# FlatMap

## map과 flatMap 차이

map은 각 요소를 변환한다.

flatMap은 각 요소를 스트림으로 변환한 뒤  
여러 스트림을 하나의 스트림으로 평탄화한다.

---

## map 예시

List<List<Integer>> numbers = List.of(
        List.of(1, 2),
        List.of(3, 4)
);

numbers.stream()
        .map(list -> list.stream())
        .toList();

결과는 Stream들이 들어있는 형태가 된다.

즉, 구조가 중첩된다.

---

## flatMap 예시

List<List<Integer>> numbers = List.of(
        List.of(1, 2),
        List.of(3, 4)
);

List<Integer> result = numbers.stream()
        .flatMap(list -> list.stream())
        .toList();

결과

1, 2, 3, 4

---

## flatMap을 사용하는 경우

중첩된 구조를 펼치고 싶을 때 사용한다.

예시

- List<List<Integer>>를 List<Integer>로 변환
- 문장 목록을 단어 목록으로 변환
- 주문 목록에서 주문 상품 목록을 펼치기
- 여러 컬렉션을 하나의 스트림으로 합치기

---

## flatMap 핵심

map

T → R

flatMap

T → Stream<R>

flatMap은 각 요소를 Stream으로 바꾸고  
그 Stream들을 하나로 합친다.

---

# Optional 간단 설명

Optional은 값이 있을 수도 있고 없을 수도 있음을 표현하는 객체이다.

null을 직접 다루는 대신  
Optional을 사용하면 값이 없는 경우를 더 명확하게 표현할 수 있다.

---

## Optional이 필요한 이유

기존 방식에서는 값이 없으면 null을 반환하는 경우가 많다.

문제점

- NullPointerException이 발생할 수 있다.
- 값이 없을 수 있다는 사실이 코드에 잘 드러나지 않는다.

Optional을 사용하면  
값이 없을 수 있다는 사실을 타입으로 표현할 수 있다.

---

## Optional 예시

Optional<String> optional = Optional.of("hello");

값 꺼내기

optional.get();

주의

get()은 값이 없으면 예외가 발생할 수 있으므로  
무조건 사용하는 것은 좋지 않다.

---

## Optional 주요 메서드

| 메서드 | 의미 |
|--------|------|
| Optional.of(value) | null이 아닌 값을 담는다 |
| Optional.ofNullable(value) | null일 수도 있는 값을 담는다 |
| Optional.empty() | 빈 Optional 생성 |
| isPresent() | 값이 있는지 확인 |
| isEmpty() | 값이 없는지 확인 |
| ifPresent() | 값이 있으면 실행 |
| orElse() | 값이 없으면 기본값 반환 |
| orElseGet() | 값이 없으면 함수로 기본값 생성 |
| orElseThrow() | 값이 없으면 예외 발생 |

---

## 스트림과 Optional

findFirst(), findAny(), max(), min() 같은 최종 연산은  
결과가 없을 수 있기 때문에 Optional을 반환한다.

예시

Optional<Integer> result = numbers.stream()
        .filter(number -> number > 10)
        .findFirst();

---

# 최종 연산

최종 연산은 스트림 처리를 마무리하고 결과를 만든다.

최종 연산이 실행되어야 중간 연산도 실제로 실행된다.

---

## forEach()

각 요소를 소비한다.

사용 함수형 인터페이스

Consumer<T>

예시

names.stream()
        .forEach(name -> System.out.println(name));

메서드 참조

names.stream()
        .forEach(System.out::println);

---

## count()

요소 개수를 반환한다.

예시

long count = numbers.stream()
        .filter(number -> number % 2 == 0)
        .count();

---

## toList()

스트림의 결과를 리스트로 반환한다.

예시

List<Integer> result = numbers.stream()
        .filter(number -> number > 10)
        .toList();

---

## reduce()

reduce는 여러 요소를 하나의 값으로 누적한다.

예시

int sum = numbers.stream()
        .reduce(0, (a, b) -> a + b);

메서드 참조

int sum = numbers.stream()
        .reduce(0, Integer::sum);

---

## anyMatch()

하나라도 조건을 만족하면 true를 반환한다.

예시

boolean result = numbers.stream()
        .anyMatch(number -> number > 10);

---

## allMatch()

모든 요소가 조건을 만족하면 true를 반환한다.

예시

boolean result = numbers.stream()
        .allMatch(number -> number > 0);

---

## noneMatch()

모든 요소가 조건을 만족하지 않으면 true를 반환한다.

예시

boolean result = numbers.stream()
        .noneMatch(number -> number < 0);

---

## findFirst()

첫 번째 요소를 Optional로 반환한다.

예시

Optional<Integer> result = numbers.stream()
        .filter(number -> number > 10)
        .findFirst();

---

## min(), max()

최솟값, 최댓값을 구한다.

예시

Optional<Integer> min = numbers.stream()
        .min(Integer::compareTo);

Optional<Integer> max = numbers.stream()
        .max(Integer::compareTo);

---

# 기본형 특화 스트림

## 기본형 특화 스트림이란?

기본형 특화 스트림은 int, long, double 같은 기본형을 효율적으로 처리하기 위한 스트림이다.

대표 종류

- IntStream
- LongStream
- DoubleStream

---

## 기본형 특화 스트림이 필요한 이유

일반 Stream<T>는 제네릭 기반이다.

제네릭은 기본형을 직접 사용할 수 없기 때문에  
int는 Integer, long은 Long, double은 Double 같은 래퍼 타입을 사용해야 한다.

이 과정에서 박싱과 언박싱이 발생할 수 있다.

기본형 특화 스트림을 사용하면  
불필요한 박싱, 언박싱 비용을 줄일 수 있다.

---

## IntStream 예시

IntStream.range(1, 5)
        .forEach(System.out::println);

결과

1, 2, 3, 4

---

## range와 rangeClosed

IntStream.range(1, 5)

결과

1, 2, 3, 4

IntStream.rangeClosed(1, 5)

결과

1, 2, 3, 4, 5

---

## mapToInt()

mapToInt는 일반 Stream을 IntStream으로 변환한다.

예시

int sum = names.stream()
        .mapToInt(name -> name.length())
        .sum();

의미

String 목록을 각 문자열의 길이 int 값으로 변환한 뒤 합계를 구한다.

---

## mapToLong()

mapToLong은 일반 Stream을 LongStream으로 변환한다.

예시

LongStream stream = numbers.stream()
        .mapToLong(number -> number.longValue());

---

## mapToDouble()

mapToDouble은 일반 Stream을 DoubleStream으로 변환한다.

예시

DoubleStream stream = numbers.stream()
        .mapToDouble(number -> number.doubleValue());

---

## 기본형 특화 스트림의 주요 메서드

| 메서드 | 의미 |
|--------|------|
| sum() | 합계 |
| average() | 평균 |
| min() | 최솟값 |
| max() | 최댓값 |
| count() | 개수 |
| summaryStatistics() | 합계, 평균, 최소, 최대, 개수 통계 |

---

## boxed()

boxed는 기본형 특화 스트림을 일반 Stream으로 변환한다.

예시

List<Integer> result = IntStream.rangeClosed(1, 5)
        .boxed()
        .toList();

---

## map과 mapToInt 차이

map은 Stream<T>에서 Stream<R>로 변환한다.

mapToInt는 Stream<T>에서 IntStream으로 변환한다.

예시

Stream<Integer> stream = numbers.stream()
        .map(number -> number * 2);

IntStream intStream = numbers.stream()
        .mapToInt(number -> number * 2);

차이

- map은 Integer 같은 객체 스트림을 반환한다.
- mapToInt는 int 기본형 스트림을 반환한다.
- 숫자 계산이 목적이면 mapToInt 같은 기본형 특화 매핑이 더 적절할 수 있다.

---

# 컬렉터

## collect()

collect는 스트림의 결과를 원하는 자료구조나 형태로 모으는 최종 연산이다.

예시

List<String> result = names.stream()
        .filter(name -> name.startsWith("A"))
        .collect(Collectors.toList());

---

## Collectors

Collectors는 자주 사용하는 수집 기능을 제공하는 유틸리티 클래스이다.

대표 기능

- toList()
- toSet()
- toMap()
- joining()
- counting()
- summingInt()
- averagingInt()
- groupingBy()
- partitioningBy()

---

## toList()

스트림 결과를 리스트로 수집한다.

예시

List<String> result = names.stream()
        .collect(Collectors.toList());

---

## toSet()

스트림 결과를 Set으로 수집한다.

예시

Set<String> result = names.stream()
        .collect(Collectors.toSet());

중복 제거가 필요한 경우 사용할 수 있다.

---

## toMap()

스트림 결과를 Map으로 수집한다.

예시

Map<Long, Member> result = members.stream()
        .collect(Collectors.toMap(
                member -> member.getId(),
                member -> member
        ));

키와 값을 만드는 함수를 각각 전달한다.

---

## joining()

문자열을 하나로 연결한다.

예시

String result = names.stream()
        .collect(Collectors.joining(", "));

---

## counting()

요소 개수를 센다.

예시

long count = names.stream()
        .collect(Collectors.counting());

---

## summingInt()

int 값을 합산한다.

예시

int totalAge = members.stream()
        .collect(Collectors.summingInt(member -> member.getAge()));

---

## averagingInt()

int 값의 평균을 구한다.

예시

double averageAge = members.stream()
        .collect(Collectors.averagingInt(member -> member.getAge()));

---

# groupingBy

groupingBy는 특정 기준으로 데이터를 그룹화한다.

예시

Map<String, List<Member>> result = members.stream()
        .collect(Collectors.groupingBy(member -> member.getTeam()));

의미

회원들을 팀 이름 기준으로 그룹화한다.

결과 형태

팀A → [회원1, 회원2]

팀B → [회원3, 회원4]

---

# partitioningBy

partitioningBy는 true, false 두 그룹으로 나눈다.

예시

Map<Boolean, List<Member>> result = members.stream()
        .collect(Collectors.partitioningBy(member -> member.getAge() >= 20));

결과 형태

true → 성인 회원 목록

false → 미성년 회원 목록

---

# 다운스트림 컬렉터

## 다운스트림 컬렉터란?

다운스트림 컬렉터는 groupingBy나 partitioningBy로 그룹을 만든 뒤  
각 그룹 안에서 추가로 어떤 방식으로 수집할지 지정하는 컬렉터이다.

즉, 그룹화 이후의 처리 방식을 지정한다.

---

## 일반 groupingBy

Map<String, List<Member>> result = members.stream()
        .collect(Collectors.groupingBy(member -> member.getTeam()));

결과

팀별 회원 목록

---

## groupingBy + counting

Map<String, Long> result = members.stream()
        .collect(Collectors.groupingBy(
                member -> member.getTeam(),
                Collectors.counting()
        ));

결과

팀별 회원 수

---

## groupingBy + mapping

Map<String, List<String>> result = members.stream()
        .collect(Collectors.groupingBy(
                member -> member.getTeam(),
                Collectors.mapping(
                        member -> member.getName(),
                        Collectors.toList()
                )
        ));

결과

팀별 회원 이름 목록

---

## groupingBy + summingInt

Map<String, Integer> result = members.stream()
        .collect(Collectors.groupingBy(
                member -> member.getTeam(),
                Collectors.summingInt(member -> member.getAge())
        ));

결과

팀별 나이 합계

---

## groupingBy + averagingInt

Map<String, Double> result = members.stream()
        .collect(Collectors.groupingBy(
                member -> member.getTeam(),
                Collectors.averagingInt(member -> member.getAge())
        ));

결과

팀별 평균 나이

---

## 다운스트림 컬렉터를 사용하는 이유

단순히 그룹별 리스트를 만드는 것에서 끝나지 않고  
그룹별 개수, 합계, 평균, 특정 값 목록 등을 바로 만들 수 있다.

장점

- 그룹화 후 추가 반복문을 줄일 수 있다.
- 데이터 집계 로직을 선언적으로 표현할 수 있다.
- 코드가 간결해진다.
- 그룹별 통계 처리가 쉬워진다.

---

# 스트림 사용 시 주의점

## 스트림은 재사용할 수 없다

스트림은 최종 연산을 한 번 수행하면 다시 사용할 수 없다.

예시

Stream<Integer> stream = numbers.stream();

stream.count();

stream.toList();

위 코드는 두 번째 최종 연산에서 오류가 발생한다.

필요하면 스트림을 다시 생성해야 한다.

---

## 원본 데이터를 변경하지 않는다

스트림 연산은 원본 컬렉션을 직접 변경하지 않는다.

결과가 필요하면 새로운 리스트나 컬렉션으로 받아야 한다.

---

## 중간 연산만으로는 실행되지 않는다

filter, map 같은 중간 연산만 작성하면 실제로 실행되지 않는다.

최종 연산이 있어야 실행된다.

---

## 너무 복잡한 스트림은 피한다

스트림을 너무 길고 복잡하게 작성하면  
오히려 for문보다 읽기 어려워질 수 있다.

간단한 데이터 처리에는 스트림이 좋지만  
복잡한 비즈니스 로직은 별도 메서드로 분리하는 것이 좋다.

---

# 스트림을 사용하는 기준

스트림을 사용하기 좋은 경우

- 컬렉션 데이터를 필터링할 때
- 데이터를 다른 형태로 변환할 때
- 합계, 평균, 개수 같은 집계를 할 때
- 그룹화가 필요할 때
- 처리 흐름을 간결하게 표현하고 싶을 때

for문이 더 나은 경우

- 중간에 복잡한 상태 변경이 많을 때
- 예외 처리나 분기 처리가 복잡할 때
- 디버깅이 중요한 복잡한 로직일 때
- 단순 반복이 더 명확할 때

---

# 전체 흐름 정리

스트림 파이프라인 구조

데이터 소스

→ 중간 연산

→ 중간 연산

→ 최종 연산

예시

members.stream()
        .filter(member -> member.getAge() >= 20)
        .map(member -> member.getName())
        .toList();

의미

1. 회원 목록에서 스트림을 만든다.
2. 성인 회원만 필터링한다.
3. 회원 객체를 회원 이름으로 변환한다.
4. 리스트로 반환한다.

---

# 핵심 정리

1. Stream API는 데이터를 처리하는 흐름을 표현하는 자바 API이다.
2. 스트림은 데이터를 저장하는 자료구조가 아니다.
3. 스트림 파이프라인은 데이터 소스, 중간 연산, 최종 연산으로 구성된다.
4. 중간 연산은 Stream을 반환하고 여러 개 연결할 수 있다.
5. 최종 연산이 실행되어야 중간 연산도 실제로 실행된다.
6. 중간 연산은 지연 연산된다.
7. 지연 연산 덕분에 불필요한 연산을 줄이고 최적화할 수 있다.
8. filter는 조건에 맞는 요소만 남긴다.
9. map은 요소를 다른 값으로 변환한다.
10. flatMap은 중첩된 스트림을 하나로 평탄화한다.
11. Optional은 값이 있을 수도 있고 없을 수도 있음을 표현한다.
12. findFirst, max, min 같은 연산은 결과가 없을 수 있어 Optional을 반환한다.
13. forEach, count, reduce, toList, collect는 최종 연산이다.
14. 기본형 특화 스트림은 int, long, double을 효율적으로 처리하기 위한 스트림이다.
15. mapToInt, mapToLong, mapToDouble은 객체 스트림을 기본형 특화 스트림으로 변환한다.
16. collect는 스트림 결과를 원하는 형태로 수집하는 최종 연산이다.
17. groupingBy는 데이터를 특정 기준으로 그룹화한다.
18. 다운스트림 컬렉터는 그룹화 이후 각 그룹 안에서 추가 집계나 변환을 수행한다.
19. 스트림은 최종 연산 후 재사용할 수 없다.
20. 스트림은 코드의 간결성과 가독성을 높여주지만, 복잡한 로직에는 무조건 좋은 선택은 아니다.
