// File: DoubleLinkedSeq.java from the package edu.colorado.collections

// This is an assignment for students to complete after reading Chapter 4 of
// "Data Structures and Other Objects Using Java" by Michael Main.


/******************************************************************************
* This class is a homework assignment;
* A DoubleLinkedSeq is a collection of double numbers.
* The sequence can have a special "current element," which is specified and 
* accessed through four methods that are not available in the sequence class 
* (start, getCurrent, advance and isCurrent).
*
* <dl><dt><b>Limitations:</b>
*   Beyond Int.MAX_VALUE elements, the size method
*   does not work.
*
* <dt><b>Note:</b><dd>
*   This file contains only blank implementations ("stubs")
*   because this is a Programming Project for my students.
*
* <dt><b>Outline of Java Source Code for this class:</b><dd>
*   <A HREF="../../../../edu/colorado/collections/DoubleLinkedSeq.java">
*   http://www.cs.colorado.edu/~main/edu/colorado/collections/DoubleLinkedSeq.java
*   </A>
*   </dl>
*
* @version
*   Jan 24, 1999
******************************************************************************/
public class DoubleLinkedSeq implements Cloneable
{
   // Invariant of the DoubleLinkedSeq class:
   // 1. The elements of the linked sequence are stored in a linked list.
   // 2. The head reference of the list is in the instance variable head.
   // 3. The tail reference of the list is in the instance variable tail.
   // 4. The total number of elements in the list is in the instance
   //    variable manyNodes.
   // 5. The current element is stored in the instance variable cursor.

   private DoubleNode head;
   private DoubleNode tail;
   private int manyNodes;
   private DoubleNode cursor;
   
   /**
   * Initialize an empty sequence.
   * @param - none
   * <dt><b>Postcondition:</b><dd>
   *   This sequence is empty.
   **/   
   public DoubleLinkedSeq( )
   {
      head = null;
      manyNodes = 0;
      cursor = null;
      tail = null;

   } // end of DoubleLinkedSeq
    
 
   /**
   * Add a new element to this sequence, after the current element. 
   * @param element</CODE>
   *   the new element that is being added
   * <dt><b>Postcondition:</b><dd>
   *   A new copy of the element has been added to this sequence. If there was
   *   a current element, then the new element is placed after the current
   *   element. If there was no current element, then the new element is placed
   *   at the end of the sequence. In all cases, the new element becomes the
   *   new current element of this sequence. 
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for a new node.
   **/
   public void addAfter(double element)
   {
      if (cursor != null) {
         cursor.addNodeAfter(element);
         cursor = cursor.getLink();
         manyNodes++;
      } // end of if
      else {
         if (head == null) {
            head = new DoubleNode(element, null);
            manyNodes++;
            cursor = head;
         } // end of if
         else {
            cursor = head;
            while (cursor.getLink() != null)
               cursor = cursor.getLink();
            cursor.addNodeAfter(element);
            cursor = cursor.getLink();
            manyNodes++;
         } // end of else
      } // end of else
   } // end of addAfter


