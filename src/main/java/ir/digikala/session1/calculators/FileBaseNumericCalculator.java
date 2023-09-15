package ir.digikala.session1.calculators;

import ir.digikala.session1.exceptions.EmptyArrayException;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileBaseNumericCalculator extends NumericCalculator<Integer> {
    private final static String FILE_NAME = "integers";
    private final ExecutorService executor;
    private List<Integer> array;
    private boolean dirty = false;


    public FileBaseNumericCalculator(List<Integer> arr) {
        super(null);
        if (arr == null || arr.isEmpty()) {
            throw new IllegalArgumentException("Array is null or empty");
        }

        this.array = new ArrayList<>(this.readAllFileContent());
        this.array.addAll(arr);
        System.out.println("Array set in constructor");
        this.executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> writeToFile());
        System.out.println("Scheduled task submitted");
        this.dirty = true;
    }

    public void shutdown() {
        this.executor.shutdown();
    }

    private void writeToFile() {
        while (true) {

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Scheduled task is running with dirty " + this.dirty);
            if (this.dirty) {
                writeToFile(this.array);
                System.out.println("Array is written to file");
                this.dirty = false;
            }
        }
    }

    private void appendToFile(Integer integer) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            fw.append(String.valueOf(integer));
            fw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Integer> readAllFileContent() {
        try (Stream<String> stream = Files.lines(Paths.get(FILE_NAME))) {
            return stream.map(Integer::valueOf)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeToFile(List<Integer> array) {
        String fileContent = array
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining("\n"));
        writeToFile(fileContent);
    }

    private void writeToFile(String content) {
        try (FileWriter fw = new FileWriter(FILE_NAME)) {
            fw.write(content);
            fw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Double avg() {
        return null;
    }

    @Override
    public Double sum() throws EmptyArrayException {
        return null;
    }

    @Override
    public Integer max() throws EmptyArrayException {
        return null;
    }

    @Override
    public Integer min() throws EmptyArrayException {
        return null;
    }

    @Override
    public NumericCalculator<Integer> findAllPrimes() {
        return null;
    }

    @Override
    public Integer findFirstPrime() {
        return null;
    }

    @Override
    public void add(Integer item) {
        this.array.add(item);
        this.dirty = true;
    }

    @Override
    public void set(int index, Integer item) {

        if (index >= array.size()) {
            throw new IllegalArgumentException("Index is greater than size of array");
        }
        array.set(index, item);
        this.dirty = true;
    }

    @Override
    public void remove(int index) {
        System.out.println("Remove called with index " + index);
        this.array.remove(index);
        this.dirty = true;
    }

    @Override
    public int compare(Integer[] b) throws EmptyArrayException {

        Objects.requireNonNull(b);
        int n = Math.min(array.size(), b.length);
        for (int i = 0; i < n; i++) {
            if (array.get(i) > b[i]) {
                return 1;
            } else if (array.get(i) < b[i]) {
                return -1;
            }
        }
        return Integer.compare(array.size(), b.length);
    }

    @Override
    public FileBaseNumericCalculator subArray(int from, int to) throws EmptyArrayException {
        return new FileBaseNumericCalculator(array.subList(from, to));
    }

    @Override
    public GeneralCalculator<Integer> reverse() {
        Collections.reverse(array);
        this.dirty = true;
        return this;
    }

    @Override
    public boolean contains(Integer item) {
        return array.contains(item);
    }

    @Override
    public int indexOf(Integer item) {
        return array.indexOf(item);
    }
}
