
public class FirstThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread thread = new Thread(){
		    public void run(){
		      System.out.println("Thread Running");
		    }
		  };

		  thread.start();
		  
		  MyThread mt = new MyThread();
		  mt.start();
		  
		  Thread thr = new Thread(new MyRunnable());
		   thr.start();
		   
		  Runnable myRunnable = new Runnable(){

			     public void run(){
			        System.out.println("Runnable running");
			     }
		  };

		  Thread thrd = new Thread(myRunnable);
		  thrd.start();
		  
		  System.out.println(Thread.currentThread().getName());
		   for(int i=0; i<10; i++){
		     new Thread("" + i){
		       public void run(){
		         System.out.println("Thread: " + getName() + " running");
		       }
		     }.start();
		   }

	}

	public static class MyThread extends Thread {

	    public void run(){
	       System.out.println("MyThread running");
	    }
	}
	
	public static class MyRunnable implements Runnable {

	    public void run(){
	       System.out.println("MyRunnable running");
	    }
	  }
}
