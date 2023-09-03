package ir.digikala.session1.calculators;

import ir.digikala.session1.models.Rectangle;

public class RectangleCalculator implements BaseCalculator<Rectangle> {
    @Override
    public Double area(Rectangle shape) {
        return (double) (2 * shape.getB() + shape.getA());
    }

    @Override
    public Double surface(Rectangle shape) {
        return (double) (shape.getA() * shape.getB());
    }
}
