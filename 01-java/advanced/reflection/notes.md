# Reflection

## 리플렉션이란

리플렉션(Reflection)은 실행 중인 클래스의 정보를 조회하고  
메서드, 필드, 생성자 등을 동적으로 다룰 수 있는 기능이다.

일반적인 자바 코드는 컴파일 시점에 호출 대상이 정해진다.

하지만 리플렉션을 사용하면  
런타임에 클래스 정보를 확인하고 메서드를 호출하거나 필드 값을 변경할 수 있다.

---

## 리플렉션이 필요한 이유

일반적인 코드에서는 특정 클래스의 메서드나 필드를 직접 호출한다.

예시

Member member = new Member();

member.getName();

이 방식은 컴파일 시점에 호출 대상이 명확하다.

하지만 여러 클래스를 공통으로 다뤄야 하는 경우  
각 클래스마다 코드를 따로 작성해야 해서 중복이 많아질 수 있다.

리플렉션을 사용하면  
클래스의 구조를 런타임에 분석해서 공통 처리 로직을 만들 수 있다.

---

## 리플렉션을 사용하는 대표적인 경우

- 프레임워크
- 라이브러리
- 테스트 도구
- 객체 매핑
- DI 컨테이너
- 애노테이션 기반 기능
- 공통 유틸리티

예시

- 스프링이 객체를 생성하고 의존관계를 주입할 때
- JPA가 엔티티 객체의 필드 값을 읽고 쓸 때
- 테스트 프레임워크가 테스트 메서드를 찾아 실행할 때

---

# 클래스와 메타데이터

## 메타데이터

메타데이터는 클래스에 대한 정보이다.

예시

- 클래스 이름
- 패키지 이름
- 부모 클래스
- 인터페이스
- 필드
- 메서드
- 생성자

---

## Class 객체

자바는 클래스의 정보를 Class 객체로 관리한다.

Class 객체를 통해 클래스의 메타데이터를 조회할 수 있다.

---

## Class 객체를 얻는 방법

방법 1

Class clazz = String.class;

방법 2

String str = "hello";

Class clazz = str.getClass();

방법 3

Class clazz = Class.forName("java.lang.String");

---

## Class 객체로 확인할 수 있는 정보

clazz.getName();

clazz.getSimpleName();

clazz.getPackageName();

clazz.getSuperclass();

clazz.getInterfaces();

---

# 메서드 탐색

리플렉션을 사용하면 클래스의 메서드 정보를 조회할 수 있다.

---

## getMethods()

getMethods()는 public 메서드를 조회한다.

특징

- public 메서드만 조회한다.
- 상속받은 public 메서드도 포함한다.
- Object에서 상속받은 메서드도 포함될 수 있다.

예시

Method[] methods = clazz.getMethods();

---

## getDeclaredMethods()

getDeclaredMethods()는 해당 클래스에 선언된 메서드를 조회한다.

특징

- 현재 클래스에 선언된 메서드만 조회한다.
- public, protected, default, private 메서드를 모두 조회한다.
- 상속받은 메서드는 포함하지 않는다.

예시

Method[] methods = clazz.getDeclaredMethods();

---

## getMethods()와 getDeclaredMethods() 차이

| 메서드 | 조회 범위 | 접근 제어자 | 상속 포함 |
|--------|-----------|-------------|-----------|
| getMethods() | public 메서드 | public만 | 포함 |
| getDeclaredMethods() | 현재 클래스에 선언된 메서드 | 모든 접근 제어자 | 포함하지 않음 |

---

# 메서드 동적 호출

리플렉션을 사용하면 메서드를 런타임에 동적으로 호출할 수 있다.

예시

Method method = clazz.getMethod("hello");

method.invoke(object);

---

## 파라미터가 있는 메서드 호출

Method method = clazz.getMethod("hello", String.class);

method.invoke(object, "java");

---

## 동적 호출의 의미

일반적인 메서드 호출

object.hello();

리플렉션을 사용한 메서드 호출

method.invoke(object);

리플렉션은 메서드 이름을 문자열로 찾고  
런타임에 호출한다.

---

# 필드 탐색

리플렉션을 사용하면 클래스의 필드 정보를 조회할 수 있다.

---

## getFields()

