/**
 * 
 * A class that implements a queue.  It is your job to complete this class.  Your queue
 * will use a linked list constructed by QueueElements.  However, your queue must be general and allow
 * setting of any type of Object.  Also you cannot use ArrayLists or arrays (you will get zero).  
 * @author Andrei Daniel Vatasescu Predi
 * <p>Date</p> 01/03/2020
 * @Version 1.0.0
 *
 */


import java.util.NoSuchElementException;

public class Queue<T>{
	/**
	 * the head and the tail of the queue of type Queue Element
	 */
	private QueueElement<T> head;
	private QueueElement<T> tail;
	/**
	 * Constructs an empty Queue.
	 */
	public Queue () {
		head=null;
		tail=null;

	}
	
	/**
	 * Returns true if the queue is empty
	 */
	public boolean isEmpty () {
		if((head==null) && (tail==null)){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	/**
	 * Returns the element at the head of the queue
	 */
	public T peek () throws NoSuchElementException {
		if(isEmpty()){
			throw new NoSuchElementException();
		}
		else{
			return head.getElement();
		}
	}

	/**
	 * Removes the front element of the queue
	 */
	public void dequeue () throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			if (head == tail) {
				head = null;
				tail = null;
			} else {
				head = head.getNext();
			}
		}
	}

	/**
	 * Puts an element on the back of the queue.
	 */
	public void enqueue(T element) {
		QueueElement<T> newNode = new QueueElement (element, null);
		if(isEmpty()){
			head=newNode;
			tail=newNode;
		}
		else{
			tail.setNext(newNode);
			tail=newNode;
		}
	}
	
	/**
	 * Method to print the full contents of the queue in order from head to tail.
	 */
	public void print () {
		QueueElement<T> shape = head;
		while(shape!=null){
			System.out.println(shape.getElement()+",");
			shape = shape.getNext();
	}
		if(!isEmpty()){
			System.out.print("\n");
		}
		else{
			System.out.println("The queue is empty");
		}
	}
}

