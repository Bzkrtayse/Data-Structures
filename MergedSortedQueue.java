public class Queue {

	private Node front, rear;
	private int queueSize;

	private class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public Queue() {
		front = null;
		rear = null;
		queueSize = 0;
	}

	public boolean isEmpty() {
		return (queueSize == 0);
	}

	public void dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty!! ");
		} else {
			front = front.next;
			queueSize--;

		}

	}

	public void enqueue(int data) {

		Node newNode = new Node(data);
		if (isEmpty()) {
			this.front = newNode;
			this.rear = newNode;
		} else {
			this.rear.next = newNode;
			this.rear = newNode;
		}
		queueSize++;

	}

	public void merge(Queue q1, Queue q2) {

		Queue mergedQ = new Queue();
		System.out.println("q1: ");
		q1.print();
		System.out.println("q2: ");
		q2.print();

		while (!q1.isEmpty() && !q2.isEmpty()) {
			if (q1.front() <= q2.front()) {
				mergedQ.enqueue(q1.front());
				q1.dequeue();
			} else {
				mergedQ.enqueue(q2.front());
				q2.dequeue();
			}
		}
		while (q1.isEmpty() && !q2.isEmpty()) {
			mergedQ.enqueue(q2.front());
			q2.dequeue();
		}
		while (q2.isEmpty() && !q1.isEmpty()) {
			mergedQ.enqueue(q1.front());
			q1.dequeue();
		}

		System.out.println("Merged Queue: ");
		mergedQ.print();

	}

	public int front() {
		return front.data;
	}

	public void print() {
		Node node = this.front;

		if (isEmpty()) {
			System.out.println("Queue is Empty!");
		} else {
			System.out.print("Front--> ");
			while (node.next != null) {
				System.out.print(node.data + " ");
				node = node.next;
			}
			System.out.print(this.rear.data);
			System.out.println(" <--Rear");
		}
	}

	public static void main(String a[]) {
		var q = new Queue();
		Queue q1 = new Queue();
		Queue q2 = new Queue();
		q1.enqueue(2);
		q1.enqueue(4);
		q1.enqueue(8);
		q1.enqueue(10);
		q2.enqueue(1);
		q2.enqueue(3);
		q2.enqueue(6);
		q2.enqueue(7);
		q2.enqueue(8);
		q2.enqueue(10);

		q.merge(q1, q2);

	}

}
