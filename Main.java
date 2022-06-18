import java.util.HashMap;
import java.util.Map;

public class Main {

    static int recurse(int n){
        if(n<=1) return n;
        int sum = 0;
        sum += recurse(n-1) + n;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(Main.recurse(10));
    }
}
