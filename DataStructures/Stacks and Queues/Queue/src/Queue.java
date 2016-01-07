public class Queue<Element>{
	Node<Element> front;
	Node<Element> tail;
	int size;
	
	public Queue(){
		front = null;
		tail = null;
		size= 0;
	}
	public void enqueue(Element elem){
		Node<Element> n = new Node<Element>();
		n.data = elem;
		if(front == null && tail == null){
			front = n;
			tail = n;
			size++;
			return;
		}
		tail.next = n;
		tail = n;
		size++;
		
	}

	public Element dequeue(){
		if(front != null){
			Element temp = front.data;
			front=front.next;
			size--;
			return temp;
		}

		return null;
	}
	
	public void displayAll(){
		Node<Element> elem = front;
		while(elem != null){
			System.out.print(elem.data+" ");
			elem=elem.next;
		}
		
	}
}

