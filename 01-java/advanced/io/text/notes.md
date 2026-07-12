# I/O Basic 2 - 문자 스트림

## 문자 다루기 - 시작

컴퓨터는 모든 데이터를 바이트로 저장한다.

문자도 파일이나 네트워크에 저장될 때는 결국 바이트로 변환된다.

문자를 저장하거나 읽을 때는 문자 인코딩이 필요하다.

예시

문자 → 인코딩 → 바이트

바이트 → 디코딩 → 문자

---

## 바이트 스트림과 문자 스트림

자바 I/O는 크게 바이트 스트림과 문자 스트림으로 나눌 수 있다.

---

## 바이트 스트림

바이트 단위로 데이터를 읽고 쓴다.

대표 클래스

- InputStream
- OutputStream

사용 대상

- 이미지
- 영상
- 실행 파일
- 바이너리 파일
- 모든 종류의 바이트 데이터

---

## 문자 스트림

문자 단위로 데이터를 읽고 쓴다.

대표 클래스

- Reader
- Writer

사용 대상

- 텍스트 파일
- 로그 파일
- CSV 파일
- 설정 파일

---

# 문자 다루기 - 스트림을 문자로

파일이나 네트워크에서 들어오는 데이터는 기본적으로 바이트이다.

이 바이트 데이터를 문자로 다루려면 문자 인코딩을 기준으로 변환해야 한다.

---

## InputStreamReader

InputStreamReader는 바이트 입력 스트림을 문자 입력 스트림으로 변환한다.

즉,

InputStream → Reader

로 연결해주는 보조 스트림이다.

예시

InputStream inputStream = new FileInputStream("test.txt");

Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);

---

## OutputStreamWriter

OutputStreamWriter는 문자 출력 스트림을 바이트 출력 스트림으로 변환한다.

즉,

Writer → OutputStream

으로 연결해주는 보조 스트림이다.

예시

OutputStream outputStream = new FileOutputStream("test.txt");

Writer writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);

---

## 인코딩 주의점

문자를 저장할 때 사용한 인코딩과  
문자를 읽을 때 사용하는 인코딩이 다르면 문자가 깨질 수 있다.

예시

UTF-8로 저장한 파일을  
EUC-KR로 읽으면 한글이 깨질 수 있다.

따라서 문자 파일을 다룰 때는 가능하면 인코딩을 명시하는 것이 좋다.

예시

StandardCharsets.UTF_8

---

# Reader

Reader는 문자 입력 스트림의 최상위 추상 클래스이다.

문자 데이터를 읽을 때 사용한다.

대표 메서드

- read()
- read(char[] buffer)
- close()

---

## Reader 사용 예시

Reader reader = new InputStreamReader(
        new FileInputStream("test.txt"),
        StandardCharsets.UTF_8
);

int ch;
while ((ch = reader.read()) != -1) {
    System.out.println((char) ch);
}

reader.close();

---

# Writer

Writer는 문자 출력 스트림의 최상위 추상 클래스이다.

문자 데이터를 쓸 때 사용한다.

대표 메서드

- write()
- flush()
- close()

---

## Writer 사용 예시

Writer writer = new OutputStreamWriter(
        new FileOutputStream("test.txt"),
        StandardCharsets.UTF_8
);

writer.write("hello");
writer.write("안녕하세요");

writer.close();

---

# FileReader와 FileWriter

FileReader와 FileWriter는 문자 파일을 읽고 쓰기 위한 기본 문자 스트림이다.

예시

FileReader reader = new FileReader("test.txt");

FileWriter writer = new FileWriter("test.txt");

---

## FileReader, FileWriter 주의점

FileReader와 FileWriter는 기본 인코딩을 사용할 수 있다.

환경에 따라 기본 인코딩이 다르면 문자 깨짐이 발생할 수 있다.

문자 인코딩을 명확하게 다루려면  
InputStreamReader, OutputStreamWriter 또는 Files 기능을 사용하는 것이 좋다.

---

# BufferedReader

BufferedReader는 Reader에 버퍼 기능을 추가하는 보조 스트림이다.

문자를 하나씩 읽는 것보다  
버퍼를 사용해서 읽으면 성능이 좋아진다.

---

## BufferedReader 사용 예시

Reader reader = new InputStreamReader(
        new FileInputStream("test.txt"),
        StandardCharsets.UTF_8
);

BufferedReader bufferedReader = new BufferedReader(reader);

String line;
while ((line = bufferedReader.readLine()) != null) {
    System.out.println(line);
}

bufferedReader.close();

---

## BufferedReader 특징

- 내부 버퍼를 사용한다.
- 문자 입력 성능을 높인다.
- readLine()을 제공한다.
- 텍스트 파일을 줄 단위로 읽을 때 편리하다.

---

## readLine()

readLine()은 한 줄씩 문자열로 읽는다.

특징

- 한 줄을 String으로 반환한다.
- 더 이상 읽을 줄이 없으면 null을 반환한다.
- 줄바꿈 문자는 포함하지 않는다.

---

# BufferedWriter

BufferedWriter는 Writer에 버퍼 기능을 추가하는 보조 스트림이다.

