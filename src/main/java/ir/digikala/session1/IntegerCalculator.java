package ir.digikala.session1;

import java.util.Random;

public class IntegerCalculator extends NumericCalculator<Integer> {

    public IntegerCalculator(Integer[] arr) {
        super(arr);
    }

    public static IntegerCalculator of(Integer... a) {
        return new IntegerCalculator(a);
    }

    public static IntegerCalculator randomArray(int n) {
        if (n <= 0) {
            return null;
        }
        Integer[] result = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            result[i] = random.nextInt();
        }
        return new IntegerCalculator(result);
    }

    public IntegerCalculator remove(int index) {
        return null;
    }

    public Double avg() {
        return sum() / arr.length;
    }

    public void bubbleSort() {
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

    public int compare(Integer[] b) {
        int n = of(arr.length, b.length).min();
        for (int i = 0; i < n; i++) {
            if (arr[i] > b[i]) {
                return 1;
            } else if (arr[i] < b[i]) {
                return -1;
            }
        }
        return Integer.compare(arr.length, b.length);
    }

    public Double sum() {
        if (arr == null || arr.length == 0) {
            return null;
        }

        double sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }

    public Integer max() {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int max = Integer.MIN_VALUE;
        for (int j : arr) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }

    public Integer min() {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int min = Integer.MAX_VALUE;
        for (int j : arr) {
            if (j < min) {
                min = j;
            }
        }
        return min;
    }


    public IntegerCalculator subArray(int from, int to) {
        if (arr.length == 0) {
            return null;
        }
        if (to < from) {
            return null;
        }
        if (from < 0) {
            return null;
        }
        if (from >= arr.length || to >= arr.length) {
            return null;
        }
        Integer[] result = new Integer[to - from + 1];
        int index = 0;
        for (int i = from; i <= to; i++) {
            result[index++] = arr[i];
        }
        return new IntegerCalculator(result);

    }

    @Override
    public String toString() {
        if (arr == null) {
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
        for (int i : arr) {
            result.append(i).append(", ");
        }
        if (!result.toString().equals("[")) {
            result.delete(result.length() - 2, result.length());
        }
        result.append("]");
        return result.toString();
    }

    public boolean equals(int[] b) {
        if (arr.length != b.length) {
            return false;
        }
        if (arr.length == 0) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public IntegerCalculator reverse() {
        Integer[] result = new Integer[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            result[arr.length - 1 - i] = arr[i];
        }
        return new IntegerCalculator(result);
    }

    public int[] reverse2() {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[arr.length - 1 - i] = arr[i];
        }
        return result;
    }

    public boolean contains(Integer item) {
        return indexOf(item) >= 0;
    }

    public int indexOf(Integer item) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public IntegerCalculator findAllPrimes() {
        Integer[] result = new Integer[arr.length];
        int index = 0;
        for (int i : arr) {
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
        return new IntegerCalculator(temp);
    }

    public Integer[] findAllPrimes2() {
        int count = 0;
        for (int i : arr) {
            if (isPrime(i)) {
                count++;
            }
        }
        Integer[] result = new Integer[count];
        int index = 0;
        for (int i : arr) {
            if (isPrime(i)) {
                result[index] = i;
                index += 1;
            }
        }
        return result;
    }

    public Integer findFirstPrime() {
        for (int i : arr) {
            if (isPrime(i)) {
                return i;
            }
        }
        return null;
    }

    private boolean isPrime(int i) {
        int count = 0;
        for (int j = 1; j <= (i / 2); j++) {
            if (i % j == 0) {
                count++;
            }
        }
        return count == 1;
    }

}
