import java.util.Iterator;

public class CircularLinkedQueue<E> implements Iterable<E> {

	private int size;
	private Node<E> last;

	public CircularLinkedQueue() {

	}

	public void enqueue(E element) {
		size++;

		Node<E> node = new Node<E>();
		node.element = element;

		if(last == null) {
			last = node;
			node.next = last;
		} else {
			node.next = last.next;
			last = node;
		}
	}

	public E dequeue() {
		size--;
		
		if(isEmpty()) {
			throw new RuntimeException("queue is empty");
		}

		E element = last.next.element;

		if(last == last.next) {
			// last node 
			last = null;
		} else {
			last.next = last.next.next;
		}

		return element;
	}

	public E first() {
		if(isEmpty()) {
			throw new RuntimeException("queue is empty");
		}

		return last.next.element;
	}

	public E last() {
		if(isEmpty()) {
			throw new RuntimeException("queue is empty");
		}
		return last.element;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}


	private class Node<E> {
		private E element;
		private Node<E> next;
	}

	public Iterator<E> iterator() {
		return null;
	}


	public static void main(String[] args) {
		
	}
}