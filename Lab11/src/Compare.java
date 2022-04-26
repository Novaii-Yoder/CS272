

public class Compare {
    public static void main (String args[]) {
        final int SIZE = 1000000;
        final int NUM_RUNS = 5;
        long times[][] = new long[2][NUM_RUNS];
        int array[] = new int[SIZE];
        long averages[] = new long[2];

        for (int i = 0; i < SIZE; i++) {
            array[i] = i;
        }

        for (int i = 1; i <= NUM_RUNS; i++ ) {
            long startTime = System.nanoTime();
            linearSearch(array, SIZE + 1);
            long endTime = System.nanoTime();
            times[0][i - 1] = endTime - startTime;

            startTime = System.nanoTime();
            binarySearch(array, SIZE + 1);
            endTime = System.nanoTime();
            times[1][i - 1] = endTime - startTime;

        }

        for (int i = 0; i < NUM_RUNS; i++) {
            System.out.println("Run " + (i + 1) + ": Linear search took " + times[0][i] + " nanoseconds.");
            System.out.println("    Binary search took " + times[1][i] + " nanoseconds.");
            averages[0] += times[0][i];
            averages[1] += times[1][i];
        }
        averages[0] /= NUM_RUNS;
        averages[1] /= NUM_RUNS;

        System.out.println("Average time for linear search is " + averages[0] + " nanoseconds.");
        System.out.println("Average time for binary search is " + averages[1] + " nanoseconds.");
    } // end of main

    private static boolean linearSearch(int[] array, int num) {
        for (int i = 0; i < array.length; i++)
            if (array[i] == num)
                return true;
        return false;
    }

    private static boolean binarySearch(int[] array, int num) {
        int start = 0;
        int end = array.length;


        while (start != end) {
            int mid = ((end - start) / 2 ) + start;
            if (num > array[mid])
                start = mid + 1;
            else
                end = mid;
        } // end of while

        if (start == num)
            return true;
        return false;
    }
}
