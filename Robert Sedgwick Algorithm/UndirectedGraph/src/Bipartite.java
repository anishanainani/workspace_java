import java.util.ArrayList;


public class Bipartite {
	private static final boolean WHITE = false;
	private static final boolean BLACK = true;
	
	private boolean[] marked;
	private int[] edgeTo;
	private boolean[] color;
	private boolean isBipartite;
	
	public Bipartite(Graph g){
		isBipartite = true;
		marked = new boolean[g.V()];
		edgeTo = new int[g.V()];
		color = new boolean[g.V()];
		
		for(int v = 0; v < g.V() && isBipartite; ++v){
			if(!marked[v]){
				bfs(g, v);
			}
		}
	}
	
	public void bfs(Graph g, int v){
		ArrayList<Integer> queue = new ArrayList<Integer>();
		marked[v] = true;
		queue.add(v);
		color[v] = WHITE;
		while(!queue.isEmpty()){
			int u = queue.remove(0);
			for(int w : g.adj(u)){
				if(!marked[w]){
					marked[w] = true;
					queue.add(w);
					edgeTo[w] = u;
				} else if(color[w] == color[u]){
					isBipartite = false;
					return;
				}
			}
		}
		
		
		
	}
	
    /**
     * Returns true if the graph is bipartite.
     *
     * @return <tt>true</tt> if the graph is bipartite; <tt>false</tt> otherwise
     */
    public boolean isBipartite() {
        return isBipartite;
    }
 
    /**
     * Returns the side of the bipartite that vertex <tt>v</tt> is on.
     *
     * @param  v the vertex
     * @return the side of the bipartition that vertex <tt>v</tt> is on; two vertices
     *         are in the same side of the bipartition if and only if they have the
     *         same color
     * @throws IllegalArgumentException unless <tt>0 &le; v &lt; V</tt> 
     * @throws UnsupportedOperationException if this method is called when the graph
     *         is not bipartite
     */
    public boolean color(int v) {
        if (!isBipartite)
            throw new UnsupportedOperationException("Graph is not bipartite");
        return color[v];
    }
    
    public static void main(String[] args){
    	Graph G = new Graph(6);
        
        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(0, 3);
        G.addEdge(2, 1);
        G.addEdge(3, 4);
        G.addEdge(3, 5);
        
        Bipartite checker = new Bipartite(G);
        System.out.println(checker.isBipartite());
    }
}
