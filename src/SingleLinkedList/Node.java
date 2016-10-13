package SingleLinkedList;

public class Node {
	public int val;
	public Node next;
	
	public Node(){
		val = 0;
		this.next = null;
	}
	
	public Node(int value){
		this.next = null;
		this.val = value;
	}
	
	public int getValue(){
		return val;
	}
	
	public void setValue(int value){
		this.val = value;
	}
	
	public Node getNext(){
		return next;
	}
	
	public void setNext(Node next){
		this.next = next;
	}	
}
