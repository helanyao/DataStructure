package SingleLinkedList;

public class TestRemoveAtPosition {

	public static void main(String[] args) {
		Node n = new Node(0);
		LinkedList ll = new LinkedList(n);
		ll.add(1);
		ll.add(2);
		ll.add(3);
		
		ll.printAll();
		
		n = removeAtPosition(ll.getHead(), 2);
		ll.setHead(n);
		ll.printAll();

	}
	
	public static Node removeAtPosition(Node head, int position){
		if(position < 0 || head == null){
			System.out.println("position or head value is illegal.");
			return head;
		}
		
		Node prev = null;
		Node current = head;
		int index = 0;
		
		while(index < position && current != null){
			if(prev == null){
				prev = head;
			}else{
				prev = current;
			}
			current = current.getNext();
			index++;
		}
		
		if(current == null){
			System.out.println("the position is out of boundary.");
		}else if(prev == null){
			Node n = head.getNext();
			head.setNext(null);
			head = n;
		}else{
			prev.setNext(current.getNext());
			current.setNext(null);
		}
		
		return head;
	}

}
