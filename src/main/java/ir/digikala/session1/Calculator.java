package ir.digikala.session1;

public class Calculator {

    public static long add(int[] a) {
        long sum = 0;
        for (int i : a) {
            sum += i;
        }
        return sum;
    }

    public static int[] subArray(int[] a, int from, int to) {
        if (a.length == 0) {
            return null;
        }
        if (to < from) {
            return null;
        }
        if (from < 0) {
            return null;
        }
        if (from >= a.length || to >= a.length) {
            return null;
        }
        int[] result = new int[to - from + 1];
        int index = 0;
        for (int i = from; i <= to; i++) {
            result[index++] = a[i];
        }
        return result;

    }

    public static String toString(int[] a) {
        StringBuilder result = new StringBuilder("[");
//        for (int i = 0; i < a.length; i++) {
//            if (i != a.length - 1) {
//                result += a[i] + ", ";
//            } else {
//                result += a[i];
//            }
//        }
        for (int i : a) {
            result.append(i).append(", ");
        }
        if (!result.toString().equals("[")) {
            result.delete(result.length() - 2, result.length());
        }
        result.append("]");
        return result.toString();
    }

    public static boolean isEqual(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }
        if (a.length == 0) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] reverse(int[] a) {
        int[] result = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            result[a.length - 1 - i] = a[i];
        }
        return result;
    }

    public static int[] reverse2(int[] a) {
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            result[a.length - 1 - i] = a[i];
        }
        return result;
    }

    public static boolean contains(int[] a, int item) {
        return indexOf(a, item) >= 0;
    }

    public static int indexOf(int[] a, int item) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public static Integer[] findAllPrimes(int[] a) {
        Integer[] result = new Integer[a.length];
        int index = 0;
        for (int i : a) {
            if (isPrime(i)) {
                result[index] = i;
                index += 1;
            }
        }
        int count = 0;
        for (Integer integer : result) {
            if (integer != null) {
                count++;
            } else {
                break;
            }
        }
        Integer[] temp = new Integer[count];
        for (int i = 0; i < count; i++) {
            temp[i] = result[i];
        }
        return temp;
    }

    public static Integer[] findAllPrimes2(int[] a) {
        int count = 0;
        for (int i : a) {
            if (isPrime(i)) {
                count++;
            }
        }
        Integer[] result = new Integer[count];
        int index = 0;
        for (int i : a) {
            if (isPrime(i)) {
                result[index] = i;
                index += 1;
            }
        }
        return result;
    }

    public static Integer findFirstPrime(int... a) {
        for (int i : a) {
            if (isPrime(i)) {
                return i;
            }
        }
        return null;
    }

    private static boolean isPrime(int i) {
        int count = 0;
        for (int j = 1; j <= (i / 2); j++) {
            if (i % j == 0) {
                count++;
            }
        }
        return count == 1;
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static float add(float a, float b) {
        return a + b;
    }

    public static int minus(int a, int b) {
        return a - b;

    }

    public static int multiply(int a, int b) {
        return a * b;

    }

    public static double divide(int a, int b) {
        //todo check division by zero
        return a / (double) b;
    }
}
