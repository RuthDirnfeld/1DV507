package rd222dv_assign2.Queues;

import java.util.Iterator;

/**
 * An interface representing a simple Queue. This interface defines the required
 * functionality for all <code>Queue</code> implementations. It provides support
 * for accessing (enqueue, dequeue, first, last) at the required position in the
 * list. It also contains basic support for sequential access of the whole
 * content (i.e., iterators). 
 * Inserts Object <code>element</code> at the last
 * position of the queue. For removing elements from the queue they can be
 * dequeued, and the element at the first position will be removed 
 * Illegal accesses (outside current range) should throw an unchecked exception of type
 * <code>IndexOutOfBoundsException</code>.
 * 
 * Currently available <code>Queue</code> implementations in the
 * <code>linked</code> package are:
 * <ul>
 * <li>{@link rd222dv_assign2.Queues.Queue}</li>
 * <li>{@link rd222dv_assign2.Queues.LinkedQueue}</li>
 * </ul>
 *
 * @author Ruth Dirnfeld
 * @version 1.0
 * @since 2017-02-01
 */
public interface Queue {
	/**
	 * Returns the size of the queue
	 * 
	 * @return the size of the queue;
	 */
	public int size(); // current queue size

	/**
	 * Returns true if no elements in Queue left
	 * 
	 * @return true if this queue is empty;
	 */
	public boolean isEmpty(); // true if queue is empty

	/**
	 * Enqueues an element into the queue. If the Queue is empty, the element
	 * inserted is the first element in the queue. Every inserted element after
	 * it will be at the position after it
	 * 
	 * @param element adding element to the queue and returning element at the last position of
	 * the queue
	 * 
	 */
	public void enqueue(Object element); // add element at end of queue

	/**
	 * Dequeues an element from the queue. It takes the element at head (first)
	 * position) and removes it. If the Queue is empty, an exception will be
	 * thrown.
	 * 
	 * @return return and remove first element.
	 * @throws IndexOutOfBoundsException
	 *             if <code>Queue</code> outside current range
	 *             <code>[0, size]</code>.
	 */
	public Object dequeue(); // return and remove first element.

	/**
	 * Returns the first element in the Queue List without removing it, if there
	 * are no elements it throws an exception
	 * 
	 * @return return (without removing) first element
	 * @throws IndexOutOfBoundsException
	 *             if <code>Queue</code> outside current range
	 *             <code>[0, size]</code>.
	 */
	public Object first(); // return (without removing) first element

	/**
	 * Returns the last element in the Queue List without removing it, if there
	 * are no elements it throws an exception
	 * 
	 * @return return (without removing) last element
	 * @throws IndexOutOfBoundsException
	 *             if <code>Queue</code> outside current range
	 *             <code>[0, size]</code>.
	 */
	public Object last(); // return (without removing) last element

	/**
	 * Returns a string representation of the current list content separated
	 * with commas.
	 * 
	 * 
	 * @return string representation of the content.
	 */
	public String toString(); // return a string representation of the queue
								// content
	/**
	*Returns an iterator that iterates over the Objects in first in first out order 
    * @return an iterator that iterates over the Objects in first in first out order 
    */
	public Iterator<Object> iterator(); // element iterator
	
	
}