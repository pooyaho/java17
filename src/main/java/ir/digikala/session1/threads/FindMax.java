package ir.digikala.session1.threads;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class FindMax {


    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            syncMax();
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
    }

    private static void syncMax() {
        int n = 10000000;
        int[] array = IntStream.generate(() -> new Random().nextInt())
                .limit(n)
                .toArray();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println(max);
    }

    private static void parallelMax() {

        int n = 10000000;
        int[] array = IntStream.generate(() -> new Random().nextInt())
                .limit(n)
                .toArray();
        int nThreads = n / 1000000;
        int[] result = new int[nThreads];
        try (ExecutorService pool = new ForkJoinPool(100)) {
            for (int i = 0; i < nThreads; i++) {
                int finalI = i;
                pool.submit(() -> {
                    int max = Integer.MIN_VALUE;
                    for (int j = finalI * 2000000; j < (finalI + 1) * 2000000; j++) {
                        if (array[j] > max) {
                            max = array[j];
                        }
                    }
                    result[finalI] = max;
                });


            }
        }

        int max = Integer.MIN_VALUE;
        for (int i : result) {
            if (max < i) {
                max = i;
            }
        }
        System.out.println(max);


    }
}
