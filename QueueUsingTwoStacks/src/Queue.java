class Queue{
	Stack stack1, stack2;
	public Queue(){
		stack1 = new Stack();
		stack2 = new Stack();
	}

	public void enqueue(int item){
		stack1.push(item);
	}

	public int dequeue(){
		if(stack2.isEmpty()){
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
		} 
		if(!stack2.isEmpty()){
			return stack2.pop();
		} else {
			System.out.println("No element in Queue!");
			return -1;
		}
		
	}
	
}