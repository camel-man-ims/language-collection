# 5장

## Filter 예제

> [StreamDistinctExample2](./StreamDistinctExample2.java)

*예제코드에 대한 설명*
* filter시 `distinctByKey` 메서드 호출

```java
public static <T> Predicate<T> distinctByKey(Function<? super T,?> key){
    Map<Object,Boolean> seen = new ConcurrentHashMap<>();
    return t -> seen.putIfAbsent(key.apply(t),Boolean.TRUE) == null;
}
```

```java
personList.stream().filter(distinctByKey(b -> (b.name + b.age))).forEach(System.out::println);
```

* 해당 상황에서 `filter` 나 `distinctByKey`가 여러 번 호출된다고 생각할 수 있으나, 그렇지 않다.
  * `distinctByKey` 에서 반환하는 `Predicate` 객체의 `test` 메서드가 여러 번 호출되는 것이다.

## Map 순회

> *[MapIterator](./MapIteratorExample.java)

* iterator 방식
* map Entry 방식
* keyset 방식
* forEach 방식

## forEach를 stream API를 사용할 때 장점

* 만약 map함수를 순회한다고 해보자.
* map 함수를 순회하면서 forEach문 안에 값을 추가/삭제 하는 경우가 있을 수 있는데, Stream API를 사용하면 해당 상황을 방지할 수 있다.

## Stream 메서드들

> * [StreamMapExample](./StreamMapExample.java)
> * [StreamSoretedExample](./StreamSortedExample2.java)
> * [StreamCollectExample](./StreamCollectExample.java)
> * [StreamCollectors](./StreamCollectors.java)

* map, forEach, filter, collect, sorted 등이 가장 많이 사용된다.
  * collect의 경우 Collector interface를 상속받은 Collectors가 구현체이다.
  * `Collectors.toCollection(ArrayList::new)` 형태
    * 위를 축약해서
    * `Collectors.toList()` 등으로 사용할 수도 있다.

* `객체::메서드이름` 을 하면 해당 메서드가 반환됨을 기억하자.
* `Comparator.comparing(Person::getName)` 을 하면 name을 기준으로 정렬을 해준다.
  * 이 때 getter가 정의돼있어야 한다.

## Match

> *[Match](./Match.java)

* `allMatch`, `anyMatch`, `noneMatch`
  * 모두 맞을 때, 하나라도 맞는 게 있을 때
  * return boolean

## Find

> *[Find](./Find.java)
> *

* `findAny`, `findFirst`
  * findAny -> 아무거나 맞는 값 반환
  * findFirst -> 첫번째 값 반환
    * 정렬이 돼 있다는 가정하에 사용해야 한다.
  * 데이터 값에 대한 검증을 할 때 유용

## Stream 안에서 값 더하기

* int[] 이용
* mapToInt(Integer::intValue)
* collect(Collectors.summingInt(Integer::intValue)) 이용
* reduce 이용
  * reduce(0,Integer::sum)
  * reduce(0,(x,y) -> x+y)

## reduce

> *[Reduce](./Reduce.java)

* 최종연산 중 모두 순회해야 출력이 되는 형태를 reduce라고 한다.
* reduce의 동작방식
  * (초기값, (x,y) -> 연산)
  * x에 누적값 쌓여가는 방식