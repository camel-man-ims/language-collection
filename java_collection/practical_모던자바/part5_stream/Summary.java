package java_collection.practical_모던자바.part5_stream;

import java.util.*;

public class Summary {
    public static void main(String[] args) {
        
        System.out.println("1. Map에서의 순회");
        Map<String,Integer> map = new HashMap<>();
        map.put("A",1);
        map.put("B",2);
        map.put("C",3);
        map.forEach((key,value) -> System.out.println("key = " + key + " value = " + value)); 

        Comparator<Integer> comp = (o1, o2) -> Integer.compare(o2,o1);
        
    }
}
