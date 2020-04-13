


/***********************************
* EECS2011 - Assignment 3
* File name: EmptyDequeException.java
* Author: U. T. Nguyen
************************************/

public class EmptyDequeException extends RuntimeException {

    
    /**
   *
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constructs a new <code>EmptyQueueException</code>
   */
   public EmptyDequeException( String err ) {
        super( err );}
}