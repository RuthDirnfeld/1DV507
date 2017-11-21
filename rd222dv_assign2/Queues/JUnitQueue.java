package rd222dv_assign2.Queues;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.*;

public class JUnitQueue {

	Queue queue = new LinkedQueue();
	Queue arrQueue = new ArrayQueue();

	@Test
	public void testSize() {
		assertEquals(0, queue.size());

		// arrayTest
		assertEquals(0, arrQueue.size());
	}

	@Test
	public void testIsEmpty() {
		assertTrue(queue.isEmpty());
		assertEquals(queue.size(), 0);

		// arrayTest
		assertTrue(arrQueue.isEmpty());
		assertEquals(arrQueue.size(), 0);
	}

	@Test
	public void testEnqueue() {
		// numberOfInserts = 4;
		for (int i = 0; i < 4; i++) {
			queue.enqueue("cat");
		}
		assertTrue(!queue.isEmpty());
		assertEquals(queue.size(), 4);
		// System.out.println("4x enqueued "+queue);

		// arrayTest
		for (int i = 0; i < 4; i++) {
			arrQueue.enqueue("cat");
		}
		assertTrue(!arrQueue.isEmpty());
		assertEquals(arrQueue.size(), 4);
		// System.out.println("4x enqueued "+arrQueue);
	}

	@Test
	public void testEnqueueDequeue() {
		Object animal = "turtle";
		queue.enqueue(animal);
		// System.out.println("Enqueued "+queue);
		assertEquals(queue.dequeue(), animal);
		// System.out.println("Dequeued "+queue);

		// arrayTest
		Object arrAnimal = "turtle";
		arrQueue.enqueue(arrAnimal);
		// System.out.println("Enqueued "+arrQueue);
		assertEquals(arrQueue.dequeue(), arrAnimal);
		// System.out.println("Dequeued "+arrQueue);
	}

	@Test
	public void testFirst() {
		Object animal = "mouse";
		queue.enqueue(animal);
		int size = queue.size();
		assertEquals(queue.first(), animal);
		assertEquals(queue.size(), size);
		// System.out.println("EnqueueFirst "+queue);

		// arrayTest
		Object arrAnimal = "mouse";
		arrQueue.enqueue(arrAnimal);
		int arrSize = arrQueue.size();
		assertEquals(arrQueue.first(), arrAnimal);
		assertEquals(arrQueue.size(), arrSize);
		// System.out.println("EnqueueFirst "+arrQueue);
	}

	@Test
	public void testHundredInHundredOut() {
		for (int i = 0; i < 100; i++) {
			queue.enqueue(i);
		}
		for (int i = 0; i < 100; i++) {
			assertEquals(((Integer) queue.dequeue()).intValue(), i);
		}
	}

	@Test
	public void testLastToEmpty() {
		// numberOfRemoves = 5;
		for (int i = 0; i < 5; i++) {
			queue.enqueue("dog");
			// System.out.println(queue);
		}
		for (int i = 0; i < 5; i++) {
			queue.dequeue();
			// System.out.println(queue);
		}
		assertTrue(queue.isEmpty());
		assertEquals(queue.size(), 0);
		// System.out.println(queue);

	}

	@Test(expected = NoSuchElementException.class)
	public void testFirstToEmptyQueue() {
		assertTrue(queue.isEmpty());
		queue.dequeue();
	}

	@Test(expected = NoSuchElementException.class)
	public void testLastOnEmptyQueue() {
		assertTrue(queue.isEmpty());
		queue.dequeue();
	}

	@Test
	public void toStringReturnEmptyString() {
		String str = "[ ]";
		assertEquals(str, queue.toString(), arrQueue.toString());
		
		//assertEquals(queue.toString(), "");
		//assertEquals(arrQueue.toString(), "");
	}
	/*
	 * @Test public void testIterator() {
	 * 
	 * }
	 */
}
