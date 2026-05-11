# String Class (String 클래스)

## String 클래스란

String은 문자열을 다루기 위한 클래스이다.

자바에서 문자열은 매우 자주 사용되기 때문에  
특별하게 지원되는 클래스이다.

예시

String str = "hello";

---

## String 클래스 특징

- 문자열을 저장하는 클래스
- 참조형 객체
- 불변 객체(Immutable)

---

## String 비교

### == 비교

== 는 참조값(주소)을 비교한다.

예시

String a = new String("hello");
String b = new String("hello");

System.out.println(a == b);

→ false

---

### equals() 비교

equals()는 문자열 값을 비교한다.

예시

System.out.println(a.equals(b));

→ true

---

## String 클래스와 불변 객체

String은 불변 객체이다.

즉, 문자열 변경이 발생하면  
기존 문자열을 수정하는 것이 아니라 새로운 객체를 생성한다.

예시

String str = "hello";
str = str + " world";

→ 새로운 String 객체 생성

---

## String 주요 메서드

### length()
문자열 길이 반환

예시

str.length()

---

### charAt()
특정 위치 문자 반환

예시

str.charAt(0)

---

### substring()
문자열 자르기

예시

str.substring(0, 3)

---

### indexOf()
특정 문자열 위치 반환

예시

str.indexOf("h")

---

### contains()
특정 문자열 포함 여부 확인

예시

str.contains("hello")

---

### equals()
문자열 값 비교

예시

str.equals("hello")

---

### replace()
문자열 변경

예시

str.replace("hello", "java")

---

### split()
문자열 분리

예시

str.split(",")

---

### trim()
앞뒤 공백 제거

예시

str.trim()

---

## StringBuilder

StringBuilder는 변경 가능한 문자열 객체이다.

문자열을 자주 변경할 때 사용한다.

---

## StringBuilder 사용하는 이유

String은 문자열 변경 시마다 새로운 객체를 생성한다.

→ 메모리 낭비 발생 가능

StringBuilder는 기존 객체를 변경하기 때문에 효율적이다.

---

## StringBuilder 예시

StringBuilder sb = new StringBuilder();

sb.append("hello");
sb.append(" world");

System.out.println(sb);

---

## String 최적화

자바는 문자열 리터럴을 String Pool에서 관리한다.

예시

String a = "hello";
String b = "hello";

→ 같은 문자열은 공유된다.

---

## 메서드 체이닝 (Method Chaining)

메서드 호출 결과로 자기 자신을 반환하여  
연속적으로 메서드를 호출하는 방식이다.

예시

StringBuilder sb = new StringBuilder();

sb.append("A")
  .append("B")
  .append("C");

---

## 핵심 정리

1. String은 문자열을 다루는 클래스이다.
2. String은 불변 객체이다.
3. 문자열 비교는 equals()를 사용한다.
4. String은 변경 시 새로운 객체가 생성된다.
5. 문자열 변경이 많으면 StringBuilder를 사용한다.
6. StringBuilder는 가변 객체이다.
7. 메서드 체이닝으로 연속 호출이 가능하다.
