# Object Class (Object 클래스)

## java.lang 패키지

java.lang 패키지는 자바에서 기본적으로 제공되는 패키지이다.  
자동으로 import 되기 때문에 따로 import 하지 않아도 사용할 수 있다.

대표 클래스
- Object
- String
- Integer
- Math 등

---

## Object 클래스

Object 클래스는 모든 클래스의 최상위 부모 클래스이다.

자바의 모든 클래스는 Object를 상속받는다.

---

## Object 다형성

모든 객체는 Object 타입으로 다룰 수 있다.

예시

Object obj = new Dog();

→ 어떤 객체든 Object로 참조 가능

---

## Object 배열

Object 타입 배열을 사용하면 다양한 객체를 하나의 배열에 담을 수 있다.

예시

Object[] arr = new Object[3];

arr[0] = new Dog();
arr[1] = new Cat();

---

## toString()

객체를 문자열로 표현할 때 사용하는 메서드이다.

기본적으로는 클래스 이름 + 해시값이 출력된다.

예시

System.out.println(obj.toString());

---

## toString() 오버라이딩

객체의 정보를 보기 좋게 출력하기 위해 재정의할 수 있다.

예시

@Override
public String toString() {
    return "name=" + name + ", age=" + age;
}

---

## equals()

두 객체의 동등성을 비교할 때 사용하는 메서드이다.

기본 equals()는 참조값(주소)을 비교한다.

---

## 동일성 vs 동등성

- 동일성 (==) → 같은 객체인지 비교 (주소값)
- 동등성 (equals) → 값이 같은지 비교

---

## equals() 오버라이딩

객체의 값을 기준으로 비교하려면 equals()를 재정의해야 한다.

예시

@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof Student)) return false;

    Student s = (Student) obj;
    return this.name.equals(s.name) && this.age == s.age;
}

---

## Object와 OCP

Object를 사용하면 다양한 객체를 하나의 타입으로 처리할 수 있어  
확장에는 유리하다.

하지만
- 구체적인 타입을 알기 어렵고
- 캐스팅이 필요해질 수 있다.

→ OCP를 완벽히 만족하기는 어렵다.

---

## 핵심 정리

1. Object는 모든 클래스의 최상위 부모이다.
2. 모든 객체는 Object로 다룰 수 있다.
3. toString()은 객체 정보를 문자열로 표현한다.
4. equals()는 객체의 동등성을 비교한다.
5. 기본 equals()는 주소를 비교한다.
6. 값 비교를 위해 equals()를 오버라이딩해야 한다.
7. Object는 유연하지만 타입 안정성은 떨어질 수 있다.
