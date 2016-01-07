
public class Tower {
	Stack<Integer> disks;
	int index;
	
	public Tower(int i){
		disks = new Stack<Integer>();
		index = i;
	}
	
	public void add(int n){
		disks.push(n);
	}
	
	public void moveToTop(Tower t){
		int top = disks.pop();
		t.add(top);
		System.out.println("Move disk from Tower"+index+" to Tower"+t.index);
	}
	
	public void moveDisks(int n, Tower destination, Tower buffer){
		if(n>0){
			moveDisks(n-1, buffer, destination);
			moveToTop(destination);
			buffer.moveDisks(n-1,destination,this);
		}
	}
}
