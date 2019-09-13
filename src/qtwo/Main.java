package qtwo;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        var fl = new FilteredList<Integer>((Integer i) -> i % 2 == 0 );

//        fl.add(23);
        fl.add(2);
        fl.add(4);
        fl.add(6);
        fl.add(8);
        fl.add(10);

        //        fl.addFirst(2);
        fl.add(2, 100);

        fl.addAll(List.of(2,4,6,8,9));

        fl.forEach(System.out::println);
    }
}
