# Network Basic

## 클라이언트와 서버

네트워크 프로그램은 보통 클라이언트와 서버 구조로 동작한다.

---

## 클라이언트

클라이언트는 서버에 요청을 보내는 쪽이다.

예시

- 웹 브라우저
- 모바일 앱
- 게임 클라이언트
- 채팅 프로그램

---

## 서버

서버는 클라이언트의 요청을 받고 응답을 보내는 쪽이다.

예시

- 웹 서버
- API 서버
- 채팅 서버
- 파일 서버

---

## 클라이언트와 서버 흐름

1. 서버가 먼저 실행된다.
2. 서버가 특정 포트에서 대기한다.
3. 클라이언트가 서버 IP와 PORT로 접속한다.
4. 연결이 성공하면 데이터를 주고받는다.
5. 통신이 끝나면 자원을 정리한다.

---

# 인터넷 통신

인터넷 통신은 멀리 떨어진 컴퓨터끼리 데이터를 주고받는 것이다.

데이터는 네트워크를 통해 여러 장비를 거쳐 목적지까지 이동한다.

---

## 네트워크 통신에 필요한 정보

네트워크 통신을 하려면 다음 정보가 필요하다.

- IP
- PORT
- 프로토콜
- DNS

---

# IP

IP는 인터넷에서 컴퓨터를 식별하기 위한 주소이다.

IP는 목적지 컴퓨터를 찾기 위해 사용된다.

예시

127.0.0.1

192.168.0.10

---

## 127.0.0.1

127.0.0.1은 자기 자신을 의미한다.

localhost라고도 부른다.

로컬에서 서버와 클라이언트를 테스트할 때 많이 사용한다.

---

# TCP

TCP는 연결 기반 프로토콜이다.

데이터를 안정적으로 주고받기 위해 사용한다.

---

## TCP 특징

- 연결이 필요하다.
- 데이터 전달을 보장한다.
- 데이터 순서를 보장한다.
- 신뢰성이 높다.
- UDP보다 상대적으로 무겁다.

---

## TCP 사용 예시

- 웹 통신
- 파일 전송
- 채팅
- 데이터베이스 연결

---

# UDP

UDP는 연결 없이 데이터를 보내는 프로토콜이다.

---

## UDP 특징

- 연결 과정이 없다.
- 데이터 전달을 보장하지 않는다.
- 데이터 순서를 보장하지 않는다.
- TCP보다 빠르고 단순하다.

---

## UDP 사용 예시

- 실시간 영상
- 음성 통화
- 게임
- DNS

---

# TCP와 UDP 비교

| 구분 | TCP | UDP |
|------|-----|-----|
| 연결 | 연결 필요 | 연결 없음 |
| 신뢰성 | 높음 | 낮음 |
| 순서 보장 | 보장 | 보장 안 함 |
| 속도 | 상대적으로 느림 | 빠름 |
| 사용 예 | 웹, 채팅, 파일 전송 | 실시간 영상, 게임, DNS |

---

# PORT

PORT는 하나의 컴퓨터 안에서 실행 중인 프로그램을 구분하기 위한 번호이다.

IP가 컴퓨터를 찾는 주소라면  
PORT는 그 컴퓨터 안의 애플리케이션을 찾는 번호이다.

---

## PORT 예시

- 80: HTTP
- 443: HTTPS
- 3306: MySQL
- 5432: PostgreSQL
- 8080: 개발용 웹 서버에서 자주 사용

---

## IP와 PORT

네트워크 연결은 IP와 PORT를 함께 사용한다.

예시

127.0.0.1:8080

의미

- 127.0.0.1 컴퓨터의
- 8080 포트에서 실행 중인 프로그램에 접속

---

# DNS

DNS는 도메인 이름을 IP 주소로 변환해주는 시스템이다.

사람은 IP보다 도메인 이름을 기억하기 쉽다.

예시

google.com

↓

IP 주소

---

## DNS가 필요한 이유

사용자는 도메인 이름으로 접속하지만  
실제 네트워크 통신은 IP 주소를 사용한다.

따라서 도메인을 IP로 바꾸는 과정이 필요하다.

---

# 네트워크 프로그램

자바에서는 Socket과 ServerSocket을 사용해서 네트워크 프로그램을 만들 수 있다.

---

## ServerSocket

ServerSocket은 서버에서 사용하는 소켓이다.

특정 PORT를 열고 클라이언트의 접속을 기다린다.

예시

ServerSocket serverSocket = new ServerSocket(12345);

Socket socket = serverSocket.accept();

---

## Socket

