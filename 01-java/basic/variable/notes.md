# Variable (변수)

## 변수란
변수는 데이터를 저장하기 위한 공간이다.  
프로그램에서 값을 저장하고 필요할 때 다시 사용하기 위해 사용한다.

---

## 변수의 특징
- 변수는 반드시 **타입(Type)** 이 필요하다.
- 변수는 선언 후 값을 **초기화**할 수 있다.

예시

int age = 20;
String name = "Tom";

---

## 변수 타입

### 정수형
- byte
- short
- int
- long

실무에서는 대부분 **int** 또는 **long**을 사용한다.  
`byte`는 파일이나 바이너리 데이터를 다룰 때 사용하는 경우가 있다.

---

### 실수형
- float
- double

`float`는 정밀도가 낮기 때문에 실무에서는 대부분 **double**을 사용한다.

---

### 문자
- char

문자 하나를 저장할 때 사용하지만 실무에서는 거의 사용하지 않는다.

---

### 문자열
- String

문자열을 저장할 때 사용하며 **가장 많이 사용하는 타입 중 하나**이다.

예시

String message = "Hello";

---

## 네이밍 규칙 (낙타 표기법)

Java에서는 **Camel Case (낙타 표기법)** 을 사용한다.

### 클래스
- 첫 글자를 **대문자**로 시작

예시

UserService  
OrderController  

---

### 변수 / 메서드
- 첫 글자는 **소문자**
- 단어가 바뀔 때 **대문자 사용**

예시

userName  
orderCount  
calculateTotalPrice()
