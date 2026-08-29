# Optional

## Optional이란

Optional은 값이 있을 수도 있고 없을 수도 있음을 표현하는 객체이다.

기존에는 값이 없을 때 null을 많이 사용했다.

하지만 null을 직접 사용하면 NullPointerException이 발생할 수 있고,  
값이 없을 수 있다는 사실이 코드에 잘 드러나지 않는다.

Optional은 이런 문제를 줄이기 위해 사용한다.

---

# 옵셔널이 필요한 이유

## null 사용의 문제점

값이 없을 때 null을 반환하면 사용하는 쪽에서 매번 null 체크를 해야 한다.

예시

String name = findName();

if (name != null) {
    System.out.println(name.length());
}

null 체크를 빼먹으면 NullPointerException이 발생할 수 있다.

---

## null의 단점

- 값이 없을 수 있다는 의도가 잘 드러나지 않는다.
- null 체크를 빼먹기 쉽다.
- NullPointerException이 발생할 수 있다.
- 여러 단계로 객체를 탐색할 때 코드가 복잡해진다.

예시

member.getAddress().getCity();

중간에 member, address 중 하나라도 null이면 예외가 발생할 수 있다.

---

## Optional의 목적

Optional은 값이 없을 수도 있음을 타입으로 표현한다.

예시

Optional<String> name = findName();

이 코드를 보면  
findName()의 결과가 없을 수도 있다는 것을 바로 알 수 있다.

---

## Optional을 사용하는 이유

- null을 직접 다루는 코드를 줄일 수 있다.
- 값이 없을 수 있다는 의도가 명확해진다.
- NullPointerException 가능성을 줄일 수 있다.
- 값이 있을 때와 없을 때의 처리를 명확하게 표현할 수 있다.

---

# Optional의 생성과 값 획득

## Optional.empty()

값이 없는 Optional을 생성한다.

예시

Optional<String> optional = Optional.empty();

의미

값이 비어 있다.

---

## Optional.of()

null이 아닌 값을 담을 때 사용한다.

예시

Optional<String> optional = Optional.of("hello");

주의

Optional.of(null)을 사용하면 NullPointerException이 발생한다.

---

## Optional.ofNullable()

값이 null일 수도 있을 때 사용한다.

예시

String value = null;

Optional<String> optional = Optional.ofNullable(value);

value가 null이면 Optional.empty()가 된다.

value가 null이 아니면 Optional.of(value)가 된다.

---

## Optional 생성 정리

| 메서드 | 의미 |
|--------|------|
| Optional.empty() | 빈 Optional 생성 |
| Optional.of(value) | null이 아닌 값을 담음 |
| Optional.ofNullable(value) | null일 수도 있는 값을 안전하게 담음 |

---

## get()

get()은 Optional 안의 값을 꺼낸다.

예시

Optional<String> optional = Optional.of("hello");

String value = optional.get();

주의

Optional이 비어 있는데 get()을 호출하면 예외가 발생한다.

따라서 get()은 가능하면 직접 사용하지 않는 것이 좋다.

---

## isPresent()

값이 있으면 true를 반환한다.

예시

Optional<String> optional = Optional.of("hello");

if (optional.isPresent()) {
    System.out.println(optional.get());
}

---

## isEmpty()

값이 없으면 true를 반환한다.

예시

Optional<String> optional = Optional.empty();

if (optional.isEmpty()) {
    System.out.println("값이 없습니다.");
}

---

# Optional 값 처리

Optional은 값을 직접 꺼내서 처리하기보다  
Optional이 제공하는 메서드로 처리하는 것이 좋다.

---

## ifPresent()

값이 있을 때만 실행한다.

예시

Optional<String> optional = Optional.of("hello");

optional.ifPresent(value -> System.out.println(value));

값이 없으면 아무 일도 하지 않는다.

---

## ifPresentOrElse()

