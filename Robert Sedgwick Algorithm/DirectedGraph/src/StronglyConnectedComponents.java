import java.util.Stack;


public class StronglyConnectedComponents {
	private boolean[] marked;
	private int[] id;
	private int count;
	private int[] size;
	
	public StronglyConnectedComponents(DiGraph g){
		marked = new boolean[g.V()];
		id = new int[g.V()];
		size = new int[g.V()];
		
		TopologicalSort ts = new TopologicalSort(g);
		Stack<Integer> topologicalSorted = ts.topologicalSorted();
		while(!topologicalSorted.isEmpty()){
			int v = topologicalSorted.pop();
			if(!marked[v]){
				dfs(g, v);
				count++;
			}
		}
	}
	
	public void dfs(DiGraph g, int v){
		marked[v] = true;
		size[count]++;
		id[v] = count;
		for(int w : g.adj(v)){
			dfs(g, w);
			
		}
	}
	
	public boolean isConnected(int v, int w){
		return id(v) == id(w);
	}
	
	public int count(){
		return count;
	}
	
	public int id(int v){
		return id[v];
	}
	
	/**
     * Returns the number of vertices in the connected component containing vertex <tt>v</tt>.
     *
     * @param  v the vertex
     * @return the number of vertices in the connected component containing vertex <tt>v</tt>
     */
	public int size(int v){
		return size[id[v]];
	}
}
