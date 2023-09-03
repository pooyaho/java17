package ir.digikala.session1.calculators;

import ir.digikala.session1.models.Square;

public class SquareCalculator implements BaseCalculator<Square> {
    public Double area(Square square) {
        return (double) (4 * square.getA());
    }

    public Double surface(Square square) {
        return Math.pow(square.getA(), 2);
    }
}
