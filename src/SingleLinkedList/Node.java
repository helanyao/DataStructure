package SingleLinkedList;

public class Node {
	private int value;
	private Node next;
	private String sValue;
	
	public Node(){
		value = 0;
		this.next = null;
		sValue = "";
	}
	
	public Node(int value){
		this.next = null;
		this.value = value;
		this.sValue = "";
	}
	
	public Node(int value, String s){
		this.next = null;
		this.value = value;
		this.sValue = s;
	}
	
	public int getValue(){
		return value;
	}
	
	public void setValue(int value){
		this.value = value;
		this.sValue = "";
	}
	
	public void setValue(int value, String s){
		this.value = value;
		this.sValue = s;
	}
	
	public Node getNext(){
		return next;
	}
	
	public void setNext(Node next){
		this.next = next;
	}
	
	
	
}