문자를 하나씩 바로 출력하지 않고  
버퍼에 모았다가 한 번에 출력해서 성능을 높인다.

예시

Writer writer = new OutputStreamWriter(
        new FileOutputStream("test.txt"),
        StandardCharsets.UTF_8
);

BufferedWriter bufferedWriter = new BufferedWriter(writer);

bufferedWriter.write("hello");
bufferedWriter.newLine();
bufferedWriter.write("안녕하세요");

bufferedWriter.close();

---

# 기본 스트림

기본 스트림은 실제 데이터 대상과 직접 연결되는 스트림이다.

단독으로 사용할 수 있다.

즉, 파일, 메모리, 배열, 문자열 같은 실제 데이터 소스와 직접 연결된다.

---

## 기본 스트림 종류

바이트 기본 스트림

- FileInputStream
- FileOutputStream
- ByteArrayInputStream
- ByteArrayOutputStream

문자 기본 스트림

- FileReader
- FileWriter
- StringReader
- StringWriter

---

## 기본 스트림 특징

- 단독 사용 가능
- 실제 데이터 대상과 직접 연결
- 파일, 메모리, 문자열 등을 직접 읽고 쓸 수 있음

---

# 보조 스트림

보조 스트림은 다른 스트림에 기능을 추가하는 스트림이다.

단독으로 사용할 수 없다.

반드시 대상 스트림이 필요하다.

예시

BufferedReader bufferedReader = new BufferedReader(reader);

여기서 BufferedReader는 보조 스트림이고,  
reader가 대상 스트림이다.

---

## 보조 스트림 종류

버퍼 기능

- BufferedInputStream
- BufferedOutputStream
- BufferedReader
- BufferedWriter

문자 변환 기능

- InputStreamReader
- OutputStreamWriter

기본 타입 데이터 처리

- DataInputStream
- DataOutputStream

객체 처리

- ObjectInputStream
- ObjectOutputStream

출력 편의 기능

- PrintStream
- PrintWriter

---

## 보조 스트림 특징

- 단독 사용 불가
- 반드시 대상 스트림이 필요함
- 기존 스트림에 기능을 추가함
- 여러 스트림을 연결해서 사용할 수 있음

---

# 기타 스트림

자바 I/O에는 다양한 목적의 스트림이 있다.

---

## DataInputStream, DataOutputStream

기본 타입 데이터를 편리하게 읽고 쓸 수 있다.

예시

- int
- long
- double
- boolean
- UTF 문자열

주의점

저장한 순서와 읽는 순서가 반드시 같아야 한다.

---

## ObjectInputStream, ObjectOutputStream

객체를 파일이나 네트워크로 저장하고 읽을 수 있다.

객체를 저장하려면 Serializable 인터페이스를 구현해야 한다.

---

## PrintStream, PrintWriter

출력을 편리하게 도와주는 스트림이다.

예시

System.out.println()

여기서 System.out은 PrintStream이다.

---

# 스트림 연결 구조 예시

파일에서 바이트를 읽는다.

FileInputStream

↓

바이트를 문자로 변환한다.

InputStreamReader

↓

버퍼를 사용해서 성능을 높이고 한 줄씩 읽는다.

BufferedReader

예시

BufferedReader br = new BufferedReader(
        new InputStreamReader(
                new FileInputStream("test.txt"),
                StandardCharsets.UTF_8
        )
);

---

# 실무에서 자주 사용하는 방식

문자 파일을 읽을 때

BufferedReader br = new BufferedReader(
        new InputStreamReader(
                new FileInputStream("test.txt"),
                StandardCharsets.UTF_8
        )
);

문자 파일을 쓸 때

BufferedWriter bw = new BufferedWriter(
        new OutputStreamWriter(
                new FileOutputStream("test.txt"),
                StandardCharsets.UTF_8
        )
);

하지만 간단한 문자 파일 처리는 Files를 사용하는 것이 더 편리할 수 있다.

예시

Files.readString(path, StandardCharsets.UTF_8);

Files.writeString(path, content, StandardCharsets.UTF_8);

---

# 핵심 정리

1. 컴퓨터는 문자를 바이트로 저장한다.
2. 문자를 저장하거나 읽을 때는 문자 인코딩이 필요하다.
3. InputStream, OutputStream은 바이트 스트림이다.
4. Reader, Writer는 문자 스트림이다.
5. InputStreamReader는 바이트 입력 스트림을 문자 입력 스트림으로 변환한다.
6. OutputStreamWriter는 문자 출력 스트림을 바이트 출력 스트림으로 변환한다.
7. BufferedReader는 문자 입력 성능을 높이고 readLine()을 제공한다.
8. BufferedWriter는 문자 출력 성능을 높인다.
9. 기본 스트림은 단독으로 사용할 수 있다.
10. 보조 스트림은 단독으로 사용할 수 없고 반드시 대상 스트림이 필요하다.
11. 보조 스트림은 기존 스트림에 기능을 추가한다.
12. 문자 파일을 다룰 때는 인코딩을 명시하는 것이 안전하다.
13. 간단한 문자 파일 처리는 Files 기능을 사용하면 편리하다.
