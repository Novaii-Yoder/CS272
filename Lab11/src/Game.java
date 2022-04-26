import java.util.Locale;
import java.util.Scanner;

public class Game {
    public static void main (String args[]) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the smallest value in the range: ");
        int small = scan.nextInt();

        System.out.println("Enter the largest value in the range: ");
        int large = scan.nextInt();

        int size = large - small + 1;
        int array[] = new int[size];
        for (int i = 0; i < size; i++ )
            array[i] = small + i;

        System.out.println("Now think of a number in that range.");
        while (small != large) {
            int mid = ((large - small) / 2 ) + small;

            System.out.println("Is your number bigger than " + mid + " (Y/N)? ");
            char ans = scan.next().toLowerCase(Locale.ROOT).charAt(0);
            while (ans != 'y' && ans != 'n') {
                System.out.println("Please enter a valid answer (Y/N): ");
                ans = scan.next().toLowerCase(Locale.ROOT).charAt(0);
            } // end of while
            if (ans == 'y')
                small = mid + 1;
            else
                large = mid;
        } // end of while

        System.out.println("My guess is " + small + "!");


    } // end of main
}
