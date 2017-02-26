public class Queue {

    private int[] elements;
    private int head;
    private int tail;
    private int size;

    public Queue(int size) {
        elements = new int[size + 1];
        head = 0;
        tail = 0;
        size = 0;
    }


    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return ((tail + 1) % elements.length ) == head;
    }

    public int size() {
        return size;
    }

    public void enqueue(int element) {
        if(!isFull()) {
            elements[tail] = element;
            tail = (tail + 1) % elements.length;
            size = size + 1;
        } else {
            throw new RuntimeException("Queue is full");
        }
    }

    public int dequeue() {
        if(!isEmpty()) {
            int element = elements[head];
            head = (head + 1) % elements.length;
            size--;
            return element;
        } else {
            throw new RuntimeException("Queue is empty");
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue(3);

        System.out.format("Queue is %s empty%n", queue.isEmpty() ? "" : "not");

        System.out.format("Queue is %s full%n", queue.isFull() ? "" : "not");

        System.out.format("Queue size %d %n", queue.size());

        queue.enqueue(1);

        System.out.format("Queue is %s empty%n", queue.isEmpty() ? "" : "not");

        System.out.format("Queue is %s full%n", queue.isFull() ? "" : "not");

        System.out.format("Queue size %d %n", queue.size());

        queue.enqueue(2);

        System.out.format("Queue is %s empty%n", queue.isEmpty() ? "" : "not");

        System.out.format("Queue is %s full%n", queue.isFull() ? "" : "not");

        System.out.format("Queue size %d %n", queue.size());

        queue.enqueue(3);

        System.out.format("Queue is %s empty%n", queue.isEmpty() ? "" : "not");

        System.out.format("Queue is %s full%n", queue.isFull() ? "" : "not");

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