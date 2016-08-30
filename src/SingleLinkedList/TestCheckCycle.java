package SingleLinkedList;

public class TestCheckCycle {

	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n00 = new Node(0);
		Node n01 = new Node(-1);
		
		n00.setNext(n1);
		n01.setNext(n1);
		
		System.out.println("n1 address = " + n1.hashCode());

	}

}
