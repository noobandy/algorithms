
public class QueueUsingStack<E> {

	private Deque<E> inStack;
	private Deque<E> outStack;

	public QueueUsingStack() {
		inStack = new Deque<E>();
		outStack = new Deque<E>();
	}


	public boolean isEmpty() {
		return inStack.isEmpty() && outStack.isEmpty();
	}

	public int size() {
		return inStack.size() + outStack.size();
	}

	public void enqueue(E element) {
		inStack.addLast(element);
	}

	public E dequeue() {
		if (outStack.isEmpty()) {
			while (!inStack.isEmpty()) {
				outStack.addLast(inStack.removeLast());
			}
		}

		return outStack.removeLast();
	}

	public static void main(String[] args) {
		QueueUsingStack<Integer> queue = new QueueUsingStack<Integer>();

		System.out.format("Queue is %s empty%n", queue.isEmpty() ? "" : "not");


		System.out.format("Queue size %d %n", queue.size());

		queue.enqueue(1);

		System.out.format("Queue is %s empty%n", queue.isEmpty() ? "" : "not");

		System.out.format("Queue size %d %n", queue.size());

		queue.enqueue(2);

		System.out.format("Queue is %s empty%n", queue.isEmpty() ? "" : "not");


		System.out.format("Queue size %d %n", queue.size());

		queue.enqueue(3);

		System.out.format("Queue is %s empty%n", queue.isEmpty() ? "" : "not");


		System.out.format("Queue size %d %n", queue.size());

		System.out.format("%d%n", queue.dequeue());
		System.out.format("%d%n", queue.dequeue());
		queue.enqueue(2);
		queue.enqueue(1);
		while (!queue.isEmpty()) {
			System.out.format("%d%n", queue.dequeue());
			System.out.format("Queue size %d %n", queue.size());
		}

	}
}