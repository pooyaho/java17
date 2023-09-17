package ir.digikala.session1.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private final static Object LOCK = new Object();
    private static AtomicInteger i = new AtomicInteger(0);
    private static int number = 0;

    public static void main(String[] args) {
        try (ExecutorService pool = Executors.newFixedThreadPool(10)) {
            for (int j = 0; j < 10; j++) {
                pool.submit(() -> {
                    for (int k = 0; k < 10; k++) {
                        synchronized (LOCK) {
                            number = number + 1;
                        }
                    }
                });
            }
            pool.shutdown();
            System.out.println(i.get());
        }
    }

    private static void raceCondition1() {
        try (ExecutorService pool = Executors.newFixedThreadPool(10)) {
            for (int j = 0; j < 10; j++) {
                pool.submit(() -> {
                    for (int k = 0; k < 10; k++) {
                        i.getAndIncrement();
                    }
                });
            }
            pool.shutdown();
            System.out.println(i.get());
        }
    }

}
