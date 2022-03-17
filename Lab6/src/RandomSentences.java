import java.util.Scanner;

public class RandomSentences {
    public static void main (String args[]) {

        Scanner scan = new Scanner(System.in);
        String nouns[] = new String[10];
        String verbs[] = new String[10];

        System.out.println("Input 10 nouns:");
        for (int i = 0; i < 10; i++)
            nouns[i] = scan.next();

        System.out.println("Input 10 verbs:");
        for (int i = 0; i < 10; i++)
            verbs[i] = scan.next();

        // cleans the input
        for (int i = 0; i < 10; i++) {
            

        } // end of for

    } // end of main
}