값이 있으면 첫 번째 동작을 실행하고,  
값이 없으면 두 번째 동작을 실행한다.

예시

optional.ifPresentOrElse(
        value -> System.out.println(value),
        () -> System.out.println("값이 없습니다.")
);

---

## orElse()

값이 있으면 값을 반환하고,  
값이 없으면 기본값을 반환한다.

예시

String result = optional.orElse("default");

---

## orElseGet()

값이 있으면 값을 반환하고,  
값이 없으면 Supplier를 실행해서 기본값을 만든다.

예시

String result = optional.orElseGet(() -> "default");

---

## orElseThrow()

값이 있으면 값을 반환하고,  
값이 없으면 예외를 발생시킨다.

예시

String result = optional.orElseThrow(
        () -> new IllegalArgumentException("값이 없습니다.")
);

---

## map()

Optional 안의 값을 다른 값으로 변환한다.

값이 있으면 변환하고,  
값이 없으면 빈 Optional을 유지한다.

예시

Optional<String> optional = Optional.of("hello");

Optional<Integer> result = optional.map(value -> value.length());

결과

Optional[5]

---

## filter()

Optional 안의 값이 조건을 만족하면 유지하고,  
조건을 만족하지 않으면 빈 Optional로 만든다.

예시

Optional<String> optional = Optional.of("hello");

Optional<String> result = optional.filter(value -> value.length() > 3);

---

## flatMap()

Optional 안의 값을 변환할 때  
변환 결과가 다시 Optional이면 flatMap을 사용한다.

예시

Optional<Member> member = findMember();

Optional<Address> address = member.flatMap(value -> value.getAddress());

map을 사용하면 Optional<Optional<Address>>처럼 중첩될 수 있다.

flatMap은 중첩된 Optional을 평탄화한다.

---

# 즉시 평가와 지연 평가

## 즉시 평가

즉시 평가는 메서드 호출 전에 값이 먼저 계산되는 방식이다.

예시

String result = optional.orElse(createDefaultValue());

이 경우 optional에 값이 있어도  
createDefaultValue()는 먼저 실행된다.

---

## 지연 평가

지연 평가는 실제로 필요할 때만 실행되는 방식이다.

예시

String result = optional.orElseGet(() -> createDefaultValue());

이 경우 optional에 값이 있으면  
createDefaultValue()는 실행되지 않는다.

값이 없을 때만 Supplier가 실행된다.

---

## 즉시 평가와 지연 평가 차이

| 구분 | 설명 |
|------|------|
| 즉시 평가 | 필요 여부와 관계없이 먼저 실행됨 |
| 지연 평가 | 실제로 필요할 때만 실행됨 |

---

# orElse() vs orElseGet()

## orElse()

orElse()는 기본값을 직접 전달한다.

예시

String result = optional.orElse(createDefaultValue());

주의

orElse()에 전달하는 값은 즉시 평가된다.

즉, Optional에 값이 있어도 createDefaultValue()가 실행된다.

---

## orElseGet()

orElseGet()은 Supplier를 전달한다.

예시

String result = optional.orElseGet(() -> createDefaultValue());

특징

Optional에 값이 없을 때만 Supplier가 실행된다.

---

## orElse()와 orElseGet() 비교

| 메서드 | 평가 방식 | 특징 |
|--------|----------|------|
| orElse() | 즉시 평가 | 값이 있어도 기본값 생성 로직이 실행될 수 있음 |
| orElseGet() | 지연 평가 | 값이 없을 때만 기본값 생성 로직 실행 |

---

## orElse()를 사용해도 되는 경우

기본값이 단순한 값이면 orElse()를 사용해도 괜찮다.

예시

String result = optional.orElse("기본값");

---

## orElseGet()을 사용하는 것이 좋은 경우

기본값을 만드는 비용이 크거나  
메서드 호출, 객체 생성, DB 조회 같은 작업이 필요하다면 orElseGet()이 좋다.

예시

