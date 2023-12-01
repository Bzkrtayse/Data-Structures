
public class CircularDoublyLinkedList {

	Node head;
	int size;

	class Node {
		Node next;
		Node previous;
		int data;

		Node(int data) {
			this.next = null;
			this.previous = null;
			this.data = data;
		}
	}

	public CircularDoublyLinkedList() {
		this.head = null;
		this.size = 0;
	}

	boolean isEmpty() {
		return size == 0;
	}

	void print() {
		if (isEmpty())
			System.out.println("List is Empty!!");
		else {
			Node current = this.head;
			System.out.println("Circular Doubly Linked List: ");
			System.out.print("Head--> ");

			while (current.next != this.head) {
				System.out.print(current.data + " ");
				current = current.next;
			}
			System.out.println(current.data);
		}
	}

	void insertToBeginning(int data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			newNode.next = newNode.previous = newNode;
			this.head = newNode;
		} else {

			Node last = this.head.previous;

			newNode.next = this.head;
			this.head.previous = newNode;
			newNode.previous = last;
			last.next = newNode;

			this.head = newNode;
		}
		size++;
	}

	void insertToEnd(int data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			newNode.next = newNode.previous = newNode;
			this.head = newNode;
		} else {
			Node last = this.head.previous;
			last.next = newNode;
			newNode.previous = last;
			newNode.next = this.head;
			this.head.previous = newNode;

		}
		size++;
	}

	void deleteFromBeginning() {
		if (isEmpty())
			System.out.println("List is Empty!!");
		else {
			Node scnd = this.head.next;
			Node last = this.head.previous;
			scnd.previous = this.head.previous;
			last.next = scnd;
			this.head = scnd;
			size--;
		}
	}

	void deleteFromEnd() {
		if (isEmpty())
			System.out.println("List is Empty!!");
		else {
			Node prevLast = this.head.previous.previous;
			prevLast.next = this.head;
			this.head.previous = prevLast;
			size--;
		}
	}

	public static void main(String[] args) {
		var list = new CircularDoublyLinkedList();
		list.insertToBeginning(3);
		list.insertToBeginning(7);
		list.insertToBeginning(5);
		list.insertToEnd(6);
		list.insertToEnd(4);
		list.deleteFromBeginning();
		list.deleteFromEnd();
		list.print();
		System.out.println("size: " + list.size);
	}

}
