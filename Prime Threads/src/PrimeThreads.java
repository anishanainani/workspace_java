

/**
 *
 * @author vikhy_000
 */
public class PrimeThreads {

    /**
     * @param args the command line arguments
     */
    private static int X = 5;
    private static int RANGE = 10000;
    private static int BITE = 1000;
    

    public static void main(String[] args) throws InterruptedException {
    	
    	int count[] = new int[X];
    	int bites[] = new int[X];
    	long time[] = new long[X];
        PrimeWork work = new PrimeWork(3, RANGE, BITE);
        PrimeThread[] pThreads = new PrimeThread[X];
        int high = 0, low = 0;
        for (int i = 0; i < X; i++) {
        	 System.out.println("Thread#"+(i+1)+" getting a bite.");
        	 ++bites[i];
        	Range range = work.getWork();
        	low = range.getLow();
        	high = range.getHigh();
     
            pThreads[i] = new PrimeThread("Thread #"+(i+1),low ,high );
            pThreads[i].start();
        }
        
        
        
        int j = 0;
        while(high!=RANGE){
        	if(!pThreads[j].isAlive()){
        		 count[j]+=pThreads[j].getCount();
        		 time[j]+=pThreads[j].getTime();
        		 ++bites[j];
        		 System.out.println("Thread#"+(j+1)+" getting a bite.");
        		Range range = work.getWork();
            	low = range.getLow();
            	high = range.getHigh();
            	
            	 pThreads[j] = new PrimeThread("Thread #"+(j+1),low ,high );
                pThreads[j].start();
               
        	}
        	++j;
            
        	if(j == X){
        		j = 0;
        	}
        }
        
      
        for (int i = 0; i < X; i++) {
        	while(pThreads[i].isAlive());
        	count[i]+=pThreads[i].getCount();
        	time[j]+=pThreads[j].getTime();
        }
        
        for (int i = 0; i < X; i++) {
        	System.out.println("Thread#"+(i+1) + " - PrimeCount: " +count[i]+" , Timer: "+time[i]+" sec , Total Bites: "+bites[i]);
        }
        
        for (int i = 0; i < X; i++) {
        	pThreads[i].join();
        	
        }
       

    }
}
