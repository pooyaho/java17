package ir.digikala.session1.calculators;

import ir.digikala.session1.models.Circle;

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