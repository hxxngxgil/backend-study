# HTTP Basic & HTTP Server

## HTTP 기본 이론

HTTP는 HyperText Transfer Protocol의 약자이다.

클라이언트와 서버가 데이터를 주고받기 위한 통신 규칙이다.

웹 브라우저가 서버에 요청을 보내고  
서버가 응답을 반환할 때 HTTP를 사용한다.

---

## HTTP 통신 구조

HTTP는 기본적으로 요청(Request)과 응답(Response) 구조로 동작한다.

흐름

1. 클라이언트가 서버에 HTTP 요청을 보낸다.
2. 서버는 요청을 분석한다.
3. 서버는 요청에 맞는 처리를 수행한다.
4. 서버는 HTTP 응답을 클라이언트에게 보낸다.

---

## 클라이언트와 서버

클라이언트

- 요청을 보내는 쪽
- 웹 브라우저, 모바일 앱, API 호출 프로그램 등

서버

- 요청을 받고 응답을 보내는 쪽
- 웹 서버, WAS, API 서버 등

---

## HTTP 특징

- 클라이언트 서버 구조
- 요청 응답 구조
- 무상태 프로토콜
- 단순하고 확장 가능
- 텍스트 기반 프로토콜

---

## Stateless

HTTP는 무상태 프로토콜이다.

서버는 이전 요청 정보를 기본적으로 기억하지 않는다.

즉, 각각의 요청은 독립적으로 처리된다.

장점

- 서버 확장성이 좋다.
- 서버를 여러 대로 늘리기 쉽다.

단점

- 로그인 상태 같은 정보를 유지하려면 별도 기술이 필요하다.
- 쿠키, 세션, 토큰 등을 사용해야 한다.

---

# HTTP 요청 메시지

HTTP 요청은 클라이언트가 서버에 보내는 메시지이다.

구성

- 시작 라인
- 헤더
- 빈 줄
- 바디

예시

GET /index.html HTTP/1.1

Host: localhost:8080

---

## 요청 라인

요청 라인은 HTTP 요청의 첫 줄이다.

구성

HTTP 메서드 + 요청 URL + HTTP 버전

예시

GET /hello HTTP/1.1

---

## HTTP 헤더

헤더는 요청이나 응답에 대한 부가 정보를 담는다.

예시

Host: localhost:8080

Content-Type: application/json

Content-Length: 20

---

## HTTP 바디

바디는 실제 전송할 데이터를 담는 영역이다.

GET 요청은 보통 바디가 없다.

POST, PUT, PATCH 요청은 바디에 데이터를 담는 경우가 많다.

---

# HTTP 응답 메시지

HTTP 응답은 서버가 클라이언트에게 보내는 메시지이다.

구성

- 상태 라인
- 헤더
- 빈 줄
- 바디

예시

HTTP/1.1 200 OK

Content-Type: text/html;charset=UTF-8

---

## 상태 라인

상태 라인은 HTTP 응답의 첫 줄이다.

구성

HTTP 버전 + 상태 코드 + 상태 메시지

예시

HTTP/1.1 200 OK

---

## 상태 코드

상태 코드는 요청 처리 결과를 숫자로 표현한다.

대표 상태 코드

| 상태 코드 | 의미 |
|----------|------|
| 200 | OK, 요청 성공 |
| 201 | Created, 리소스 생성 성공 |
| 400 | Bad Request, 잘못된 요청 |
| 404 | Not Found, 리소스 없음 |
| 500 | Internal Server Error, 서버 내부 오류 |

---

# HTTP 메서드

HTTP 메서드는 클라이언트가 서버에게 원하는 동작을 알려준다.

---

## GET

리소스를 조회할 때 사용한다.

특징

- 데이터를 조회한다.
- 보통 바디를 사용하지 않는다.
- 쿼리 파라미터로 데이터를 전달할 수 있다.

예시

GET /members?id=1

---

## POST

데이터를 등록하거나 요청 데이터를 처리할 때 사용한다.

특징

- 바디에 데이터를 담아 전송한다.
- 회원가입, 게시글 작성 등에 사용한다.
- 서버 상태를 변경할 수 있다.

---

## PUT

리소스를 전체 수정할 때 사용한다.

특징

- 기존 리소스를 대체한다.
- 없으면 새로 생성할 수도 있다.
- 전체 수정에 가깝다.

---

## PATCH

리소스의 일부를 수정할 때 사용한다.

특징

- 부분 수정에 사용한다.
- 필요한 필드만 변경할 수 있다.

---

## DELETE

리소스를 삭제할 때 사용한다.

특징

- 지정한 리소스를 삭제한다.

---

## HTTP 메서드 정리

| 메서드 | 용도 |
|--------|------|
| GET | 조회 |
| POST | 등록, 처리 |
| PUT | 전체 수정 |
| PATCH | 부분 수정 |
| DELETE | 삭제 |

---

# HTTP 서버 만들기

자바에서는 ServerSocket과 Socket을 사용해서 간단한 HTTP 서버를 직접 만들 수 있다.

