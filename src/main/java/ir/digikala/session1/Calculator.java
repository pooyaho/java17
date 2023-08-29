package ir.digikala.session1;

import java.util.ArrayList;
import java.util.Random;

public class Calculator {
    public static double avg(ArrayList<Integer> a) {
        return (double) sum(a) / a.size();
    }

    public static void bubbleSort(int[] arr) {
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for (j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }
//
//            // If no two elements were
//            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }
    }

    public static int compare(int[] a, int[] b) {
        int n = min(of(a.length, b.length));
        for (int i = 0; i < n; i++) {
            if (a[i] > b[i]) {
                return 1;
            } else if (a[i] < b[i]) {
                return -1;
            }
        }
        return Integer.compare(a.length, b.length);
    }

    public static int[] of(int... a) {
        return a;
    }

    public static int[] randomArray(int n) {
        if (n <= 0) {
            return null;
        }
        int[] result = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            result[i] = random.nextInt();
        }
        return result;
    }

    public static Long sum(ArrayList<Integer> a) {
        if (a == null || a.isEmpty()) {
            return null;
        }

        Long sum = 0L;
        for (int i : a) {
            sum += i;
        }
        return sum;
    }

    public static Integer max(int[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        int max = Integer.MIN_VALUE;
        for (int j : a) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }

    public static Integer min(int[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        int min = Integer.MAX_VALUE;
        for (int j : a) {
            if (j < min) {
                min = j;
            }
        }
        return min;
    }

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
        if (a == null) {
            return "";
        }
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

    public static Integer findFirstPrime(int[] a) {
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
