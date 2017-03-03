import java.util.*;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private static final int INITIAL_CAPACITY = 1;
	private int size;
	private Item[] items;

	// construct an empty randomized queue
	public RandomizedQueue() {
		items = (Item[]) new Object[INITIAL_CAPACITY];
	}

	private void resize(int newSize) {
		Item[] temp = (Item[]) new Object[newSize];
		for (int i = 0; i < size; i++) {
			temp[i] = items[i];
		}
		items = temp;
	}

	// is the queue empty?
	public boolean isEmpty()  {
		return size == 0;
	}

	// return the number of items on the queue
	public int size() {
		return size;
	}

	// add the item
	public void enqueue(Item item)   {
		if (item == null) {
			throw new NullPointerException();
		}

		items[size++] = item;

		if (size >= items.length) {
			resize(items.length * 2);
		}
	}

	// remove and return a random item
	public Item dequeue()	{
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		int i = StdRandom.uniform(size);
		Item item = items[i];
		items[i] = items[--size];
		items[size] = null;

		if (size <= (items.length / 4)) {
			resize(items.length / 2);
		}

		return item;
	}

	// return (but do not remove) a random item
	public Item sample()	{
		int i = StdRandom.uniform(size);
		return items[i];
	}

	// return an independent iterator over items in random order
	public Iterator<Item> iterator() {
		return new RandomIterator<Item>(items, size);
	}

	private static class RandomIterator<Item> implements Iterator<Item> {
		private Item[] items;
		private int size;

		public RandomIterator(Item[] items, int size) {
			this.items = (Item[]) new Object[items.length];

			for (int i = 0; i < items.length; i++) {
				this.items[i] = items[i];
			}

			this.size = size;
		}

		public boolean hasNext() {
			return size != 0;
		}

		public Item next() {
			if (size == 0) {
				throw new NoSuchElementException();
			}

			int i = StdRandom.uniform(size);
			Item item = items[i];
			items[i] = items[--size];
			items[size] = null;
			return item;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

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