   /**
   * Add a new element to this sequence, before the current element. 
   * @param element</CODE>
   *   the new element that is being added
   * <dt><b>Postcondition:</b><dd>
   *   A new copy of the element has been added to this sequence. If there was
   *   a current element, then the new element is placed before the current
   *   element. If there was no current element, then the new element is placed
   *   at the start of the sequence. In all cases, the new element becomes the
   *   new current element of this sequence. 
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for a new node.
   **/
   public void addBefore(double element)
   {
      if (cursor != null) {
         if (head == cursor) {
            head = new DoubleNode(element, head);
            cursor = head;
            manyNodes++;
         }
         else {
            DoubleNode temp = head;
            while (temp.getLink() != cursor) {
               temp = temp.getLink();
            }
            temp.addNodeAfter(element);
            cursor = temp.getLink();
         }
      } // end of if
      else {
         if (head != null)
            head = new DoubleNode(element, head.getLink());
         else
            head = new DoubleNode(element, null);
         cursor = head;
         manyNodes++;
      } // end of else
   } // end of addBefore
   
   
   /**
   * Place the contents of another sequence at the end of this sequence.
   * @param addend</CODE>
   *   a sequence whose contents will be placed at the end of this sequence
   * <dt><b>Precondition:</b><dd>
   *   The parameter, addend</CODE>, is not null. 
   * <dt><b>Postcondition:</b><dd>
   *   The elements from addend</CODE> have been placed at the end of 
   *   this sequence. The current element of this sequence remains where it 
   *   was, and the addend</CODE> is also unchanged.
   * @exception NullPointerException
   *   Indicates that addend</CODE> is null. 
   * @exception OutOfMemoryError
   *   Indicates insufficient memory to increase the size of this sequence.
   **/
   public void addAll(DoubleLinkedSeq addend)
   {
      DoubleNode temp = head;
      DoubleLinkedSeq add = addend.clone();
      while (temp.getLink() != null)
         temp = temp.getLink();
      temp.setLink(add.head);
      manyNodes = manyNodes + add.size();
   }   
   
   
   /**
   * Move forward, so that the current element is now the next element in
   * this sequence.
   * @param - none
   * <dt><b>Precondition:</b><dd>
   *   isCurrent()</CODE> returns true. 
   * <dt><b>Postcondition:</b><dd>
   *   If the current element was already the end element of this sequence 
   *   (with nothing after it), then there is no longer any current element. 
   *   Otherwise, the new element is the element immediately after the 
   *   original current element.
   * @exception IllegalStateException
   *   Indicates that there is no current element, so 
   *   advance</CODE> may not be called.
   **/
   public void advance( )
   {
      if (cursor == null)
         throw new IllegalStateException("There is no current element.");
      if (cursor.getLink() == null)
         cursor = null;
      else
         cursor = cursor.getLink();
   }
   
   
   /**
   * Generate a copy of this sequence.
   * @param - none
   * @return
   *   The return value is a copy of this sequence. Subsequent changes to the
   *   copy will not affect the original, nor vice versa. 
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for creating the clone.
   **/ 
   public DoubleLinkedSeq clone( )
   {
      DoubleLinkedSeq answer;

      try {
         answer = (DoubleLinkedSeq) super.clone( );
      } catch (CloneNotSupportedException e) {
         throw new RuntimeException("This class does not implement Cloneable");
      } // end of try catch

      answer.head = DoubleNode.listCopy(head);

      return answer;
   }
   

   /**
   * Create a new sequence that contains all the elements from one sequence
   * followed by another.
   * @param s1</CODE>
   *   the first of two sequences
   * @param s2</CODE>
   *   the second of two sequences
   * <dt><b>Precondition:</b><dd>
   *   Neither s1 nor s2 is null.
   * @return
   *   a new sequence that has the elements of s1</CODE> followed by the
   *   elements of s2</CODE> (with no current element)
   * @exception NullPointerException
   *   Indicates that one of the arguments is null.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for the new sequence.
   **/   
   public static DoubleLinkedSeq concatenation(DoubleLinkedSeq s1, DoubleLinkedSeq s2)
   {
      DoubleLinkedSeq answer;
      answer = s1.clone();
      answer.addAll(s2);
      return answer;
   }


   /**
   * Accessor method to get the current element of this sequence. 
   * @param - none
   * <dt><b>Precondition:</b><dd>
   *   isCurrent()</CODE> returns true.
   * @return
   *   the current element of this sequence
   * @exception IllegalStateException
   *   Indicates that there is no current element, so 
   *   getCurrent</CODE> may not be called.
   **/
   public double getCurrent( )
   {
      if (cursor == null)
         throw new IllegalStateException("There is no current element.");
      return cursor.getData();
   }


   /**
   * Accessor method to determine whether this sequence has a specified 
   * current element that can be retrieved with the 
   * getCurrent</CODE> method. 
   * @param - none
   * @return
   *   true (there is a current element) or false (there is no current element at the moment)
   **/
   public boolean isCurrent( )
   {
      if (cursor != null)
         return true;
      else
         return false;
   }
              
