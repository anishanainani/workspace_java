import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;


public class ResizingArrayStack<Item> implements Iterable<Item> {

	private int N;
	private Item[] items;
	
	public ResizingArrayStack(){
		items = (Item[]) new Object[2];
		N = 0;
	}

	public void push(Item item){
		if(N == items.length-1){
			resize(items.length*2);
		}
		
		items[N++] = item;
	}
	
	public Item pop(){
		if(N == items.length/2) resize(items.length/4);
		
		Item item = items[N-1];
		items[N-1] = null;
		return item;
	}
	
	public void resize(int capacity){
		assert capacity >= N;
		Item[] temp = (Item[]) new Object[capacity];
		for(int i = 0; i < N; i++){
			temp[i] = items[i];
		}
		
		items = temp;
	}
	
	public int size(){
		return N;
	}
	
	public boolean isEmpty(){
		return N==0;
	}
	
	public Item peek() {
	        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
	        return items[N-1];
	}
	 
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ReverseArrayIterator implements Iterator<Item> {
        private int i;

        public ReverseArrayIterator() {
            i = N-1;
        }

        public boolean hasNext() {
            return i >= 0;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return items[i--];
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
