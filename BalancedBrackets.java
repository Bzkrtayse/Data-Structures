package stack;

class Stack {

	Node top;
	int stackSize;

	class Node {
		char data;
		Node next;

		public Node(char data) {
			this.data = data;
			this.next = null;
		}
	}

	public Stack() {
		this.top = null;
		this.stackSize = 0;
	}

	public boolean checkIfBalanced(String str) {
		char[] chars = str.toCharArray();
		Stack open = new Stack();
		for (int i = 0; i < chars.length; i++) {
			char ch = chars[i];
			if (ch == '(' || ch == '{' || ch == '[') {
				open.push(ch);
				continue;
			}

			char top;
			switch (ch) {
			case ')':
				top = open.pop();
				if (top == '{' || top == '[')
					return false;
				break;
			case '}':
				top = open.pop();
				open.pop();
				if (top == '(' || top == '[')
					return false;
				break;
			case ']':
				top = (char) open.pop();
				open.pop();
				if (top == '(' || top == '{')
					return false;
				break;
			}
		}
		return open.isEmpty();
	}

	public boolean isEmpty() {
		return stackSize == 0;
	}

	public void push(char data) {

		Node newNode = new Node(data);
		if (isEmpty()) {
			this.top = newNode;
		} else {
			newNode.next = this.top;
			this.top = newNode;
		}
		stackSize++;
	}

	private char pop() {

		if (!isEmpty()) {
			char ch = this.top.data;
			this.top = this.top.next;
			stackSize--;
			return ch;
		} else
			return '!';

	}

	public static void main(String[] args) {

		Stack stack = new Stack();
		String str1 = "(A+B)-(C-D)";
		String str2 = "((A+B)-(C-D)";
		String str3 = "((A+B)-[C-D])";
		String str4 = "((A+B)-C-D]}";
		System.out.println(str1 + " " + stack.checkIfBalanced(str1));
		System.out.println(str2 + " " + stack.checkIfBalanced(str2));
		System.out.println(str3 + " " + stack.checkIfBalanced(str3));
		System.out.println(str4 + " " + stack.checkIfBalanced(str4));
	}
}
