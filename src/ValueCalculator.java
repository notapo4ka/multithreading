import java.util.Arrays;

public class ValueCalculator {

    private double[] values;
    private int size;
    private int halfSize;
    private double[] firstHalf;
    private double[] secondHalf;
    private long start;
    private long end;

    public ValueCalculator() {
        size = 1_000_000;
        values = new double[size];
        halfSize = size / 2;
    }

    public double[] getValues() {
        return values;
    }

    public int getSize() {
        return size;
    }

    public int getHalfSize() {
        return halfSize;
    }

    public double[] getFirstHalf() {
        return firstHalf;
    }

    public double[] getSecondHalf() {
        return secondHalf;
    }

    public long getStart() {
        return start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public void fillArray() {
        start = System.currentTimeMillis();
        double[] values = getValues();

        for (int i = 0; i < getSize(); i++) {
            values[i] = 1;
        }
        firstHalf = Arrays.copyOfRange(values, 0 , getHalfSize());
        secondHalf = Arrays.copyOfRange(values, getHalfSize(), values.length);
    }

    public void glueArray() {
        double[] fullArray = new double[firstHalf.length + secondHalf.length];
        System.arraycopy(secondHalf, 0, fullArray, 0, secondHalf.length);
        System.arraycopy(firstHalf, 0, fullArray, secondHalf.length, firstHalf.length);
    }
}