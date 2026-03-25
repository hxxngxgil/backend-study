# Constructor (생성자)

## 생성자란
생성자는 객체를 생성할 때 호출되는 특별한 메서드이다.  
객체 생성 시 필요한 초기값을 설정하기 위해 사용한다.

---

## 생성자가 필요한 이유
객체를 생성한 후 따로 값을 설정하면 코드가 번거롭고 실수가 발생할 수 있다.  
생성자를 사용하면 객체 생성과 동시에 값을 초기화할 수 있다.

---

## 생성자 도입

예시

class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

사용

Student student = new Student("Tom", 20);

---

## this

this는 현재 객체 자신을 가리키는 키워드이다.  
멤버 변수와 매개변수의 이름이 같을 때 구분하기 위해 사용한다.

예시

this.name = name;

---

## 기본 생성자

매개변수가 없는 생성자를 기본 생성자라고 한다.

예시

Student() {
}

클래스에 생성자를 하나도 정의하지 않으면  
자바가 자동으로 기본 생성자를 만들어준다.

하지만 생성자를 하나라도 직접 만들면  
기본 생성자는 자동 생성되지 않는다.

---

## 생성자 오버로딩

생성자도 메서드처럼 오버로딩이 가능하다.  
즉, 매개변수의 타입이나 개수가 다르면 여러 개 정의할 수 있다.

예시

Student(String name) {
    this.name = name;
}

Student(String name, int age) {
    this.name = name;
    this.age = age;
}

---

## this()

this()는 같은 클래스의 다른 생성자를 호출할 때 사용한다.  
중복 코드를 줄일 수 있으며 생성자의 첫줄에 작성할 수 있다.

예시

Student(String name) {
    this(name, 0);
}

Student(String name, int age) {
    this.name = name;
    this.age = age;
}

---

## 핵심 정리

1. 생성자는 객체 생성 시 자동으로 호출된다.
2. 생성자를 사용하면 객체 초기화를 쉽게 할 수 있다.
3. this는 현재 객체를 가리킨다.
4. 기본 생성자는 자동 생성될 수 있다.
5. 생성자는 오버로딩이 가능하다.
6. this()를 사용하면 생성자 간 중복을 줄일 수 있다.
