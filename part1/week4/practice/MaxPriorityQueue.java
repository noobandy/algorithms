
public class MaxPriorityQueue<E extends Comparable<E>> {

	private E[] elemensts;
	private int index;

	public MaxPriorityQueue(int capacity) {
		elemensts = (E[]) new Comparable[capacity + 1];
		index = 0;
	}

	public int size() {
		return index;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void add(E elemenst) {
		if(size() == elemensts.length - 1) {
			throw new RuntimeException("queue is full");
		}

		elemensts[++index] = elemenst;
		swim(index);
	}

	public E remove() {
		if(isEmpty()) {
			throw new RuntimeException("queue is empty");
		}

		E elemenst = elemensts[1];
		swap(1, index);
		elemensts[index] = null;
		index--;
		sink(1);

		return elemenst;
	}

	public E max() {
		if(isEmpty()) {
			throw new RuntimeException("queue is empty");
		}

		return elemensts[1];
	}

	private void sink(int k) {
		while((k * 2) < index) {
			if(elemensts[k].compareTo(elemensts[k * 2]) < 0) {
				swap(k, k * 2);
				k = k * 2;
			} else if(elemensts[k].compareTo(elemensts[(k * 2) + 1]) < 0) {
				swap(k, (k * 2) + 1);
				k = (k * 2) + 1;
			} else {
				break;
			}
		}
	}

	private void swim(int k) {
		while(k > 1 && elemensts[k / 2].compareTo(elemensts[k]) < 0) {
			swap(k, k / 2);
			k = k / 2;
		}
	}

	private void swap(int i, int j) {
		E temp = elemensts[i];
		elemensts[i] = elemensts[j];
		elemensts[j] = temp;
	}

	public static void main(String[] args) {
		MaxPriorityQueue<Integer> queue = new MaxPriorityQueue<Integer>(6);

		System.out.println(queue.size());
		System.out.println(queue.isEmpty());
		
		queue.add(1);
		System.out.println(queue.max());
		queue.add(3);
		System.out.println(queue.max());
		queue.add(2);
		System.out.println(queue.max());
		queue.add(4);
		System.out.println(queue.max());
		queue.add(5);
		queue.add(5);
		System.out.println(queue.max());

		System.out.println(queue.remove());

		System.out.println(queue.max());

		System.out.println(queue.remove());

		System.out.println(queue.max());

		System.out.println(queue.remove());

		System.out.println(queue.max());

		queue.add(3);

		System.out.println(queue.max());

		queue.add(5);

		System.out.println(queue.max());

		queue.add(4);

		System.out.println(queue.max());

		while(!queue.isEmpty()) {
			System.out.println(queue.remove());
		} 

	}
}