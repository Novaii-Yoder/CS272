public class DLinkTester {
    public static void main (String[] args) {
        System.out.println("TESTING SWAP()*************************************");

        System.out.println("Creating a new DList named l1, and adding and 2 elements to it");
        DList l1 = new DList();
        DNode node1 = new DNode("World!", null, null);
        l1.addFirst(node1);
        DNode node2 = new DNode("Hello", null, null);
        l1.addLast(node2);
        System.out.printf("l1(size: %s): %s\n",l1.size(), l1);



        System.out.println("Testing swap() on node1 and node2");
        swap(node1, node2);
        System.out.printf("l1(size: %s): %s\n",l1.size(), l1);

        System.out.println("Testing swap() on node1 and node2 again, to see if all edge cases work");
        swap(node1, node2);
        System.out.printf("l1(size: %s): %s\n",l1.size(), l1);

        System.out.printf("Output from testing swap(node1, node1): %b\n",swap(node1, node1));

        System.out.println("Adding a new node after node 2");
        DNode node3 = new DNode("Java", null, null);
        l1.addAfter(node2, node3);
        System.out.printf("l1(size: %s): %s\n",l1.size(), l1);

        System.out.println("Testing swap() on node1 and node3 once more for the final edge case");
        swap(node1, node3);
        System.out.printf("l1(size: %s): %s\n",l1.size(), l1);

        System.out.println("Testing swap with node3 and node3.getPrev()");
        System.out.printf("Should be false as node3.getPrev() is the dummy DNode header: %b\n",swap(node3, node3.getPrev()));

        System.out.println("TESTING CONCAT()***********************************");

        System.out.println("Creating a new DList l2, and adding 2 elements");
        DList l2 = new DList();
        l2.addLast(new DNode("Weird", null, null));
        l2.addLast(new DNode("Alpha", null, null));
        System.out.printf("l2(size: %s): %s\n",l2.size(), l2);

        System.out.println("Testing concat() on l1 and l2, and saving it to new DList l3");
        DList l3 = concat(l1, l2);
        System.out.printf("l3(size: %s): %s\n",l3.size(), l3);

        System.out.println("Testing concat() on l1 and an empty DLists, and saving it to new DList l4");
        DList l4 = concat(l1, new DList());
        System.out.printf("l4(size: %s): %s\n",l4.size(), l4);

        System.out.println("Testing concat() on two empty DLists, and saving it to new DList l5");
        DList l5 = concat(new DList(), new DList());
        System.out.printf("l5(size: %s): %s\n",l5.size(), l5);


        System.out.println("TESTING REVERSE()**********************************");

        System.out.println("Testing reverse() on l3");
        reverse(l3);
        System.out.printf("l3(size: %s): %s\n",l3.size(), l3);

        System.out.println("Testing reverse() on l5, which is empty");
        reverse(l5);
        System.out.printf("l5(size: %s): %s\n",l5.size(), l5);

        System.out.println("TESTING MERGE()************************************");

        System.out.println("Testing merge() on l1 and l3, and saving it to new DList l6");
        DList l6 = merge(l1, l3);
        System.out.printf("l6(size: %s): %s\n",l6.size(), l6);

        System.out.println("Testing merge() on l1 and an empty DList, and saving it to new DList l7");
        DList l7 = merge(l1, new DList());
        System.out.printf("l7(size: %s): %s\n",l7.size(), l7);

        System.out.println("Testing merge() with two empty lists, and saving it to new DList l8");
        DList l8 = merge(new DList(), new DList());
        System.out.printf("l8(size: %s): %s\n",l8.size(), l8);

        System.out.println("Testing Complete!");

    } // end of main

    /**
     * Swaps two given DNodes within a DList. Swaps the nodes themselves not just their data
     * @param n1 - The first of two DNodes
     * @param n2 - The second Dnode being swapped
     * Precondition - The nodes are not null
     * @return true if it succeeds and false if the n1 and n2
     *          refer to the same node.
     * Postcondition - the position of the two nodes has been swapped if they
     *              refer to two different and valid nodes in a DList.
     * Throws - IllegalArgumentException - indicates that one of the inputs is null
     */
    private static boolean swap(DNode n1, DNode n2) throws IllegalArgumentException {
        if (n1 == null || n2 == null) {
            throw new IllegalArgumentException("Can't swap a null node");
        }else if (n1 == n2 || n1.getNext() == null || n1.getPrev() == null ||
                    n2.getNext() == null || n2.getPrev() == null) {
            return false;
        }else if (n1.getNext() == n2 || n1.getPrev() == n2) {

            // looks if n1 is after n2 and swaps their names
            if (n1.getPrev() == n2) {
                DNode temp = n1;
                n1 = n2;
                n2 = temp;
            }

            // swaps the positions of two DNodes iff they are next to each other
            n1.setNext(n2.getNext());
            n2.setPrev(n1.getPrev());

            n1.getPrev().setNext(n2);
            n2.getNext().setPrev(n1);

            n1.setPrev(n2);
            n2.setNext(n1);

        }else {
            // Swaps n1 and n2 when they aren't next to each other
            DNode tempNext = n2.getNext();
            DNode tempPrev = n1.getPrev();

            n1.getNext().setPrev(n2);
            n2.getPrev().setNext(n1);

            n1.getPrev().setNext(n2);
            n2.getNext().setPrev(n1);

            n1.setPrev(n2.getPrev());
            n2.setNext(n1.getNext());

            n1.setNext(tempNext);
            n2.setPrev(tempPrev);

        }
        return true;
    } // end of swap

    /**
     * Creates a new DList that is a concatenation of two DLists, should work with empty DLists
     * @param l1 - The first DList to be concatenated
     * @param l2 - The second DList to be concatenated
     * Precondition - l1 and l2 are not null
     * @return answer - A concatenation of the two inputted DLists
     * Throws - IllegalArgumentException - indicates that one of the inputs is null
     */
    private static DList concat(DList l1, DList l2) throws IllegalArgumentException {
        if (l1 == null || l2 == null)
            throw new IllegalArgumentException("Can't concatenate a null DList");

        DList answer = new DList();

        // Returns an empty DList if both DLists are empty
        if (l1.isEmpty() && l2.isEmpty())
            return answer;

        // if one of the DLists is empty, this returns a copy of the other DList
        if (l1.isEmpty()) {
            for (int i = 0; i < l2.size(); i++) {
                DNode temp = l2.getFirst();
                for (int j = 0; j < i; j++) {
                    temp = temp.getNext();
                } // end of for
                answer.addLast(new DNode(temp.getElement(), null, null));
            } // end of for
            return answer;
        } // end of if
        if (l2.isEmpty()) {
            for (int i = 0; i < l1.size(); i++) {
                DNode temp = l1.getFirst();
                for (int j = 0; j < i; j++) {
                    temp = temp.getNext();
                } // end of for
                answer.addLast(new DNode(temp.getElement(), null, null));
            } // end of for
            return answer;
        } // end of if

        // adds all elements of l1 to answer
        DNode starter = l1.getFirst();
        answer.addLast(new DNode(starter.getElement(), null, null));
        while (l1.hasNext(starter)) {
            starter = starter.getNext();
            answer.addLast(new DNode(starter.getElement(), null, null));
        } // end while

        // adds all elements of l2 to answer
        starter = l2.getFirst();
        answer.addLast(new DNode(starter.getElement(), null, null));
        while (l2.hasNext(starter)) {
            starter = starter.getNext();
            answer.addLast(new DNode(starter.getElement(), null, null));
        } // end while

        return answer;
    } // end of concat

    /**
     * Reverses the order of DNodes in a given DList, should work with empty DLists
     * @param l1 - The DList that is going to be reversed
     * Postcondition - The given l1 has the element's order reversed
     * Throws - IllegalArgumentException - indicates that one of the inputs is null
     */
    private static void reverse (DList l1) throws IllegalArgumentException {
        if (l1 == null)
            throw new IllegalArgumentException("Can't reverse a null DList");
        // loops through half of the list swaps with the other half
        for (int i = 0; i < l1.size() / 2; i++) {
            DNode swapperFront = l1.getFirst();
            DNode swapperEnd = l1.getLast();
            // calculates the offset for the nodes we want to swap
            for (int j = 0; j < i; j++) {
                swapperFront = swapperFront.getNext();
                swapperEnd = swapperEnd.getPrev();
            } // end of for
            swap(swapperFront, swapperEnd);
        } // end of for
    } // end of reverse

    /**
     * Merges two DLists alternately into a new DLists, should work with empty DLists
     * @param l1 - The first of two DLists that is being merged
     * @param l2 - The second DLists that is being merged
     * @return answer - A merge of the two inputted DLists.
     *              With alternating elements from l1 and l2.
     */
    private static DList merge(DList l1, DList l2) throws IllegalArgumentException {
        if (l1 == null || l2 == null)
            throw new IllegalArgumentException("Can't merge with a null DList");
        DList answer = new DList();

        // Returns an empty DList if both DLists are empty
        if (l1.isEmpty() && l2.isEmpty())
            return answer;

        // if one of the DLists is empty, this returns a copy of the other DList
        if (l1.isEmpty()) {
            for (int i = 0; i < l2.size(); i++) {
                DNode temp = l2.getFirst();
                for (int j = 0; j < i; j++) {
                    temp = temp.getNext();
                } // end of for
                answer.addLast(new DNode(temp.getElement(), null, null));
            } // end of for
            return answer;
        } // end of if
        if (l2.isEmpty()) {
            for (int i = 0; i < l1.size(); i++) {
                DNode temp = l1.getFirst();
                for (int j = 0; j < i; j++) {
                    temp = temp.getNext();
                } // end of for
                answer.addLast(new DNode(temp.getElement(), null, null));
            } // end of for
            return answer;
        } // end of if

        // calculates the largest of the two DLists
        int max = l1.size();
        if (l2.size() > l1.size())
            max = l2.size();

        // loops a number of times equal to the largest DList's size
        for (int i = 0; i < max; i++) {
            // adds the next element from l1 if there is any left
            if (i < l1.size()) {
                DNode temp = l1.getFirst();
                for (int j = 0; j < i; j++) {
                    temp = temp.getNext();
                } // end of for
                answer.addLast(new DNode(temp.getElement(), null, null));
            } // end of if

            // adds the next element from l2 if there is any left
            if (i < l2.size()) {
                DNode temp = l2.getFirst();
                for (int j = 0; j < i; j++) {
                    temp = temp.getNext();
                } // end of for
                answer.addLast(new DNode(temp.getElement(), null, null));
            } // end of if
        } // end of for
        return answer;
    } // end of merge
} // end of DLinkTester
