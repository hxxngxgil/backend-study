# Generic (제네릭)

## 제네릭이 필요한 이유

제네릭(Generic)은 타입을 일반화하여 다양한 타입을 안전하게 사용할 수 있도록 하는 기능이다.

제네릭을 사용하면

- 중복 코드 감소
- 타입 안정성 향상
- 캐스팅 제거

가 가능하다.

---

## 다형성을 통한 중복 해결 시도

Object를 사용하면 여러 타입을 하나로 처리할 수 있다.

예시

Object data;

하지만

- 사용할 때 캐스팅이 필요
- 잘못된 타입이 들어갈 수 있음
- 컴파일 시 타입 오류를 확인할 수 없음

이라는 문제가 있다.

---

## 제네릭 적용

제네릭은 타입을 미리 지정하지 않고 사용할 수 있다.

예시

class Box<T> {

    private T value;

}

사용

Box<String> box = new Box<>();

---

# 제네릭 용어

## 제네릭(Generic)

타입을 일반화하여 사용하는 기능

---

## 제네릭 타입(Generic Type)

타입 매개변수를 사용하는 클래스 또는 인터페이스

예시

class Box<T>

---

## 타입 매개변수(Type Parameter)

실제 타입이 결정되기 전 사용하는 타입 변수

예시

<T>

<E>

<K>

<V>

---

## 타입 인자(Type Argument)

제네릭 사용 시 실제 전달하는 타입

예시

Box<String>

여기서

String

이 타입 인자이다.

---

## 제네릭 관례

자주 사용하는 타입 매개변수

T → Type

E → Element

K → Key

V → Value

R → Return

N → Number

---

## 제네릭 활용 예제

예시

class Box<T> {

    private T value;

    public void set(T value){
        this.value = value;
    }

    public T get(){
        return value;
    }

}

---

# 타입 매개변수 제한

타입 매개변수는 extends를 사용하여 제한할 수 있다.

예시

class Box<T extends Number>

→ Number와 그 자식만 사용 가능

---

## 타입 매개변수 제한이 필요한 이유

모든 타입을 허용하면

Number의 메서드를 사용할 수 없다.

제한을 걸면

Number가 가진 기능을 사용할 수 있다.

---

## 다형성 시도와 제네릭

Object를 사용하는 것보다

제네릭을 사용하면

- 타입 안정성
- 캐스팅 제거

라는 장점이 있다.

---

# 제네릭 메서드

메서드 자체에 타입 매개변수를 선언하는 방식이다.

예시

public static <T> T identity(T value){

    return value;

}

---

## 제네릭 메서드 특징

- 클래스와 별개로 타입 선언
- 호출 시 타입 결정

---

# 제네릭 메서드 활용

예시

String s = identity("Java");

Integer n = identity(10);

---

# 와일드카드 (Wildcard)

와일드카드는

이미 만들어진 제네릭 타입을 사용할 때

타입 범위를 유연하게 지정하는 기능이다.

※ 와일드카드는 제네릭 타입이나 제네릭 메서드를 선언하는 것이 아니다.

---

## ?

모든 타입 허용

예시

List<?>

---

## 상한 제한

? extends Number

Number와 자식 클래스 허용

예시

List<? extends Number>

---

## 하한 제한

? super Integer

Integer와 부모 클래스 허용

예시

List<? super Integer>

---

# 제네릭과 와일드카드 차이

제네릭

→ 타입을 선언할 때 사용

예시

class Box<T>

---

와일드카드

→ 이미 존재하는 제네릭을 사용할 때 사용

예시

void print(List<?> list)

---

# 타입 이레이저 (Type Erasure)

제네릭은 컴파일 시점에만 존재한다.

컴파일 후에는 타입 정보가 제거된다.

예시

List<String>

↓

List

---

## 타입 이레이저 특징

- 런타임에는 타입 정보가 없음
- 컴파일 시 타입 검사 수행
- 이전 버전과 호환성을 위해 사용

---

# 핵심 정리

1. 제네릭은 타입을 일반화하는 기능이다.
2. Object보다 타입 안정성이 높다.
3. 제네릭 타입은 타입 매개변수를 사용하는 클래스이다.
4. 타입 매개변수는 T, E, K, V 등을 사용한다.
5. 타입 인자는 실제 전달하는 타입(String, Integer 등)이다.
6. extends를 사용하면 타입을 제한할 수 있다.
7. 제네릭 메서드는 메서드 자체에 타입을 선언한다.
8. 와일드카드는 이미 만들어진 제네릭을 사용할 때 사용한다.
9. 와일드카드는 제네릭을 선언하는 문법이 아니다.
10. 타입 이레이저로 인해 런타임에는 제네릭 타입 정보가 제거된다.
