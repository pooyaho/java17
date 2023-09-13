package ir.digikala.session1.calculators;

import ir.digikala.session1.models.Circle;

class Singleton {
    private static Singleton singleton;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    public static void main(String[] args) {

        Singleton instance = Singleton.getInstance();
    }
}

public class CircleCalculator implements BaseCalculator<Circle> {
    public Double area(Circle circle) {
        return 2 * Math.PI * circle.getA();
    }

    public Double surface(Circle circle) {
        return Math.PI * circle.getA() * circle.getA();
    }
}

class ArrayUtil<T> {
    private Integer integer;

    public static <E> E itemAt(E[] arr, E item, int index) {
        if (index < 0) {
            return null;
        }
        return arr[index];
    }

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{1, 2, 3, 4};
        Integer item = itemAt(integers, 2, 2);

        System.out.println(item);
    }

}