
public class ListElement<objType>{
	public objType value;
	public ListElement<objType> next;	

	ListElement(objType data){
		value = data;
		next = null;
	}

	public objType value() {
		return value;
	}

	public ListElement<objType> next() {
		return next;
	}

	public void setValue(objType data){
		value = data;
	}

	public void setNext(ListElement<objType> elem){
		next = elem;
	}
}