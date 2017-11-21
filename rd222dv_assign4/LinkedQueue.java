package rd222dv_assign4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<T> implements Queue<T> {

	private class Node { //taken from assign2 and replaced Object with T
		private T data;
		private Node next;
	}
	
	private int size = 0;
	private Node head = null;
	private Node tail = null;

	public LinkedQueue() {} // Constructor

	@Override
	public int size() { //changed the size, because it was wrong in assign2 but everything else is pretty much the same
		return size;
	}

	@Override
	public boolean isEmpty() { //true if empty
		return head == null;
	}

	@Override
	public void enqueue(T element) { // add element at end of queue
		if (isEmpty() == true) {
			Node newNode = new Node();
			newNode.data = element;
			head = newNode;
			tail = head;

		} else {
			Node newNode = new Node();
			newNode.data = element;
			tail.next = newNode;
			tail = tail.next;
		}
		size++;
	}

	@Override
	public T dequeue() { //Removes and returns the element from this queue that was recently added.
		if (isEmpty() == true) {
			throw new NoSuchElementException();
		}

		T element = head.data;
		head = head.next;
		size--;
		return element;
	}

	@Override
	public T first() { // return (without removing) first element
		if (head == null) {
			throw new NoSuchElementException();
		} else
			return head.data;
	}

	@Override
	public T last() { // return (without removing) last element
		if (tail == null) {
			throw new NoSuchElementException();
		} else
			return tail.data;
	}

	@Override
	public String toString() { // return a string representation of the queue content
		StringBuilder str = new StringBuilder();
		Node newNode = new Node();
		newNode = head;
		str.append("<");
		while (newNode != null) {
			str.append(" " + newNode.data);
			newNode = newNode.next;
		}
		str.append(" >");
		return str.toString();
	}

	@Override
	public Iterator<T> iterator() {
		return new QueueIterator<T>();
	}

	private class QueueIterator<X> implements Iterator<X> { //private Iterator class / taken from assign2
		
		private Node pos = null;
		
		public X next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			if (pos == null) {
				pos = head;
			} else {
				pos = pos.next;
			}
			return (X) pos.data;
		}
		
		@Override
		public boolean hasNext() {

			if (pos == null) { //pos is null, return true if queue is not empty
				return head != null;
			} else
				return pos.next != null;
		}
	}			
}