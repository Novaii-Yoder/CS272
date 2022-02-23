                                                                                                                                                                                                                         
/** Doubly linked list with nodes of type DNode storing strings. */
public class DList {
  private int size;			// number of elements
  private DNode header, trailer;	// sentinels
  
  /** Constructor that creates an empty list */
  public DList() { 
    size = 0;
    header = new DNode(null, null, null);	// create header
    trailer = new DNode(null, header, null);	// create trailer
    header.setNext(trailer);	// make header and trailer point to each other
  }
  
  /** Returns the number of elements in the list */
  public int size() { return size; }
  
  /** Returns whether the list is empty */
  public boolean isEmpty() { return (size == 0); }
  
  /** Returns the first node of the list
   *  Precondition:
   *  	List is not empty
   *  Throws: IllegalStateException
   *	Indicates that the list is empty
   **/
  public DNode getFirst() throws IllegalStateException {
    if (isEmpty()) throw new IllegalStateException("List is empty");
    return header.getNext();
  }
  
  /** Returns the last node of the list
   *  Precondition:
   *  	List is not empty
   *  Throws: IllegalStateException
   *	Indicates that the list is empty
   **/
  public DNode getLast() throws IllegalStateException {
    if (isEmpty()) throw new IllegalStateException("List is empty");
    return trailer.getPrev();
  }
  
  /** Returns the node before the given node v.
   *  Parameters:
   * 	v - reference to a node in the list
   *  Precondition:
   *  	v is not the header and v is not null
   *  Returns:
   *  	the node before the given node v. 
   *  Throws: IllegalArgumentException
   *  	Indicates that v is the header 
   **/
  public DNode getPrev(DNode v) throws IllegalArgumentException {
    if (v == header) throw new IllegalArgumentException
      ("Cannot move back past the header of the list");
    return v.getPrev();
  }
  
  /** Returns the node after the given node v. 
   *  Parameters:
   * 	v - reference to a node in the list
   *  Precondition:
   *  	v is not the trailer and v is not null 
   *  Returns:
   *  	the node after the given node v. 
   *  Throws: IllegalArgumentException
   *  	Indicates that v is the trailer 
   **/
  public DNode getNext(DNode v) throws IllegalArgumentException {
    if (v == trailer) throw new IllegalArgumentException
      ("Cannot move forward past the trailer of the list");
   return v.getNext();
  }

  /** Inserts the given node z before the given node v.
   *  Parameters:
   * 	v - reference to a node in the list, 
   *    z - reference to the node to be inserted 
   *  Precondition:
   *  	v is not the header and v is not null and z is not null
   *  Postcondition:
   *  	Node z has been inserted before the given node v
   *  Throws: IllegalArgumentException
   *  	Indicates that v is the header 
   **/
  public void addBefore(DNode v, DNode z) throws IllegalArgumentException {
    DNode u = getPrev(v);	// may throw an IllegalArgumentException

    z.setPrev(u);
    z.setNext(v);
    v.setPrev(z);
    u.setNext(z);
    size++;
  }
  
  /** Inserts the given node z after the given node v.
   *  Parameters:
   * 	v - reference to a node in the list, 
   *    z - reference to the node to be inserted
   *  Precondition:
   *  	v is not the trailer and v is not null and z is not null
   *  Postcondition:
   *  	Node z has been inserted after the given node v
   *  Throws: IllegalArgumentException
   *  	Indicates that v is the trailer
   **/
  public void addAfter(DNode v, DNode z) throws IllegalArgumentException {
    DNode w = getNext(v);	// may throw an IllegalArgumentException

    z.setPrev(v);
    z.setNext(w);
    w.setPrev(z);
    v.setNext(z);
    size++;
  }
  
  /** Inserts the given node v at the head of the list
   *  Parameters:
   *  	v - reference to the node to be inserted
   *  Precondition: v is not null 
   *  Postcondition:
   *  	Node v has been inserted at the head of the list
   **/
  public void addFirst(DNode v) {
    addAfter(header, v);
  }
  
  /** Inserts the given node v at the tail of the list
   *  Parameters:
   *  	v - reference to the node to be inserted
   *  Precondition: v is not null 
   *  Postcondition:
   *  	Node v has been inserted at the tail of the list
   **/
  public void addLast(DNode v) {
    addBefore(trailer, v);
  }
  
  /** Removes the given node v from the list.
   *  Parameters:
   *  	v - reference to the node to be removed 
   *  Precondition:
   *  	v is not the header and v is not the trailer
   *  Postcondition:
   *  	Node v has been removed from the linked list
   **/
  public void remove(DNode v) {
    DNode u = getPrev(v);	// may throw an IllegalArgumentException

    DNode w = getNext(v);	// may throw an IllegalArgumentException
    // unlink the node from the list 
    w.setPrev(u);
    u.setNext(w);
    v.setPrev(null);
    v.setNext(null);
    size--;
  }

  /** Returns whether a given node has a previous node
   *  Parameters:
   * 	v - reference to a node in the list
   *  Precondition: v is not null 
   *  Returns:
   *    true if v has a previous node and the previous node is not a header; 
   *    false otherwise
   **/
  public boolean hasPrev(DNode v) { 
	  return (v.getPrev() != header) && (v != header) ; 
  }
  
  /** Returns whether a given node has a next node
   *  Parameters:
   * 	v - reference to a node in the list
   *  Precondition: v is not null 
   *  Returns:
   *    true if v has a next node and the next node is not a trailer; 
   *    false otherwise 
   **/
  public boolean hasNext(DNode v) { 
	  return (v.getNext() != trailer) && (v != trailer); 
  }
  
  /** Returns a string representation of the list */
  public String toString() {
    String s = "[";
    DNode v = header.getNext();
    while (v != trailer) {
      s += v.getElement();
      v = v.getNext();
      if (v != trailer)
	s += ",";
    }
    s += "]";
    return s;
  }
}
