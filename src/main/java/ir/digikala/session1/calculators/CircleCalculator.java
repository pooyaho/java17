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

