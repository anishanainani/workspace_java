import java.util.LinkedList;
import java.util.List;


public class DiGraph {
	
	private List<Integer>[] adj;
	private int V, E;
	private int[] indegree, outdegree;
	
	public DiGraph(int V){
		this.V = V;
		indegree = new int[V];
		outdegree = new int[V];
		adj = (List<Integer>[])new List[V];
		for(int i = 0; i < V; i++){
			adj[i] = new LinkedList<Integer>();
		}
	}
	

    // throw an IndexOutOfBoundsException unless 0 <= v < V
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
    }

    /**
     * Adds the directed edge v->w to this digraph.
     *
     * @param  v the tail vertex
     * @param  w the head vertex
     * @throws IndexOutOfBoundsException unless both 0 <= v < V and 0 <= w < V
     */
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        indegree[w]++;
        E++;
    }

    /**
     * Returns the vertices adjacent from vertex <tt>v</tt> in this digraph.
     *
     * @param  v the vertex
     * @return the vertices adjacent from vertex <tt>v</tt> in this digraph, as an iterable
     * @throws IndexOutOfBoundsException unless 0 <= v < V
     */
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    /**
     * Returns the number of directed edges incident from vertex <tt>v</tt>.
     * This is known as the <em>outdegree</em> of vertex <tt>v</tt>.
     *
     * @param  v the vertex
     * @return the outdegree of vertex <tt>v</tt>               
     * @throws IndexOutOfBoundsException unless 0 <= v < V
     */
    public int outdegree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    /**
     * Returns the number of directed edges incident to vertex <tt>v</tt>.
     * This is known as the <em>indegree</em> of vertex <tt>v</tt>.
     *
     * @param  v the vertex
     * @return the indegree of vertex <tt>v</tt>               
     * @throws IndexOutOfBoundsException unless 0 <= v < V
     */
    public int indegree(int v) {
        validateVertex(v);
        return indegree[v];
    }

    /**
     * Returns the reverse of the digraph.
     *
     * @return the reverse of the digraph
     */

	
	public int V(){
		return V;
	}
	
	public int E(){
		return E;
	}
	
	
	public String toString() {
		StringBuilder s = new StringBuilder();
	    s.append(V + " vertices, " + E + " edges " + "\n");
	    for (int v = 0; v < V; v++) {
	    	s.append(String.format("%d: ", v));
	        for (int w : adj[v]) {
	        	s.append(String.format("%d ", w));
	        }
	        s.append("\n");
	    }
	    return s.toString();
	}
	

}
