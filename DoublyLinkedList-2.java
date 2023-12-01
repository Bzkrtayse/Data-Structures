
public class DoublyLinkedList {
	Node head;
	int sizeOfList;

	class Node {
		int data;
		Node next;
		Node previous;

		Node(int data) {
			this.data = data;
			this.next = null;
			this.previous = null;
		}
	}

	public DoublyLinkedList() {
		this.head = null;
		this.sizeOfList = 0;
	}

	boolean isEmpty() {
		return sizeOfList == 0;
	}

	void printList() {
		if (isEmpty())
			System.out.println("List is Empty!!");
		else {
			Node current = this.head;
			System.out.println("Doubly Linked List: ");
			System.out.print("Head --> ");
			while (current != null) {

				System.out.print(current.data + " ");
				current = current.next;
			}
		}
	}

	void deleteFromBeginning() {
		if (isEmpty()) {
			System.out.println("List is Empty!!");
		} else {
			this.head = this.head.next;
			this.head.previous = null;
			sizeOfList--;
		}
	}

	void deleteFromEnd() {
		if (isEmpty()) {
			System.out.println("List is Empty!!");
		} else {
			Node current = this.head;
			while (current.next.next != null) {
				current = current.next;
			}
			current.next = null;
			sizeOfList--;
		}
	}

	void deleteFromMiddle(int key) {
		if (isEmpty())
			System.out.println("List is Empty!!");

		else if (head.data == key) {
			deleteFromBeginning();
		}

		else if (!isEmpty()) {
			Node current = this.head;
			while (current.next != null) {
				current = current.next;
			}
			if (key == current.data) {
				deleteFromEnd();
			}
		} else {

			Node current = this.head;

			while (current.data != key) {
				current = current.next;
			}
			current.previous.next = current.next;
			current.next.previous = current.previous;

			sizeOfList--;
		}

	}

	void insertToBeginning(int data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			this.head = newNode;
		} else {
			this.head.previous = newNode;
			newNode.next = this.head;
			this.head = newNode;
		}
		sizeOfList++;
	}

	void insertToEnd(int data) {

		Node newNode = new Node(data);

		if (isEmpty())
			this.head = newNode;
		else {
			Node current = this.head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
			newNode.previous = current;
		}
		sizeOfList++;
	}

	void insertToMiddle(int data, int key) {

		Node newNode = new Node(data);

		if (isEmpty())
			insertToBeginning(data);

		else {
			Node current = this.head;
			while (current.data != key) {
				current = current.next;
			}
			newNode.previous = current;
			newNode.next = current.next;
			current.next.previous = newNode;
			current.next = newNode;

		}
		sizeOfList++;

	}

	public static void main(String[] args) {
		var list = new DoublyLinkedList();

		list.insertToBeginning(1);
		list.insertToEnd(4);
		list.insertToBeginning(3);
		list.insertToEnd(5);
		list.insertToEnd(6);
		list.insertToMiddle(7, 4);
		list.insertToMiddle(9, 1);
		list.insertToMiddle(0, 3);
		list.deleteFromMiddle(5);
		list.deleteFromMiddle(6);
		list.printList();
		System.out.println("size: " + list.sizeOfList);
	}
}
