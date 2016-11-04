package MyStack;

public class MyStack<T> {
	private static final int MAX_CAP = 50;

	private Object[] arr;
	private int size;
	private int num;
	private int index;
	
	public MyStack(){
		this.arr = new Object[MAX_CAP];
		this.size = MAX_CAP;
		this.num = 0;
		this.index = -1;
	}
	
	public MyStack(int size){
		this.arr = new Object[size];
		this.size = size;
		this.num = 0;
		this.index = -1;
	}
	
	public void push(T item){
		if(index == size -1){
			System.out.println("stack is full. failed to push new item.");
			return;
		}
		index++;
		arr[index] = item;
	}
	
	public Object pop(){
		if(index == -1){
			System.out.println("stack is empty. failed to pop item.");
			return null;
		}
		return arr[index--];
	}
	
	public Object peek(){
		if(index == -1){
			System.out.println("stack is empty. failed to peek item.");
			return null;
		}
		return arr[index];
	}
	
	public void print(){
		System.out.println("\nsize = " + size + "; num = " + num + "; index = " + index);
		for(int i = index; i >= 0; i--){
			System.out.println("the " + i + "th item: " + arr[i].toString());
		}
	}
}
