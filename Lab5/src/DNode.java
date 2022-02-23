
/** Node of a doubly linked list of strings */
public class DNode {
  private String element;	// String element stored by a node
  private DNode next, prev;	// Pointers to next and previous nodes

  /** Constructor that creates a node with given fields 
   *  Parameters: 
   *  	e - the initial element of this new node
   * 	p - a reference to the node before this new node
   * 	n - a reference to a node after this new node
   * 	(references may be null)
   *  Postcondition:
   *  	This new node contains the specified data and links to the 
   *  	previous and next nodes
   **/
  public DNode(String e, DNode p, DNode n) {
    element = e;
    prev = p;
    next = n;
  }
  
  /** Accessor method to get the element from this node. 
   *  Returns: 
   *  	the element of this node 
   **/
  public String getElement() { return element; }
  
  /** Accessor method to get a reference to the previous node.
   *  Returns:
   *	the previous node of this node 
   **/
  public DNode getPrev() { return prev; }
  
  /** Accessor method to get a reference to the next node.
   *  Returns:
   *  	the next node of this node 
   * */
  public DNode getNext() { return next; }
  
  /** Sets the element of this node
   *  Parameters:
   *  	newElem - the new element to place in this node
   *  Postcondition:
   *  	The element of this node has been set to newElem. 
   **/
  public void setElement(String newElem) { element = newElem; }
  
  /** Sets the previous node of this node
   *  Parameters:
   *  	newPrev - a reference to the node that should appear before 
   *  		this node (or the null reference)
   *  Postcondition:
   *  	The link to the node before this node has been set to newPrev. 
   **/
  public void setPrev(DNode newPrev) { prev = newPrev; }
  
  /** Sets the next node of this node
   *  Parameters:
   *  	newNext - a reference to the node that should appear after 
   *  		this node (or the null reference)
   *  Postcondition:
   *  	The link to the node after this node has been set to newNext. 
   **/
  public void setNext(DNode newNext) { next = newNext; }
}

