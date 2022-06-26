# Thread 기본

> * [ThreadImpl: Thread 상속](./ThreadImpl.java)
> * [ThreadImplRunnable: Runnable 상속](./ThreadImplRunnable.java)

## 1. Thread 구현 방법

* thread를 상속받거나, runnable을 상속받은 다음 `run()` 메서드를 overriding해준다.
  * thread를 상속받은 경우, 해당 객체를 만들어서 `start()` 메서드를 실행시켜주면 `run()` 메서드가 호출된다.
  * runnable을 상속받은 경우, `Thread` 객체를 생성한 다음에 runnable을 상속받아서 구현한 해당 객체를 넘겨주면 된다.
    * 이 역시 `start()` 메서드를 통해 실행시켜주면 된다.