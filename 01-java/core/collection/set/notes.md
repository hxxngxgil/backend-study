# Hash, HashSet & Set

## List vs Set

### List

특징

- 순서를 유지한다.
- 중복을 허용한다.
- 인덱스로 조회할 수 있다.

대표 구현체

- ArrayList
- LinkedList

---

### Set

특징

- 순서를 보장하지 않는다.
- 중복을 허용하지 않는다.
- 동일한 데이터는 하나만 저장된다.

대표 구현체

- HashSet
- LinkedHashSet
- TreeSet

---

# Hash란?

Hash는 데이터를 빠르게 저장하고 검색하기 위한 기술이다.

입력 데이터를 해시 함수를 통해 숫자(Hash Code)로 변환하고,
이를 배열의 인덱스로 사용하여 데이터를 저장한다.

---

# Hash 관련 용어

## 해시 함수(Hash Function)

데이터를 입력받아 Hash Code를 생성하는 함수

---

## 해시 코드(Hash Code)

해시 함수가 반환한 정수 값

예시

```
"Java"
↓

2301506
```

---

## 해시 인덱스(Hash Index)

Hash Code를 배열 크기에 맞게 변환한 인덱스

예시

```
index = hashCode % 배열크기
```

---

# 배열의 Index 사용

배열은 인덱스로 바로 접근하기 때문에

조회 성능이 매우 빠르다.

시간 복잡도

O(1)

---

# 메모리 낭비

Hash에서

Hash Code를 그대로 배열 인덱스로 사용하면

매우 큰 배열이 필요하게 된다.

따라서

배열 크기보다 큰 Hash Code는

나머지 연산(%)을 사용한다.

---

# 나머지 연산

배열 크기가 10이라면

```
index = hashCode % 10
```

를 사용하여

항상 0~9 사이의 인덱스를 만든다.

---

# 해시 충돌(Hash Collision)

서로 다른 데이터가

같은 Hash Index를 가지는 현상이다.

예시

```
Apple

↓

5

Banana

↓

5
```

둘 다 같은 위치에 저장되어 충돌이 발생한다.

---

# 해시 충돌 해결

대표적인 방법

- LinkedList
- Tree

이번 강의에서는

LinkedList를 이용하여 충돌을 해결하였다.

---

# HashSet

HashSet은

Hash를 이용하여

중복을 허용하지 않는 Set 구현체이다.

특징

- 중복 불가
- 순서 보장 X
- 매우 빠른 검색

---

# HashSet 동작 과정

1. hashCode() 호출

↓

2. Hash Code 생성

↓

3. Hash Index 계산

↓

4. 해당 Bucket 확인

↓

5. equals() 비교

↓

6. 저장 또는 중복 판단

---

# 문자열 Hash Code

String은

hashCode()가 이미 구현되어 있다.

따라서 문자열은

HashSet에서 바로 사용할 수 있다.

---

# hashCode()

모든 객체는 Object의 hashCode()를 가진다.

HashSet

HashMap

등의 Hash 기반 컬렉션은

hashCode()를 먼저 사용한다.

---

# equals()

equals()는

객체의 논리적인 동일성을 비교한다.

기본 구현은

참조값을 비교한다.

필요하면 오버라이딩하여

원하는 기준으로 비교한다.

---

# hashCode()와 equals()의 중요성

직접 만든 객체를 HashSet에 저장하려면

반드시

- equals()
- hashCode()

를 함께 오버라이딩해야 한다.

그렇지 않으면

같은 데이터라도

중복으로 저장될 수 있다.

---

# 왜 둘 다 필요한가?

HashSet은

먼저 hashCode()로 위치를 찾고

같은 Bucket 안에서는

equals()로 실제 같은 객체인지 확인한다.

즉

hashCode()

↓

equals()

순서로 동작한다.

---

# 제네릭 도입

HashSet도

제네릭을 사용하여

타입 안정성을 제공한다.

예시

HashSet<String>

HashSet<Integer>

---

# Set 인터페이스

Set은

중복을 허용하지 않는 컬렉션 인터페이스이다.

대표 구현체

- HashSet
- LinkedHashSet
- TreeSet

---

# HashSet

특징

- 중복 X
- 순서 X
- 가장 빠른 성능

시간 복잡도

추가

O(1)

검색

O(1)

삭제

O(1)

(평균)

---

# LinkedHashSet

특징

- 중복 X
- 입력 순서 유지

HashSet보다 약간 느리다.

---

# TreeSet

특징

- 중복 X
- 자동 정렬

내부적으로

Tree(Red-Black Tree)를 사용한다.

시간 복잡도

추가

O(log n)

검색

O(log n)

삭제

O(log n)

---

# Set 성능 비교

| 구현체 | 순서 유지 | 정렬 | 평균 검색 |
|---------|-----------|------|-----------|
| HashSet | X | X | O(1) |
| LinkedHashSet | O | X | O(1) |
| TreeSet | 정렬 | O | O(log n) |

---

# Set 선택 가이드

HashSet

- 가장 많이 사용
- 성능 우선

LinkedHashSet

- 입력 순서 유지 필요

TreeSet

- 자동 정렬 필요

---

# 실무에서는?

대부분

HashSet을 사용한다.

입력 순서가 중요하면

LinkedHashSet

자동 정렬이 필요하면

TreeSet을 사용한다.

---

# 핵심 정리

1. Hash는 빠른 검색을 위한 기술이다.
2. Hash Function은 Hash Code를 생성한다.
3. Hash Code를 배열 크기에 맞게 변환한 값이 Hash Index이다.
4. Hash Collision은 서로 다른 데이터가 같은 Index를 사용하는 현상이다.
5. HashSet은 충돌을 LinkedList 등의 구조로 해결한다.
6. HashSet은 hashCode()로 위치를 찾고 equals()로 실제 같은 객체인지 확인한다.
7. 직접 만든 객체는 equals()와 hashCode()를 반드시 함께 오버라이딩해야 한다.
8. HashSet은 중복을 허용하지 않고 평균 O(1)의 성능을 가진다.
9. LinkedHashSet은 입력 순서를 유지한다.
10. TreeSet은 자동 정렬을 제공하며 O(log n)의 성능을 가진다.
11. 실무에서는 대부분 HashSet을 사용한다.
