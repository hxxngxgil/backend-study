# File & Files

## File

`File`은 자바에서 파일과 디렉토리를 다루기 위해 제공하는 클래스이다.

파일 자체를 읽고 쓰는 기능보다는  
파일 또는 디렉토리의 정보를 확인하거나 생성, 삭제하는 기능을 제공한다.

---

## File의 특징

- 파일 또는 디렉토리를 표현한다.
- 파일 존재 여부를 확인할 수 있다.
- 파일 이름, 경로, 크기 등을 확인할 수 있다.
- 디렉토리를 생성하거나 파일을 삭제할 수 있다.
- 오래된 방식의 파일 처리 클래스이다.

---

## File 사용 예시

File file = new File("temp/test.txt");

file.exists();
file.isFile();
file.isDirectory();
file.getName();
file.getPath();
file.length();

---

## File의 한계

`File`은 파일 정보를 다루는 데 사용할 수 있지만  
파일을 읽고 쓰는 기능은 직접 제공하지 않는다.

파일 내용을 읽거나 쓰려면  
InputStream, OutputStream, Reader, Writer 등을 함께 사용해야 한다.

또한 예외 처리나 기능 면에서 최신 방식인 `Files`보다 불편하다.

---

# Files

`Files`는 자바 NIO에서 제공하는 파일 처리 유틸리티 클래스이다.

파일 읽기, 쓰기, 복사, 삭제, 이동 등  
다양한 기능을 편리하게 제공한다.

---

## Files의 특징

- 파일 읽기 가능
- 파일 쓰기 가능
- 파일 복사 가능
- 파일 삭제 가능
- 파일 이동 가능
- 디렉토리 생성 가능
- 문자 파일 처리 가능
- 스트림보다 간단하게 파일 작업 가능

---

## Files 사용 예시

Path path = Path.of("temp/test.txt");

Files.exists(path);
Files.isRegularFile(path);
Files.isDirectory(path);
Files.size(path);

---

# File과 Files 차이

| 구분 | File | Files |
|------|------|-------|
| 패키지 | java.io | java.nio.file |
| 역할 | 파일/디렉토리 정보 표현 | 파일 작업 유틸리티 |
| 파일 읽기/쓰기 | 직접 제공 X | 제공 O |
| 사용 방식 | 객체 중심 | static 메서드 중심 |
| 최신 방식 | 오래된 방식 | 권장되는 방식 |

---

# 경로 표시

파일 경로는 운영체제마다 표현 방식이 다를 수 있다.

예시

Windows

C:\temp\test.txt

Linux / macOS

/temp/test.txt

---

## 상대 경로

현재 프로그램이 실행되는 위치를 기준으로 파일을 찾는 방식이다.

예시

temp/test.txt

---

## 절대 경로

루트 경로부터 전체 경로를 작성하는 방식이다.

예시

Windows

C:\temp\test.txt

Linux / macOS

/home/user/temp/test.txt

---

## Path

`Path`는 파일이나 디렉토리의 경로를 표현하는 객체이다.

예시

Path path = Path.of("temp/test.txt");

---

## Path를 사용하는 이유

문자열로 경로를 직접 다루는 것보다  
`Path`를 사용하면 더 안전하고 편리하게 경로를 관리할 수 있다.

---

# Files로 문자 파일 읽기

`Files`를 사용하면 문자 파일을 간단하게 읽을 수 있다.

---

## readString()

파일 전체 내용을 문자열로 읽는다.

예시

Path path = Path.of("temp/test.txt");

String content = Files.readString(path);

---

## readAllLines()

파일 내용을 줄 단위로 읽어서 List로 반환한다.

예시

Path path = Path.of("temp/test.txt");

List<String> lines = Files.readAllLines(path);

---

## 문자 파일 읽기 주의점

문자 파일을 읽을 때는 문자 인코딩이 중요하다.

저장할 때 사용한 인코딩과  
읽을 때 사용하는 인코딩이 다르면 문자가 깨질 수 있다.

예시

String content = Files.readString(path, StandardCharsets.UTF_8);

---

# Files로 문자 파일 쓰기

문자열을 파일에 쓸 수도 있다.

예시

Path path = Path.of("temp/test.txt");

Files.writeString(path, "hello file", StandardCharsets.UTF_8);

---

# 파일 복사 최적화

파일을 복사하는 방법은 여러 가지가 있다.

이번 강의에서는 다음 방식들을 비교했다.

1. 스트림 직접 사용
2. transferTo 사용
3. Files.copy 사용

