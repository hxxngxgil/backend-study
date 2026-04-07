# Inheritance (상속)

## 상속이란
상속은 기존 클래스의 필드와 메서드를 자식 클래스가 물려받아 사용하는 기능이다.  
코드 재사용과 확장을 위해 사용한다.

---

## 상속 관계

상속은 부모 클래스와 자식 클래스의 관계로 이루어진다.

- 부모 클래스 (super class)
- 자식 클래스 (sub class)

예시

class Animal {
    void move() {
        System.out.println("이동한다");
    }
}

class Dog extends Animal {
}

---

## 상속과 기능 추가

자식 클래스는 부모의 기능을 그대로 사용하면서  
자신만의 기능을 추가할 수 있다.

예시

class Dog extends Animal {
    void bark() {
        System.out.println("멍멍");
    }
}

---

## 상속과 메모리 구조

객체를 생성하면 자식 객체 안에 부모 클래스도 함께 생성된다.

예시

Dog dog = new Dog();

→ Dog 객체 생성  
→ 내부에 Animal 객체도 함께 생성됨

---

## 상속과 메서드 오버라이딩

부모 클래스의 메서드를 자식 클래스에서 재정의할 수 있다.

예시

class Animal {
    void move() {
        System.out.println("이동한다");
    }
}

class Dog extends Animal {
    @Override
    void move() {
        System.out.println("강아지가 이동한다");
    }
}

---

## 상속과 접근 제어

자식 클래스는 부모 클래스의 접근 가능한 멤버만 사용할 수 있다.

- private → 접근 불가
- default → 같은 패키지만 가능
- protected → 상속 관계에서 접근 가능
- public → 모두 가능

---

## super (부모 참조)

super는 부모 클래스를 가리키는 키워드이다.

예시

super.move();

→ 부모 클래스의 메서드 호출

---

## super() (부모 생성자 호출)

자식 클래스에서 부모 생성자를 호출할 때 사용한다.

예시

class Animal {
    Animal(String name) {
    }
}

class Dog extends Animal {
    Dog() {
        super("dog");
    }
}

---

## 단일 상속

자바는 다중 상속을 지원하지 않는다.  
하나의 클래스만 상속할 수 있다.

예시

class Dog extends Animal  // 가능
class Dog extends Animal, Pet  // 불가능

---

## 핵심 정리

1. 상속은 부모의 기능을 자식이 물려받는 것이다.
2. extends 키워드를 사용한다.
3. 자식은 부모 기능을 사용하고 추가 기능을 만들 수 있다.
4. 메서드는 오버라이딩으로 재정의할 수 있다.
5. super는 부모를 참조한다.
6. 자바는 단일 상속만 지원한다.
