
public class Main {

	public static void main(String[] args) {
		Graph g = new Graph();
		g.isDirected=true;
		g.addEdge("A", "K");
		g.addEdge("A", "L");
		g.addEdge("A", "S");
		g.addEdge("K", "S");
		g.addEdge("L", "C");
		g.addEdge("A", "Y");
		g.addEdge("S", "A");
		//g.addEdge("X", "Y");

		g.displayGraph();
		
		DFS bf= new DFS(g);
		bf.traverse("A");
		

	}

}
