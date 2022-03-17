import java.util.Scanner;

public class RandomSentences {
    public static void main (String args[]) {

        Scanner scan = new Scanner(System.in);
        LinkedBag nouns = new LinkedBag<String>();
        LinkedBag verbs = new LinkedBag<String>();

        // gets input and cleans it before putting them into bags
        System.out.println("Input 10 nouns:");
        for (int i = 0; i < 10; i++) {
            String s = scan.next();
        s = s.replaceAll("[^a-zA-Z]", "");
            s = s.toLowerCase();
            nouns.add(s);
        } // end of for
        System.out.println("Input 10 verbs:");
        for (int i = 0; i < 10; i++) {
            String s = scan.next();
            s = s.replaceAll("[^a-zA-Z]", "");
            s = s.toLowerCase();
            verbs.add(s);
        } // end of for

        System.out.println("How many sentences do want to generate?");
        int N = scan.nextInt();

        for(int i = 0; i < N; i++) {
            System.out.println("The " + nouns.grab() + " " + verbs.grab() + " the " + nouns.grab() + ".");
        } // end of for

    } // end of main
}
