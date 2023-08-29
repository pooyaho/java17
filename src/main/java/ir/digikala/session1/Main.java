package ir.digikala.session1;

import java.util.Arrays;
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

        int[] ints = scanner1();
        doOperation(ints);
    }

    private static void doOperation(int[] ints) {
        boolean shouldBreak = false;
        while (!shouldBreak) {
            System.out.println("Select one of below commands");
            System.out.println("0) Quit");
            System.out.println("1) Average");
            System.out.println("2) Sum");

            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();
            switch (i) {
                case 0 -> {
                    shouldBreak = true;
                }
                case 1 -> {
                    double avg = Calculator.avg(ints);
                    System.out.println("Average is " + avg);
                }
                case 2 -> {
                    Long sum = Calculator.sum(ints);
                    System.out.println("Sum is " + sum);
                }
                default -> System.err.println("Invalid input");
            }
        }
    }

    private static int[] scanner1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Array items in space separated format");
        String s = scanner.nextLine();
        String[] strings = s.split(" ");
        int[] ints = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }
        System.out.println("Input is " + Arrays.toString(ints));
        return ints;
    }

    private static int[] scanner2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input size of array");
        int n = scanner.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Input the " + (i + 1) + "th number");
            int a = scanner.nextInt();
            ints[i] = a;
        }

        System.out.println("Input is " + Arrays.toString(ints));
        return ints;
    }

    public static int fibonacci(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
