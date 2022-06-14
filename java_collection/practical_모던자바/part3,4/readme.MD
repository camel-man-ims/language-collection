# Part3: 인터페이스 사용 이유

## 인터페이스

* 여행사 관련 프로그램이 있다고 가정해보자.
* 여행사 입장에서 검색 조건을 여러 개 둘 수 있다.
	* 도시 이름, 항공사명, 가격 등등
* 그런데 아래와 같이 코드를 짜면 크게 두가지 문제점이 생긴다.
	1. 코드 중복이 상당히 일어난다.
	2. API가 빈번히 수정된다.

```java
list <- store TravelInfos

# N <- means cityname, travel's name, price,....
List<TravelInfo> findByN(String keyword){
	for(TravelInfo info : list){
		if info.equals(info.getCityName(keyword):
			result.add(info)
	}
	return result
}
```

* 그래서 인터페이스가 등장했다.
	* 정보와 로직을 분리한다는 개념에서 시작됐다.
* 조회 조건을 여행사 클래스에서 전부 제공하는게 아니라, ~사용하는 쪽에서 함수를 만들어 클래스에 제공~ 한다.

```java
public interface Filter{
	boolean isMatched(CustomInterface in)
}
```

* 위와 같이 인터페이스 규격만 제공하고, 어떤 조건에 따라 검색할 지는 사용자에게 맡긴다.
* 위와 같이 인터페이스에 ~하나의 메서드만 정의한 것~ 을 함수형 인터페이스라고 한다.

```java
list <- store TravelInfos

# N <- means cityname, travel's name, price,....
List<TravelInfo> findByN(CustomInteface in){
	for(TravelInfo info : list){
		if info.isMatched(info) :
			result.add(info)
	}
	return result
}
```

* 위와 같이 사용할 수 있다.

# Part4 : 함수형 인터페이스

## 함수형 인터페이스 4가지
> 인터페이스 = 행동

* 행동을 정의한 것을 실행한다.

> function -> 적용 apply
> 소비자 consumer -> 받아들임 accpet

* Consumer
	* accept
	* 받아들인다.
	* 전달되는 함수를 실행한다.

```java
void func(String s, Consumer<String> consumer):
	consumer.accept(s)

func("a",(input)->System.out.println(input))
```

* Function
	* apply
	* 실행한다.
	* `input` 제네릭과, `output` 제네릭이 존재한다.

```java
int func(String s, Function<String,Integer> function):
	return function.apply(s)

func("a",(input) -> input.length())
```

* Predicate
	* test
	* 예측한다.
	* boolean 값으로 해당 실행결과를 반환한다.

```java
boolean func(String s, Predicate<String> predicate):
	return predicate.test(s)

func("abc", (input) -> input.length() > 3)
```

* Supplier
	* get
	* 공급한 것을 가져간다.
	* 지정된 정보를 확인하거나 조회한다.

```java
String func(Supplier<String> supplier):
	return supplier.get()

func(()->return "abcd")
```

## 기본형 인터페이스
* jvm 입장에서 auto boxing/ auto unboxing은 비용이 굉장히 많이 드는 작업이다.
* 그래서 데이터 타입이 정의된 인터페이스를 사용할 수 있다.
	* 타입을 미리 지정해서 받기 때문에 generic을 받지 않는다.

```java
func (int i, IntPredicate p):
	return p.test(i)

func("4, (i) -> i >=3)
```

> operator class는 일단 패스

## 메서드 참조
### 정적, 비한정적, 한정적 ( 98p )
* 정적
```java
Integer.parseInt(“1”)
```
->
```java
Integer::parseInt
```

* 비 한정적
```java
(String s) -> s.toLowerCase()
```
를 메서드 참조로 바꾸면
```java
s.toLowerCase()
```
로 바꿔야 하는데 이는 변수를 선언한 적이 없기 때문에 불가능하다.
그래서
```java
String.toLowerCase()
```
로 하는 것이다. 이를 변수 이름을 참조하지 않는다고 해서 비 한정적이라고 한다.

* 한정적
```java
Calender cal = Calender.getInstance()
cal::getTime
```
지정된 객체에 대해 메서드 참조를 할 경우, 실제 존재하는 인스턴스에 대해 한정적으로 참조했으므로 한정적 메서드 참조라고 한다.

* 생성자
	* 생성자의 경우
```java
클래스명::new
```

### 함수형 인터페이스 조합
* andThen, and, Or 등의 메서드를 통해 인터페이스를 연결할 수 있다.
	* 아직 정확하지는 않지만, stream() 도 이렇게 돌아가지 않을까 싶다.

