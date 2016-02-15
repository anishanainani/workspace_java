import java.util.Random;


public class ShuffleArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] input = {"a", "b", "c", "d", "e", "f"};
		shuffle(input);
		show(input);
	}
	
	public static void shuffle(Object[] a){
		int N = a.length;
		Random rng = new Random();
		for(int i = 1; i < N; ++i){
			int r = rng.nextInt(i+1);
			exch(a, i, r);
		}
	}
	
	public static void exch(Object[] a, int i, int j){
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	public static void show(Object[] a){
		for(int i = 0; i < a.length; ++i){
			System.out.println(a[i]);
		}
	}

}
