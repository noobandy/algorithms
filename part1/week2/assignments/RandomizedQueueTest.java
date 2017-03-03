public class RandomizedQueueTest {
	// unit testing (optional)
	public static void main(String[] args)   {
		RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();
		System.out.println(queue.isEmpty());
		System.out.println(queue.size());
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);

		System.out.println(queue.isEmpty());
		System.out.println(queue.size());
		for (Integer i : queue) {
			System.out.println(i);
		}

		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());

		System.out.println(queue.isEmpty());
		System.out.println(queue.size());

		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());

		System.out.println(queue.isEmpty());
		System.out.println(queue.size());

		for (int i = 0; i < 40; i++) {
			if (i % 2 == 0) {
				queue.enqueue(i);
			} else {
				queue.dequeue();
			}
		}
	}
}