getFields()는 public 필드를 조회한다.

특징

- public 필드만 조회한다.
- 상속받은 public 필드도 포함한다.

예시

Field[] fields = clazz.getFields();

---

## getDeclaredFields()

getDeclaredFields()는 해당 클래스에 선언된 필드를 조회한다.

특징

- 현재 클래스에 선언된 필드만 조회한다.
- public, protected, default, private 필드를 모두 조회한다.
- 상속받은 필드는 포함하지 않는다.

예시

Field[] fields = clazz.getDeclaredFields();

---

## getFields()와 getDeclaredFields() 차이

| 메서드 | 조회 범위 | 접근 제어자 | 상속 포함 |
|--------|-----------|-------------|-----------|
| getFields() | public 필드 | public만 | 포함 |
| getDeclaredFields() | 현재 클래스에 선언된 필드 | 모든 접근 제어자 | 포함하지 않음 |

---

# 필드 값 읽기

리플렉션을 사용하면 객체의 필드 값을 읽을 수 있다.

예시

Field field = clazz.getDeclaredField("name");

field.setAccessible(true);

Object value = field.get(object);

---

## setAccessible(true)

private 필드나 메서드에 접근하려면 setAccessible(true)를 사용할 수 있다.

예시

field.setAccessible(true);

주의

캡슐화를 깨는 기능이므로 신중하게 사용해야 한다.

---

# 필드 값 변경

리플렉션을 사용하면 객체의 필드 값을 변경할 수도 있다.

예시

Field field = clazz.getDeclaredField("name");

field.setAccessible(true);

field.set(object, "newName");

---

## 필드 값 변경 주의점

private 필드는 외부에서 직접 수정하지 못하도록 숨겨둔 값이다.

리플렉션으로 private 필드 값을 변경하면  
객체의 캡슐화가 깨질 수 있다.

따라서 일반적인 비즈니스 로직에서는 권장하지 않는다.

---

# 생성자 탐색

리플렉션을 사용하면 생성자 정보도 조회할 수 있다.

---

## getConstructors()

getConstructors()는 public 생성자를 조회한다.

특징

- public 생성자만 조회한다.

예시

Constructor[] constructors = clazz.getConstructors();

---

## getDeclaredConstructors()

getDeclaredConstructors()는 해당 클래스에 선언된 모든 생성자를 조회한다.

특징

- public, protected, default, private 생성자를 모두 조회한다.

예시

Constructor[] constructors = clazz.getDeclaredConstructors();

---

## getConstructor()

특정 public 생성자를 조회한다.

예시

Constructor constructor = clazz.getConstructor(String.class);

---

## getDeclaredConstructor()

특정 생성자를 접근 제어자와 관계없이 조회한다.

예시

Constructor constructor = clazz.getDeclaredConstructor(String.class);

---

# 객체 생성

리플렉션을 사용하면 생성자를 통해 객체를 동적으로 생성할 수 있다.

예시

Constructor constructor = clazz.getDeclaredConstructor();

Object object = constructor.newInstance();

---

## 파라미터가 있는 생성자로 객체 생성

Constructor constructor = clazz.getDeclaredConstructor(String.class, int.class);

Object object = constructor.newInstance("memberA", 20);

---

# 리플렉션 활용 예제

리플렉션을 사용하면 여러 클래스에 공통으로 적용되는 기능을 만들 수 있다.

예시

- 객체의 모든 필드 출력
- 객체의 필드 값을 Map으로 변환
- 특정 애노테이션이 붙은 메서드 실행
- 공통 검증 로직
- 객체 생성 자동화

---

## 객체 필드 출력 예시

Field[] fields = clazz.getDeclaredFields();

for (Field field : fields) {
    field.setAccessible(true);
    Object value = field.get(object);
    System.out.println(field.getName() + " = " + value);
}

---

## 리플렉션이 프레임워크에서 중요한 이유

프레임워크는 사용자가 만든 클래스를 미리 알 수 없다.

하지만 실행 중에 클래스 정보를 분석해야 한다.

예시

스프링은 사용자가 만든 클래스를 보고

- 객체를 생성하고
- 필요한 의존관계를 주입하고
- 애노테이션을 분석하고
- 메서드를 실행한다.

