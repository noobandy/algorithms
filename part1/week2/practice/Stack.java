public class Stack {

	private int[] elements;
	private int top;
	
	public Stack(int size) {
		elements = new int[size];
		top = -1;
	}

	public boolean isFull() {
		return top == (elements.length - 1);
	}

	public boolean isEmpty() {
		return top == -1;
	}


	public int size() {
		return top + 1;
	}

	public void push(int element) {
		if(!isFull()) {
			top = top + 1;
			elements[top] = element;
		} else {
			throw new RuntimeException("Stack overflow");
		}
	}


	public int pop() {
		if(!isEmpty()) {
			int element = elements[top];
			top = top - 1;
			return element;
		} else {
			throw new RuntimeException("Stack underflow");
		}
	}

	public static void main(String[] args) {
		Stack stack = new Stack(3);

		System.out.format("Stack is %s empty%n", stack.isEmpty() ? "" : "not");

		System.out.format("Stack is %s full%n", stack.isFull() ? "" : "not");

		System.out.format("Stack size %d %n", stack.size());

		stack.push(1);

		System.out.format("Stack is %s empty%n", stack.isEmpty() ? "" : "not");

		System.out.format("Stack is %s full%n", stack.isFull() ? "" : "not");

		System.out.format("Stack size %d %n", stack.size());

		stack.push(2);

		System.out.format("Stack is %s empty%n", stack.isEmpty() ? "" : "not");

		System.out.format("Stack is %s full%n", stack.isFull() ? "" : "not");

		System.out.format("Stack size %d %n", stack.size());

		stack.push(3);

		System.out.format("Stack is %s empty%n", stack.isEmpty() ? "" : "not");

		System.out.format("Stack is %s full%n", stack.isFull() ? "" : "not");

		System.out.format("Stack size %d %n", stack.size());

		while(!stack.isEmpty()) {
			System.out.format("%d%n", stack.pop());
			System.out.format("Stack size %d %n", stack.size());
		}


	}

}