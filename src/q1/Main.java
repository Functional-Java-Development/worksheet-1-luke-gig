package q1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntUnaryOperator;

public class Main {

    private static int generateRand(int i) {
            return (int) (Math.random() * 90);
    }

    public static void main(String[] args) {

//        a
        var arr = new Integer[100];

//         lambda
        IntUnaryOperator gen = (i) -> (int) (Math.random() * 90);


//        Arrays.setAll(arr, gen);

// method reference
        Arrays.setAll(arr, Main::generateRand);

//        print out
        System.out.println(Arrays.toString(arr));

//        c
        Comparator<Integer> cmp = (Integer a, Integer b) -> {
            if(String.valueOf(a).length() == String.valueOf(b).length()){
                return Integer.compare(a, b);
            }
            return Integer.compare(b, a);
        };

//        d
        Arrays.sort(arr, cmp);

//        e
        System.out.println(Arrays.toString(arr));

    }
}