HTTP도 결국 TCP 위에서 동작하므로  
소켓을 사용해서 요청을 받고 응답을 보낼 수 있다.

---

## HTTP 서버 - 시작

기본 흐름

1. ServerSocket을 생성한다.
2. 특정 PORT를 연다.
3. accept()로 클라이언트 연결을 기다린다.
4. 클라이언트가 접속하면 Socket을 얻는다.
5. Socket의 InputStream으로 요청을 읽는다.
6. Socket의 OutputStream으로 응답을 쓴다.
7. 자원을 정리한다.

---

## 기본 서버 흐름 예시

ServerSocket serverSocket = new ServerSocket(12345);

Socket socket = serverSocket.accept();

InputStream inputStream = socket.getInputStream();

OutputStream outputStream = socket.getOutputStream();

---

## HTTP 요청 읽기

클라이언트가 보낸 HTTP 요청은 InputStream으로 읽을 수 있다.

문자 기반으로 읽으려면 BufferedReader를 사용할 수 있다.

예시

BufferedReader reader = new BufferedReader(
        new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8)
);

---

## HTTP 응답 쓰기

HTTP 응답은 OutputStream 또는 Writer를 사용해서 보낼 수 있다.

응답에는 상태 라인, 헤더, 빈 줄, 바디가 포함되어야 한다.

예시 흐름

HTTP/1.1 200 OK

Content-Type: text/html;charset=UTF-8

빈 줄

HTML 본문

---

# HTTP 서버 - 동시 요청

처음 만든 서버는 한 번에 하나의 요청만 처리할 수 있다.

이유

accept()로 연결을 받고  
해당 요청 처리가 끝날 때까지 다음 요청을 처리하지 못하기 때문이다.

---

## 동시 요청 처리

여러 클라이언트 요청을 동시에 처리하려면  
각 요청을 별도 스레드에서 처리해야 한다.

방식

- 요청마다 Thread 생성
- ExecutorService 사용

---

## Thread 방식

클라이언트가 접속할 때마다 새로운 Thread를 생성해서 처리할 수 있다.

장점

- 구현이 단순하다.
- 동시에 여러 요청을 처리할 수 있다.

단점

- 요청이 많아지면 스레드가 너무 많이 생성될 수 있다.
- 서버 자원을 많이 사용할 수 있다.

---

## ExecutorService 방식

스레드 풀을 사용해서 요청을 처리한다.

장점

- 스레드 생성 비용을 줄일 수 있다.
- 동시에 처리할 스레드 수를 제한할 수 있다.
- 실무 방식에 더 가깝다.

---

# HTTP 서버 - 기능 추가

HTTP 서버를 만들면서 요청 URL에 따라 다른 기능을 수행하도록 개선할 수 있다.

예시

/hello

/site1

/site2

/search?q=hello

---

## URL에 따른 분기

요청 URL을 분석해서  
각 URL에 맞는 응답을 반환한다.

예시

/hello 요청 → hello 페이지 응답

/site1 요청 → site1 페이지 응답

/site2 요청 → site2 페이지 응답

---

# URL 인코딩

URL에는 한글, 공백, 특수문자를 그대로 사용하기 어렵다.

따라서 URL에 포함되는 문자는 인코딩이 필요할 수 있다.

---

## URL 인코딩이 필요한 이유

URL은 정해진 문자 규칙이 있다.

한글이나 공백 같은 문자는  
안전하게 전송하기 위해 인코딩된다.

예시

공백

→ %20

한글

→ 퍼센트 인코딩 형태

---

## URL 디코딩

서버는 인코딩된 URL을 다시 원래 문자로 복원해야 한다.

예시

URLEncoder.encode(value, StandardCharsets.UTF_8)

URLDecoder.decode(value, StandardCharsets.UTF_8)

---

## URL 인코딩 주의점

클라이언트와 서버가 같은 문자 인코딩 기준을 사용해야 한다.

현대 웹에서는 보통 UTF-8을 사용한다.

---

# HTTP 서버 - 요청, 응답

서버 코드를 깔끔하게 만들기 위해  
HTTP 요청과 응답을 객체로 분리할 수 있다.

---

## HTTP 요청 객체

요청 객체는 클라이언트의 요청 정보를 담는다.

포함할 수 있는 정보

- HTTP 메서드
- 요청 경로
- 쿼리 파라미터
- 헤더
- 바디

---

## HTTP 응답 객체

응답 객체는 서버가 클라이언트에게 보낼 응답 정보를 담는다.

포함할 수 있는 정보

- 상태 코드
- 응답 헤더
- 응답 바디

---

## 요청, 응답 객체를 분리하는 이유

- 코드가 깔끔해진다.
- HTTP 요청 분석 로직과 비즈니스 로직을 분리할 수 있다.
- 응답 생성 로직을 재사용할 수 있다.
- 유지보수가 쉬워진다.

---

# HTTP 서버 - 커맨드 패턴

커맨드 패턴은 요청을 처리하는 기능을 객체로 분리하는 디자인 패턴이다.

요청 URL마다 다른 Command 객체를 실행하도록 만들 수 있다.

---

## 커맨드 패턴 구조

