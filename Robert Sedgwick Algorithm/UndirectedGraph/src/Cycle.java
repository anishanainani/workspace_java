import java.util.Stack;

public class Cycle {
	
	private boolean[] marked;
	private int[] edgeTo;
	Stack<Integer> cycle;
	
	public Cycle(Graph g){
		if(hasSelfLoop(g)) return;
		if(hasParallelEdge(g)) return;
		marked = new boolean[g.V()];
		edgeTo = new int[g.V()];
		for(int v = 0; v < g.V(); ++v){
			if(!marked[v]){
				dfs(g, -1, v);
			}
		}
	}
	
	public boolean hasSelfLoop(Graph g){
		for(int v = 0; v < g.V(); ++v){
			for(int w : g.adj(v)){
				if(w == v){
					cycle =new Stack<Integer>();
					cycle.push(v);
					cycle.push(v);
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean hasParallelEdge(Graph g){
		marked = new boolean[g.V()];
		for(int v = 0; v < g.V(); ++v){
			for(int w : g.adj(v)){
				if(marked[w]){
					cycle = new Stack<Integer>();
					cycle.push(v);
					cycle.push(w);
					cycle.push(v);
					return true;
				}
				
				marked[w] = true;
			}
			
			for(int w: g.adj(v)){
				marked[w] = false;
			}
		}
		
		return false;
	}
	
	public void dfs(Graph g, int u, int v){
		marked[v] = true;
		
		for(int w : g.adj(v)){
			
			if (cycle != null) return;
			
			if(!marked[w]){
				edgeTo[w] = v;
				dfs(g, v, w);
			}
			
			else if(w!=u){
				cycle = new Stack<Integer>();
				
				for(int x = v; x != w; x = edgeTo[x]){
					cycle.push(x);
				}
				
				cycle.push(w);
				cycle.push(v);
			}
		}
	}
	
    /**
     * Returns true if the graph <tt>G</tt> has a cycle.
     *
     * @return <tt>true</tt> if the graph has a cycle; <tt>false</tt> otherwise
     */
    public boolean hasCycle() {
        return cycle != null;
    }

     /**
     * Returns a cycle in the graph <tt>G</tt>.
     * @return a cycle if the graph <tt>G</tt> has a cycle,
     *         and <tt>null</tt> otherwise
     */
    public Iterable<Integer> cycle() {
        return cycle;
    }
    
    public static void main(String[] args) {
        Graph G = new Graph(6);
        
        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(0, 3);
        G.addEdge(2, 1);
        G.addEdge(3, 4);
        G.addEdge(3, 5);
        
        Cycle finder = new Cycle(G);
        if (finder.hasCycle()) {
            for (int v : finder.cycle()) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
        else {
        	System.out.println("Graph is acyclic");
        }
    }

}
