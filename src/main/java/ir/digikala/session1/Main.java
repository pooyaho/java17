package ir.digikala.session1;

public class Main {
    public static void main(String[] args) {
//        int[] a = {10, 6, 12, 5, 13};
        int[] a = new int[100000];
        for (int i = 0; i < 100000; i++) {
            a[i] = i;
        }

//        System.out.println("Calculator.add(1,2) = " + Calculator.add(1, 2));
//        System.out.println("Calculator.add(1,2,3,4,5,6,7,8) = " + Calculator.add(1, 2, 3, 4, 5, 6, Integer.MAX_VALUE, Integer.MAX_VALUE));
//        System.out.println("Calculator.minus(2,1) = " + Calculator.minus(2, 1));
//        System.out.println("Calculator.multiply(10, 20) = " + Calculator.multiply(10, 20));
//        System.out.println("Calculator.divide(10,3) = " + Calculator.divide(10, 3));
//        System.out.println("Calculator.findFirstPrime(10, 6, 12, 5, 13) = " + Calculator.findFirstPrime(10, 6, 12, 5, 13));
//        System.out.println("Calculator.findAllPrimes(a) = " + Arrays.toString(Calculator.findAllPrimes2(a)));
//        System.out.println("Calculator.indexOf(a,12) = " + Calculator.indexOf(a, 12));
//        System.out.println("Calculator.contains(a,50) = " + Calculator.contains(a, 50));
//        System.out.println("Calculator.reverse(a) = " + Arrays.toString(Calculator.reverse(a)));
//        System.out.println("Calculator.isEqual(Calculator.reverse(a),Calculator.reverse2(a)) = " + Calculator.isEqual(Calculator.reverse(a), Calculator.reverse2(a)));
        long l = System.currentTimeMillis();
//        System.out.println(l / (1000L * 60 * 60 * 24 * 365));
//        System.out.println("Calculator.subArray(a,1,3) = " + Calculator.toString(Calculator.subArray(a, 1, 2000)));
        System.out.println(fibonacci(50));
        long l2 = System.currentTimeMillis();
        System.out.println(l2 - l);
    }

    public static int fibonacci(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
