package ir.digikala.session1;


import ir.digikala.session1.calculators.NumericCalculator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        int[] a = {10, 6, 12, 5, 13};
//        int[] a = new int[100000];
//        for (int i = 0; i < 100000; i++) {
//            a[i] = i;
//        }
//
////        System.out.println("Calculator.add(1,2) = " + Calculator.add(1, 2));
////        System.out.println("Calculator.add(1,2,3,4,5,6,7,8) = " + Calculator.add(1, 2, 3, 4, 5, 6, Integer.MAX_VALUE, Integer.MAX_VALUE));
////        System.out.println("Calculator.minus(2,1) = " + Calculator.minus(2, 1));
////        System.out.println("Calculator.multiply(10, 20) = " + Calculator.multiply(10, 20));
////        System.out.println("Calculator.divide(10,3) = " + Calculator.divide(10, 3));
////        System.out.println("Calculator.findFirstPrime(10, 6, 12, 5, 13) = " + Calculator.findFirstPrime(10, 6, 12, 5, 13));
////        System.out.println("Calculator.findAllPrimes(a) = " + Arrays.toString(Calculator.findAllPrimes2(a)));
////        System.out.println("Calculator.indexOf(a,12) = " + Calculator.indexOf(a, 12));
////        System.out.println("Calculator.contains(a,50) = " + Calculator.contains(a, 50));
////        System.out.println("Calculator.reverse(a) = " + Arrays.toString(Calculator.reverse(a)));
////        System.out.println("Calculator.isEqual(Calculator.reverse(a),Calculator.reverse2(a)) = " + Calculator.isEqual(Calculator.reverse(a), Calculator.reverse2(a)));
////        System.out.println(l / (1000L * 60 * 60 * 24 * 365));
////        System.out.println("Calculator.subArray(a,1,3) = " + Calculator.toString(Calculator.subArray(a, 1, 2000)));
////        System.out.println(fibonacci(50));
//        int[] randomArray = Calculator.randomArray(10000000);
////        System.out.println("Calculator.toString(Calculator.randomArray(10)) = " + Calculator.toString(randomArray));
////        System.out.println("Calculator.max(a) = " + Calculator.max(randomArray));
//
//        int[][] arr = new int[2][3];
//        for (int i = 0; i < 2; i++) {
//            for (int j = 0; j < 3; j++) {
//                arr[i][j] = i * j;
//            }
//        }
////        System.out.println(Arrays.toString(arr));
//        for (int i = 0; i < 2; i++) {
//            StringBuilder s = new StringBuilder();
//            for (int j = 0; j < 3; j++) {
//                s.append(j).append(" ");
//            }
//            System.out.println(s);
//        }
//        long l = System.currentTimeMillis();
////        System.out.println("Calculator.sum(randomArray) = " + Calculator.sum(randomArray));
////        Arrays.sort(randomArray);
//
////        Calculator.bubbleSort(randomArray);
////        System.out.println("Calculator.toString(randomArray) = " + Calculator.toString(randomArray));
//        System.out.println("Calculator.avg(randomArray) = " + Calculator.avg(Calculator.of(1, 3, 5, 2)));
//        long l2 = System.currentTimeMillis();
//        System.out.println(l2 - l);
        LinkedList<Integer> arrayList = new LinkedList<>();
        List<Integer> list = arrayList;
        ArrayList<Integer> list1 = (ArrayList<Integer>) (list);
        for (int i = 0; i < 100; i++) {
            arrayList.add(i);
        }
// revolutionary os
        int sum = 0;
        for (Integer i : arrayList) {
            sum += i;
        }
        System.out.println(sum);

//        LinkedList<Integer> linkedList = new LinkedList<>();
//        HashSet<Integer> set = new HashSet<>();
//        set.add(12);
//        set.add(13);
//        set.add(456);
//        HashMap<String, String> map = new HashMap<>();
//        map.put("name", "Ali");
//        map.put("family", "Alavi");
//        map.put("nationalCode", "1234567890");
//        System.out.println(map.get("nationalCode"));


// immutable or mutable
//        String s = "Hello";


//        System.out.println(s);
        Integer[] ints = scanner1();
        doOperation(ints);
//        for (Integer anInt : ints) {
//            ints.remove(anInt);
//        }
//        doOperation(ints);
    }

    private static void doOperation(Integer[] ints) {
        boolean shouldBreak = false;
        while (!shouldBreak) {
            System.out.println("Select one of below commands");
            System.out.println("0) Quit");
            System.out.println("1) Average");
            System.out.println("2) Sum");

            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();
            NumericCalculator calculator = new IntegerCalculator(ints);
            switch (i) {
                case 0 -> {
                    shouldBreak = true;
                }
                case 1 -> {
                    double avg = calculator.avg();
                    System.out.println("Average is " + avg);
                }
                case 2 -> {
                    Double sum = calculator.sum();
                    System.out.println("Sum is " + sum);
                }
                default -> System.err.println("Invalid input");
            }
        }
    }

    private static Integer[] scanner1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Array items in space separated format");
        String s = scanner.nextLine();
        if (s == null || s.trim().isEmpty() || containsNonNumeric(s)) {
            throw new IllegalArgumentException();
        }
        String[] strings = s.split(" ");
        ArrayList<Integer> ints = new ArrayList<>();

        for (String string : strings) {
            ints.add(Integer.parseInt(string));
        }
        System.out.println("Input is " + ints);
        return ints.toArray(new Integer[0]);
    }

    private static boolean containsNonNumeric(String s) {
        boolean result = true;
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private static ArrayList<Integer> scanner2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input size of array");
        int n = scanner.nextInt();
        ArrayList<Integer> ints = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Input the " + (i + 1) + "th number");
            int a = scanner.nextInt();
            ints.add(a);
        }

        System.out.println("Input is " + ints);
        return ints;
    }

    public static int fibonacci(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}


