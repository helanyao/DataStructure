package SingleLinkedList;

public class TestMergeList {

	public static void main(String[] args) {
		Node n1 = new Node(0);
		LinkedList ll1 = new LinkedList(n1);
		ll1.add(1);
		ll1.add(3);
		ll1.add(5);
		
		Node n2 = new Node(-1);
		LinkedList ll2 = new LinkedList(n2);
		ll2.add(2);
		ll2.add(3);
		
		Node n = MergeLists(ll1.getHead(), ll2.getHead());
		
		while(n != null){
			System.out.print(n.getValue() + " ");
			n = n.getNext();
		}
		

	}
	
	public static Node MergeLists(Node headA, Node headB) {
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

}
