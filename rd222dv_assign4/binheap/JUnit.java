package rd222dv_assign4.binheap;

import static org.junit.Assert.*;
import java.util.Random;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class JUnit {
	private static int test_count = 0;

	@Before
	public void setUp() { //executed before every test method
		test_count++;
		System.out.println("Test " + test_count);
	}

	@After
	public void tearDown() { //executed after every test method
	}

	@Test
	public void testSize() {

		BinaryIntHeap heap = new BinaryIntHeap(); //check with empty heap
		assertEquals(0, heap.size());
		
		for (int i = 0; i < 50; i++) { //filling the heap
			assertEquals(i, heap.size());
			heap.insert(i);
		}
		assertEquals(50, heap.size());
	}

	@Test
	public void testIsEmpty() {
		
		BinaryIntHeap heap = new BinaryIntHeap(); //check empty
		assertEquals(true, heap.isEmpty());

		heap.insert(1); //adding one element -> not empty
		assertEquals(false, heap.isEmpty());

	}

	@Test
	public void testPullHighest() {
		BinaryIntHeap heap = new BinaryIntHeap();

		for (int i = 0; i < 50; i++) { //filling the heap
			heap.insert(i);
		}
		
		for (int i = 49; i >= 0; i--) { //remove the elements and check if it is the highest
			assertEquals(i, heap.pullHighest());
		}
	}

	@Test
	public void testInsert() {
		BinaryIntHeap heap = new BinaryIntHeap(); //empty
		Random rand = new Random();

		for (int i = 1; i < 50; i++) { //adding 50

			if (i % 2 == 0) { // positive elements
				heap.insert(rand.nextInt((i + 1) * 2));
			}
			
			else { //negative
				int n = rand.nextInt((i + 1) * 2);
				heap.insert(-n);
			}
			assertEquals(false, heap.isEmpty()); //elements have been inserted
		}
	}
}