# I/O Basic (입출력 기본)

## 스트림이란

스트림(Stream)은 데이터를 순서대로 읽거나 쓰기 위한 흐름이다.

자바에서 파일, 네트워크, 메모리 등에 데이터를 입출력할 때 스트림을 사용한다.

---

## 스트림의 특징

- 데이터를 순서대로 처리한다.
- 입력 스트림과 출력 스트림으로 나뉜다.
- 바이트 단위 또는 문자 단위로 데이터를 처리할 수 있다.

---

## InputStream

InputStream은 데이터를 읽기 위한 입력 스트림이다.

주로 파일, 네트워크, 메모리 등에서 데이터를 읽을 때 사용한다.

예시

InputStream inputStream = new FileInputStream("test.txt");

int data = inputStream.read();

inputStream.close();

---

## OutputStream

OutputStream은 데이터를 쓰기 위한 출력 스트림이다.

파일, 네트워크, 메모리 등에 데이터를 저장하거나 전송할 때 사용한다.

예시

OutputStream outputStream = new FileOutputStream("test.txt");

outputStream.write(65);

outputStream.close();

---

## InputStream과 OutputStream 정리

InputStream

- 데이터 읽기
- read() 사용

OutputStream

- 데이터 쓰기
- write() 사용

---

# 파일 입출력과 성능 최적화

파일 입출력은 디스크에 접근하는 작업이기 때문에 비용이 크다.

따라서 데이터를 어떻게 읽고 쓰느냐에 따라 성능 차이가 크게 발생할 수 있다.

---

## 하나씩 쓰기

데이터를 1바이트씩 쓰는 방식이다.

예시

for (int i = 0; i < data.length; i++) {
    outputStream.write(data[i]);
}

---

## 하나씩 쓰기의 문제점

1바이트마다 write()를 호출하기 때문에 성능이 매우 느릴 수 있다.

이유

- 디스크 접근 횟수 증가
- 메서드 호출 횟수 증가
- 입출력 비용 증가

---

## 버퍼 활용

버퍼(Buffer)는 데이터를 임시로 모아두는 공간이다.

데이터를 하나씩 바로 쓰지 않고  
일정 크기만큼 모아서 한 번에 처리하면 성능을 개선할 수 있다.

---

## 버퍼를 사용하는 이유

- 입출력 횟수 감소
- 디스크 접근 비용 감소
- 성능 향상

---

## Buffered 스트림 쓰기

BufferedOutputStream은 내부 버퍼를 사용해서 출력 성능을 높인다.

예시

OutputStream outputStream = new FileOutputStream("test.txt");
BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

bufferedOutputStream.write(data);

bufferedOutputStream.close();

---

## BufferedOutputStream 특징

- 데이터를 바로 파일에 쓰지 않고 버퍼에 모은다.
- 버퍼가 차거나 flush(), close()가 호출되면 실제로 출력한다.
- 하나씩 쓰는 것보다 성능이 좋다.

---

## Buffered 스트림 읽기

BufferedInputStream은 내부 버퍼를 사용해서 입력 성능을 높인다.

예시

InputStream inputStream = new FileInputStream("test.txt");
BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

int data = bufferedInputStream.read();

bufferedInputStream.close();

---

## BufferedInputStream 특징

- 파일에서 데이터를 한 번에 읽어 버퍼에 저장한다.
- read() 호출 시 버퍼에서 데이터를 가져온다.
- 파일 접근 횟수를 줄여 성능을 높인다.

---

## 한 번에 쓰기

데이터 전체를 byte 배열로 준비한 뒤 한 번에 쓰는 방식이다.

예시

outputStream.write(data);

---

## 한 번에 쓰기의 특징

- write() 호출 횟수가 줄어든다.
- 작은 파일에서는 매우 간단하고 빠르다.
- 큰 파일은 메모리 사용량이 커질 수 있다.

---

## 성능 비교 정리

| 방식 | 특징 | 성능 |
|------|------|------|
| 하나씩 쓰기 | 1바이트씩 write() 호출 | 느림 |
| 버퍼 직접 활용 | 데이터를 모아서 처리 | 빠름 |
| Buffered 스트림 | 내부 버퍼 사용 | 빠름 |
| 한 번에 쓰기 | byte 배열 전체를 한 번에 처리 | 매우 빠름 |

---

## close()의 중요성

스트림을 사용한 후에는 반드시 close()를 호출해야 한다.

close() 역할

- 리소스 반환
- 버퍼에 남은 데이터 출력
- 파일 사용 종료

---

## flush()

flush()는 버퍼에 남아있는 데이터를 강제로 출력한다.

close()를 호출하면 내부적으로 flush()가 수행된다.

---

## 핵심 정리

1. 스트림은 데이터를 읽고 쓰는 흐름이다.
2. InputStream은 데이터를 읽을 때 사용한다.
3. OutputStream은 데이터를 쓸 때 사용한다.
4. 파일 입출력은 디스크 접근 비용이 크다.
5. 1바이트씩 읽고 쓰면 성능이 느리다.
6. 버퍼를 사용하면 입출력 횟수를 줄일 수 있다.
7. BufferedInputStream은 입력 성능을 높인다.
8. BufferedOutputStream은 출력 성능을 높인다.
9. 한 번에 쓰기는 빠르지만 큰 데이터는 메모리 사용량에 주의해야 한다.
10. 스트림 사용 후 close()를 반드시 호출해야 한다.
