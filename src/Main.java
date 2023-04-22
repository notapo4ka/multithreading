import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ValueCalculator valueCalculator = new ValueCalculator();
        valueCalculator.fillArray();

        System.out.println();

        System.out.println("FirstHalfArray: " + Arrays.toString(valueCalculator.getFirstHalf()));
        System.out.println("SecondHalfArray: " + Arrays.toString(valueCalculator.getSecondHalf()));

        double[] values = valueCalculator.getValues();

        double[] firstHalfValues = valueCalculator.getFirstHalf();
        double[] secondHalfValues = valueCalculator.getSecondHalf();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < firstHalfValues.length; i++) {
                values[i] = (float) (values[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < secondHalfValues.length; i++) {
                values[i] = (float) (values[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Arrays.toString(values));

        valueCalculator.glueArray();

        valueCalculator.setEnd(System.currentTimeMillis());
        long elapsedTime = valueCalculator.getEnd() - valueCalculator.getStart();
        System.out.println("elapsedTime = " + elapsedTime);
    }
}