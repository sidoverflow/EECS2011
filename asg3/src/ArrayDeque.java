
import java.util.Arrays;

/***********************************
* EECS2011 - Assignment 3
* File name: ArrayDeque.java
* Author: Sudarsan, Sidharth
* Email: lensman@my.yorku.ca
* EECS username: lensman
************************************/



public class ArrayDeque {
	public static final int INIT_CAPACITY = 8; // initial array capacity
	protected int capacity; // current capacity of the array
	protected int front; // index of the front element
	protected int rear; // index of the rear element
	protected int[] A; // array deque

	public ArrayDeque() // constructor method
	{
		A = new int[INIT_CAPACITY];
		capacity = INIT_CAPACITY;
		front = rear = 0;
	}

	/**
	 * Display the content of the deque
	 * 
	 */
	public void printDeque() {
		for (int i = front; i != rear; i = (i + 1) % capacity)
			System.out.print(A[i] + " ");
		System.out.println();
	}

	/**
	 * Display the content of the whole array
	 *
	 */
	public void printArray() {
		for (int i = 0; i < capacity; i++)
			System.out.print(A[i] + " ");
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
		
		return (capacity - front + rear) % capacity; 
	
	}
	/**
	 * Returns true if this collection is empty.
	 * 
	 * @return true if this collection is empty.
	 */
	public boolean isEmpty() {

		return front == rear; 
	}

	/**
	 * Returns the first element of the deque
	 * 
	 */
	public int getFirst() throws EmptyDequeException {
		
		if (isEmpty()) {
			throw new EmptyDequeException("Empty Deque");
		}
		
		return A[front];
	}

	/**
	 * Returns the last element of the deque
	 * 
	 */
	public int getLast() throws EmptyDequeException {

		if (isEmpty()) {
			throw new EmptyDequeException("Empty Deque");

		}
		return A[rear - 1];
	}

	/**
	 * Inserts e at the beginning (as the first element) of the deque
	 * 
	 */
	public void insertFirst(int e) {

		if (size() == (capacity - 1)) {
			if (rear == capacity - 1) {
				A = Arrays.copyOf(A, 2 * capacity);
				capacity *= 2;
			} else {
				int newCapacity = 2 * capacity;
				A = Arrays.copyOf(A, newCapacity);
				int count = capacity - rear - 1;
				int tmp;

				for (tmp = newCapacity - count; tmp < newCapacity; tmp++) {
					A[tmp] = this.removeFirst();

				}
				front = newCapacity - count;
				capacity *= 2;

			}

		}

		int localSize = size();
		if (isEmpty()) {
			front = (capacity - localSize + rear) % capacity;
		} else {
			front = (capacity - localSize + rear - 1) % capacity;
		}

		A[front] = e;
		rear = (front + localSize + 1) % capacity;

	}

	/**
	 * Inserts e at the end (as the last element) of the deque
	 * 
	 */
	public void insertLast(int e) {

		if (size() == (capacity - 1)) {
			if (rear == capacity - 1) {
				A = Arrays.copyOf(A, 2 * capacity);
				capacity *= 2;
			} else {
				int[] B;
				int newCapacity = 2 * capacity;
				B = Arrays.copyOf(A, newCapacity);
				int count = capacity - rear - 1;
				int tmp;

				for (tmp = newCapacity - count; tmp < newCapacity; tmp++) {
					B[tmp] = this.removeFirst();

				}
				front = newCapacity - count;
				capacity *= 2;
				A = B;

			}
		}

		A[rear] = e;
		rear = (front + size() + 1) % capacity;

	}

	/**
	 * Removes and returns the first element of the deque
	 * 
	 */
	public int removeFirst() throws EmptyDequeException {

		if (size() < (capacity / 4) + 1 && capacity > INIT_CAPACITY) {

			int j = 0;
			int[] temp = new int[capacity / 2];
			for (int i = front; i < rear; i = (++i % capacity)) {
				temp[j] = A[i];
				j++;
			}

			A = temp;
			capacity /= 2;
			front = 0;
			rear = j;
			int rm = A[front];
			A[front] = 0;
			front = (capacity - size() + rear + 1) % capacity;
			return rm;

		} else if (isEmpty()) {
			throw new EmptyDequeException("Empty Deque");
		}

		int rm = A[front];
		A[front] = 0;
		front = (capacity - size() + rear + 1) % capacity;

		return rm;
	}

	/**
	 * Removes and returns the last element of the deque
	 * 
	 */
	public int removeLast() throws EmptyDequeException {

		if (size() < (capacity / 4) + 1 && capacity > INIT_CAPACITY) {

			int a = 0;
			int[] temp = new int[capacity / 2];
			for (int i = front; i < rear; i = (++i % capacity)) {
				temp[a] = A[i];
				a++;
			}

			A = temp;
			capacity /= 2;
			front = 0;
			rear = a;
			int rm = A[front];
			A[front] = 0;
			front = (capacity - size() + rear + 1) % capacity;
			return rm;

		} else if (isEmpty()) {
			throw new EmptyDequeException("Empty Deque");
		}

		int rmIndex = (capacity + rear - 1) % capacity;
		int rm = A[rmIndex];
		A[rmIndex] = 0;

		rear = (capacity + rear - 1) % capacity;

		return rm;
	}
}