Command 인터페이스

- execute() 같은 공통 메서드를 정의한다.

각 기능 클래스

- HelloCommand
- Site1Command
- Site2Command
- SearchCommand

각 클래스는 Command 인터페이스를 구현한다.

---

## 커맨드 패턴을 사용하는 이유

URL마다 if문으로 계속 분기하면 코드가 복잡해진다.

커맨드 패턴을 사용하면  
요청 처리 기능을 각각의 클래스로 분리할 수 있다.

장점

- 기능 추가가 쉽다.
- 기존 코드 수정이 줄어든다.
- 역할이 분리된다.
- 유지보수가 쉬워진다.
- OCP 원칙에 가까운 구조를 만들 수 있다.

---

## 커맨드 패턴 적용 전

if (path.equals("/hello")) {
    // hello 처리
} else if (path.equals("/site1")) {
    // site1 처리
} else if (path.equals("/site2")) {
    // site2 처리
}

문제점

- URL이 늘어날수록 if문이 길어진다.
- 기능이 한 곳에 몰린다.
- 수정이 어려워진다.

---

## 커맨드 패턴 적용 후

Map<String, Command> commands = new HashMap<>();

commands.put("/hello", new HelloCommand());

commands.put("/site1", new Site1Command());

commands.put("/site2", new Site2Command());

요청 경로에 맞는 Command를 찾아 실행한다.

---

# 웹 애플리케이션 서버의 역사

웹 초창기에는 정적 HTML 파일을 응답하는 방식이 중심이었다.

하지만 사용자의 요청에 따라 동적으로 응답을 만들어야 하는 요구가 늘어나면서  
웹 애플리케이션 서버가 발전했다.

---

## 정적 리소스

정적 리소스는 요청마다 내용이 변하지 않는 파일이다.

예시

- HTML
- CSS
- JavaScript
- 이미지

---

## 동적 응답

동적 응답은 요청에 따라 서버가 결과를 만들어서 반환하는 방식이다.

예시

- 로그인 결과
- 회원 목록
- 게시글 조회
- 검색 결과

---

## CGI 방식

초기에는 요청마다 별도의 프로그램을 실행해서 동적 응답을 만들었다.

단점

- 요청마다 프로세스를 생성할 수 있다.
- 성능이 좋지 않다.
- 많은 요청을 처리하기 어렵다.

---

## Servlet과 WAS

자바에서는 Servlet을 통해 웹 요청을 처리할 수 있다.

WAS는 Web Application Server의 약자이다.

WAS는 웹 요청을 받아서  
서블릿 같은 자바 웹 애플리케이션 코드를 실행하고  
응답을 만들어준다.

---

## WAS 역할

- HTTP 요청 수신
- 요청 분석
- 적절한 애플리케이션 코드 실행
- HTTP 응답 생성
- 멀티스레드 처리
- 세션 관리
- 서블릿 관리

---

## 직접 만든 HTTP 서버와 WAS

직접 만든 HTTP 서버는 HTTP 요청과 응답의 원리를 이해하기 위한 학습용이다.

실무에서는 Tomcat 같은 WAS가  
HTTP 요청 처리, 스레드 관리, 서블릿 실행 등을 대신 처리해준다.

---

# 전체 흐름 정리

이번 단원에서는 다음 흐름을 학습했다.

1. HTTP 기본 이론을 이해한다.
2. HTTP 메서드를 학습한다.
3. Socket과 ServerSocket으로 HTTP 서버를 직접 만든다.
4. 동시 요청 처리를 위해 스레드를 사용한다.
5. URL 인코딩과 디코딩을 이해한다.
6. HTTP 요청과 응답을 객체로 분리한다.
7. 커맨드 패턴으로 요청 처리 구조를 개선한다.
8. 웹 애플리케이션 서버가 왜 등장했는지 이해한다.

---

# 핵심 정리

1. HTTP는 클라이언트와 서버가 데이터를 주고받기 위한 프로토콜이다.
2. HTTP는 요청과 응답 구조로 동작한다.
3. HTTP 요청은 메서드, URL, 헤더, 바디로 구성된다.
4. HTTP 응답은 상태 코드, 헤더, 바디로 구성된다.
5. GET은 조회, POST는 등록과 처리, PUT은 전체 수정, PATCH는 부분 수정, DELETE는 삭제에 사용한다.
6. HTTP는 기본적으로 무상태 프로토콜이다.
7. HTTP 서버는 Socket과 ServerSocket으로 직접 만들 수 있다.
8. 동시에 여러 요청을 처리하려면 스레드나 스레드 풀이 필요하다.
9. URL에 한글이나 특수문자가 있으면 URL 인코딩이 필요하다.
10. 요청과 응답을 객체로 분리하면 코드가 깔끔해진다.
11. 커맨드 패턴을 사용하면 URL별 기능을 객체로 분리할 수 있다.
12. 웹 애플리케이션 서버는 HTTP 요청 처리와 애플리케이션 실행을 도와준다.
13. 직접 HTTP 서버를 만들어보면 WAS와 서블릿의 동작 원리를 이해하기 쉬워진다.