   /**
   * Remove the current element from this sequence.
   * @param - none
   * <dt><b>Precondition:</b><dd>
   *   isCurrent()</CODE> returns true.
   * <dt><b>Postcondition:</b><dd>
   *   The current element has been removed from this sequence, and the 
   *   following element (if there is one) is now the new current element. 
   *   If there was no following element, then there is now no current 
   *   element.
   * @exception IllegalStateException
   *   Indicates that there is no current element, so 
   *   removeCurrent</CODE> may not be called. 
   **/
   public void removeCurrent( )
   {
      if (cursor == null)
         throw new IllegalStateException("There is no current element.");
      DoubleNode temp = head;
      while (temp.getLink() != cursor)
         temp = temp.getLink();
      temp.removeNodeAfter();
      cursor = temp.getLink();
      manyNodes--;
   }
                 
   
   /**
   * Determine the number of elements in this sequence.
   * @param - none
   * @return
   *   the number of elements in this sequence
   **/ 
   public int size( )
   {
      return manyNodes;
   }
   
   
   /**
   * Set the current element at the front of this sequence.
   * @param - none
   * <dt><b>Postcondition:</b><dd>
   *   The front element of this sequence is now the current element (but 
   *   if this sequence has no elements at all, then there is no current 
   *   element).
   **/ 
   public void start( ) {
      cursor = head;
   }

    /**
    * Set the current element at the front of this sequence.
    * @param - none
    * @return
    *   A string of the current linked sequence is returned
    *   the string shows all the elements in the sequence
    *   and the current element
    **/
   public String toString( ) {
      if (head == null)
         return "";

      DoubleNode temp = head;
      String answer = "";
      if (temp == cursor)
         answer = answer + "(" + temp.getData() + ")";
      else
         answer = answer + temp.getData();
      while (temp.getLink() != null) {
         temp = temp.getLink();
         if (temp == cursor)
            answer = answer + " (" + temp.getData() + ")";
         else
            answer = answer +" " + temp.getData();
      }
      return answer;
   }

     /**
     * return a DoubleLinkedSeq that is the reverse of the current DoubleLinkedSeq.
     * @param - none
     * Precondition:
     *    the DoubleLinkedSeq that is being reversed isn't null
     * @return
     *   A string of the current linked sequence is returned
     *   the string shows all the elements in the sequence
     *   and the current element
     **/
   public DoubleLinkedSeq reverse( ) {
      DoubleLinkedSeq answer = new DoubleLinkedSeq();
      DoubleNode temp = head;

      for (int i = 0; i < manyNodes; i++) {
         answer.addBefore(temp.getData());
         temp = temp.getLink();
      }
      return answer;
   }

     /**
     * Takes a double value and deletes all elements in the sequence that
     * are less than the given value.
     * @param - value
     *   The cutoff point for which values will get removed
     * Precondition:
     *   The current DoubleLinkedSeq isn't null
     * Postcondition:
     *   The current DoubleLinkedSeq no longer contains nodes
     *   with elements less than the given value.
     **/
   public void removeSmaller(double value) {
      DoubleNode cursor = head;
      while (cursor != null) {
         if (cursor.getData() < value)
            removeCurrent();
         else
            advance();
      }
   }

    /**
    * Set the current element at the front of this sequence.
    * @param - none
    * Precondition:
    *    That the current DoubleLinkedSeq isn't null.
    * @return
    *   A DoubleLinkedSeq that contains every other element
    *   of the current DoubleLinkedSeq.
    **/
   public DoubleLinkedSeq everyOther( ) {
      DoubleLinkedSeq answer = new DoubleLinkedSeq();
      DoubleNode temp = head;
      answer.addAfter(temp.getData());
      while (temp.getLink() != null && temp.getLink().getLink() != null) {
         temp = temp.getLink().getLink();
         answer.addAfter(temp.getData());
      }
      return answer;
   }
}
           
