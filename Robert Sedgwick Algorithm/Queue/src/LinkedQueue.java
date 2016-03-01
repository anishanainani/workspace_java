import java.util.Iterator;
import java.util.NoSuchElementException;


public class LinkedQueue<Item>  implements Iterable<Item>{

	private Node head, tail;
	private int N;
	
	private class Node{
		Item item;
		Node next;
		
		public Node(Item item){
			this.item = item;
		}
	}
	
	public LinkedQueue(){
		N = 0;
		head = null;
		tail = null;
	}
	
	public void enqueue(Item data){
		Node oldTail = tail;
		tail = new Node(data);
		tail.next = null;
		
		if(isEmpty()){
			head = tail;
		} else {
			oldTail.next = tail;
		}
		N++;
	}
	
	public Item dequeue(){
		if(isEmpty()) throw new NoSuchElementException("Queue Underflow");
		
		Item item = head.item;
		head = head.next;
		N--;
		
		if(isEmpty()){
			tail = null;
		}
		return item;
	}
	
	public boolean isEmpty(){
		return head==null;
	}
	
	public int size(){
		return N;
	}
	
	public Iterator<Item> iterator(){
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item> {
		private Node current = null;
		
		public ListIterator(){
			current = head;;
		}
		
		public boolean hasNext() {
			return (current!=null);
		}

		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}

		public void remove() {
			// TODO Auto-generated method stub
			
		}

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
