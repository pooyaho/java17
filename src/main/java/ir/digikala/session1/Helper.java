package ir.digikala.session1;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface Filter<T> {
    boolean filter(T item);
}

@FunctionalInterface
interface ForEach<T> {
    void forEach(T item); //todo add foreach to linked list
}

@FunctionalInterface
interface Map<T> {
    T map(T item);
}

public class Helper {
    public static Double sum(List<? extends Number> list) {
        double temp = 0;
        for (Number t : list) {
            temp += Double.parseDouble(t.toString());
        }
//        int a = 0b11101;
//        int b = 0xaaf;
        return temp;
    }

    public static void main2(String[] args) {
        List<Long> integers = new ArrayList<>();
        List<? extends Number> a = integers;
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integers.add((long) i);
        }
        System.out.println(sum(integers));

//        Runnable r = () -> {
//            int i = 0;
//            System.out.println("Hello from function!");
//            i = 10;
//        };

    }

    public static List<Integer> filter(List<Integer> list, Filter<Integer> f) {
        List<Integer> temp = new ArrayList<>();
        for (Integer i : list) {
            if (f.filter(i)) {
                temp.add(i);
            }
        }
        return temp;
    }

    public static List<Integer> map(List<Integer> list, Map<Integer> f) {
        List<Integer> temp = new ArrayList<>();
        for (Integer i : list) {
            temp.add(f.map(i));
        }
        return temp;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(filter(list, item -> item % 2 == 0));
        System.out.println(map(list, item -> item + 2));
    }
}