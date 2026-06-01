# Enum (열거형)

## 문자열과 타입 안정성

상수를 문자열로 관리하면 오타가 발생할 수 있다.

예시

String grade = "GOLD";
String grade2 = "GLOD";

→ 컴파일 오류가 발생하지 않는다.
→ 실행 시에만 문제를 발견할 수 있다.

---

## 타입 안전 열거형 패턴

문자열 대신 객체를 사용하여 타입 안정성을 높이는 방식이다.

예시

public class Grade {
    public static final Grade BASIC = new Grade();
    public static final Grade GOLD = new Grade();
    public static final Grade DIAMOND = new Grade();
}

장점
- 타입 안정성 보장
- 오타 방지

단점
- 코드가 복잡함
- 사용이 불편함

---

## Enum Type

자바는 타입 안전 열거형 패턴을 쉽게 사용하도록 Enum을 제공한다.

예시

public enum Grade {
    BASIC,
    GOLD,
    DIAMOND
}

사용

Grade grade = Grade.GOLD;

---

## Enum 특징

- 타입 안정성 제공
- 오타 방지
- 코드 가독성 향상
- 허용된 값만 사용 가능

---

## 주요 메서드

### values()

모든 Enum 상수를 배열로 반환한다.

예시

Grade[] values = Grade.values();

---

### valueOf()

문자열과 일치하는 Enum 상수를 반환한다.

예시

Grade grade = Grade.valueOf("GOLD");

---

### name()

Enum 상수 이름 반환

예시

grade.name();

결과

GOLD

---

### ordinal()

Enum 선언 순서 반환

예시

grade.ordinal();

결과

0, 1, 2 ...

※ 실무에서는 순서가 변경될 수 있으므로 사용을 권장하지 않는다.

---

## Enum 리팩토링

문자열 상수를 사용하던 코드를 Enum으로 변경할 수 있다.

변경 전

String grade = "GOLD";

---

변경 후

Grade grade = Grade.GOLD;

장점
- 컴파일 시 오류 확인 가능
- 오타 방지
- 유지보수 향상

---

## Enum 활용

예시

public enum Grade {
    BASIC(10),
    GOLD(20),
    DIAMOND(30);

    private final int discountPercent;

    Grade(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }
}

→ Enum도 생성자, 필드, 메서드를 가질 수 있다.

---

## 핵심 정리

1. 문자열 상수는 오타를 컴파일 시점에 발견할 수 없다.
2. Enum은 타입 안정성을 제공한다.
3. Enum은 허용된 값만 사용할 수 있다.
4. values(), valueOf(), name()은 자주 사용하는 메서드이다.
5. ordinal()은 실무에서 사용을 권장하지 않는다.
6. Enum은 생성자, 필드, 메서드를 가질 수 있다.
7. 문자열 상수보다 Enum 사용이 권장된다.
