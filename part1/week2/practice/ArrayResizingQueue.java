import java.util.*;

public class ArrayResizingQueue<Item> implements Iterable<Item> {
	private static final int INITIAL_CAPACITY = 20;
	private int size;
	private int head;
	private int tail;
	private Item[] items;

	// construct an empty randomized queue
	public ArrayResizingQueue() {
		items = (Item[]) new Object[INITIAL_CAPACITY];
	}

	private void grow() {
		int newCapacity = items.length * 2;
		System.out.format("growing form %d to %d.%n", items.length, newCapacity);

		Item[] temp = (Item[]) new Object[newCapacity];
		int curr = head;
		head = curr % newCapacity;
		while (curr != tail) {
			temp[curr % newCapacity] = items[curr % items.length];
			curr = (curr + 1) % items.length;
		}
		tail = curr % newCapacity;
		items = temp;
	}

	private void shrink() {

		int newCapacity = items.length / 2;
		System.out.format("shrinking form %d to %d.%n", items.length, newCapacity);

		Item[] temp = (Item[]) new Object[newCapacity];
		int curr = head;
		head = curr % newCapacity;

		while (curr != tail) {
			temp[curr % newCapacity] = items[curr % items.length];
			curr = (curr + 1) % items.length;
		}
		tail = curr % newCapacity;

		items = temp;
	}

	private void ensureCapacity() {

		if (size == (items.length - 1)) {
			// grow to double
			grow();
		} else {
			if (items.length > INITIAL_CAPACITY && size == (items.length / 4)) {
				// shrink half
				shrink();
			}
		}
	}

	// is the queue empty?
	public boolean isEmpty()  {
		return head == tail;
	}

	// return the number of items on the queue
	public int size() {
		return size;
	}

	// add the item
	public void enqueue(Item item)   {

		ensureCapacity();

		items[tail] = item;
		tail = (tail + 1) % items.length;

		size++;
	}

	// remove and return a random item
	public Item dequeue()	{
		Item item = items[head];
		items[head] = null;
		head = (head + 1) % items.length;
		size--;
		ensureCapacity();
		return item;
	}

	// return (but do not remove) a random item
	public Item sample()	{
		return items[head];
	}

	// return an independent iterator over items in random order
	public Iterator<Item> iterator() {
		return new RandomIterator<Item>(items, head, tail);
	}

	private static class RandomIterator<Item> implements Iterator<Item> {
		private Item[] items;
		private int head;
		private int tail;

		public RandomIterator(Item[] items, int head, int tail) {
			this.items = items;
			this.head = head;
			this.tail = tail;
		}

		public boolean hasNext() {
			return head != tail;
		}

		public Item next() {
			Item item = items[head];
			head = (head + 1) % items.length;
			return item;
		}

		public void remove() {

		}
	}

	// unit testing (optional)
	public static void main(String[] args)   {
		ArrayResizingQueue<Integer> queue = new ArrayResizingQueue<Integer>();
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