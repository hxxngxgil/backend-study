# Collection Framework - Iteration & Sorting (컬렉션 프레임워크 - 순회와 정렬)

## Iterable

Iterable은 객체를 반복(순회)할 수 있도록 하는 인터페이스이다.

반복을 시작하기 위해 iterator() 메서드를 제공한다.

예시

Iterable<String> iterable;

---

## Iterator

Iterator는 컬렉션의 요소를 하나씩 순회하는 객체이다.

주요 메서드

- hasNext()
- next()

예시

Iterator<String> iterator = list.iterator();

while(iterator.hasNext()) {
    System.out.println(iterator.next());
}

---

## 직접 구현하는 Iterable

사용자 정의 클래스도 Iterable 인터페이스를 구현하면
향상된 for문으로 순회할 수 있다.

필수 메서드

iterator()

---

## 향상된 for문 (for-each)

Iterable을 구현한 객체는
향상된 for문으로 쉽게 순회할 수 있다.

예시

for(String s : list) {
    System.out.println(s);
}

내부적으로 Iterator를 사용한다.

---

## 자바가 제공하는 Iterable

대표 컬렉션은 모두 Iterable을 구현한다.

- List
- Set
- Queue

따라서 모두 향상된 for문 사용이 가능하다.

---

# Comparable

객체의 기본 정렬 기준을 정의하는 인터페이스이다.

자기 자신과 비교하는 기준을 구현한다.

메서드

compareTo()

예시

public class Student implements Comparable<Student> {

    @Override
    public int compareTo(Student o) {
        return this.age - o.age;
    }

}

---

# Comparator

정렬 기준을 외부에서 정의하는 인터페이스이다.

기존 클래스를 수정하지 않고
다양한 기준으로 정렬할 수 있다.

메서드

compare()

예시

Collections.sort(list, comparator);

---

# Comparable vs Comparator

Comparable

- 클래스 내부에서 구현
- 기본 정렬 기준

Comparator

- 클래스 외부에서 구현
- 여러 정렬 기준 생성 가능

---

# Collections 유틸 클래스

Collections 클래스는 컬렉션을 편리하게 다룰 수 있는
유틸리티 메서드를 제공한다.

대표 메서드

- sort()
- reverse()
- shuffle()
- binarySearch()
- max()
- min()

---

# 컬렉션 프레임워크 정리

## List

특징

- 순서 O
- 중복 O

대표 구현체

- ArrayList
- LinkedList

---

## Set

특징

- 순서 X
- 중복 X

대표 구현체

- HashSet
- LinkedHashSet
- TreeSet

---

## Map

특징

- Key-Value 저장
- Key 중복 불가

대표 구현체

- HashMap
- LinkedHashMap
- TreeMap

---

## Queue

FIFO(선입선출)

대표 구현체

- ArrayDeque
- PriorityQueue

---

## Deque

양쪽에서 삽입/삭제 가능

스택과 큐 모두 구현 가능

대표 구현체

- ArrayDeque

---

# 컬렉션 선택 가이드

## List

순서가 중요하고
중복을 허용해야 하는 경우

일반적인 선택

ArrayList

앞쪽 삽입/삭제가 매우 많은 경우

LinkedList

---

## Set

중복을 허용하지 않는 경우

일반적인 선택

HashSet

순서를 유지

LinkedHashSet

정렬이 필요

TreeSet

---

## Map

Key-Value 저장

일반적인 선택

HashMap

입력 순서 유지

LinkedHashMap

정렬 필요

TreeMap

---

## Queue / Deque

스택 또는 큐 구조

일반적으로

ArrayDeque

우선순위 처리

PriorityQueue

※ PriorityQueue는 특수한 경우에 사용하며
실무에서는 자주 사용하지 않는다.

---

# 실무 선택 가이드

대부분의 경우

List

→ ArrayList

Set

→ HashSet

Map

→ HashMap

Queue

→ ArrayDeque

를 사용한다.

---

# 핵심 정리

1. Iterable은 반복 가능한 객체를 위한 인터페이스이다.
2. Iterator는 컬렉션을 순회하는 객체이다.
3. 향상된 for문은 내부적으로 Iterator를 사용한다.
4. Comparable은 기본 정렬 기준을 정의한다.
5. Comparator는 외부에서 정렬 기준을 정의한다.
6. List는 순서를 유지하고 중복을 허용한다.
7. Set은 중복을 허용하지 않는다.
8. Map은 Key-Value 형태로 데이터를 저장한다.
9. Queue와 Deque는 FIFO, LIFO 구조를 구현할 수 있다.
10. 실무에서는 대부분 ArrayList, HashSet, HashMap, ArrayDeque를 사용한다.
