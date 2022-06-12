# 5장

## [Filter에 관한 내용](./StreamDistinctExample2.java)

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