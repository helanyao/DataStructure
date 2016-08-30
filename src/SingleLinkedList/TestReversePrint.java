package SingleLinkedList;

public class TestReversePrint {

	public static void main(String[] args) {
		Node n = new Node(0);
		LinkedList ll = new LinkedList(n);
		ll.add(1);
		ll.add(2);
		ll.add(3);
		
		ll.printAll();
		
		ReversePrint(ll.getHead());

	}
	
	public static void ReversePrint(Node head) {
		  if(head == null){
		      return;
		  }
		  else{
		    ReversePrint(head.getNext());
		    System.out.println(head.getValue());
		  }
	}
}
