package SingleLinkedList;

public class LinkedList {
	public ListNode head;
	public int num;
	
	public LinkedList(){
		// System.out.println("default constructor of LinkedList");
		head = null;
		num = 0;
	}
	
	public LinkedList(ListNode n){
		// System.out.println("head provided constructor of LinkedList");
		head = n;
		num = 1;
	}
	
	public ListNode getHead(){
		return head;
	}
	
	public void setHead(ListNode head){
		this.head = head;
	}
	
	public int getNum(){
		return num;
	}
	
	public void setNum(int num){
		this.num = num;
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public void printAll(){
		System.out.println("");
		if(isEmpty()) {
			System.out.println("empty linked list");
		}else{
			ListNode n = head;
			while(n != null){
				System.out.print(n.getValue() + "  ");
				n = n.getNext();
			}
		}
		System.out.println("\n");
	}
	
	public void add(int v){
		ListNode n = new ListNode(v);
		if(isEmpty()){
			head = n;
			num = 1;
		} else {
			ListNode current = head;
			while(current.getNext() != null){
				current = current.getNext();
			}
			current.setNext(n);
		}
	}
	
	public boolean remove(int v){
		if(isEmpty()){
			System.out.println("\ncan't remove node from an empty linked list");
			return false;
		}
		
		if(head.getValue() == v){
			System.out.println("remove head node");
			head = head.getNext();
			num--;
			return true;
		}else{
			ListNode cur = head.getNext();
			ListNode prv = head;
			while(cur != null){
				if(cur.getValue() == v){
					prv.setNext(cur.getNext());
					System.out.println("\nremoving node.. " + v);
					num--;
					return true;
				}else{
					prv = cur;
					cur = cur.getNext();
				}
			}
			System.out.println("\ncan't find node match input value");
			return false;
		}
	}
	
	public int[] toArray(){
		if(num < 0){
			return null;
		}
		int[] arr = new int[num];
		int i = 0;
		for(ListNode n = head; n != null && i < num; n = n.getNext(), i++){
			arr[i] = n.getValue();
		}
		
		return arr;
	}
	
}
