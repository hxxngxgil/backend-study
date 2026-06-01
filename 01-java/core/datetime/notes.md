# Date & Time (날짜와 시간)

## 날짜와 시간 라이브러리가 필요한 이유

날짜와 시간 계산은 매우 복잡하다.

예시

- 윤년
- 월별 일수 차이
- 타임존
- 서머타임

직접 구현하기 어렵기 때문에 자바는 java.time 패키지를 제공한다.

---

## 시간의 두 가지 개념

날짜와 시간은 크게 두 가지로 구분할 수 있다.

### 1. 특정 시점의 시간 (시각)

예시

- 2025-06-15 13:00:00

특정한 한 순간을 의미한다.

---

### 2. 시간의 간격 (기간)

예시

- 3일
- 5시간
- 10분

시간이 얼마나 흘렀는지를 의미한다.

---

## java.time 주요 클래스

### LocalDate

날짜만 표현

예시

2025-06-15

---

### LocalTime

시간만 표현

예시

13:30:00

---

### LocalDateTime

날짜와 시간을 함께 표현

예시

2025-06-15T13:30:00

타임존 정보는 포함하지 않는다.

---

## ZonedDateTime

날짜 + 시간 + 타임존

예시

Asia/Seoul

타임존이 필요한 경우 사용한다.

---

## Instant

기계 중심의 시간 표현

UTC 기준으로 시간을 저장한다.

시스템 간 시간 비교 및 서버에서 많이 사용한다.

---

## 기간과 시간 간격

### Period

날짜 기준 간격

예시

- 1년
- 2개월
- 3일

---

### Duration

시간 기준 간격

예시

- 5시간
- 30분
- 10초

---

## 날짜와 시간의 핵심 인터페이스

### Temporal

날짜와 시간을 표현하는 기본 인터페이스

---

### TemporalAccessor

날짜/시간 정보 조회 기능 제공

---

### TemporalAdjuster

날짜 조정 기능 제공

---

## 시간 단위

### TemporalUnit

시간 단위를 표현하는 인터페이스

---

### ChronoUnit

자바에서 제공하는 시간 단위 구현체

예시

- YEARS
- MONTHS
- DAYS
- HOURS
- MINUTES
- SECONDS

---

## 날짜와 시간 조회

예시

year
month
day
hour
minute

각 정보를 개별적으로 조회 가능하다.

---

## 날짜와 시간 조작

날짜와 시간 객체는 불변 객체이다.

값을 변경하면 새로운 객체가 생성된다.

예시

date.plusDays(10)
date.minusMonths(1)

---

## with()

특정 값을 변경할 때 사용한다.

예시

date.withYear(2030)

→ 연도만 변경

기존 객체는 변경되지 않는다.

---

## TemporalAdjusters

자주 사용하는 날짜 계산 기능 제공

주요 기능

### firstDayOfMonth()

해당 월의 첫 번째 날

---

### lastDayOfMonth()

해당 월의 마지막 날

---

### next()

다음 특정 요일

---

### previous()

이전 특정 요일

---

## 날짜와 시간 비교

### equals()

객체 자체 비교

날짜, 시간, 타임존 등 모든 정보가 동일해야 한다.

---

### isEqual()

실제 시각이 같은지 비교

타임존이 달라도 같은 순간이면 true

---

## equals() vs isEqual()

equals()
- 객체 자체 비교
- 타입과 타임존까지 비교

isEqual()
- 실제 시각 비교
- 타임존이 달라도 같은 순간이면 true

---

## 날짜와 시간 파싱

문자열 → 날짜 객체

예시

LocalDate.parse("2025-06-15")

---

## 날짜와 시간 포맷팅

날짜 객체 → 문자열

예시

DateTimeFormatter

yyyy-MM-dd
yyyy/MM/dd

원하는 형식으로 출력 가능

---

## 핵심 정리

1. 시간은 시각(Point in Time)과 기간(Time Interval)으로 구분한다.
2. LocalDateTime은 날짜와 시간을 표현한다.
3. ZonedDateTime은 타임존 정보를 포함한다.
4. Instant는 UTC 기반의 기계 중심 시간이다.
5. Period는 날짜 간격, Duration은 시간 간격을 표현한다.
6. 날짜/시간 객체는 불변 객체이다.
7. with()는 특정 값을 변경한 새로운 객체를 반환한다.
8. TemporalAdjusters는 자주 사용하는 날짜 계산 기능을 제공한다.
9. equals()는 객체 비교, isEqual()은 실제 시각 비교이다.
10. parse()는 파싱, DateTimeFormatter는 포맷팅에 사용한다.
