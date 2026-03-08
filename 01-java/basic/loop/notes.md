# Loop (반복문)

## 반복문이란
반복문은 특정 코드를 여러 번 반복해서 실행할 때 사용하는 문법이다.

---

## while 문
조건이 true인 동안 계속 반복 실행된다.

예시

int i = 1;

while (i <= 5) {
    System.out.println(i);
    i++;
}

---

## do-while 문
코드를 먼저 실행한 후 조건을 검사한다.  
따라서 최소 한 번은 실행된다.

예시

int i = 1;

do {
    System.out.println(i);
    i++;
} while (i <= 5);

---

## for 문
반복 횟수가 정해져 있을 때 많이 사용하는 반복문이다.

구조

for (초기값; 조건; 증감식)

예시

for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}

---

## break
반복문을 즉시 종료한다.

예시

for (int i = 1; i <= 10; i++) {

    if (i == 5) {
        break;
    }

    System.out.println(i);
}

---

## continue
현재 반복을 건너뛰고 다음 반복을 실행한다.

예시

for (int i = 1; i <= 5; i++) {

    if (i == 3) {
        continue;
    }

    System.out.println(i);
}

---

## 중첩 for 문
for문 안에 또 다른 for문이 들어가는 구조이다.

예시

for (int i = 1; i <= 3; i++) {

    for (int j = 1; j <= 3; j++) {
        System.out.println(i + " , " + j);
    }

}
