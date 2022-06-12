import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        
        Integer putIfAbsent = map.putIfAbsent(1, 2);
        System.out.println(map);
    }
}
