
/***********************************
* EECS2011 - Assignment 3
* File name: ListDeque.java
* Author: Sudarsan, Sidharth
* Email: lensman@my.yorku.ca
* EECS username: lensman
************************************/




public class ListDeque 
{

   protected DNode header, trailer;  // dummy nodes

   protected int size;    // number of elements

   public ListDeque()     // constructor: initialize an empty deque
   {
      header = new DNode( 0, null, null );
      trailer = new DNode( 0, null, null );
      header.setNext(trailer);  // make header point to trailer
      trailer.setPrev(header);  // make trailer point to header
      size = 0;
   }


    /**
     * Display the content of the deque
     *
     */
    public void printDeque( )
    {
	for ( DNode p = header.getNext(); p != trailer; p = p.getNext() )
	    System.out.print( p.getElement() + " " );
	System.out.println();
    }



   // ***************************************
   // DO NOT MODIFY THE CODE ABOVE THIS LINE.
   // ADD YOUR CODE BELOW THIS LINE.
   //
   // ***************************************

   /**
     * Returns the number of items in this collection.
     * @return the number of items in this collection.
     */
    public int size( )
    {

      return size;   
    }


    /**
     * Returns true if this collection is empty.
     * @return true if this collection is empty.
     */ 
    public boolean isEmpty( )
    {

      return size == 0;   
    }


    /**
     * Returns the first element of the deque
     * 
     */
    public int getFirst( ) throws EmptyDequeException
    {
    	
    	if (isEmpty()) {
    		throw new EmptyDequeException("Empty Deque");
    	}

    	return header.getNext().getElement();          
    }


    /**
     * Returns the last element of the deque
     * 
     */
    public int getLast( ) throws EmptyDequeException
    {
    	
    	if (isEmpty()) {
    		throw new EmptyDequeException("Empty Deque");
    	}
    	
    	return trailer.getPrev().getElement(); 

    }


    /**
     * Inserts e at the beginning (as the first element) of the deque
     * 
     */
    public void insertFirst( int e )
    {
  
		DNode newNode = new DNode(e, null, null);
		DNode p = header;
		DNode n = p.getNext();
    	newNode.setPrev(p);
    	newNode.setNext(n);
    	p.setNext(newNode);
    	n.setPrev(newNode);
    	size++;
    	
    }


    /**
     * Inserts e at the end (as the last element) of the deque
     * 
     */
    public void insertLast( int e )
    {

    	DNode newNode = new DNode(e, null, null);
		DNode p = trailer.getPrev();
		DNode n = trailer;
    	newNode.setPrev(p);
    	newNode.setNext(n);
    	p.setNext(newNode);
    	n.setPrev(newNode);
    	size++;
    }


    /**
     * Removes and returns the first element of the deque
     * 
     */
    public int removeFirst( ) throws EmptyDequeException
    {

    	if (isEmpty()) {
    		throw new EmptyDequeException("Empty Deque");
    	}
    	
    	DNode prev = header;
    	DNode node = header.getNext();
    	DNode next = header.getNext().getNext();
    	
    	prev.setNext(next);
    	next.setPrev(prev);
    	size--;
    	
    	return node.getElement();
    	
    }


    /**
     * Removes and returns the last element of the deque
     * 
     */
    public int removeLast( ) throws EmptyDequeException
    {

    	if (isEmpty()) {
    		throw new EmptyDequeException("Empty Deque");
    	}
    	
    	DNode prev = trailer.getPrev().getPrev();
    	DNode node = trailer.getPrev();
    	DNode next = trailer;
    	
    	prev.setNext(next);
    	next.setPrev(prev);
    	size--;
    	
    	return node.getElement();
    }


} // end class
