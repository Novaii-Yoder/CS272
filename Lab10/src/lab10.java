import java.util.Scanner;

public class lab10 {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        IntTreeBag b1 = new IntTreeBag();

        System.out.print("How many elements are there? ");
        int numEle = scan.nextInt();
        int[] array = new int[numEle];

        System.out.print("Please enter " + numEle + " integers: ");
        for (int i = 0; i < numEle; i++)
            array[i] = scan.nextInt();

        for (int i = 0; i < numEle; i++) {
            int max = array[0];
            int position = 0;
            for (int j = 1; j < numEle - i; j++){
                if (array[j] > max) {
                    max = array[j];
                    position = j;
                }
            } // end of for
            int temp = array[position];
            array[position] = array[numEle - 1 - i];
            array[numEle - 1 - i] = temp;
        } // end of for

        System.out.print("Sorted Array: ");
        for (int i = 0; i < numEle; i++)
            System.out.print(array[i] + " ");
        System.out.println();

        b1 = IntTreeBag.sortedArrayToBST(array, 0, numEle - 1);

        System.out.println("BST (tree 1) obtained from the array:");
        IntTreeBag.print(b1);

        IntTreeBag b2 = b1.clone();
        System.out.println("Clone of the tree (tree 2):");
        IntTreeBag.print(b2);

        int user;
        boolean endProgram = false;
        while (!endProgram) {
            System.out.print("Please enter 1 to add, 2 to remove, 0 to exit: ");
            user = scan.nextInt();
            switch (user) {
                case 0:
                    endProgram = true;
                    break;
                case 1:
                    System.out.print("Please enter the element you would like to add: ");
                    b2.add(scan.nextInt());
                    System.out.println("Updated tree 2:");
                    IntTreeBag.print(b2);
                    break;
                case 2:
                    System.out.print("Please enter the element you would like to remove: ");
                    b2.remove(scan.nextInt());
                    System.out.println("Updated tree 2:");
                    IntTreeBag.print(b2);
                    break;
                default:
                    System.out.println("Please enter a valid option.");
                    break;
            } // end of switch
        } // end of while

        System.out.print("Please enter element to count occurrences: ");
        int count = scan.nextInt();
        System.out.println(count + " occurs " + b2.countOccurrences(count) + " time(s) in tree 2");

        IntTreeBag b3 = IntTreeBag.union(b1, b2);
        System.out.println("Tree 3 (union of tree 1 and tree 2): ");
        IntTreeBag.print(b3);

        b1.addAll(b2);
        System.out.println("Result of adding all nodes from tree 2 to tree 1: ");
        IntTreeBag.print(b1);




    } // end of main
}
