# Condition (조건문)

## 조건문이란
조건문은 특정 조건의 true / false 에 따라 실행되는 코드가 달라지도록 하는 문법이다.

---

## if 문
조건이 true일 때만 코드가 실행된다.

예시

int age = 20;

if (age >= 18) {
    System.out.println("성인입니다.");
}

---

## if - else 문
조건의 결과에 따라 서로 다른 코드를 실행한다.

int age = 15;

if (age >= 18) {
    System.out.println("성인");
} else {
    System.out.println("미성년자");
}

---

## else if 문
여러 조건을 순서대로 검사할 때 사용한다.

int score = 85;

if (score >= 90) {
    System.out.println("A");
} else if (score >= 80) {
    System.out.println("B");
} else {
    System.out.println("C");
}

---

## switch 문
여러 값을 비교할 때 사용한다.

int grade = 2;
int coupon;

switch (grade) {
    case 1:
        coupon = 1000;
        break;
    case 2:
        coupon = 2000;
        break;
    default:
        coupon = 500;
}

---

## 삼항 연산자
조건문을 한 줄로 간단하게 표현할 때 사용한다.

형식

조건 ? 참일 때 값 : 거짓일 때 값

예시

int age = 20;

String result = (age >= 18) ? "성인" : "미성년자";
