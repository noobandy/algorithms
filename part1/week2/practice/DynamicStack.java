public class DynamicStack {

	private LinkedList linkedList;
	
	public DynamicStack() {
        linkedList = new LinkedList();

	}

	public boolean isEmpty() {
		return linkedList.isEmpty();
	}


	public int size() {
		return linkedList.size();
	}

	public void push(int element) {
		linkedList.insert(element);
	}


	public int pop() {
		return linkedList.remove();
	}

	public static void main(String[] args) {
		DynamicStack stack = new DynamicStack();

		System.out.format("Stack is %s empty%n", stack.isEmpty() ? "" : "not");

		

		System.out.format("Stack size %d %n", stack.size());

		stack.push(1);

		System.out.format("Stack is %s empty%n", stack.isEmpty() ? "" : "not");

		
		System.out.format("Stack size %d %n", stack.size());

		stack.push(2);

		System.out.format("Stack is %s empty%n", stack.isEmpty() ? "" : "not");

		

		System.out.format("Stack size %d %n", stack.size());

		stack.push(3);

		System.out.format("Stack is %s empty%n", stack.isEmpty() ? "" : "not");

		

		System.out.format("Stack size %d %n", stack.size());

		while(!stack.isEmpty()) {
			System.out.format("%d%n", stack.pop());
			System.out.format("Stack size %d %n", stack.size());
		}


	}

}