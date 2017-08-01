public class DoublyLinkedList<E> {
	
	private Node head;
	private int size;

	public DoublyLinkedList() {
		head = new Node();
		head.next = head;
		head.prev = head;
		size = 0;
	}

	public void addFirst(E element) {
		addBefore(head, element);
	}

	public E getFirst() {
		if(isEmpty()) {
			throw new RuntimeException("list empty");
		}
		
		return head.prev.element;
	}

	public E removeFirst() {
		if(isEmpty()) {
			throw new RuntimeException("list empty");
		}

		Node first = head.prev;

		first.next.prev = first.prev;
		first.prev.next = first.next;

		size--;
		return first.element;
	}

	public void addLast(E element) {
		addAfter(head, element);
	}

	public E getLast() {
		if(isEmpty()) {
			throw new RuntimeException("list empty");
		}
		
		return head.next.element;
	}



	public E removeLast() {
		if(isEmpty()) {
			throw new RuntimeException("list empty");
		}

		Node last = head.next;
		
		last.prev.next = last.next;
		last.next.prev = last.prev;

		size--;
		
		return last.element;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	private void addAfter(Node after, E element) {
		Node node = new Node();
		node.element = element;
		node.next = after.next;
		node.prev = after;

		after.next.prev = node;
		after.next = node;

		size++;
	}

	private void addBefore(Node before, E element) {
		Node node = new Node();
		node.element = element;
		node.next = before.prev;
		node.prev = before;

		before.prev.prev = node;
		before.prev = node;

		size++;
	}

	private class Node {
		Node next;
		Node prev;
		E element;
	}

	public static void main(String[] args) {
		DoublyLinkedList<Integer> nums = new DoublyLinkedList<Integer>();

		System.out.format("list size is %d%n", nums.size());

		System.out.format("list is %s empty%n", nums.isEmpty() ? "" : "not");

		System.out.format("as stack %n");

		for(int i = 0; i < 5; i++) {
			nums.addLast(i);
			System.out.format("push %d , size: %d, top: %d%n", i, nums.size(), nums.getLast());
		}

		for(int i = 0; i < 5; i++) {
			int top = nums.removeLast();
			System.out.format("pop %d size: %d%n", top, nums.size());
		}

		System.out.format("as queue %n");

		for(int i = 0; i < 5; i++) {
			nums.addLast(i);
			System.out.format("enqueue %d , size: %d, front: %d%n", i, nums.size(), nums.getFirst());
		}

		for(int i = 0; i < 5; i++) {
			int front = nums.removeFirst();
			System.out.format("dequeue %d size: %d%n", front, nums.size());
		}
	}
}