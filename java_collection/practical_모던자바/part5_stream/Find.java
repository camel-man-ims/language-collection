package java_collection.practical_모던자바.part5_stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*
 * date: 22.06.13
 * page: 165
 */

public class Find {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,3,5,7,8);
        Optional<Integer> result = list.stream().parallel().filter(num -> num<4).findAny();
        System.out.println(result.get());
    }
}
