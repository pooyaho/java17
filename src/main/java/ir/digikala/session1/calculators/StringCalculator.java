package ir.digikala.session1.calculators;

public class StringCalculator extends GeneralCalculator<String> {


    public StringCalculator(String[] arr) {
        super(arr);
    }

    @Override
    public void add(String item) {
        String[] newArray = new String[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            newArray[i] = arr[i];
        }
        newArray[arr.length] = item;
        this.arr = newArray;
    }

    @Override
    public void set(int index, String item) {
        this.arr[index] = item;
    }

    @Override
    public void remove(int index) {
        this.arr[index] = null;
        shiftArray();
    }

    private void shiftArray() {
        int nullIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                nullIndex = i;
                break;
            }
        }
        if (nullIndex == -1) {
            return;
        }
        for (int i = nullIndex; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = null;
        String[] newArray = new String[arr.length - 1];
        for (int i = 0; i < arr.length - 1; i++) {
            newArray[i] = arr[i];
        }
        this.arr = newArray;
    }

    @Override
    public int compare(String[] b) {
        return 0;
    }

    @Override
    public GeneralCalculator<String> subArray(int from, int to) {
        return null;
    }

    @Override
    public GeneralCalculator<String> reverse() {
        return null;
    }

    @Override
    public boolean contains(String item) {
        return false;
    }

    @Override
    public int indexOf(String item) {
        return 0;
    }
}
