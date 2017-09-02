
public class EditorBuffer {

	private Node head;
	private Node curser;

	public EditorBuffer() {
		this(new char[]{});
	}

	public EditorBuffer(char[] chars) {
		for(char c : chars) {
			Node node = new Node();
			node.c = c;
			if(head == null) {
				head = node;
			} else {
				node.next = curser.next;

				curser.next = node;
			}

			curser = node;
		}
	}

	public char get() {
		return 'a';
	}

	public char delete() {

	}

	public void left(int n) {

	}

	public void right(int n) {

	}

	public void set(char c) {
		
	}

}