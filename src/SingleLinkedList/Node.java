package SingleLinkedList;

public class Node {
	public int value;
	public Node next;
	public String val;
	
	public Node(){
		value = 0;
		this.next = null;
		val = "";
	}
	
	public Node(int value){
		this.next = null;
		this.value = value;
		this.val = "";
	}
	
	public Node(int value, String s){
		this.next = null;
		this.value = value;
		this.val = s;
	}
	
	public int getValue(){
		return value;
	}
	
	public void setValue(int value){
		this.value = value;
		this.val = "";
	}
	
	public void setValue(int value, String s){
		this.value = value;
		this.val = s;
	}
	
	public Node getNext(){
		return next;
	}
	
	public void setNext(Node next){
		this.next = next;
	}
	
	
	
}
