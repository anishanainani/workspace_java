

public class SinglyLinkedList<objType> {
	ListElement<objType> head;
	int length = 0;
	
	SinglyLinkedList(){
		
	}
	
	public boolean insertInFront(objType value){
		ListElement<objType> newNode = new ListElement<objType>(value);
		newNode.setNext(head);
		head = newNode;
		length++;
		return true;
	}
	
	public boolean delete(objType value){
		if(head.value() == value){
			head = head.next();
			System.out.println("Value "+value+" deleted");
			return true;
		}
		
		ListElement<objType> elem = head;
		
		while(elem.next() != null){
			if(elem.next().value() == value){
				elem.setNext(elem.next().next());
				System.out.println("Value "+value+" deleted");
				return true;
			
			}
			elem=elem.next();
		}
		System.out.println("Value not found.");
		return false;
	}
	
	public ListElement<objType> search(objType value){
		ListElement<objType> elem = head;
		while(elem!=null){
			if(elem.value() == value){
				return elem;
			}
			elem=elem.next();
		}
		return null;
	}
	
	public ListElement<objType> getHead(){
		return head;
	}
	
	public void displayAll(){
		ListElement<objType> elem = head;
		while(elem!=null){
			System.out.println(elem.value());
			elem=elem.next();
		}
		
	}
	public int size(){
		return length;
	}
	
	public ListElement<objType> getNthElement(int n){
		ListElement<objType> elem = head, last = head;
		
		for(int i = 0; i < n; ++i){
			if(last == null){
				System.out.println("Error");
				return null;
			}
			
			last = last.next();
		}
		
		while(last!=null){
			elem = elem.next();
			last=last.next();
		}
		
		return elem;
	}
	
	public void reverse(int n){
		ListElement<objType> start = null, current;
		
		if(length == 1){
			return;
		}
		
		if(length <= n){
			current = head;
		} else {
			start = getNthElement(n+1);
			current = start.next();
		}
		
		ListElement<objType> elem = current.next(), next = elem.next();
		
		while(true){
			elem.setNext(current);
			current = elem;
			if(next == null){
				break;
			}
			elem = next;
			next = elem.next();
		}
		
		if(length <= n){
			head.setNext(null);
			head = elem;
			
		} else {
			start.next().setNext(null);
			start.setNext(elem);
		}
	
	}
}
