
public class Queue {

		Stack<Integer> stack1;
		Stack<Integer> stack2;
		
		Queue(){
			stack1 = new Stack<Integer>();
			stack2 = new Stack<Integer>();
		}
		
		public void enqueue(int n){
			stack1.push(n);
		}
		
		public int size(){
			return stack1.size+stack2.size;
		}
		
		public int dequeue(){
			
			if(!stack2.isEmpty()){
				return stack1.pop();
			}
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
			return stack2.pop();
			
			
		}
}
