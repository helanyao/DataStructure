package SingleLinkedList;

public class LinkedListTest {

	public static void main(String[] args) {
		ListNode n = new ListNode(0);
		LinkedList ll = new LinkedList(n);
		ll.add(1);
		ll.add(2);
		ll.add(3);
		
		ll.printAll();

	}

}
