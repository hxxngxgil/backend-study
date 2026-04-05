# Final (상수와 변경 불가)

## final이란
final은 한 번 값이 할당되면 이후 변경할 수 없도록 만드는 키워드이다.

---

## final 변수

final이 붙은 변수는 한 번만 값을 할당할 수 있다.

예시

final int a = 10;

→ 이후 a의 값을 변경할 수 없다.

---

## final 초기화 방법

final 변수는 반드시 한 번 초기화해야 한다.

### 1. 선언 시 초기화

final int a = 10;

---

### 2. 생성자에서 초기화

class Student {
    final int age;

    Student(int age) {
        this.age = age;
    }
}

→ 객체 생성 시 한 번만 초기화 가능

---

## 필드에서 초기화 vs 생성자 초기화

### 필드에서 초기화

final int a = 10;

- 이미 값이 설정되어 있기 때문에
- 생성자에서 다시 초기화할 수 없다.

---

### 생성자에서 초기화

- 객체 생성 시 값을 설정 가능
- 유연하게 값 설정 가능

---

## 상수 (Constant)

변하지 않는 값을 상수라고 한다.  
final + static을 함께 사용한다.

예시

static final int MAX_VALUE = 100;

---

## 상수 네이밍 규칙

- 모두 대문자 사용
- 단어 구분은 언더스코어(_)

예시

MAX_VALUE  
USER_LIMIT

---

## static final 사용하는 이유

final만 사용하면 객체마다 값이 복사된다.

→ 여러 인스턴스 생성 시 메모리 낭비 발생

static을 함께 사용하면

→ 하나의 값을 모든 객체가 공유

→ 메모리 효율 증가

---

## 참조형과 final

참조형 변수에 final을 사용하면  
참조값(주소)을 변경할 수 없다.

예시

final Student student = new Student();

→ student = new Student(); (불가능)

---

## 중요한 포인트

참조값은 변경할 수 없지만  
객체 내부 값은 변경 가능하다.

예시

student.name = "Tom"; (가능)

---

## 핵심 정리

1. final은 값을 한 번만 할당할 수 있다.
2. 생성자를 통해 final 값을 초기화할 수 있다.
3. static final은 상수로 사용된다.
4. 상수는 대문자 + 언더스코어로 작성한다.
5. 참조형에서 final은 주소 변경만 막는다.
6. 객체 내부 값은 변경 가능하다.
