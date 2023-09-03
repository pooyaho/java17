//package ir.digikala.session1.calculators;
//
//public class LongCalculator extends NumericCalculator<Long> {
//    public LongCalculator(Long[] arr) {
//        super(arr);
//    }
//
//    @Override
//    public void remove(int index) {
//        this.arr[index] = null;
//        shiftArray();
//    }
//
//    private void shiftArray() {
//        int nullIndex = -1;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == null) {
//                nullIndex = i;
//                break;
//            }
//        }
//        if (nullIndex == -1) {
//            return;
//        }
//        for (int i = nullIndex; i < arr.length - 1; i++) {
//            arr[i] = arr[i + 1];
//        }
//        arr[arr.length - 1] = null;
//        Long[] newArray = new Long[arr.length - 1];
//        for (int i = 0; i < arr.length - 1; i++) {
//            newArray[i] = arr[i];
//        }
//
//        this.arr = newArray;
//    }
//
//    @Override
//    public Double avg() {
//
//        return sum() / arr.length;
//    }
//
//    @Override
//    public int compare(Long[] b) {
//        return 0;
//    }
//
//    @Override
//    public Double sum() {
//        return null;
//    }
//
//    @Override
//    public Long max() {
//        return null;
//    }
//
//    @Override
//    public Long min() {
//        return null;
//    }
//
//    @Override
//    public LongCalculator subArray(int from, int to) {
//        //todo validation
//        Long[] newArray = new Long[to - from];
//        int index = 0;
//        for (int i = from; i <= from; i++) {
//            newArray[index++] = arr[i];
//        }
//        return new LongCalculator(newArray);
//    }
//
//    @Override
//    public LongCalculator reverse() {
//        return null;
//    }
//
//    @Override
//    public boolean contains(Long item) {
//        return false;
//    }
//
//    @Override
//    public int indexOf(Long item) {
//        return 0;
//    }
//
//    @Override
//    public LongCalculator findAllPrimes() {
//        return null;
//    }
//
//    @Override
//    public Long findFirstPrime() {
//        return null;
//    }
//}
