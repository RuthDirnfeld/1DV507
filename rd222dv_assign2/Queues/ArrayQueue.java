package rd222dv_assign2.Queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue implements Queue {
	private int size = 0;
	private Object[] values = new Object[5];
	private int first = 0;
	private int last = 0;

	/* Constructor */
	public ArrayQueue() {

	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void enqueue(Object element) {

		/*
		 * Resize if size is equal to array length. During first time add
		 * element at position 0, this will be the first and last element of the
		 * queue. Increase the size. Otherwise, add the element at position size
		 * and increase the size.
		 * 
		 */

		if (size == values.length) {
			resize();
		}

		if (isEmpty() == true) { // during first element
			values[size] = element;
			first = size;
			last = first;
		} else {
			values[size] = element;
			last = size;
		}
		size++;
	}

	@Override
	public Object dequeue() {

		/*
		 * Throw error if array is empty. Otherwise use the private method and
		 * remove and return the object at position first.
		 */

		if (isEmpty() == true) {
			throw new NoSuchElementException();
		}
		Object obj = remove();
		// shrink(); //will shrink the array and no empty spaces left
		return obj;
	}

	@Override
	public Object first() {
		/*
		 * Throw error if array is empty. Otherwise return the object at
		 * position first.
		 */

		if (isEmpty() == true) {
			throw new NoSuchElementException();
		}
		return values[first];
	}

	@Override
	public Object last() {

		/*
		 * Throw error if array is empty. Otherwise return the object at
		 * position last.
		 */

		if (isEmpty() == true) {
			throw new NoSuchElementException();
		}

		return values[last];
	}

	@Override
	public Iterator iterator() {
		return new ArrayQueueIterator();
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("[ ");
		for (int i = 0; i < size; i++) {
			str.append(values[i] + " ");
		}
		str.append("]");
		return str.toString();
	}

	// double the array
	private void resize() {
		Object[] temp = new Object[values.length * 2];
		for (int i = 0; i < size; i++) {
			temp[i] = values[i];
		}
		values = temp;
	}

	/*
	 * First take the first element and save it in a variable, then put rest of
	 * the element in new array
	 */
	private Object remove() {
		Object[] temp = new Object[values.length];
		Object a = values[first];
		for (int i = 0; i < size - 1; i++) {
			temp[i] = values[i + 1];
		}
		values = temp;
		last = last - 1;
		/*
		 * change the last position, as we shift the second element to position
		 * first, so we automatically changed the first position.
		 */
		size--;
		return a;

	}

	/* Iterator */
	private class ArrayQueueIterator implements Iterator {

		private int total = 0;

		@Override
		public boolean hasNext() {
			return total < size;
		}

		@Override
		public Object next() {
			return values[total++];
		}

	}

	public static void main(String[] args) {
		Queue arrQueue = new ArrayQueue();

		arrQueue.enqueue("cat");
		arrQueue.enqueue("turtle");
		arrQueue.enqueue("mouse");
		arrQueue.enqueue("butterfly");

		System.out.println("Is Empty? " + arrQueue.isEmpty());
		System.out.println("Current size: " + arrQueue.size());
		System.out.println("Current queue: " + arrQueue.toString());

		System.out.println("First: " + arrQueue.first());
		System.out.println("Last: " + arrQueue.last());

		System.out.println("Dequeue: " + arrQueue.dequeue());
		System.out.println("Current size: " + arrQueue.size());
		System.out.println("Current queue: " + arrQueue.toString());

	}
}
/*public static final int MAX = 8; // default capacity of array

private Object[] queue; // has elements of queue
private int capacity; // capacity of array
private int head; // index where the next element will be dequeued
private int tail; // index where the next element will be enqueued

public ArrayQueue() {
	this(MAX);
}

public ArrayQueue(int capacity) {
	this.capacity = capacity;
	this.queue = new Object[capacity];
	this.head = 0;
	this.tail = 0;
}

@Override
public int size() {
	int size = tail - head;
	if (size < 0)
		size += queue.length;
	return size;
}
// return ((capacity - head + tail) % capacity);
// }

@Override
public boolean isEmpty() {
	if (size() == 0)
		// if (head == -1 && tail == -1) {
		return true;
	// }
	return false;
}

@Override
public void enqueue(Object element) {
	if (size() == capacity - 1) {
		throw new NoSuchElementException("Array is Full");
	} else
		queue[tail] = element;
	tail = (tail + 1) % capacity;

}

@Override
public Object dequeue() {
	if (isEmpty()) {
		throw new NoSuchElementException("Array is Empty");
	} else if (tail == head) {
		Object element = queue[tail];
		tail = head = -1;
		return element;
	} else {
		Object element = queue[head];
		head = (head + 1) % size();
		return element;
	}
}

@Override
public Object first() {
	if (isEmpty()) {
		throw new NoSuchElementException("Array is Empty");
	} else {
		return queue[head];
	}
}

@Override
public Object last() {
	if (isEmpty()) {
		throw new NoSuchElementException("Array is Empty");
	} else {
		return queue[tail - 1];
	}
}

@Override
public String toString() {
	String rep = "";
	for (int i = 0; i < size(); i++) {
		rep += queue[(head + i) % capacity].toString();
		rep += " ";
	}
	return rep;
}

@Override
public Iterator<Object> iterator() {
	Iterator<java.lang.Object> iterator = Arrays.stream(queue).iterator();
	return iterator;
}*/
