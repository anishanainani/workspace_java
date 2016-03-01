
public class ConnectedComponents {
	private boolean[] marked;
	private int[] id;
	private int count;
	private int[] size;
	
	public ConnectedComponents(Graph g){
		marked = new boolean[g.V()];
		id = new int[g.V()];
		size = new int[g.V()];
		
		for(int v = 0; v < g.V(); ++v){
			if(!marked[v]){
				dfs(g, v);
				count++;
			}
		}
	}
	
	public void dfs(Graph g, int v){
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
