package SingleLinkedList;

public class ReverseLinkedList {

	public static void main(String[] args) {
		Node n = new Node(0);
		LinkedList ll = new LinkedList(n);
		ll.add(1);
		ll.add(2);
		ll.add(3);
		
		ll.setHead(reverseListN(ll.getHead()));
		
		ll.printAll();
		
		ll.setHead(reverseList(ll.getHead(), null));
		ll.printAll();
	}
	
	public static Node reverseListN(Node head) {
		Node prev = null, cur = head;
		
		while(cur != null) {
			Node next = cur.getNext();
			cur.setNext(prev);
			prev = cur;
			cur = next;
		}
		
		return prev;
	}
	
	public static Node reverseList(Node head, Node pre) {
		if(head == null) {
			return pre;
		}
		Node next = head.getNext();
		head.setNext(pre);
		return reverseList(next, head);
	}

}
