package MyStack;

public class MyStackTest {

	public static void main(String[] args) {
		MyStack<Integer> s = new MyStack<Integer>(3);
		
		s.push(new Integer(4));
		System.out.println(s.peek());
		
		s.push(new Integer(1));
		s.pop();
		
		s.print();

	}

}