Socket은 클라이언트와 서버가 데이터를 주고받기 위한 연결 통로이다.

클라이언트는 서버의 IP와 PORT로 Socket을 생성한다.

예시

Socket socket = new Socket("localhost", 12345);

---

## 소켓 연결 흐름

서버

1. ServerSocket 생성
2. PORT 오픈
3. accept()로 클라이언트 접속 대기
4. 클라이언트가 접속하면 Socket 생성
5. Socket으로 메시지 송수신
6. close()로 자원 정리

클라이언트

1. Socket 생성
2. 서버 IP와 PORT로 연결
3. 메시지 송수신
4. close()로 자원 정리

---

## 메시지 주고받기

소켓에서 데이터를 주고받을 때는 스트림을 사용한다.

입력

socket.getInputStream();

출력

socket.getOutputStream();

문자 데이터를 주고받으려면 Reader, Writer 계열로 변환해서 사용할 수 있다.

예시

BufferedReader reader = new BufferedReader(
        new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8)
);

BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8)
);

---

# 자원 정리

네트워크 프로그램에서는 자원 정리가 매우 중요하다.

소켓, 스트림, 서버 소켓을 사용한 후에는 반드시 닫아야 한다.

닫지 않으면 리소스 누수가 발생할 수 있다.

---

## finally로 자원 정리

예외가 발생해도 finally는 실행된다.

따라서 finally에서 자원을 정리할 수 있다.

예시

Socket socket = null;