이런 기능을 만들 때 리플렉션이 사용될 수 있다.

---

# 리플렉션 사용 주의점

리플렉션은 강력하지만 일반적으로 남용하면 안 된다.

---

## 1. 컴파일 타임 안정성이 떨어진다

일반 메서드 호출은 컴파일 시점에 오류를 잡을 수 있다.

예시

member.getName();

하지만 리플렉션은 문자열로 메서드나 필드를 찾는다.

예시

clazz.getDeclaredField("name");

필드명이나 메서드명이 틀려도 컴파일 단계에서는 알 수 없고  
실행 중에 예외가 발생할 수 있다.

---

## 2. 코드 이해가 어려워진다

일반 코드는 어떤 메서드가 호출되는지 바로 알 수 있다.

하지만 리플렉션은 런타임에 호출 대상이 결정된다.

따라서 코드를 읽는 사람이 흐름을 이해하기 어려울 수 있다.

---

## 3. 캡슐화를 깨뜨릴 수 있다

setAccessible(true)를 사용하면 private 필드나 메서드에도 접근할 수 있다.

이는 객체가 숨기려고 한 내부 구현을 외부에서 건드리는 것이다.

객체의 무결성이 깨질 수 있다.

---

## 4. 성능이 일반 호출보다 느릴 수 있다

리플렉션은 메서드나 필드를 동적으로 탐색하고 호출한다.

일반적인 메서드 호출보다 추가 비용이 발생할 수 있다.

---

## 5. 유지보수가 어려워질 수 있다

필드명이나 메서드명을 문자열로 사용하면  
리팩토링할 때 자동 변경이 어렵다.

예시

"name"

이런 문자열은 IDE가 안전하게 추적하지 못할 수 있다.

---

# 리플렉션은 언제 사용해야 할까?

리플렉션은 일반적인 비즈니스 로직에 사용하는 것이 아니라  
여러 클래스를 공통으로 처리해야 할 때 사용하는 것이 좋다.

사용하기 좋은 경우

- 프레임워크 개발
- 공통 유틸리티 작성
- 애노테이션 기반 처리
- 객체 매핑
- 테스트 도구
- 반복되는 공통 처리 제거

---

# 비즈니스 로직에서 리플렉션을 권장하지 않는 이유

비즈니스 로직은 명확하고 안정적이어야 한다.

예시

회원 가입

주문 생성

결제 처리

재고 차감

이런 코드는 코드 흐름이 명확해야 하고  
컴파일 시점에 오류를 최대한 잡을 수 있어야 한다.

리플렉션을 사용하면

- 어떤 메서드가 호출되는지 파악하기 어렵고
- 컴파일 시점에 오류를 잡기 어렵고
- 캡슐화가 깨질 수 있고
- 리팩토링에 약하고
- 유지보수가 어려워질 수 있다.

따라서 비즈니스 로직에서는 리플렉션을 직접 사용하는 것을 권장하지 않는다.

---

# 핵심 정리

1. 리플렉션은 런타임에 클래스 정보를 조회하고 조작하는 기능이다.
2. Class 객체를 통해 클래스의 메타데이터를 확인할 수 있다.
3. getMethods()는 public 메서드와 상속받은 public 메서드를 조회한다.
4. getDeclaredMethods()는 현재 클래스에 선언된 모든 메서드를 조회한다.
5. getFields()는 public 필드와 상속받은 public 필드를 조회한다.
6. getDeclaredFields()는 현재 클래스에 선언된 모든 필드를 조회한다.
7. Method.invoke()로 메서드를 동적으로 호출할 수 있다.
8. Field.get(), Field.set()으로 필드 값을 읽거나 변경할 수 있다.
9. Constructor.newInstance()로 객체를 동적으로 생성할 수 있다.
10. setAccessible(true)는 private 멤버에 접근할 수 있지만 캡슐화를 깨뜨릴 수 있다.
11. 리플렉션은 프레임워크나 공통 처리 기능을 만들 때 유용하다.
12. 일반적인 비즈니스 로직에서는 리플렉션 사용을 권장하지 않는다.
13. 리플렉션은 강력하지만 컴파일 안정성, 가독성, 성능, 유지보수 측면에서 주의가 필요하다.
