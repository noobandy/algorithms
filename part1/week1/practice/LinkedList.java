import java.util.Iterator;


public class LinkedList<E> implements Iterable<E> {

	private Node<E> head;
	private int size;
	private int updateCounter;

	public LinkedList() {

	}
	
	public void add(E element) {
		updateCounter++;
		size++;

		Node<E> node = new Node<E>();
		node.element = element;
		if(head == null) {
			// first element
			head = node;
		} else {
			// insert in the start
			node.next = head;
			head = node;
		}
	}

	public void remove(E element) {
		updateCounter++;

		Node<E> curr = head;
		Node<E> prev = curr;

		while(curr != null) {
			if(curr.element.equals(element)) {
				// found it 
				size--;
				if(curr == prev) {
					// element is in the head node
					head = curr.next;

				} else {
					prev.next = curr.next;
				}
				break;
			}

			prev = curr;
			curr = curr.next;
		}
	}

	public boolean contains(E element) {
		Node<E> curr = head;

		while(curr != null) {
			if(curr.element.equals(element)) {
				return true;
			}

			curr = curr.next;
		}

		return false;
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
		return new LinkedListIterator();
	}

	private class LinkedListIterator implements Iterator<E> {
		private Node<E> curr;
		private Node<E> prev;
		private Node<E> prevPrev;

		private int updateCounter;

		public LinkedListIterator() {
			curr = prev = prevPrev = head;
			this.updateCounter = LinkedList.this.updateCounter;
		}

		public boolean hasNext() {
			if(this.updateCounter != LinkedList.this.updateCounter) {
				throw new RuntimeException("list modified during iteration");
			}

			return curr != null;
		}

		public E next() {
			if(this.updateCounter != LinkedList.this.updateCounter) {
				throw new RuntimeException("list modified during iteration");
			}

			if(curr == null) {
				throw new RuntimeException("no element");
			}

			E element = curr.element;

			prevPrev = prev;
			prev = curr;
			curr = curr.next;

			return element;
		}

		public void remove() {
			if(this.updateCounter != LinkedList.this.updateCounter) {
				throw new RuntimeException("list modified during iteration");
			}

			if(prev == curr) {
				throw new RuntimeException("no element");
			}

			if(prev == head) {
				// head node
				head = curr;
				prev = curr;
			} else {
				prevPrev.next = curr;
				prev = curr;
			}

			
			LinkedList.this.size--;
			this.updateCounter++;
			LinkedList.this.updateCounter++;
		}
	}

	public static void main(String[] args) {

		LinkedList<Integer> numbers = new LinkedList<Integer>();
		Integer five = 5;
		Integer nine = 9;
		Integer minusOne = -1;

		for(int i = 0; i < 10; i++) {
			System.out.format("list is %sempty it's size is %d%n", numbers.isEmpty() ? "" : "not ", numbers.size());
			numbers.add(i);
		}

		System.out.format("list is %sempty it's size is %d%n", numbers.isEmpty() ? "" : "not ", numbers.size());	
		
		for(Integer number : numbers) {
			System.out.format("%d%n", number);
		}

		System.out.format("list %scontains %d%n", numbers.contains(five) ? "" : "doesn't ", five);
		System.out.format("list %scontains %d%n", numbers.contains(minusOne) ? "" : "doesn't ", minusOne);

		Iterator<Integer> iterator = numbers.iterator();
		
		while(iterator.hasNext()) {
			Integer number = iterator.next();

			if(number.equals(nine)) {
				iterator.remove();
				System.out.format("deleting %d from list, new size is %d%n", number, numbers.size());
			}

			if(number.equals(five)) {
				iterator.remove(); 
				System.out.format("deleting %d from list, new size is %d%n", number, numbers.size());
			}
		}

		System.out.format("calling next after hasNext has returned false%n");

		try {
			iterator.next();
		} catch(RuntimeException e) {
			System.out.format("received error %s%n", e.getMessage());
		}

		System.out.format("calling remove after hasNext has returned false%n");

		try {
			iterator.remove();
			System.out.format("calling remove after hasNext has returned again%n");
			iterator.remove();
		} catch(RuntimeException e) {
			System.out.format("received error %s%n", e.getMessage());
		}

		iterator = numbers.iterator();	

		while(iterator.hasNext()) {
			Integer number = iterator.next();

			if(number == nine) {
				System.out.format("modifying list during iteration");
				try {
					numbers.remove(five);
				} catch(RuntimeException e) {
					System.out.format("received error %s%n", e.getMessage());
				}
			}
		}

		iterator = numbers.iterator();

		while(iterator.hasNext()) {
			Integer number = iterator.next();
			iterator.remove();

			System.out.format("deleting %d from list, new size is %d%n", number, numbers.size());
		}

		System.out.format("list is %sempty it's size is %d%n", numbers.isEmpty() ? "" : "not ", numbers.size());
	}
}