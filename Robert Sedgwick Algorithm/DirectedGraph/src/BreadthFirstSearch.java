import java.util.ArrayList;


public class BreadthFirstSearch {
	private boolean marked[];
	private int edgeTo[];
	
	
	public void bfs(DiGraph g, int s){
		marked = new boolean[g.V()];
		edgeTo = new int[g.V()];
		
		marked[s] = true;
		ArrayList<Integer> queue = new ArrayList<Integer>();
		queue.add(s);
		
		while(!queue.isEmpty()){
			int v = queue.remove(0);
			for(int w : g.adj(v)){
				if(!marked[w]){
					queue.add(w);
					marked[w] = true;
					edgeTo[w] = v;
				}
			}
		}
	}
}
