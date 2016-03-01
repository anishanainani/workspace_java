import java.util.LinkedList;
import java.util.List;

public class Graph {
	private int V;
	private List<Integer>[] adj;
	
	public Graph(int V){
		this.V = V;
		adj = (List<Integer>[]) new List[V];
		for(int i = 0; i < V; ++i){
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int v, int w){
		adj[v].add(w);
		adj[w].add(v);
	}
	
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	
	public int V(){
		return V;
	}
	
}
