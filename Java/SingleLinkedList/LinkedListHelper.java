package SingleLinkedList;

public class LinkedListHelper {
	
	public ListNode removeAtPosition(ListNode head, int position){
		if(position < 0 || head == null){
			System.out.println("position or head value is illegal.");
			return head;
		}
		
		ListNode prev = null;
		ListNode current = head;
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
			ListNode n = head.getNext();
			head.setNext(null);
			head = n;
		}else{
			prev.setNext(current.getNext());
			current.setNext(null);
		}
		
		return head;
	}
	
	// remove all nodes who match val
	public ListNode remove(ListNode head, int val) {
		ListNode prv = null, cur = head;
		while(cur != null) {
			if(cur.val == val) {
				if(prv == null) {
					head = cur.next;
					cur.next = null;
					cur = head;
					continue;
				} else {
					prv.next = cur.next;
					cur.next = null;
					cur = prv.next;
					continue;
				}
			}
			prv = cur;
			cur = cur.next;
		}
		
		return head;
	}
}
