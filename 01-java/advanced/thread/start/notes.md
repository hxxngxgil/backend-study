# Thread Basic (프로세스와 스레드)

## 멀티태스킹

멀티태스킹은 여러 작업을 동시에 처리하는 것처럼 실행하는 것을 말한다.

예시

- 음악 재생
- 웹 브라우저 실행
- 문서 작성

---

## 멀티프로세싱

멀티프로세싱은 여러 프로세스를 동시에 실행하는 것을 말한다.

각 프로세스는 독립된 메모리 공간을 가진다.

---

## 프로세스

프로세스는 실행 중인 프로그램이다.

특징

- 독립된 메모리 공간 사용
- 다른 프로세스와 기본적으로 메모리를 공유하지 않음

---

## 스레드

스레드는 프로세스 안에서 실행되는 작업 단위이다.

하나의 프로세스 안에는 여러 스레드가 존재할 수 있다.

특징

- 같은 프로세스의 메모리를 공유
- 동시에 여러 작업 처리 가능

---

## 스레드와 스케줄링

CPU는 여러 스레드를 번갈아가며 실행한다.

어떤 스레드를 언제 실행할지는 스케줄러가 결정한다.

---

## 컨텍스트 스위칭

컨텍스트 스위칭은 실행 중인 스레드를 멈추고 다른 스레드로 전환하는 작업이다.

특징

- 여러 스레드가 동시에 실행되는 것처럼 보이게 함
- 전환 비용이 발생함

---

# Thread 생성과 실행

## Thread로 스레드 생성

Thread 클래스를 상속받아 스레드를 만들 수 있다.

예시

class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("스레드 실행");
    }

}

MyThread thread = new MyThread();
thread.start();

---

## start()와 run() 차이

### start()

새로운 스레드를 생성하고 run() 메서드를 실행한다.

반드시 start()로 실행해야 새로운 스레드에서 동작한다.

---

### run()

그냥 일반 메서드 호출이다.

새로운 스레드가 생성되지 않고 현재 스레드에서 실행된다.

주의

스레드를 실행할 때 run()을 직접 호출하면 안 된다.

---

## 데몬 스레드

데몬 스레드는 보조 작업을 수행하는 스레드이다.

특징

- 일반 스레드가 모두 종료되면 데몬 스레드도 함께 종료된다.
- 백그라운드 작업에 사용된다.

예시

thread.setDaemon(true);

---

# Runnable로 스레드 생성

Runnable 인터페이스를 구현해서 스레드를 만들 수 있다.

예시

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Runnable 실행");
    }

}

Thread thread = new Thread(new MyRunnable());
thread.start();

---

## Runnable 사용 이유

실무에서는 Thread를 직접 상속받는 것보다 Runnable을 더 많이 사용한다.

이유

- 자바는 단일 상속만 가능하다.
- Thread를 상속하면 다른 클래스를 상속할 수 없다.
- Runnable은 인터페이스이므로 더 유연하다.
- 작업과 실행 대상을 분리할 수 있다.

---

## 로거 만들기

스레드 이름과 실행 시간을 함께 출력하면  
여러 스레드가 어떻게 실행되는지 확인하기 쉽다.

예시

System.out.println(Thread.currentThread().getName());

---

## 여러 스레드 만들기

Thread 객체를 여러 개 생성하면  
여러 스레드를 동시에 실행할 수 있다.

예시

Thread thread1 = new Thread(new MyRunnable());
Thread thread2 = new Thread(new MyRunnable());

thread1.start();
thread2.start();

---

# Runnable을 만드는 다양한 방법

## 정적 중첩 클래스 사용

class Outer {

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("정적 중첩 클래스 실행");
        }

    }

}

---

## 익명 클래스 사용

Runnable runnable = new Runnable() {

    @Override
    public void run() {
        System.out.println("익명 클래스 실행");
    }

};

Thread thread = new Thread(runnable);
thread.start();

---

## 람다 사용

Runnable은 함수형 인터페이스이므로 람다로 간단하게 작성할 수 있다.

예시

Runnable runnable = () -> System.out.println("람다 실행");

Thread thread = new Thread(runnable);
thread.start();

람다는 이후에 더 자세히 학습한다.

---

# Thread vs Runnable

## Thread 상속 방식

장점

- 간단하게 구현 가능

단점

- 다른 클래스를 상속할 수 없음
- 작업과 스레드 실행이 강하게 결합됨
- 유연성이 떨어짐

---

## Runnable 구현 방식

장점

- 인터페이스 기반이라 유연함
- 다른 클래스 상속 가능
- 작업과 실행을 분리 가능
- 실무에서 더 권장됨

---

# 핵심 정리

1. 프로세스는 실행 중인 프로그램이다.
2. 스레드는 프로세스 안에서 실행되는 작업 단위이다.
3. 하나의 프로세스는 여러 스레드를 가질 수 있다.
4. 스케줄러가 스레드 실행 순서를 결정한다.
5. 컨텍스트 스위칭은 실행 스레드를 전환하는 작업이다.
6. 스레드는 run()이 아니라 start()로 실행해야 한다.
7. run() 직접 호출은 일반 메서드 호출일 뿐이다.
8. 데몬 스레드는 일반 스레드가 끝나면 함께 종료된다.
9. 실무에서는 Thread 상속보다 Runnable 구현 방식을 더 권장한다.
10. Runnable은 정적 중첩 클래스, 익명 클래스, 람다로 만들 수 있다.
