/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author vikhy_000
 */
public class PrimeThread extends Thread {

    int start, end;
    String name;
    FindPrime fp;
    int count,bites;
    long time = 0;

    PrimeThread(String name, int start, int end) {
        this.name = name;
        this.start = start;
        this.end = end;
        fp = new FindPrime();
       
    }
    
  
    

  
    long getTime(){
    	return time;
    }
    
    
    public void run() {
        final long starttime = System.nanoTime();
       
        count = fp.countPrime(start, end);
        
     
        final long endtime = System.nanoTime();
        
        time=(endtime - starttime) / 1000000L;
    }

    public int getCount() {
        return count;
    }
}
