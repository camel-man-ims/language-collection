package java_collection.연습;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
 * date: 22.06.15
 */

public class ExecutorsTest {

    static class MyJob implements Runnable{
        String name;
        @Override
        public void run() {
            for(int i=0;i<5;i++){
                System.out.println("name = " + name + " i = " + i);
                try{
                    TimeUnit.SECONDS.sleep(1);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
        MyJob(String name){
            this.name = name;
        }
    }

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
        service.scheduleWithFixedDelay(new MyJob("Thread 1"), 1, 2, TimeUnit.SECONDS);
        service.scheduleWithFixedDelay(new MyJob("Thread 2"), 1, 2, TimeUnit.SECONDS);
        service.scheduleWithFixedDelay(new MyJob("Thread 3"), 1, 2, TimeUnit.SECONDS);
    }
}
