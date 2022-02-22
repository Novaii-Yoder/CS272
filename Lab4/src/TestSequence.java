public class TestSequence {
    public static void main(String args[]) {

        DoubleLinkedSeq l1 = new DoubleLinkedSeq();
        DoubleLinkedSeq l2, l3, l4;
        DoubleLinkedSeq l5 = new DoubleLinkedSeq();

        System.out.println("Testing addAfter on empty l1");
        l1.addAfter(12.9);
        System.out.printf("Size of l1: %d | l1: %s\n", l1.size(), l1.toString());

        System.out.println("Testing addAfter on l1 which has 1 element");
        l1.addAfter(23.4);
        System.out.printf("Size of l1: %d | l1: %s\n", l1.size(), l1.toString());

        System.out.println("Testing addBefore on l1");
        l1.addBefore(86.2);
        System.out.printf("Size of l1: %d | l1: %s\n", l1.size(), l1.toString());

        System.out.println("Testing start on l1");
        l1.start();
        System.out.printf("Size of l1: %d | l1: %s\n", l1.size(), l1.toString());

        System.out.println("Testing advance on l1");
        l1.advance();
        System.out.printf("Size of l1: %d | l1: %s\n", l1.size(), l1.toString());

        System.out.println("Testing addAfter on l1");
        l1.addAfter(6.7);
        System.out.printf("Size of l1: %d | l1: %s\n", l1.size(), l1.toString());

        System.out.println("Testing clone on l1 and saving it to l2");
        l2 = l1.clone();
        System.out.printf("Size of l2: %d | l2: %s\n", l2.size(), l2.toString());


        System.out.println("Testing addALl by adding l2 to l1");
        l1.addAll(l2);
        System.out.printf("Size of l1: %d | l1: %s\n", l1.size(), l1.toString());

        System.out.println("Testing removeCurrent on l1.");
        l1.removeCurrent();
        System.out.printf("Size of l1: %d | l1: %s\n", l1.size(), l1.toString());

        System.out.println("Advancing cursor on l1 two times");
        l1.advance();
        l1.advance();
        System.out.printf("Size of l1: %d | l1: %s\n", l1.size(), l1.toString());

        System.out.println("Removing current element on l1");
        l1.removeCurrent();
        System.out.printf("Size of l1: %d | l1: %s\n", l1.size(), l1.toString());

        System.out.println("Adding 11.31 before cursor on l1");
        l1.addBefore(11.31);
        System.out.printf("Size of l1: %d | l1: %s\n", l1.size(), l1.toString());

        System.out.println("Testing reverse() by reversing l1 and saving it to l3");
        l3 = l1.reverse();
        System.out.printf("Size of l3: %d | l3: %s\n", l3.size(), l3.toString());

        System.out.println("Adding element 21.2 after cursor on l1");
        l1.addAfter(21.2);
        System.out.printf("Size of l1: %d | l1: %s\n", l1.size(), l1.toString());

        System.out.println("Testing everyOther() on l1 and saving it to l4");
        l4 = l1.everyOther();
        System.out.printf("Size of l4: %d | l4: %s\n", l4.size(), l4.toString());

        System.out.println("Creating new DoubleLinkedSeq l5 and adding 1 element (0.2)");
        l5.addAfter(0.2);
        System.out.printf("Size of l5: %d | l5: %s\n", l5.size(), l5.toString());

        System.out.println("Trying everyOther on l5 and saving it to l4");
        l4 = l5.everyOther();
        System.out.printf("Size of l4: %d | l4: %s\n", l4.size(), l4.toString());

        System.out.printf("Size of l1: %d | l1: %s\n", l1.size(), l1.toString());
        System.out.println("Testing removeSmaller() by removing everything less than 13 from l1");
        l1.removeSmaller(13.0);
        System.out.printf("Size of l1: %d | l1: %s\n", l1.size(), l1.toString());

        System.out.println("Testing isCurrent() on l1, should return false");
        System.out.printf("Size of l1: %d | l1: %s\n", l1.size(), l1.toString());
        System.out.printf("%b\n", l1.isCurrent());

        System.out.println("Starting cursor on l1 and testing isCurrent() again, should return true");
        l1.start();
        System.out.printf("Size of l1: %d | l1: %s\n", l1.size(), l1.toString());
        System.out.printf("%b\n", l1.isCurrent());

        System.out.println("Testing getCurrent() on l1");
        System.out.printf("Current element in l1: %f\n", l1.getCurrent());

        System.out.printf("Size of l1: %d | l1: %s\n", l1.size(), l1.toString());
        System.out.printf("Size of l4: %d | l4: %s\n", l4.size(), l4.toString());
        System.out.println("Testing concatenation() on l1 and l4, and saving it to l1.");
        l1 = DoubleLinkedSeq.concatenation(l1, l4);
        System.out.printf("Size of l1: %d | l1: %s\n", l1.size(), l1.toString());
        System.out.printf("Size of l4: %d | l4: %s\n", l4.size(), l4.toString());

        System.out.println("Testing Complete!");

    } // end of main
}
