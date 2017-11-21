package rd222dv_assign4;

import java.util.Iterator;
import static org.junit.Assert.*;
import org.junit.*;

public class QueueJUnit { //most of the JUnit tests have been taken from assign2
	private static int test_count = 0;
 
	@Before // executed before every test method 
	public void setUp() {
		test_count++;
		System.out.println("Test: " + test_count);
	}

	@After // executed after every test method
	public void tearDown() {
	}

	@Test
	public void testSize() {
	
		Queue<Integer> queueInt = new LinkedQueue<Integer>();
		Queue<String> queueStr = new LinkedQueue<String>();

		assertEquals(0, queueInt.size()); //if is Empty
		assertEquals(0, queueStr.size());

		for (int i = 0; i < 50; i++) { //enqueue 50
			queueInt.enqueue(50);
			queueStr.enqueue("" + 50);
		}
		assertEquals(50, queueInt.size()); //check if size is 50
		assertEquals(50, queueStr.size());
	}

	@Test
	public void testIsEmpty() {

		Queue<Integer> queueInt = new LinkedQueue<Integer>();
		Queue<String> queueStr = new LinkedQueue<String>();

		assertEquals(true, queueInt.isEmpty()); //if is empty
		assertEquals(true, queueStr.isEmpty());

		queueInt.enqueue(50); //if is 50
		queueStr.enqueue("" + 50);

		assertEquals(false, queueInt.isEmpty());
		assertEquals(false, queueStr.isEmpty());
	}

	@Test
	public void testEnqueue() {
		Queue<Integer> queueInt = new LinkedQueue<Integer>();
		Queue<String> queueStr = new LinkedQueue<String>();

		for (int i = 0; i < 50; i++) {
			queueInt.enqueue(i);
			queueStr.enqueue("" + i);

			assertTrue(!queueInt.isEmpty());
			assertTrue(!queueStr.isEmpty());			
		}
	}

	@Test
	public void testEnqueueDequeue() {
		Queue<Integer> queueInt = new LinkedQueue<Integer>();
		Queue<String> queueStr = new LinkedQueue<String>();

		for (int i = 0; i < 50; i++) { //first adding
			queueInt.enqueue(i);
			queueStr.enqueue("" + i);
		}

		for (int i = 0; i < 50; i++) { //removing again
			assertEquals(i, (int) queueInt.dequeue()); 
			assertEquals("" + i, queueStr.dequeue());
		}
	}

	@Test
	public void testFirst() {
		Queue<Integer> queueInt = new LinkedQueue<Integer>();
		Queue<String> queueStr = new LinkedQueue<String>();

		for (int i = 0; i < 50; i++) { //adding to queue
			queueInt.enqueue(i);
			queueStr.enqueue("" + i);
		}

		assertEquals(0, (int) queueInt.first());
		assertEquals("" + 0, queueStr.first());

		Queue<Integer> queueInt1 = new LinkedQueue<Integer>(); //test with 1 Element
		Queue<String> queueStr1 = new LinkedQueue<String>();

		queueInt1.enqueue(50);
		queueStr1.enqueue("" + 50);

		assertEquals(50, (int) queueInt1.first()); 
		assertEquals("" + 50, queueStr1.first());

	}

	@Test
	public void testLast() {
		Queue<Integer> queueInt = new LinkedQueue<Integer>();
		Queue<String> queueStr = new LinkedQueue<String>();

		for (int i = 0; i < 50; i++) { //adding to queue
			queueInt.enqueue(i);
			queueStr.enqueue("" + i);

			assertEquals(i, (int) queueInt.last()); //test last
			assertEquals("" + i, queueStr.last());
		}
		
		Queue<Integer> queueInt1 = new LinkedQueue<Integer>(); //test with 1 element
		Queue<String> queueStr1 = new LinkedQueue<String>();

		queueInt1.enqueue(50);
		queueStr1.enqueue("" + 50);

		assertEquals(50, (int) queueInt1.last()); /* Check */
		assertEquals("" + 50, queueStr1.last());
	}

	@Test
	public void testString() {
		
		Queue<Integer> queueInt = new LinkedQueue<Integer>();
		Queue<String> queueStr = new LinkedQueue<String>();

		String str = "< >";
		assertEquals(str, queueInt.toString());
		assertEquals(str, queueStr.toString());

	}

	@Test
	public void testIterator() {
		
		Queue<Integer> queueInt = new LinkedQueue<Integer>();
		Queue<String> queueStr = new LinkedQueue<String>();

		for (int i = 0; i < 50; i++) { //adding to queue
			queueInt.enqueue(i);
			queueStr.enqueue("" + i);

		}
		
		//test if Iterator has same element as inserted above
		Iterator<Integer> IntIt = queueInt.iterator();
		Iterator<String> StrIt = queueStr.iterator();

		int j = 0;
		while (IntIt.hasNext()) {
			assertEquals(j, (int) IntIt.next());
			j++;
		}
		
		int k = 0;
		while (StrIt.hasNext()) {
			assertEquals("" + k, StrIt.next());
			k++;
		}

		Queue<Integer> queueInt1 = new LinkedQueue<Integer>(); //empty queue
		Queue<String> queueStr1 = new LinkedQueue<String>();

		Iterator<Integer> intQueue = queueInt1.iterator();
		Iterator<String> strQueue = queueStr1.iterator();

		assertEquals(false, intQueue.hasNext());
		assertEquals(false, strQueue.hasNext());

	}
}