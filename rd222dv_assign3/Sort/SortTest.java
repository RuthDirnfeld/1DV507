package rd222dv_assign3.Sort;

import org.junit.Test;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.Random;

public class SortTest {
	Random rand = new Random();
	private static int test_counter = 0; // test_count set up + tearDown from Jonas' JUnit lecture
	
	SortingAlgorithms sortTest = new SortingAlgorithms();
	Comparator<String> byLength =  (s1, s2) -> s2.length() - s1.length();
    String[] one = new String[]{"Jens"};
    String[] unsorted = new String[]{"Jens", "Jonas", "TestForLongest", "Anna", "Morgan"};
    String[] sorted = new String[]{"Jens", "Anna", "Jonas", "Morgan", "TestForLongest"};
    
	@Before
	public void setUp() { //executed before every test method (not test case)
		test_counter++;
		System.out.println("Test: " + test_counter);
	}
	@After
	public void tearDown() { // executed after every test method
	}

	@Test
	public void testIntInsertionSort() {

		int[] array = SortingAlgorithms.insertionSort(randIntArr(8, 100));

		System.out.println("Insertion: " + Arrays.toString(array)); 

		int size = array.length; // size of array
		boolean var = false; // boolean variable

		for (int i = 0; i < size - 1; i++) { //check if first variable is smaller than next
			if (array[i] <= array[i + 1]) {
				var = true; // if so, change boolean
			}
			assertEquals(true, var); // check
			var = false; 
		}
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testStringInsertionSort() { //it works in the SortingAlgorithms class when I use the normal test, but I seriously don't know why it doesn't work with Units
	
		assertTrue(Arrays.asList(sortTest.insertionSort(one,byLength)).contains(one));

        assertTrue(Arrays.asList(sortTest.insertionSort(unsorted,byLength)).contains(sorted));
	}

	private int[] randIntArr(int length, int n) { //array with random numbers

		int[] arr = new int[length];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(n);
		}
		return arr;
	}

}

