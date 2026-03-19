# Class & Object (클래스와 객체)

## 클래스가 필요한 이유
여러 개의 변수를 각각 관리하면 코드가 복잡해지고 관리하기 어려워진다.  
관련된 데이터를 하나로 묶기 위해 클래스를 사용한다.

---

## 클래스 도입

예시 (기존 방식)

int student1Age = 20;
String student1Name = "Tom";

→ 변수들이 따로 관리됨

클래스 사용

class Student {
    String name;
    int age;
}

→ 데이터를 하나로 묶어서 관리 가능

---

## 객체 사용

클래스를 기반으로 실제 데이터를 생성하여 사용한다.

예시

Student student1 = new Student();

student1.name = "Tom";
student1.age = 20;

---

## 클래스 / 객체 / 인스턴스

### 클래스
객체를 만들기 위한 설계도

### 객체
클래스를 기반으로 생성된 실제 데이터

### 인스턴스
객체를 관계 중심으로 표현한 용어

👉 실무에서는 객체와 인스턴스를 거의 같은 의미로 사용한다.

---

## 붕어빵 예시

클래스 → 붕어빵 틀  
객체 → 만들어진 붕어빵  

---

## 객체 생성 (new)

new 키워드를 사용하면 객체가 생성된다.

예시

Student student = new Student();

---

## 중요한 개념 (참조값)

student 변수에는 객체 자체가 아니라  
객체의 위치를 가리키는 **참조값**이 저장된다.

즉

Student student = new Student();

→ student는 객체의 주소(참조값)를 가지고 있다.

---

## 클래스 배열

클래스도 배열로 사용할 수 있다.

예시

Student[] students = new Student[3];

students[0] = new Student();
students[1] = new Student();

→ 여러 객체를 배열로 관리 가능
