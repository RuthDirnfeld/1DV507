package rd222dv_assign1.intCollection;

public class CollectionMain {

	public static void main(String[] args) {
		
		ArrayIntList list = new ArrayIntList();
		System.out.println("List: ");
		list.add(1);
		list.add(3);
		list.add(8);
		list.add(7);
		list.add(3);
		
		System.out.println(list);
		
		System.out.println("Index of 7 at pos: "+list.indexOf(7));
		
		list.addAt(9,2);
		
		System.out.println(list);
		
		System.out.println("List is empty: " + list.isEmpty());
		
		System.out.println("Index of 7 at pos: "+list.indexOf(7));
		
		list.remove(3);
		
		System.out.println("Remove int from index 3: "+list);
		
		ArrayIntStack stack = new ArrayIntStack();
		System.out.println("Stack: ");
		stack.push(1); // pushing elements to the stack
		stack.push(3);
		stack.push(8);

		// Peek at the top of the stack.
		System.out.println("Top of stack: " + stack.peek());

		// Pop the stack and display the result.
		System.out.println("Popping this element: " + stack.pop()); //?????????

		// Pop again.
		System.out.println("Popping this element: " + stack.pop());

		System.out.println("Stack Size: " + stack.size());
		
		System.out.println("Top of stack: " + stack.peek());
		
		System.out.println("Stack is empty: " + stack.isEmpty());
	}

}
