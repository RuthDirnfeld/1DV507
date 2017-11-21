package rd222dv_assign1.intCollection;

public class ArrayIntList extends AbstractIntCollection implements IntList {

	@Override
	public void add(int n) {
		if (size<values.length) { // If the array is long enough, add 'n' on the spot 'size' and increase the 'size' by 1
			values[size++] = n;
		}
	}

	@Override
	public void addAt(int n, int index) throws IndexOutOfBoundsException {
		int temp = size+1;
		for (int i=size; i>index-1; i--) {
			values[temp--] = values[i];
		}
		values[index] = n;  // Add n at the place of index 
		size++;
	}

	@Override
	public void remove(int index) throws IndexOutOfBoundsException {
		for (int i=index; i<size; i++) { // Takes the value of Index and change the value with the to the right
			values[i] = values[i+1];
		}
		size--; // decrease list because we took a value
	}

	@Override
	public int get(int index) throws IndexOutOfBoundsException {
		return values[index];
	}

	@Override
	public int indexOf(int n) {
		for(int i=0; i<values.length; i++) {
	         if(values[i] == n)
	             return i;
		}
		return -1;
	}
}
