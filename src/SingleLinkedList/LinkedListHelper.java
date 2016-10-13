package SingleLinkedList;

public class LinkedListHelper {
	public Node findMiddle(Node head) {
		if(head == null) {
			return null;
		}
		
		Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
	}
	
	public Node reverseListN(Node head) {
		Node prev = null, cur = head;
		
		while(cur != null) {
			Node next = cur.getNext();
			cur.setNext(prev);
			prev = cur;
			cur = next;
		}
		
		return prev;
	}
	
	public Node reverseList(Node head, Node pre) {
		if(head == null) {
			return pre;
		}
		
		Node next = head.getNext();
		head.setNext(pre);
		
		return reverseList(next, head);
	}
	
	public void reversePrint(Node head) {
		  if(head == null){
		      return;
		  } else{
		    reversePrint(head.getNext());
		    System.out.println(head.getValue());
		  }
	}
	
    public Node mergeTwoLists(Node l1, Node l2) {
    	Node dummy = new Node(0);
    	Node lastNode = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                lastNode.next = l1;
                l1 = l1.next;
            } else {
                lastNode.next = l2;
                l2 = l2.next;
            }
            lastNode = lastNode.next;
        }
        
        if (l1 != null) {
            lastNode.next = l1;
        } else {
            lastNode.next = l2;
        }
        
        return dummy.next;
    }
	
	public Node removeAtPosition(Node head, int position){
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
