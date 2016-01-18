public class Stack{
	Node top;
	public void push(int item){
		Node newNode = new Node();
		newNode.value = item;
		newNode.next = top;
		top = newNode;
	}
	
	public int pop(){
		if(top!=null){
			int item = top.value;
			top = top.next;
			return item;
		}
		
		return -1;
	}
	
	public boolean isEmpty(){
		return (top==null);
	}
}
