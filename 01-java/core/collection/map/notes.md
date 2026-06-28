# Map, Stack, Queue & Deque

## Map

Map은 데이터를 **Key-Value(키-값)** 형태로 저장하는 컬렉션이다.

### 특징

- Key는 중복을 허용하지 않는다.
- Value는 중복을 허용한다.
- Key를 이용해 빠르게 데이터를 조회할 수 있다.
- 순서를 보장하지 않는다. (HashMap 기준)

예시

```
id  → "kim"
name → "홍길동"
age → 20
```

---

# Map 구현체

## HashMap

특징

- 가장 많이 사용하는 Map 구현체
- Key 중복 불가
- Value 중복 가능
- 순서 유지 X
- 평균 검색 O(1)

실무에서 가장 많이 사용한다.

---

## LinkedHashMap

특징

- 입력 순서 유지
- HashMap보다 약간 느리다.

---

## TreeMap

특징

- Key 기준 자동 정렬
- 내부적으로 Red-Black Tree 사용

시간 복잡도

- 조회 O(log n)
- 추가 O(log n)
- 삭제 O(log n)

---

# Map 선택 가이드

HashMap

- 대부분의 상황
- 가장 많이 사용

LinkedHashMap

- 입력 순서를 유지해야 하는 경우

TreeMap

- Key를 정렬해야 하는 경우

---

# Stack 자료구조

Stack은

**후입선출(LIFO : Last In First Out)**

구조를 사용하는 자료구조이다.

가장 나중에 들어온 데이터가

가장 먼저 나온다.

예시

```
3
2
1
```

↓

```
3
2
1
```

주요 연산

- push()
- pop()
- peek()

---

# Queue 자료구조

Queue는

**선입선출(FIFO : First In First Out)**

구조를 사용하는 자료구조이다.

가장 먼저 들어온 데이터가

가장 먼저 나온다.

예시

```
1
2
3
```

↓

```
1
2
3
```

주요 연산

- offer()
- poll()
- peek()

---

# Deque(Double Ended Queue)

Deque는

양쪽에서 데이터를 추가하거나 삭제할 수 있는 자료구조이다.

앞과 뒤 모두 사용 가능하다.

---

## Deque 주요 메서드

앞쪽

- offerFirst()
- pollFirst()
- peekFirst()

뒤쪽

- offerLast()
- pollLast()
- peekLast()

---

# Deque와 Stack

Deque는

Stack처럼 사용할 수 있다.

예시

- push()
- pop()
- peek()

---

# Deque와 Queue

Deque는

Queue처럼 사용할 수도 있다.

예시

- offer()
- poll()
- peek()

---

# Deque 구현체

## ArrayDeque

특징

- 배열 기반
- 가장 빠른 성능
- 실무에서 가장 많이 사용

---

## LinkedList

특징

- 연결 리스트 기반
- Deque 기능도 지원

하지만 대부분의 경우

ArrayDeque가 더 좋은 성능을 제공한다.

---

# ArrayDeque를 사용하는 이유

- 메모리 효율이 좋다.
- CPU 캐시 효율이 높다.
- 객체 생성이 적다.
- 대부분의 연산에서 LinkedList보다 빠르다.

실무에서는 특별한 이유가 없다면

Deque 구현체로 **ArrayDeque**를 사용하는 것이 권장된다.

---

# 자료구조 선택 가이드

| 자료구조 | 특징 | 대표 구현체 |
|----------|------|-------------|
| List | 순서 O, 중복 O | ArrayList |
| Set | 순서 X, 중복 X | HashSet |
| Map | Key-Value 저장 | HashMap |
| Stack | LIFO | ArrayDeque |
| Queue | FIFO | ArrayDeque |
| Deque | 양쪽 입출력 | ArrayDeque |

---

# 핵심 정리

1. Map은 Key-Value 형태로 데이터를 저장한다.
2. Key는 중복이 불가능하고 Value는 중복이 가능하다.
3. HashMap은 가장 많이 사용하는 Map 구현체이다.
4. LinkedHashMap은 입력 순서를 유지한다.
5. TreeMap은 Key를 자동으로 정렬한다.
6. Stack은 LIFO(후입선출) 구조이다.
7. Queue는 FIFO(선입선출) 구조이다.
8. Deque는 앞과 뒤에서 모두 데이터를 추가하거나 삭제할 수 있다.
9. Deque는 Stack과 Queue를 모두 구현할 수 있다.
10. 실무에서는 Deque 구현체로 대부분 ArrayDeque를 사용한다.
