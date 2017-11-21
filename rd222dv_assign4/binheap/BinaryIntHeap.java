package rd222dv_assign4.binheap;

public class BinaryIntHeap {
	// Important from lecture notes:
	// An array can be used to store the elements in a binary heap + Position 0
	// is never used
	// The root node is always in position 1 //Elements are added layer by layer

	private int[] heap;
	private int size;

	public BinaryIntHeap() { // Constructs an empty heap
		heap = new int[8];
		size = 1;
	}

	public void insert(int n) { // Add n to heap
		if (size == 1) {
			heap[size] = n;
			size++;
		} else if (size > 1) {
			if (size == heap.length) // resize
				resize();
			heap[size++] = n;
		}
		int index = size - 1;
		check(index);

	}
	
	public int pullHighest() { // Return and remove element with highest
								// priority
		if (size == 1) {
			throw new IllegalArgumentException("Queue is Empty");
		}
		int temp = heap[1]; //picking the first element and saving it in a variable
		heap[1] = heap[size - 1]; //decrease
	    size--;
		int index = 1;
		swap(index);
		return temp;
	}

	public int size() { // Current heap size
		return size - 1;
	}

	public boolean isEmpty() { // True if heap is empty
		return size == 1;
	}
	
	private void check(int a) { 
		if (a == 1) { //if index is 1, return
			return;
		} else if (heap[a] <= heap[a / 2]) //return if smaller than the parent
			return;
		else {
			int pos = a; //if both false, do recursion until root is reached
			int temp = heap[a / 2];
			int index = a / 2;
			heap[index] = heap[a];
			heap[pos] = temp;
			check(index);
		}
	}
	
	private void resize() { //double the size of the array
		int[] temp = new int[heap.length * 2];
		for (int i = 0; i < size; i++) {
			temp[i] = heap[i];
		}
		heap = temp;
	}

	private void swap(int n) {
		if (n == size - 1 || n * 2 > size - 1 || n * 2 + 1 > size - 1) { //return if last or no children
			return;
		}
		int left = heap[n * 2];
		int right = heap[n * 2 + 1];
		if (heap[n] >= left && heap[n] >= right) { //check if element at parameter index is >= to children, if so-return
			return;
		} else {
			if (left >= right) { //checking which child is bigger and then swap
				int temp = heap[n];
				heap[n] = left;
				heap[n * 2] = temp;
				swap(n * 2);
			} else {
				int temp = heap[n];
				heap[n] = right;
				heap[n * 2 + 1] = temp;
				swap(n * 2 + 1);
			}
		}
	}
}
