# 5장

## Filter 예제

> [코드](./StreamDistinctExample2.java)

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

## forEach를 stream API를 사용할 때 장점

* 만약 map함수를 순회한다고 해보자.
* map 함수를 순회하면서 forEach문 안에 값을 추가/삭제 하는 경우가 있을 수 있는데, Stream API를 사용하면 해당 상황을 방지할 수 있다.

## Stream 메서드들

* map, forEach, filter, collect, sorted 등이 가장 많이 사용된다.
  * collect의 경우 Collector interface를 상속받은 Collectors가 구현체이다.
  * `Collectors.toCollection(ArrayList::new)` 형태
    * 위를 축약해서
    * `Collectors.toList()` 등으로 사용할 수도 있다.

* `객체::메서드이름` 을 하면 해당 메서드가 반환됨을 기억하자.
* `Comparator.comparing(Person::getName)` 을 하면 name을 기준으로 정렬을 해준다.
  * 이 때 getter가 정의돼있어야 한다.


