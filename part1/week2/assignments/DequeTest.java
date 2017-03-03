public class DequeTest {
	public static void main(String[] args) {
        Deque<Integer> deque = new Deque<Integer>();
        System.out.format("deque is %s empty.%n", deque.isEmpty() ? "" : "not");
        System.out.format("deque size is %d.%n", deque.size());
        deque.addFirst(2);
        deque.addFirst(1);
        System.out.format("deque is %s empty.%n", deque.isEmpty() ? "" : "not");
        System.out.format("deque size is %d.%n", deque.size());

        for (Integer num : deque) {
            System.out.print(num);
        }

        System.out.println();

        deque.addLast(3);
        deque.addLast(4);


        System.out.format("deque is %s empty.%n", deque.isEmpty() ? "" : "not");
        System.out.format("deque size is %d.%n", deque.size());
        for (Integer num : deque) {
            System.out.print(num);
        }

        System.out.println();

        System.out.format("%d%n", deque.removeFirst());

        System.out.format("deque is %s empty.%n", deque.isEmpty() ? "" : "not");
        System.out.format("deque size is %d.%n", deque.size());
        for (Integer num : deque) {
            System.out.print(num);
        }

        System.out.println();

        System.out.format("%d%n", deque.removeLast());

        System.out.format("deque is %s empty.%n", deque.isEmpty() ? "" : "not");
        System.out.format("deque size is %d.%n", deque.size());
        for (Integer num : deque) {
            System.out.print(num);
        }

        System.out.println();

        System.out.format("%d%n", deque.removeFirst());

        System.out.format("%d%n", deque.removeLast());

        System.out.format("deque is %s empty.%n", deque.isEmpty() ? "" : "not");
        System.out.format("deque size is %d.%n", deque.size());

        deque.addFirst(2);
        deque.addFirst(1);
        deque.addLast(3);
        deque.addLast(4);

        System.out.format("deque is %s empty.%n", deque.isEmpty() ? "" : "not");
        System.out.format("deque size is %d.%n", deque.size());

        for (Integer num : deque) {
            System.out.print(num);
        }

        System.out.println();

    }
}