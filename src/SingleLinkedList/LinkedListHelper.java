package SingleLinkedList;

public class LinkedListHelper {
	public ListNode findMiddle(ListNode head) {
		if(head == null) {
			return null;
		}
		
		ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
	}
	
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode dummy = new ListNode(0);
    	ListNode lastNode = dummy;
        
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
