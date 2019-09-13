package qthree;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        var fl = new AdvancedFilteredList<Integer>((List<Integer> list, Integer element) -> {

            list.stream().forEach((Integer i) -> {
                                  if (Math.abs(element) % i == 0) {
                                      System.out.println("Already have factor in list");
                                      throw new IllegalArgumentException("Illegal Arg");
                                  }
                              }
                             );
            return element;
        });

        fl.add(2);

        fl.add(4);

        fl.forEach(System.out::println);
    }
}
