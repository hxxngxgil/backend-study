# Static (정적 변수와 메서드)

## static이란
static은 클래스에 속하는 변수나 메서드를 만들 때 사용하는 키워드이다.  
객체를 생성하지 않아도 클래스 이름으로 바로 접근할 수 있다.

---

## 변수의 종류

### 지역 변수
- 메서드 내부에서 선언
- 메서드 실행 시 생성, 종료 시 소멸

---

### 인스턴스 변수
- static이 없는 멤버 변수
- 객체마다 별도로 존재

---

### 클래스 변수 (static 변수)
- static이 붙은 변수
- 모든 객체가 하나의 값을 공유

---

## 생명주기

- 지역 변수 → 메서드 실행 시 생성 / 종료 시 소멸
- 인스턴스 변수 → 객체 생성 시 생성 / 객체 소멸 시 제거
- 클래스 변수(static) → 프로그램 실행 시 생성 / 종료 시까지 유지

---

## static 변수

static 변수는 모든 객체가 공유하는 변수이다.

예시

class Counter {
    static int count = 0;
}

Counter.count++;

---

## static 메서드

static 메서드는 객체 생성 없이 클래스 이름으로 호출할 수 있다.

예시

class MathUtil {
    static int add(int a, int b) {
        return a + b;
    }
}

int result = MathUtil.add(10, 20);

---

## static과 인스턴스 접근

### static 메서드 특징
- static 변수만 사용 가능
- 인스턴스 변수 접근 불가능

이유  
static은 클래스 기준으로 동작하기 때문에  
객체(참조값)가 없어서 인스턴스에 접근할 수 없다.

---

### 인스턴스 메서드 특징
- 인스턴스 변수 사용 가능
- static 변수도 사용 가능

---

## 멤버 메서드 종류

### 인스턴스 메서드
- static이 없는 메서드
- 객체 생성 후 사용

---

### 클래스 메서드 (static 메서드)
- static이 붙은 메서드
- 클래스 이름으로 바로 호출 가능

---

## static import

static 메서드를 import하면 클래스 이름 없이 사용할 수 있다.

예시

import static java.lang.Math.*;

int result = max(10, 20);

---

## 핵심 정리

1. static은 클래스에 속한다.
2. static 변수는 모든 객체가 공유한다.
3. static 메서드는 객체 없이 호출 가능하다.
4. static 메서드는 인스턴스에 접근할 수 없다.
5. 인스턴스 메서드는 static 사용이 가능하다.
6. static import를 사용하면 클래스명 없이 호출 가능하다.
