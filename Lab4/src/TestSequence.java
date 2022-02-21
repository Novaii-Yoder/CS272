public class TestSequence {
    public static void main(String args[]) {

        DoubleLinkedSeq l1 = new DoubleLinkedSeq();
        DoubleLinkedSeq l2, l3, l4;
        DoubleLinkedSeq l5 = new DoubleLinkedSeq();

        System.out.println("Testing addAfter on empty l1");
        l1.addAfter(12.0);
        System.out.println("Testing addAfter on l1 which has 1 element");
        l1.addAfter(24.0);
        System.out.println("Testing addBefore on l1");
        l1.addBefore(16.0);
        System.out.println("Testing start on l1");
        l1.start();
        System.out.println("Testing advance on l1");
        l1.advance();
        System.out.println("Testing addAfter on l1 now that cursor is not null");
        l1.addAfter(6.0);

        System.out.println("Testing clone on l1 and saving it to l2");
        l2 = l1.clone();

        System.out.println("Testing addALl by adding l2 to l1");
        l1.addAll(l2);

        System.out.printf("Size of l1: %d\n", l1.size());
        System.out.printf("l1: %s\n", l1.toString());
        l1.removeCurrent();
        System.out.printf("l1: %s\n", l1.toString());
        l1.advance();
        l1.advance();
        System.out.printf("l1: %s\n", l1.toString());
        l1.removeCurrent();
        System.out.printf("l1: %s\n", l1.toString());
        System.out.printf("Size of l1: %d\n", l1.size());
        l1.addBefore(11.31);
        System.out.printf("l1: %s\n", l1.toString());

        l3 = l1.reverse();
        System.out.printf("l3: %s\n", l3.toString());

        l1.addAfter(21.2);
        System.out.printf("l1: %s\n", l1.toString());
        l4 = l1.everyOther();
        System.out.printf("l4: %s\n", l4.toString());

        l5.addAfter(0.2);
        System.out.printf("l5: %s\n", l5.toString());
        l4 = l5.everyOther();
        System.out.printf("l4: %s\n", l4.toString());

        System.out.printf("l1: %s\nRemoving everything less than 13.\n", l1.toString());
        l1.removeSmaller(13.0);
        System.out.printf("l1: %s\n", l1.toString());
    } // end of main
}
