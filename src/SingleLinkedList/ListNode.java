package SingleLinkedList;

public class ListNode {
	public int val;
	public ListNode next;
	
	public ListNode(){
		val = 0;
		this.next = null;
	}
	
	public ListNode(int value){
		this.next = null;
		this.val = value;
	}
	
	public int getValue(){
		return val;
	}
	
	public void setValue(int value){
		this.val = value;
	}
	
	public ListNode getNext(){
		return next;
	}
	
	public void setNext(ListNode next){
		this.next = next;
	}	
}