String result = optional.orElseGet(() -> findDefaultName());

---

# 실전 활용 - 주소 찾기

## null을 사용하는 주소 찾기

회원의 주소에서 도시 이름을 가져온다고 가정한다.

기존 방식

Member member = findMember();

if (member != null) {
    Address address = member.getAddress();

    if (address != null) {
        String city = address.getCity();
    }
}

문제점

- null 체크가 많다.
- 코드가 길어진다.
- 핵심 로직이 잘 보이지 않는다.

---

## Optional을 사용하는 주소 찾기

Optional<Member> member = findMember();

String city = member
        .flatMap(value -> value.getAddress())
        .map(address -> address.getCity())
        .orElse("주소 없음");

---

## 주소 찾기 흐름

1. 회원을 찾는다.
2. 회원이 있으면 주소를 찾는다.
3. 주소가 있으면 도시 이름을 꺼낸다.
4. 중간에 값이 없으면 "주소 없음"을 반환한다.

---

## flatMap을 사용하는 이유

findMember()가 Optional<Member>를 반환하고,  
getAddress()도 Optional<Address>를 반환한다고 가정하면  
map을 사용했을 때 Optional이 중첩될 수 있다.

예시

Optional<Optional<Address>>

이런 중첩을 피하려면 flatMap을 사용한다.

---

# 실전 활용 - 배송

## 배송 정보 조회 예시

주문에서 배송 상태를 조회한다고 가정한다.

주문이 없을 수도 있고,  
배송 정보가 없을 수도 있다.

기존 null 방식은 중간마다 null 체크가 필요하다.

---

## Optional을 사용한 배송 처리

Optional<Order> order = findOrder();

String deliveryStatus = order
        .flatMap(value -> value.getDelivery())
        .map(delivery -> delivery.getStatus())
        .orElse("배송 정보 없음");

---

## 배송 처리 흐름

1. 주문을 조회한다.
2. 주문이 있으면 배송 정보를 조회한다.
3. 배송 정보가 있으면 배송 상태를 조회한다.
4. 값이 없으면 기본 메시지를 반환한다.

---

## 배송비 계산 예시

Optional<Order> order = findOrder();

int deliveryFee = order
        .filter(value -> value.getPrice() < 30000)
        .map(value -> 3000)
        .orElse(0);

의미

- 주문이 있고
- 주문 금액이 30,000원 미만이면
- 배송비 3,000원을 반환한다.
- 주문이 없거나 조건에 맞지 않으면 0을 반환한다.

---

# Optional 베스트 프랙티스

## 1. 반환 타입으로 사용하는 것이 좋다

Optional은 메서드가 값을 반환할 때  
결과가 없을 수 있음을 표현하기 위해 사용하는 것이 좋다.

예시

Optional<Member> findMember(Long id)

의미

회원을 찾을 수도 있고 못 찾을 수도 있다.

---

## 2. 필드에는 Optional을 사용하지 않는 것이 좋다

엔티티나 DTO의 필드에 Optional을 사용하는 것은 권장하지 않는다.

좋지 않은 예시

class Member {
    private Optional<String> name;
}

이유

- 객체 구조가 복잡해진다.
- 직렬화나 라이브러리 사용 시 문제가 생길 수 있다.
- 필드는 실제 값을 가지는 것이 자연스럽다.

---

## 3. 메서드 파라미터로 Optional을 사용하지 않는 것이 좋다

좋지 않은 예시

void save(Optional<Member> member)

보통 파라미터는 필요한 값을 직접 받는 것이 더 명확하다.

Optional은 주로 반환 타입에서 값이 없을 수 있음을 표현할 때 사용한다.

---

## 4. 컬렉션을 Optional로 감싸지 않는 것이 좋다

좋지 않은 예시

Optional<List<Member>> findMembers()

보통 컬렉션은 값이 없으면 빈 컬렉션을 반환하는 것이 좋다.

좋은 예시

