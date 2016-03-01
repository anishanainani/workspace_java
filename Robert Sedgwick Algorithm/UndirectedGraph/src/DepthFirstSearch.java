import java.util.Stack;


public class DepthFirstSearch {
	private boolean marked[];
	private int edgeTo[];
	private int s;
	
	public DepthFirstSearch(Graph g, int s){
		this.s = s;
		marked = new boolean[g.V()];
		edgeTo = new int[g.V()];
		dfs(g, s);
	}
	
	public void dfs(Graph g, int v){
		marked[v] = true;
		for(int w : g.adj(v)){
			if(!marked[w]){
				dfs(g, w);
				edgeTo[w] = v;
			}
		}
	}
	
	public boolean hasPathTo(int v){
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)) return null;
		
		Stack<Integer> path = new Stack<Integer>();
		for(int x = v; x!=s; x=edgeTo[v] ){
			path.push(v);
		}
		
		path.push(s);
		return path;
	}
}
