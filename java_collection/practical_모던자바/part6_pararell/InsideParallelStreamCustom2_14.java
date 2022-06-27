package java_collection.practical_모던자바.part6_pararell;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
 * date: 22.06.27
 * page: 217
 */

 import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class InsideParallelStreamCustom2_14 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        // 이 부분 추가
        ForkJoinPool customPool = new ForkJoinPool(2);

        customPool.submit(()->{
            System.out.println("Thread size = " + customPool.getParallelism());

            intList.parallelStream().forEach((value)->{
                String threadName= Thread.currentThread().getName();
    
                LocalDateTime currentTime = LocalDateTime.now();
                System.out.println(currentTime.format(formatter) + " thread name = " + threadName + "stream value = " +value );
                try{
                    TimeUnit.SECONDS.sleep(1);
                } catch(Exception e){
    
                }
            });
        }).get();
    }
}
