# Utility Classes (유틸리티 클래스)

## Class 클래스

Class 클래스는 클래스의 정보를 다루는 클래스이다.

실행 중인 클래스의 정보(이름, 메서드 등)를 확인할 수 있다.

---

## Class 클래스 사용

예시

Class clazz = String.class;

---

## 주요 기능

- 클래스 이름 조회
- 메서드 정보 조회
- 생성자 정보 조회

---

## getClass()

객체의 클래스 정보를 반환한다.

예시

String str = "hello";

System.out.println(str.getClass());

---

## System 클래스

System 클래스는 시스템 관련 기능을 제공한다.

대표적으로
- 출력
- 시간 측정
- 프로그램 종료 등을 지원한다.

---

## System.out.println()

콘솔 출력

예시

System.out.println("hello");

---

## System.currentTimeMillis()

현재 시간(ms) 반환

예시

long time = System.currentTimeMillis();

---

## System.exit()

프로그램 종료

예시

System.exit(0);

---

## Math 클래스

Math 클래스는 수학 계산 기능을 제공한다.

모든 메서드는 static으로 제공된다.

---

## Math 주요 메서드

### abs()
절대값 반환

예시

Math.abs(-10)

---

### max()
큰 값 반환

예시

Math.max(10, 20)

---

### min()
작은 값 반환

예시

Math.min(10, 20)

---

### random()
0.0 ~ 1.0 사이 랜덤 값 반환

예시

Math.random()

---

### sqrt()
제곱근 반환

예시

Math.sqrt(16)

---

## Random 클래스

Random 클래스는 랜덤 값을 생성하는 클래스이다.

java.util 패키지에 존재한다.

---

## Random 객체 생성

예시

Random random = new Random();

---

## nextInt()

정수 랜덤값 생성

예시

random.nextInt();

---

## 범위 지정 랜덤

0 ~ 9 랜덤 숫자

예시

random.nextInt(10);

---

## Random 특징

- 다양한 타입 랜덤 생성 가능
- 난수 생성 기능 제공

---

## 핵심 정리

1. Class 클래스는 클래스 정보를 다룬다.
2. System 클래스는 시스템 기능을 제공한다.
3. Math 클래스는 수학 계산 기능을 제공한다.
4. Math 메서드는 static으로 사용한다.
5. Random 클래스는 랜덤 값을 생성한다.
6. nextInt(n)은 0 ~ n-1 범위 값을 생성한다.
