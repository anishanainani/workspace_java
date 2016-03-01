import java.util.Stack;


public class TopologicalSort {

	private boolean[] marked;
	Stack<Integer> reversePostorder;
	
	public TopologicalSort(DiGraph g){
		Cycle checker = new Cycle(g);
		if(checker.hasCycle()){
			System.out.println("Graph is not a DAG");
			return;
		}
		
		marked = new boolean[g.V()];
		reversePostorder = new Stack<Integer>();
		for(int v = 0; v < g.V(); v++){
			if(!marked[v]){
				dfs(g, v);
			}
		}
	}
	
	public void dfs(DiGraph g, int v){
		marked[v] = true;
		
		for(int w : g.adj(v)){
			if(!marked[w])
				dfs(g, w);
		}
		reversePostorder.push(v);
	}
	
	public Stack<Integer> topologicalSorted(){
		
		return reversePostorder;
	}
	
	public static void main(String[] args) {
		DiGraph G = new DiGraph(6);
        
        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(0, 3);
        //G.addEdge(2, 1);
        G.addEdge(3, 4);
        G.addEdge(3, 5);
        
        TopologicalSort finder = new TopologicalSort(G);
        Stack<Integer> reversePostorder = finder.topologicalSorted();
        while (!reversePostorder.isEmpty()) {
            System.out.print(reversePostorder.pop() + " ");
    	}
        System.out.println();

	}

}