try {
    socket = new Socket("localhost", 12345);
} catch (IOException e) {
    e.printStackTrace();
} finally {
    if (socket != null) {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

---

## finally 자원 정리의 단점

- 코드가 길어진다.
- close() 중에도 예외가 발생할 수 있다.
- 자원이 많아지면 코드가 복잡해진다.
- 가독성이 떨어진다.

---

# try-with-resources

try-with-resources는 자원을 자동으로 정리해주는 문법이다.

AutoCloseable을 구현한 객체는 try-with-resources에서 자동으로 close()가 호출된다.

예시

try (Socket socket = new Socket("localhost", 12345)) {
    // socket 사용
} catch (IOException e) {
    e.printStackTrace();
}

---

## try-with-resources 장점

- 리소스 누수 방지
- 스코프 범위 한정
- 코드 간결성 향상
- 가독성 향상
- 조금 더 빠른 자원 해제 가능
- 자원 정리 중 발생하는 부가적인 문제도 함께 관리 가능

---

## try-with-resources를 사용하는 이유

직접 finally에서 close()를 호출하는 것보다  
try-with-resources를 사용하는 것이 안전하고 깔끔하다.

실무에서는 자원 정리가 필요한 경우 try-with-resources를 우선적으로 고려한다.

---

# 셧다운 훅

셧다운 훅은 자바 애플리케이션이 정상적으로 종료될 때 실행되는 작업이다.

JVM이 종료되기 전에 등록된 셧다운 훅이 실행된다.

예시

Runtime.getRuntime().addShutdownHook(new Thread(() -> {
    System.out.println("shutdown hook 실행");
}));

---

## 셧다운 훅 사용 예시

- 서버 종료 시 자원 정리
- 로그 저장
- 임시 파일 삭제
- 연결 종료 처리

---

## 셧다운 훅 주의점

셧다운 훅은 정상 종료 시 실행된다.

하지만 프로세스가 강제로 종료되거나  
운영체제 수준에서 즉시 종료되면 실행되지 않을 수 있다.

---

# 네트워크 예외

네트워크 프로그램에서는 다양한 예외가 발생할 수 있다.

대표적인 예외 상황

- 연결 실패
- 타임아웃
- 정상 종료
- 강제 종료

---

# 연결 예외

서버에 연결할 수 없을 때 발생한다.

예시 상황

- 서버가 실행 중이 아님
- 포트가 열려 있지 않음
- 방화벽 차단
- 잘못된 IP 또는 PORT

대표 예외

ConnectException

---

## Connection refused

서버가 해당 포트에서 대기하고 있지 않을 때 발생할 수 있다.

예시

java.net.ConnectException: Connection refused

---

# 타임아웃

타임아웃은 일정 시간 동안 작업이 완료되지 않으면 기다리기를 중단하는 것이다.

네트워크에서는 타임아웃이 매우 중요하다.

실무에서 자주 발생하는 문제이다.

---

## 연결 타임아웃

연결 타임아웃은 서버에 연결을 시도했지만  
정해진 시간 안에 연결되지 않는 경우 발생한다.

예시 상황

- 서버 응답 없음
- 네트워크 장애
- 방화벽 문제
- IP는 있지만 연결이 지연됨

설정 예시

Socket socket = new Socket();

socket.connect(new InetSocketAddress("localhost", 12345), 3000);

의미

3초 안에 연결되지 않으면 타임아웃 발생

---

## Read 타임아웃

Read 타임아웃은 연결은 성공했지만  
상대방이 데이터를 보내지 않아 read()가 계속 대기하는 상황을 막기 위한 것이다.

설정 예시

socket.setSoTimeout(3000);

의미

3초 동안 데이터를 읽지 못하면 타임아웃 발생

대표 예외

SocketTimeoutException

---

## 타임아웃이 중요한 이유

타임아웃이 없으면 네트워크 장애 상황에서  
프로그램이 무한정 대기할 수 있다.

실무에서는 연결 타임아웃과 Read 타임아웃을 적절히 설정해야 한다.

---

# 정상 종료

TCP 연결은 정상 종료 시 FIN 패킷을 사용한다.

상대방이 정상적으로 연결을 종료하면  
읽기 작업에서 EOF를 받을 수 있다.

자바에서는 read()가 -1을 반환하는 경우가 있다.

---

## 정상 종료 특징

- 상대방이 close()를 호출
- TCP FIN 패킷 전송
- 읽는 쪽에서는 더 이상 데이터가 없음을 알 수 있음
- read() 결과가 -1이 될 수 있음

---

# 강제 종료

상대방이 비정상적으로 종료되거나  
연결이 갑자기 끊기면 강제 종료 상황이 발생할 수 있다.

예시 상황

- 프로그램 강제 종료
- 네트워크 단절
- 프로세스 종료
- 소켓을 비정상적으로 닫음

---

## 강제 종료 시 발생 가능한 예외

대표 예외

- SocketException
- Connection reset
- Broken pipe

---

# TCP RST 패킷

TCP RST는 연결을 즉시 강제로 종료할 때 사용하는 패킷이다.

정상 종료가 FIN이라면  
강제 종료는 RST로 이해할 수 있다.

---

## TCP RST가 발생할 수 있는 상황

- 상대방 프로세스가 갑자기 종료됨
- 이미 닫힌 소켓에 데이터를 보냄
- 연결 상태가 비정상적임
- 운영체제가 연결을 강제로 끊음

---

## FIN과 RST 차이

| 구분 | FIN | RST |
|------|-----|-----|
| 의미 | 정상 종료 | 강제 종료 |
| 종료 방식 | 서로 종료 절차 진행 | 즉시 연결 끊음 |
| 상황 | close() 정상 호출 | 비정상 종료, 오류 상황 |
| 결과 | EOF 가능 | Connection reset 등 예외 가능 |

---

# 네트워크 프로그램에서 중요한 점

1. 서버는 먼저 실행되어 PORT를 열고 있어야 한다.
2. 클라이언트는 서버 IP와 PORT로 접속한다.
3. 소켓 통신은 스트림을 사용한다.
4. 자원 정리는 반드시 해야 한다.
5. 가능하면 try-with-resources를 사용한다.
6. 타임아웃 설정은 실무에서 매우 중요하다.
7. 정상 종료와 강제 종료를 구분할 수 있어야 한다.
8. Connection reset은 TCP RST와 관련될 수 있다.

---

# 핵심 정리

1. 클라이언트는 요청을 보내고 서버는 응답을 보낸다.
2. IP는 컴퓨터를 찾기 위한 주소이다.
3. PORT는 컴퓨터 안의 프로그램을 구분하기 위한 번호이다.
4. DNS는 도메인 이름을 IP 주소로 변환한다.
5. TCP는 연결 기반이며 신뢰성 있는 통신을 제공한다.
6. UDP는 연결이 없고 빠르지만 신뢰성을 보장하지 않는다.
7. 자바 네트워크 프로그램은 Socket과 ServerSocket을 사용한다.
8. Socket 통신은 InputStream, OutputStream을 통해 데이터를 주고받는다.
9. 네트워크 자원은 반드시 정리해야 한다.
10. try-with-resources는 리소스 누수를 막고 코드를 간결하게 한다.
11. 셧다운 훅은 자바가 정상 종료될 때 실행된다.
12. 연결 예외는 서버가 없거나 포트가 열려 있지 않을 때 발생할 수 있다.
13. 타임아웃에는 연결 타임아웃과 Read 타임아웃이 있다.
14. 타임아웃 설정은 실무에서 매우 중요하다.
15. 정상 종료는 FIN, 강제 종료는 RST와 관련된다.
16. TCP RST가 발생하면 Connection reset 같은 예외가 발생할 수 있다.
