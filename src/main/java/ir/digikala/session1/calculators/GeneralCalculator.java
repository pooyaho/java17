package ir.digikala.session1.calculators;


public abstract class GeneralCalculator<T> {
    protected T[] arr;

    public GeneralCalculator(T[] arr) {
        this.arr = arr;
    }

    public abstract void add(T item);

    public abstract void set(int index, T item);

    public abstract void remove(int index);

    public abstract int compare(T[] b);

    public abstract GeneralCalculator<T> subArray(int from, int to);

    public abstract GeneralCalculator<T> reverse();

    public abstract boolean contains(T item);

    public abstract int indexOf(T item);
}
