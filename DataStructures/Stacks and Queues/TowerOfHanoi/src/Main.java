
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tower[] towers = new Tower[3];
		for(int i = 0; i < 3; ++i){
			towers[i] = new Tower(i);
		}
		for(int i = 5; i >=0; --i){
			towers[0].add(i);
		}

		towers[0].moveDisks(5, towers[2], towers[1]);
	}

}
