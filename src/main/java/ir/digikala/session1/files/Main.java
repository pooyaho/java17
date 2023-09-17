package ir.digikala.session1.files;

import ir.digikala.session1.threads.FileBaseNumericCalculator;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Student implements Serializable {
    private String name;
    private String family;

    public Student() {
    }

    public Student(String name, String family) {
        this.name = name;
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", family='" + family + '\'' + '}';
    }
}

public class Main {

    private static void printString() {
        try {
            Thread.sleep(5000);
            System.out.println("Hello world!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("In finally");
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        List<Integer> list = IntStream.generate(() -> new Random().nextInt())
                .limit(100)
                .boxed()
                .toList();
        FileBaseNumericCalculator f = new FileBaseNumericCalculator(list);
        Thread.sleep(7000);
        f.remove(50);
//        URL url = new URL("https://en.wikipedia.org/wiki/Stanley_Kubrick");
//        try (InputStreamReader reader = new InputStreamReader(url.openStream());
//             BufferedReader br = new BufferedReader(reader)) {
//            br.lines().forEach(i -> System.out.println(i));
//        }
//        Student s = new Student("John", "Doe");
//        writeToFile("student.txt", s.getName() + "," + s.getFamily());
//        try (Stream<String> stream = Files.lines(Paths.get("student.txt"))) {
//            stream.map(i -> {
//                String[] strings = i.split(",");
//                return new Student(strings[0], strings[1]);
//            }).forEach(i -> System.out.println(i));
//        }

//        writeObject(s);

//        readObject();

//        try (FileOutputStream fos = new FileOutputStream("./a.txt", true)) {
//
//            fos.write("Hello world!\n".getBytes());
//            fos.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//


//        writeToFile();
//        try (FileReader fr = new FileReader("./a.txt");
//             BufferedReader br = new BufferedReader(fr)) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//            }
//        }
//        readFromFile();


    }

    private static void readObject() throws IOException {
        try (FileInputStream fis = new FileInputStream("c.obj"); ObjectInputStream ois = new ObjectInputStream(fis)) {
            Student student = (Student) ois.readObject();
            System.out.println(student);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeObject(Student s) throws IOException {
        try (FileOutputStream fos = new FileOutputStream("c.obj"); ObjectOutputStream ous = new ObjectOutputStream(fos)) {
            ous.writeObject(s);
            ous.flush();
        }
    }

    private static Stream<String> readFromFile(String file) throws IOException {
        try (Stream<String> s = Files.lines(Paths.get(file))) {
            return s;
        }
    }

    private static void writeToFile(String file, String content) throws IOException {
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.append(content).append("\n");
            fw.flush();
        }
    }
}
