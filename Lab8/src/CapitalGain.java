import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class CapitalGain {
    public static void main (String[] args) throws FileNotFoundException {

        Scanner scan = new Scanner(System.in);


        System.out.print("What is the file containing the stock information: ");

        String filename = scan.next();

        Scanner file = null;
        try {
            file = new Scanner(new FileInputStream(filename));
        }
        catch(FileNotFoundException fnfe) {
            System.out.println("File " + filename +
                    " was not found or could not be opened.");
            System.exit(0);
        }

        LinkedQueue<Transaction> lq = new LinkedQueue<Transaction>();
        LinkedQueue<Transaction> sharesOwned = new LinkedQueue<Transaction>();
        int capitalGain = 0, finalShareNum = 0;

        System.out.println("The following transactions were read from the file:");
        while (file.hasNextLine()) {
            String data = file.nextLine();
            data = data.toLowerCase();
            int m = data.indexOf("$") + 1;
            int cost = parseInt(data.substring(m, data.indexOf(' ', m)));


            if (data.charAt(0) == 'b') {
                int num = parseInt(data.substring(4, data.indexOf(' ', 4)));
                Transaction t = new Transaction(false, num, cost);
                lq.add(t);
                System.out.println(t);
            } // end of if
            else if (data.charAt(0) == 's') {
                int num = parseInt(data.substring(5, data.indexOf(' ', 5)));
                Transaction t = new Transaction(true, num, cost);
                lq.add(t);
                System.out.println(t);
            } // end of elseif
        } // end of while

        while (!lq.isEmpty()) {
            Transaction t = lq.remove();
            System.out.println("Processing transaction: " + t);
            if (t.isSell()) {
                int sharesLeft = t.getNumber();
                while(sharesLeft > 0) {
                    if (sharesOwned.isEmpty()) {
                        System.out.println("Error: attempt to sell non-existing shares!");
                        return;
                    }
                    if (sharesLeft >= sharesOwned.peek().getNumber()) {
                        sharesLeft -= sharesOwned.peek().getNumber();
                        capitalGain += sharesOwned.peek().getNumber() * (t.getPrice() - sharesOwned.remove().getPrice());
                    } else {
                        capitalGain += sharesLeft * (t.getPrice() - sharesOwned.peek().getPrice());
                        sharesOwned.peek().changeNumber(sharesOwned.peek().getNumber() - sharesLeft);
                        sharesLeft = 0;
                    }
                }
            } else {
                sharesOwned.add(t);
            }
        } // end of while

        while (!sharesOwned.isEmpty()) {
            finalShareNum += sharesOwned.remove().getNumber();
        }

        System.out.println("Capital gain is $" + capitalGain);
        System.out.println("There are " + finalShareNum + " share(s) left.");
    }
}
