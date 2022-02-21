import java.util.Scanner;

public class BagTester {
    public static void main(String[] args) {
        int input = 0;
        IntArrayBag b1 = new IntArrayBag();
        IntArrayBag b2 = new IntArrayBag();

        Scanner scan = new Scanner(System.in);

        System.out.println("1 - add an element to b1");
        System.out.println("2 - remove an element from b1");
        System.out.println("3 - add an element to b2");
        System.out.println("4 - remove an element from b2");
        System.out.println("5 - check if b1 equals b2");
        System.out.println("6 - Remove all elements of b2 from b1");
        System.out.println("7 - Print the intersection of b1 and b2");
        System.out.println("0 - Quit");

        do{
            System.out.print("b1 = " + b1.toString() + " b2 = " + b2.toString() + " ");
            System.out.print("What would you like to do (enter an integer 0-7)? ");
            input = scan.nextInt();
            switch(input) {
                case 1:
                    System.out.print("Enter the element to be added to b1: ");
                    input = scan.nextInt();
                    b1.add(input);
                    System.out.println("" + input + " is added to b1");
                    break;
                case 2:
                    System.out.print("Enter the element to be removed from b1: ");
                    input = scan.nextInt();
                    if (b1.remove(input))
                        System.out.println(input + " is removed from b1");
                    else
                        System.out.println(input + " is not in b1");
                    break;
                case 3:
                    System.out.print("Enter the element to be added to b2: ");
                    input = scan.nextInt();
                    b2.add(input);
                    System.out.println("" + input + " is added to b2");
                    break;
                case 4:
                    System.out.print("Enter the element to be removed from b2: ");
                    input = scan.nextInt();
                    if (b2.remove(input))
                        System.out.println(input + " is removed from b2");
                    else
                        System.out.println(input + " is not in b2");
                    break;
                case 5:
                    if (b1.equals(b2))
                        System.out.println("b1 and b2 are equal.");
                    else
                        System.out.println("b1 and b2 are not equal.");
                    break;
                case 6:
                    b1.removeAll(b2);
                    System.out.println("Elements of b2 are removed from b1.");
                    break;
                case 7:
                    System.out.println("Intersection of b1 and b2 is " + IntArrayBag.intersection(b1, b2).toString());
                    break;
                case 0:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }
        }while (input != 0);

    } // end of main
} // end of BagTester
