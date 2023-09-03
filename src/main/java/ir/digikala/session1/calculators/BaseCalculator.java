package ir.digikala.session1.calculators;

import ir.digikala.session1.models.Shape;

public interface BaseCalculator<T extends Shape> {
    Double area(T shape);

    Double surface(T shape);
}
