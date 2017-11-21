package rd222dv_assign1.intCollection;

import java.util.NoSuchElementException;

public class ArrayIntStack extends AbstractIntCollection implements IntStack {

	@Override
	public void push(int n) {
		if (size == values.length) {
			throw new IllegalStateException("Cannot add to full stack");
		}
		values[size++] = n;
	}

	@Override
	public int pop() throws IndexOutOfBoundsException {
		if (size == 0) {
			throw new NoSuchElementException("Cannot pop from empty stack");
		}
		int value = values[size-1];
		size--;
		return value;
	}

	@Override
	public int peek() throws IndexOutOfBoundsException {
		if (size == 0) {
			throw new NoSuchElementException("Cannot peek into empty stack");
		}
		return values[size - 1];
	}

}
