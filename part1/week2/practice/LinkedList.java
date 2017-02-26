
public class LinkedList {

    private static class Node {
        private int value;
        private Node next;
        
        public Node () {
            super();
        }
    }

    private Node head;
    private int size;

    public LinkedList() {
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insert(int element) {
        Node node = new Node();
        node.value = element;
        node.next = head;
        head = node;

        size++;
    }

    public int remove() {
        if(!isEmpty()) {
            int element = head.value;
            head = head.next;
            size--;
            return element;
        } else {
            throw new RuntimeException("List is empty");
        }
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {


    }
}