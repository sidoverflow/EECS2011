
/***********************************
* EECS2011 - Assignment 3
* File name: AnotherListDeque.java
* Author: Sudarsan, Sidharth
* Email: lensman@my.yorku.ca
* EECS username: lensman
************************************/


public class AnotherListDeque {

	protected DNode head, tail; // head and tail contain actual data (int)

	protected int size; // number of elements

	public AnotherListDeque() // constructor: initialize an empty deque
	{
		head = tail = null;

		size = 0;
	}

	/**
	 * Display the content of the deque
	 *
	 */
	public void printDeque() {

		for (DNode p = head; p != null; p = p.getNext())
			System.out.print(p.getElement() + " ");
		System.out.println();

	}

	// ***************************************
	// DO NOT MODIFY THE CODE ABOVE THIS LINE.
	// ADD YOUR CODE BELOW THIS LINE.
	//
	// ***************************************

	/**
	 * Returns the number of items in this collection.
	 * 
	 * @return the number of items in this collection.
	 */
	public int size() {

		return size; 
	}

	/**
	 * Returns true if this collection is empty.
	 * 
	 * @return true if this collection is empty.
	 */
	public boolean isEmpty() {

		return size == 0;
	}

	/**
	 * Returns the first element of the deque
	 * 
	 */
	public int getFirst() throws EmptyDequeException {

		if (isEmpty()) {
			throw new EmptyDequeException("Empty Deque");
		}

		return head.getElement(); 
	}

	/**
	 * Returns the last element of the deque
	 * 
	 */
	public int getLast() throws EmptyDequeException {

		if (isEmpty()) {
			throw new EmptyDequeException("Empty Deque");
		}

		return tail.getElement(); 
	}

	/**
	 * Inserts e at the beginning (as the first element) of the deque
	 * 
	 */
	public void insertFirst(int e) {
		
		DNode newNode = new DNode(e, null, null);
		DNode n;
		DNode p;

		if (size == 0) {
			head = newNode;
			size++;
		}

		else if (size == 1) {
			n = head;
			head = newNode;
			head.setNext(n);
			n.setPrev(head);
			tail = n;
			size++;

		} else {
			p = head;
			newNode.setNext(head);
			head = newNode;
			p.setPrev(newNode);
			size++;
		}

	}

	/**
	 * Inserts e at the end (as the last element) of the deque
	 * 
	 */
	public void insertLast(int e) {
		
		DNode n;
		DNode newNode = new DNode(e, null, null);
		n = tail;
		newNode.setPrev(tail);
		tail = newNode;
		n.setNext(newNode);

		size++;
	}

	/**
	 * Removes and returns the first element of the deque
	 * 
	 */
	public int removeFirst() throws EmptyDequeException {

		if (head == null) {
			throw new EmptyDequeException("Empty Deque");
		}
		DNode value = head;
		head = head.getNext();
		size--;
		return value.getElement();
	}

	/**
	 * Removes and returns the last element of the deque
	 * 
	 */
	public int removeLast() throws EmptyDequeException {

		if (head == null) {
			throw new EmptyDequeException("Empty Deque");
		}
		DNode value = tail;
		tail = tail.getPrev();
		tail.setNext(null);
		size--;
		return value.getElement();

	}

} // end class
