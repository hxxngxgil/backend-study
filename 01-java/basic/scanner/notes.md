# Scanner (입력 받기)

## Scanner란
Scanner는 사용자로부터 입력을 받을 때 사용하는 클래스이다.

Java에서는 콘솔에서 값을 입력받기 위해 Scanner 클래스를 사용한다.

---

## Scanner 사용 방법

Scanner를 사용하려면 먼저 import를 해야 한다.

import java.util.Scanner;

Scanner 객체를 생성한다.

Scanner scanner = new Scanner(System.in);

---

## 문자열 입력

nextLine()을 사용하면 문자열 전체를 입력받을 수 있다.

String name = scanner.nextLine();

---

## 숫자 입력

정수 입력

int age = scanner.nextInt();

실수 입력

double score = scanner.nextDouble();

---

## print 와 println

print와 println은 콘솔에 출력할 때 사용하는 메서드이다.

print  
출력 후 줄바꿈을 하지 않는다.

예시

System.out.print("Hello");
System.out.print("Java");

출력 결과

HelloJava

---

println  
출력 후 자동으로 줄바꿈이 된다.

예시

System.out.println("Hello");
System.out.println("Java");

출력 결과

Hello
Java

---

## 줄바꿈 문자 \n

\n 은 줄바꿈을 의미하는 문자이다.

예시

System.out.print("Hello\nJava");

출력 결과

Hello
Java
