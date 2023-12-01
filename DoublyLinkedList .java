
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

	void deleteFromMiddle(int index) {
		if (isEmpty())
			System.out.println("List is Empty!!");
		else if (index < 0 || index >= sizeOfList) {
			System.out.println("Try another index!");
		} else {
			if (index == 0)
				deleteFromBeginning();

			else if (index == sizeOfList - 1)
				deleteFromEnd();
			else {
				int count = 0;
				Node current = this.head;
				while (count != index) {
					current = current.next;
					count++;
				}
				current.next.previous = current.previous;
				current.previous.next = current.next;
				sizeOfList--;
			}

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

	void insertToMiddle(int data, int index) {

		Node newNode = new Node(data);

		if (isEmpty())
			insertToBeginning(data);

		else if (index < 0 || index > sizeOfList) {
			System.out.println("Try another index!");
		} else {
			if (index == 0)
				insertToBeginning(data);
			else if (index == sizeOfList)
				insertToEnd(data);
			else {
				int count = 0;
				Node current = this.head;
				while (count != index) {
					current = current.next;
					count++;
				}
				newNode.next = current;
				newNode.previous = current.previous;
				current.previous.next = newNode;
				current.previous = newNode;

				sizeOfList++;
			}
		}

	}

	public static void main(String[] args) {
		var list = new DoublyLinkedList();

		list.insertToBeginning(1);
		list.insertToEnd(4);
		list.insertToMiddle(3, 1);
		list.insertToMiddle(7, 1);
		list.insertToBeginning(9);
		list.insertToEnd(6);
		list.deleteFromEnd();
		list.deleteFromMiddle(2);
		list.printList();
		System.out.println("size: " + list.sizeOfList);
	}
}
