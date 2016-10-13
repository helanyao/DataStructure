package SingleLinkedList;

public class LinkedListTest {

	public static void main(String[] args) {
		Node n = new Node(0);
		LinkedList ll = new LinkedList(n);
		ll.add(1);
		ll.add(2);
		ll.add(3);
		
		ll.printAll();

	}

}
