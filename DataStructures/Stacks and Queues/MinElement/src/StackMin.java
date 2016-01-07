public class StackMin{
	Node top;
	int size;
	
	public StackMin(){
		top = null;
		size = 0;
	}
	public void push(int elem){
		Node n = new Node();
		n.data = elem;
		n.next = top;
		top = n;
		size++;
	}

	public int pop(){
		if(top != null){
			int temp = top.data;
			top=top.next;
			size--;
			return temp;
		}

		return -1;
	}
	
	public void displayAll(){
		Node elem = top;
		while(elem != null){
			System.out.print(elem.data+ " ");
			elem=elem.next;
		}
		
	}
}
