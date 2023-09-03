package ir.digikala.session1.calculators;

import ir.digikala.session1.models.Triangle;

public class TriangleCalculator implements BaseCalculator<Triangle> {
    public Double area(Triangle triangle) {
        return (double) (triangle.getC() + triangle.getA() + triangle.getB());
    }

    public Double surface(Triangle triangle) {
        double s = ((double) triangle.getB() + triangle.getA() + triangle.getC()) / 2;
        return Math.sqrt(s * (s - triangle.getC()) * (s - triangle.getA()) * (s - triangle.getB()));
    }
}
