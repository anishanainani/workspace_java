public class Stack<Element>{
	StackNode<Element> top;
	int size;
	
	public Stack(){
		top = null;
		size = 0;
	}
	public void push(Element elem){
		StackNode<Element> n = new StackNode<Element>();
		n.data = elem;
		n.next = top;
		top = n;
		size++;
	}

	public Element pop(){
		if(top != null){
			Element temp = top.data;
			top=top.next;
			size--;
			return temp;
		}

		return null;
	}
	
	public boolean isEmpty(){
		return top==null;
	}
	
	public void displayAll(){
		StackNode<Element> elem = top;
		while(elem != null){
			System.out.print(elem.data+ " ");
			elem=elem.next;
		}
		
	}
}
