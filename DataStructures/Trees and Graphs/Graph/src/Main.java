
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph();
		g.addEdge("A", "K");
		g.addEdge("S", "L");
		g.addEdge("A", "S");
		g.addEdge("C", "L");
		g.addEdge("A", "L");

		g.displayGraph();
	}

}
