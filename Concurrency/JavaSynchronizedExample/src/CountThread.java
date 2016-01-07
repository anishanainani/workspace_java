
public class CountThread extends Thread{
	protected Counter counter = null;

    public CountThread(Counter counter){
       this.counter = counter;
    }

    public void run() {
    	for(int i=0; i<10; i++){
    		counter.add(i);
    		System.out.println("Value added by "+getName()+": "+counter.count);
    	}
    }
}
