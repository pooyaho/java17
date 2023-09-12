package ir.digikala.session1.calculators;

import ir.digikala.session1.exceptions.EmptyArrayException;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

        Random random = new Random();
        Integer[] array1 = random.ints(n, 0, 10000)
                .boxed()
                .toArray(Integer[]::new);

        Integer[] array = IntStream.generate(() -> random.nextInt(0, 10000))
                .limit(n)
                .boxed()
                .toArray(Integer[]::new);
        return new IntegerCalculator(array1);
//        Integer[] result = new Integer[n];
//
//        for (int i = 0; i < n; i++) {
//            result[i] = random.nextInt();
//        }
//        return new IntegerCalculator(result);
    }

    public static void main(String[] args) throws EmptyArrayException {
//        Integer[] m = null;
//        Integer[] integers = Optional.ofNullable(m)
//                .filter(i -> i.length > 0)
//                .orElse(new Integer[]{1, 2, 3});
//                .orElseThrow(() -> new EmptyArrayException("You should fill input array"));
//        System.out.println(Arrays.toString(integers));
        int count = 0;
        IntStream.generate(() -> new Random().nextInt())
                .limit(10)
                .mapToObj(i -> new Student(String.valueOf(i), "Ali"))
                .sorted(/*(i, j) -> {
                    return i.getNationalCode().compareTo(j.getNationalCode());
                }*/)
                .forEach(i -> {
                    System.out.println(count);
                    System.out.println(i);
                });


        IntegerCalculator integerCalculator = IntegerCalculator.randomArray(10);

        System.out.println(integerCalculator.toString());
        Integer[] array = new Integer[]{1, 1, 1, 2, 3, 4, 5, 6, 7, 10, 201};
        System.out.println(Arrays.stream(array)
                .distinct()
                .reduce(IntegerCalculator::add)
                .get());
        Arrays.stream(array)
                .filter(i -> i % 2 == 0)
                .map(i -> i * 2)
                .forEach(i -> System.out.println(i));

        System.out.println(Arrays.stream(array)

                .map(i -> "Hello " + i)
                .distinct()
                .toList());

        System.out.println(Arrays.stream(array)
                .filter(i -> {
                    if (i % 2 == 0) {
                        return true;
                    } else {
                        return false;
                    }
                })
                .distinct()
                .reduce((i, j) -> i + j)
                .get());

        System.out.println(Arrays.stream(array)
                .map(i -> i.toString())
                .collect(Collectors.joining(", ", "[", "]")));

//        IntegerCalculator ic = new IntegerCalculator(new Integer[]{});
//        try {
//            System.out.println(ic.avg());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public static int add(int a, int b) {
        return a + b;
    }

    @Override
    public void add(Integer item) {

    }

    @Override
    public void set(int index, Integer item) {

    }

    public void remove(int index) {

    }

    public Double avg() {
        try {
            return sum() / arr.length;
        } catch (EmptyArrayException e) {
            throw new RuntimeException("Error in sum method", e);
        }
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

    public int compare(Integer[] b) throws EmptyArrayException {
        Objects.requireNonNull(b);
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

    public Double sum() throws EmptyArrayException {
//        if (arr == null) {
//            throw new RuntimeException("Array is empty");
//            throw new EmptyArrayException("You should fill input array");
//        }
        Integer[] integers = Optional.of(arr)
                .filter(i -> i.length > 0)
                .orElseThrow(() -> new EmptyArrayException("You should fill input array"));
        return Arrays.stream(integers)
                .map(i -> (double) i)
                .reduce((i, j) -> i + j)
                .get();

    }

    public Integer max() throws EmptyArrayException {
        if (arr == null || arr.length == 0) {
            throw new EmptyArrayException();
        }
        return Arrays.stream(arr)
                .reduce((i, j) -> {
                    if (i > j) {
                        return i;
                    }
                    return j;
                })
                .get();


    }

    public Integer min() throws EmptyArrayException {
        if (arr == null || arr.length == 0) {
            throw new EmptyArrayException();
        }
        return Arrays.stream(arr)
                .reduce((i, j) -> {
                    if (i < j) {
                        return i;
                    }
                    return j;
                })
                .get();
    }

    /**
     * Returns a sub array from the base array
     *
     * @param from from index
     * @param to   to index
     * @return The equivalent generic type of class
     * @throws EmptyArrayException if the input array is empty or null
     */
    public IntegerCalculator subArray(int from, int to) throws EmptyArrayException {
        if (arr == null || arr.length == 0) {
            throw new EmptyArrayException();
        }
        if (to < from) {
            throw new IllegalArgumentException("to argument is smaller than from");
        }
        if (from < 0) {
            throw new IllegalArgumentException("from argument should greater than or equal zero");
        }
        if (from >= arr.length || to >= arr.length) {
            throw new IllegalArgumentException("from and to arguments should between size of array");
        }
        Integer[] array = Arrays.stream(arr)
                .skip(from)
                .limit(to - from)
                .toArray(Integer[]::new);
        return new IntegerCalculator(array);
//        Integer[] result = new Integer[to - from + 1];
//        int index = 0;
//        for (int i = from; i <= to; i++) {
//            result[index++] = arr[i];
//        }
//        return new IntegerCalculator(result);

    }

    @Override
    public String toString() {
        if (arr == null) {
            return "";
        }
//        StringBuilder result = new StringBuilder("[");
//        for (int i = 0; i < a.length; i++) {
//            if (i != a.length - 1) {
//                result += a[i] + ", ";
//            } else {
//                result += a[i];
//            }
//        }
        return Arrays.stream(arr)
                .map(i -> i.toString())
                .collect(Collectors.joining(",", "[", "]"));

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
        return Arrays.stream(arr)
                .anyMatch(i -> i.equals(item));
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
        Integer[] array = Arrays.stream(arr)
                .filter(i -> isPrime(i))
                .toArray(Integer[]::new);
        return new IntegerCalculator(array);

//        Integer[] result = new Integer[arr.length];
//        int index = 0;
//        for (int i : arr) {
//            if (isPrime(i)) {
//                result[index] = i;
//                index += 1;
//            }
//        }
//        int count = 0;
//        for (Integer integer : result) {
//            if (integer != null) {
//                count++;
//            } else {
//                break;
//            }
//        }
//        Integer[] temp = new Integer[count];
//        for (int i = 0; i < count; i++) {
//            temp[i] = result[i];
//        }
//        return new IntegerCalculator(temp);
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
//        int count = 0;

        return !IntStream.range(2, i / 2)
                .anyMatch(j -> i % j == 0);
//        for (int j = 1; j <= (i / 2); j++) {
//            if (i % j == 0) {
//                count++;
//            }
//        }
//        return count == 1;
    }

    static class Student implements Comparable<Student> {
        private String nationalCode;
        private String name;

        public Student(String nationalCode, String name) {
            this.nationalCode = nationalCode;
            this.name = name;
        }

        public String getNationalCode() {
            return nationalCode;
        }

        public void setNationalCode(String nationalCode) {
            this.nationalCode = nationalCode;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "nationalCode='" + nationalCode + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }


        @Override
        public int compareTo(Student o) {
            return this.getNationalCode().compareTo(o.getNationalCode());
        }
    }
}
