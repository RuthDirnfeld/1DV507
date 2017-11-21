package rd222dv_assign4;

public class QueueMain {
	public static void main(String[] args) { 
		
	Queue <Object> queue = new LinkedQueue<Object>(); //main for testing taken from assign2 too

	queue.enqueue("cat");
	queue.enqueue("turtle");
	queue.enqueue("mouse");
	queue.enqueue("butterfly");

	System.out.println("Is Empty? " + queue.isEmpty());
	System.out.println("Current size: " + queue.size());
	System.out.println("Current queue: " + queue.toString());

	System.out.println("First: " + queue.first());
	System.out.println("Last: " + queue.last());

	System.out.println("Dequeue: " + queue.dequeue());
	System.out.println("Current size: " + queue.size());
	System.out.println("Current queue: " + queue.toString());

	queue.dequeue();
	queue.dequeue();
	System.out.println("Current size: " + queue.size());
	queue.dequeue();
	System.out.println("Is Empty? " + queue.isEmpty());
}
}
