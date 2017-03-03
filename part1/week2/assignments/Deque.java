import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
        private Node<Item> prev;
    }

    private Node<Item> head;
    private Node<Item> tail;
    private int size;

    // construct an empty deque
    public Deque() {
    }

    // is the deque empty?
    public boolean isEmpty() {
        return head == null;
    }
    // return the number of items on the deque
    public int size() {
        return size;
    }

    private void validateAdd(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
    }

    private void validateRemove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
    }

    // add the item to the front
    public void addFirst(Item item)  {
        validateAdd(item);

        Node<Item> node = new Node<Item>();
        node.item = item;
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    // add the item to the end
    public void addLast(Item item) {
        validateAdd(item);

        Node<Item> node = new Node<Item>();
        node.item = item;
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }

        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        validateRemove();

        Item item = head.item;

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head.next.prev = null;
            head = head.next;
        }

        size--;


        return item;
    }

    // remove and return the item from the end
    public Item removeLast() {
        validateRemove();

        Item item = tail.item;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail.prev.next = null;
            tail = tail.prev;
        }
        size--;

        return item;
    }

    // return an iterator over items in order from front to end

    public Iterator<Item> iterator() {
        return new DequeIterator<Item>(head);
    }

    private static class DequeIterator<Item> implements Iterator<Item> {

        private Node<Item> curr;
        public DequeIterator(Node<Item> head) {
            curr = head;
        }

        public boolean hasNext() {
            return curr != null;
        }

        public Item next() {
            if (curr == null) {
                throw new NoSuchElementException();
            } else {
                Item item = curr.item;
                curr = curr.next;
                return item;
            }
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

}