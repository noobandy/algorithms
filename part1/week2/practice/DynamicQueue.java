public class DynamicQueue {

	private static class Node {
		private int value;
		private Node next;

	}

	private Node head;
	private Node tail;
	private int size;

	public boolean isEmpty() {
		return head == null;
	}

	public int size() {
		return size;
	}

	public void enqueue(int element) {
		Node node = new Node();
		node.value = element;

		if(head == null) {
			head = tail = node;
		} else {
			tail.next = node;
			tail = node;
		}

		size++;
	}

	public int dequeue() {
		if(!isEmpty()) {
			int element = head.value;

			if(head == tail) {
				head = null;
				tail = null;
			} else {
				head = head.next;
			}
			size--;
			return element;
		} else {
			throw new RuntimeException("Queue is empty");
		}
	}

	public static void main(String[] args) {
        DynamicQueue queue = new DynamicQueue();

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
        while(!queue.isEmpty()) {
            System.out.format("%d%n", queue.dequeue());
            System.out.format("Queue size %d %n", queue.size());
        }

    }
}