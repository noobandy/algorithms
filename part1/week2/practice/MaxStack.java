import java.util.NoSuchElementException;

public class MaxStack<E extends Comparable<? super E>> {

	private static class Node<E> {
		private E element;
		private Node<E> next;
		private Node<E> prevMax;
	}

	private Node<E> head;
	private Node<E> maxNode;
	private int size;

	public MaxStack() {

	}

	public boolean isEmpty() {
		return head == null;
	}

	public int size() {
		return size;
	}

	public void push(E element) {
		if(element == null) {
			throw new NullPointerException("element is null");
		}

		Node<E> node = new Node<E>();
		node.element = element;

		if(isEmpty()) {
			head = node;
			maxNode = node;
		} else {
			if(node.element.compareTo(maxNode.element) > 0) {
				node.prevMax = maxNode;
				maxNode = node;
			}

			node.next = head;
			head = node;
		}

		size++;
	}

	public E pop() {
		if(isEmpty()) {
			throw new NoSuchElementException("stack is empty");
		}
		
		if(maxNode == head) {
			maxNode = head.prevMax;
		}
		E element = head.element;

		head = head.next;

		size--;
		return element;
	}

	public E max() {
		if(isEmpty()) {
			throw new NoSuchElementException("stack is empty");
		}
		
		return maxNode.element;
	}

	public static void main(String[] args) {
		MaxStack<Integer> stack = new MaxStack<Integer>();

		System.out.format("Stack is %s empty%n", stack.isEmpty() ? "" : "not");

		

		System.out.format("Stack size %d %n", stack.size());

		stack.push(1);

		System.out.format("Stack is %s empty%n", stack.isEmpty() ? "" : "not");

		
		System.out.format("Stack size %d %n", stack.size());

		System.out.format("Max element in stack is %d %n", stack.max());

		stack.push(2);

		System.out.format("Stack is %s empty%n", stack.isEmpty() ? "" : "not");

		System.out.format("Stack size %d %n", stack.size());

		System.out.format("Max element in stack is %d %n", stack.max());

		stack.push(3);

		System.out.format("Stack is %s empty%n", stack.isEmpty() ? "" : "not");

		System.out.format("Stack size %d %n", stack.size());

		System.out.format("Max element in stack is %d %n", stack.max());

		stack.push(5);
		stack.push(4);
		stack.push(10);
		stack.push(3);
		stack.push(7);
		stack.push(6);
		
		while(!stack.isEmpty()) {
			System.out.format("Max element in stack is %d %n", stack.max());
			System.out.format("%d%n", stack.pop());
			System.out.format("Stack size %d %n", stack.size());

		}


	}
}