List<Member> findMembers()

결과가 없으면

List.of()

또는 빈 리스트를 반환한다.

---

## 5. Optional.get()을 직접 사용하는 것을 피한다

get()은 값이 없으면 예외가 발생한다.

Optional을 사용하는 의미가 줄어들 수 있다.

대신 다음 메서드를 사용하는 것이 좋다.

- orElse()
- orElseGet()
- orElseThrow()
- ifPresent()
- map()
- flatMap()
- filter()

---

## 6. null을 Optional에 넣지 않는다

Optional.of(null)은 예외가 발생한다.

null일 수 있는 값은 Optional.ofNullable()을 사용한다.

---

## 7. Optional을 무조건 사용하는 것은 아니다

Optional은 값이 없을 수 있음을 명확하게 표현하기 위한 도구이다.

모든 값에 Optional을 사용하는 것은 오히려 코드가 복잡해질 수 있다.

---

## 8. 복잡한 로직은 Optional 체인에 억지로 넣지 않는다

Optional의 map, flatMap, filter를 너무 길게 연결하면  
오히려 가독성이 떨어질 수 있다.

복잡한 비즈니스 로직은 별도 메서드로 분리하는 것이 좋다.

---

# Optional 사용 기준

## Optional을 사용하기 좋은 경우

- 조회 결과가 없을 수 있을 때
- null 반환을 피하고 싶을 때
- 값이 없을 수 있다는 의도를 타입으로 표현하고 싶을 때
- find 계열 메서드의 반환값

예시

Optional<Member> findById(Long id)

Optional<User> findByEmail(String email)

---

## Optional을 피하는 것이 좋은 경우

- 클래스 필드
- 메서드 파라미터
- 컬렉션 반환값
- 무조건 값이 있어야 하는 경우
- 단순히 null 체크를 피하려고 모든 곳에 사용하는 경우

---

# Optional과 Stream

Stream의 일부 최종 연산은 결과가 없을 수 있기 때문에 Optional을 반환한다.

예시

- findFirst()
- findAny()
- max()
- min()
- reduce()

예시

Optional<Integer> max = numbers.stream()
        .max(Integer::compareTo);

이 경우 numbers가 비어 있으면 최댓값이 없기 때문에 Optional.empty()가 반환된다.

---

# 핵심 정리

1. Optional은 값이 있을 수도 있고 없을 수도 있음을 표현하는 객체이다.
2. Optional은 null을 직접 다루는 코드를 줄이기 위해 사용한다.
3. Optional.empty()는 빈 Optional을 만든다.
4. Optional.of(value)는 null이 아닌 값을 담는다.
5. Optional.ofNullable(value)는 null일 수도 있는 값을 안전하게 담는다.
6. Optional.get()은 값이 없으면 예외가 발생하므로 직접 사용을 피하는 것이 좋다.
7. ifPresent()는 값이 있을 때만 동작을 실행한다.
8. orElse()는 기본값을 즉시 평가한다.
9. orElseGet()은 값이 없을 때만 Supplier를 실행하는 지연 평가 방식이다.
10. 기본값 생성 비용이 크면 orElseGet()을 사용하는 것이 좋다.
11. map()은 Optional 안의 값을 변환한다.
12. flatMap()은 Optional이 중첩되는 것을 방지한다.
13. filter()는 조건을 만족하지 않으면 빈 Optional로 만든다.
14. Optional은 주로 반환 타입에 사용하는 것이 좋다.
15. 필드, 파라미터, 컬렉션 반환값에는 Optional 사용을 피하는 것이 좋다.
16. 컬렉션은 Optional로 감싸기보다 빈 컬렉션을 반환하는 것이 좋다.
17. Optional은 값이 없을 수 있다는 의도를 명확하게 드러내기 위한 도구이다.
18. Optional을 무조건 많이 쓰는 것보다 필요한 위치에 적절히 사용하는 것이 중요하다.
