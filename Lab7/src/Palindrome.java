import java.util.Scanner;

public class Palindrome {
    public static void main (String args[]) {

        Scanner scan = new Scanner(System.in);

        System.out.print("How many integers are in the sequence? ");

        int length = scan.nextInt();
        int num;
        LinkedStack<Integer> stack1 = new LinkedStack<Integer>();
        LinkedStack<Integer> stack2 = new LinkedStack<Integer>();
        LinkedStack<Integer> stack3 = new LinkedStack<Integer>();

        System.out.println("Please enter a sequence of " + length + " integers:");
        for (int i = 0; i < length; i++) {
            num = scan.nextInt();
            stack1.push(num);
            stack2.push(num);
        } // end of for

        // reverses one of the stacks
        while (!stack2.isEmpty())
            stack3.push(stack2.pop());

        boolean palindrome = true;
        while (!stack1.isEmpty() && !stack3.isEmpty())
            if (!stack1.pop().equals(stack3.pop()))
                palindrome = false;

        if (palindrome)
            System.out.println("This sequence is palindromic.");
        else
            System.out.println("This sequence is NOT palindromic.");
    }
}
