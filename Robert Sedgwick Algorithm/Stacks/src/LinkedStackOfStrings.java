import java.util.NoSuchElementException;


public class LinkedStackOfStrings {

	private Node head;
	private int N;
	
	private class Node{
		String item;
		Node next;
		
		public Node(String item){
			this.item = item;
		}
	}
	
	public LinkedStackOfStrings(){
		N = 0;
		head = null;
	}
	
	public void push(String data){
		Node oldHead = head;
		head = new Node(data);
		head.next = oldHead;
		N++;
	}
	
	public String pop(){
		if(isEmpty()) throw new NoSuchElementException("Stack Underflow");
		
		String item = head.item;
		head = head.next;
		N--;
		return item;
	}
	
	public boolean isEmpty(){
		return head==null;
	}
	
	public int size(){
		return N;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