각 방식에 따라 코드의 복잡도와 성능이 달라질 수 있다.

---

# 1. 스트림 직접 사용

InputStream과 OutputStream을 직접 사용해서 파일을 복사하는 방식이다.

예시

InputStream inputStream = new FileInputStream(source);
OutputStream outputStream = new FileOutputStream(target);

byte[] buffer = new byte[8192];

int readCount;
while ((readCount = inputStream.read(buffer)) != -1) {
    outputStream.write(buffer, 0, readCount);
}

inputStream.close();
outputStream.close();

---

## 스트림 직접 사용 특징

장점

- 동작 원리를 이해하기 좋다.
- 버퍼 크기를 직접 조절할 수 있다.
- 오래전부터 사용된 기본 방식이다.

단점

- 코드가 길다.
- close 처리를 직접 해야 한다.
- 실수할 가능성이 있다.

---

# 2. transferTo 사용

`InputStream`의 `transferTo()`를 사용하면  
입력 스트림의 데이터를 출력 스트림으로 쉽게 전달할 수 있다.

예시

InputStream inputStream = new FileInputStream(source);
OutputStream outputStream = new FileOutputStream(target);

inputStream.transferTo(outputStream);

inputStream.close();
outputStream.close();

---

## transferTo 특징

장점

- 코드가 간단하다.
- 직접 반복문을 작성하지 않아도 된다.
- 스트림 복사 코드를 줄일 수 있다.

단점

- 스트림 생성과 close 처리는 여전히 필요하다.
- 파일 복사만 놓고 보면 Files.copy가 더 간단할 수 있다.

---

# 3. Files.copy 사용

`Files.copy()`를 사용하면 파일 복사를 매우 간단하게 처리할 수 있다.

예시

Path source = Path.of("temp/source.dat");
Path target = Path.of("temp/target.dat");

Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);

---

## Files.copy 특징

장점

- 코드가 가장 간단하다.
- 파일 복사 의도가 명확하다.
- 내부적으로 최적화된 방식으로 복사할 수 있다.
- 실무에서 파일 복사 시 사용하기 좋다.

단점

- 세부적인 복사 과정을 직접 제어하기는 어렵다.

---

# 파일 복사 성능 비교

| 방식 | 설명 | 특징 |
|------|------|------|
| 스트림 직접 사용 | InputStream, OutputStream으로 직접 복사 | 원리 이해에 좋지만 코드가 길다 |
| transferTo | 입력 스트림 데이터를 출력 스트림으로 전달 | 코드가 간단하고 성능도 좋다 |
| Files.copy | Files에서 제공하는 파일 복사 기능 | 가장 간단하고 실무에서 사용하기 좋다 |

---

## 성능 비교에서 중요한 점

파일 복사 성능은 다음 요소에 따라 달라질 수 있다.

- 파일 크기
- 버퍼 크기
- 디스크 성능
- 운영체제
- JVM 환경
- 캐시 상태

따라서 한 번의 실행 결과만 보고  
항상 특정 방식이 무조건 빠르다고 판단하면 안 된다.

---

# 실무에서는?

파일 내용을 직접 제어하면서 복사해야 한다면  
스트림 또는 transferTo를 사용할 수 있다.

단순히 파일을 복사하는 목적이라면  
`Files.copy()`를 사용하는 것이 가장 간단하고 명확하다.

문자 파일을 간단히 읽고 쓸 때도  
`Files.readString()`, `Files.writeString()`을 사용하면 편리하다.

---

# 핵심 정리

1. File은 파일이나 디렉토리를 표현하는 오래된 클래스이다.
2. File은 파일 정보 확인, 생성, 삭제 등에 사용할 수 있다.
3. Files는 파일 작업을 편리하게 제공하는 유틸리티 클래스이다.
4. 최신 파일 작업은 Files와 Path를 사용하는 것이 편리하다.
5. Path는 파일 또는 디렉토리의 경로를 표현한다.
6. 경로에는 상대 경로와 절대 경로가 있다.
7. Files.readString()으로 문자 파일을 간단히 읽을 수 있다.
8. Files.writeString()으로 문자 파일을 간단히 쓸 수 있다.
9. 파일 복사는 스트림, transferTo, Files.copy 방식으로 할 수 있다.
10. 단순 파일 복사는 Files.copy가 가장 간단하고 명확하다.
11. 성능 비교는 파일 크기, 버퍼 크기, 디스크, 운영체제, 캐시 상태에 따라 달라질 수 있다.
