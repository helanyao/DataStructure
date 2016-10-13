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
	
	public Node MergeLists(Node headA, Node headB) {
	    Node head = null;
	    Node curA = headA;
	    Node curB = headB;
	    Node cur = null;
	    Node n = null;
	    
	    while(curA != null && curB != null){
	        if(curA.getValue() < curB.getValue()){
	            n = curA;
	            curA = curA.getNext();
	        }else{
	            n = curB;
	            curB = curB.getNext();
	        }
	        
	        if(head == null){
	            head = n;
	            cur = head;
	        }else{
	            cur.setNext(n);
	            cur = cur.getNext();
	        }
	        n.setNext(null);
	    }
	    
	    if(curA != null){
	    	if(cur != null){
	    		cur.setNext(curA);
	    	}else{
	    		head = headA;
	    	}
	    }else if(curB != null){
	    	if(cur != null){
	    		cur.setNext(curB);
	    	}else{
	    		head = headB;
	    	}
	        
	    }
	    
	    return head;

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
