package pl.aptewicz.unittests;

public class Main {
    public static void main(String[] args) {
        final int elNr = 55;

        System.out.println("call fibonacci iter");
        final long start = System.currentTimeMillis();
        final int el = Fibonacci.getValueIter(elNr);
        final long end = System.currentTimeMillis();
        System.out.println("result " + el + " time: " + (end - start));

        System.out.println("call fibonacci rec");
        final long startRec = System.currentTimeMillis();
        final int elRec = Fibonacci.getValue(elNr);
        final long endRec = System.currentTimeMillis();
        System.out.println("result " + elRec + " time: " + (endRec - startRec));
    }
}
