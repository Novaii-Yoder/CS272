// File: IntTreeBag.java from the package edu.colorado.collections

// The implementation of most methods in this file is left as a student
// exercise from Section 9.5 of "Data Structures and Other Objects Using Java"

//import edu.colorado.nodes.IntBTNode; 

/******************************************************************************
* This class is a homework assignment;
* An <CODE>IntTreeBag</CODE> is a collection of int numbers.
*
* <dl><dt><b>Limitations:</b> <dd>
*   Beyond <CODE>Integer.MAX_VALUE</CODE> elements, <CODE>countOccurrences</CODE>,
*   and <CODE>size</CODE> are wrong. 
*
* <dt><b>Outline of Java Source Code for this class:</b><dd>
*   <A HREF="../../../../edu/colorado/collections/IntTreeBag.java">
*   http://www.cs.colorado.edu/~main/edu/colorado/collections/IntTreeBag.java
*   </A>
*
* <dt><b>Note:</b><dd>
*   This file contains only blank implementations ("stubs")
*   because this is a Programming Project for my students.
*
* @version
*   Jan 24, 1999
*
******************************************************************************/
public class IntTreeBag
{
   // Invariant of the IntTreeBag class:
   //   1. The elements in the bag are stored in a binary search tree.
   //   2. The instance variable root is a reference to the root of the
   //      binary search tree (or null for an empty tree).
   private IntBTNode root;   


   /**
   * Insert a new element into this bag.
   * @param element</CODE>
   *   the new element that is being inserted
   * <dt><b>Postcondition:</b><dd>
   *   A new copy of the element has been added to this bag.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory a new IntBTNode.
   **/
   public void add(int element)
   {
      IntBTNode newNode = new IntBTNode(element, null, null);
      if (root == null) {
         root = newNode;
         return;
      }
      boolean done = false;
      IntBTNode cursor = root;
      while (!done) {
         if (element <= cursor.getData()) {
            if (cursor.getLeft() == null) {
               cursor.setLeft(newNode);
               done = true;
            } // end of if
            else
               cursor = cursor.getLeft();

         } else {
            if (cursor.getRight() == null) {
               cursor.setRight(newNode);
               done = true;
            } // end of if
            else
               cursor = cursor.getRight();

         } // end of if and else block
      } // end of while
   }


   /**
   * Add the contents of another bag to this bag.
   * @param addend</CODE>
   *   a bag whose contents will be added to this bag
   * <dt><b>Precondition:</b><dd>
   *   The parameter, <CODE>addend</CODE>, is not null.
   * <dt><b>Postcondition:</b><dd>
   *   The elements from <CODE>addend</CODE> have been added to this bag.
   * @exception IllegalArgumentException
   *   Indicates that <CODE>addend</CODE> is null.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory to increase the size of the bag.
   **/
   public void addAll(IntTreeBag addend)
   {
      IntBTNode addroot;

      if (root == addend.root) {
         addroot = IntBTNode.treeCopy(addend.root);
         addTree(addroot);
      } // end of if
      else
         addTree(addend.root);
   }

   /**
    * Adds all of a tree to this bag.
    * @param - addroot
    *    The root of the tree being added
    * Postcondition: This bag has all of the addroot's elements added to it
    * @exception OutOfMemoryError
    *   Indicates insufficient memory.
    **/
   private void addTree(IntBTNode addroot) {
      if (addroot != null) {
         add(addroot.getData( ));
         this.addTree(addroot.getLeft());
         this.addTree(addroot.getRight());
      }
   } // end of addTree


   /**
   * Generate a copy of this bag.
   * @param - none
   * @return
   *   The return value is a copy of this bag. Subsequent changes to the
   *   copy will not affect the original, nor vice versa. 
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for creating the clone.
   **/ 
   public IntTreeBag clone( )
   {
      IntTreeBag answer = new IntTreeBag();
      answer.root = IntBTNode.treeCopy(this.root);
      return answer;
   }
   

   /**
   * Accessor method to count the number of occurrences of a particular element
   * in this bag.
   * @param target</CODE>
   *   the element that needs to be counted
   * @return
   *   the number of times that <CODE>target</CODE> occurs in this bag
   **/
   public int countOccurrences(int target)
   {
      int answer = 0;
      IntBTNode cursor = root;
      while (cursor != null) {
         if (target == cursor.getData()) {
            answer++;
            cursor = cursor.getLeft();
         } else {
            if (target < cursor.getData())
               cursor = cursor.getLeft();
            else
               cursor = cursor.getRight();
         }

      }
      return answer;
   }
   
             
   /**
   * Remove one copy of a specified element from this bag.
   * @param target</CODE>
   *   the element to remove from the bag
   * <dt><b>Postcondition:</b><dd>
   *   If <CODE>target</CODE> was found in the bag, then one copy of
   *   <CODE>target</CODE> has been removed and the method returns true. 
   *   Otherwise the bag remains unchanged and the method returns false. 
   **/
   public boolean remove(int target)
   {
      IntBTNode cursor = root;
      IntBTNode parentOfCursor = null;
      while (cursor != null && cursor.getData() != target){
         if (target < cursor.getData()) {
            parentOfCursor = cursor;
            cursor = cursor.getLeft();
         } else {
            parentOfCursor = cursor;
            cursor = cursor.getRight();
         } // end of if and else block
      } // end of while

      if (cursor == null)
         return false;

      if (cursor == root && cursor.getLeft() == null) {
         root = root.getRight();
         return true;
      } // end of if

      if (cursor.getLeft() == null){
         if (cursor == parentOfCursor.getLeft()){
            parentOfCursor.setLeft(cursor.getRight());
         } else {
            parentOfCursor.setRight(cursor.getRight());
         } // end of if and else block
         return true;
      } // end of if

      cursor.setData(cursor.getLeft().getRightmostData());
      cursor.setLeft(cursor.getLeft().removeRightmost());
      return true;
   }
   
      
   /**
   * Determine the number of elements in this bag.
   * @param - none
   * @return
   *   the number of elements in this bag
   **/                           
   public int size( )
   {
      return IntBTNode.treeSize(root);
   }
   

   /**
   * Create a new bag that contains all the elements from two other bags.
   * @param b1</CODE>
   *   the first of two bags
   * @param b2</CODE>
   *   the second of two bags
   * <dt><b>Precondition:</b><dd>
   *   Neither b1 nor b2 is null.
   * @return
   *   the union of b1 and b2
   * @exception IllegalArgumentException
   *   Indicates that one of the arguments is null.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for the new bag.
   **/   
   public static IntTreeBag union(IntTreeBag b1, IntTreeBag b2)
   {
      IntTreeBag answer = new IntTreeBag();
      answer.addTree(b1.root);
      answer.addTree(b2.root);
      return answer;
   }

   public static IntTreeBag sortedArrayToBST(int[] data, int first, int last) {
      IntTreeBag answer = new IntTreeBag();
      int mid = ((last - first) / 2) + first;
      answer.add(data[mid]);

      if (first < mid)
         answer.addAll(sortedArrayToBST(data, first, mid - 1));

      if (mid < last)
         answer.addAll(sortedArrayToBST(data, mid + 1, last));

      return answer;
   } // end of sortedArrayToBST

   public static void print(IntTreeBag b) {
      b.root.print(0);
   }
}
           
