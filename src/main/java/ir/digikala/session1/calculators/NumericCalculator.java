package ir.digikala.session1.calculators;


import ir.digikala.session1.exceptions.EmptyArrayException;

public abstract class NumericCalculator<T extends Number> extends GeneralCalculator<T> {
    public NumericCalculator(T[] arr) {
        super(arr);
    }

    public abstract Double avg();

    public abstract Double sum() throws EmptyArrayException;

    public abstract T max() throws EmptyArrayException;

    public abstract T min() throws EmptyArrayException;

    public abstract NumericCalculator<T> findAllPrimes();

    public abstract T findFirstPrime();
}
