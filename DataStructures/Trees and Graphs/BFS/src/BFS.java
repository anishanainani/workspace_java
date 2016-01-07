import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;



public class BFS {
	Graph g;
	HashMap<String,Boolean> discovered;
	HashMap<String,Boolean> processed;
	HashMap<String,String> parent;
	HashMap<String,color> colors;
	boolean bipartite;
	
	enum color{
		UNCOLORED,WHITE,BLACK;
	}
	BFS(Graph g){
		this.g = g;
	}
	
	public void traverse(String s){
		//initialize();
		
		colors.put(s, color.WHITE);
		discovered.put(s, true);
		
		ArrayList<String> queue = new ArrayList<String>();
		queue.add(s);
		
		while(!queue.isEmpty()){
			String n = queue.remove(0);
			process_vertex(n);
			
			if(!g.adjacency_list.containsKey(n)){
				continue;
			}
			
			
			ArrayList<String> adj = g.adjacency_list.get(n);
			
			for(int i = 0; i < adj.size(); ++i){
				String node = adj.get(i);
			
				if(!processed.get(node) || g.isDirected){
					process_edge_colored(n,node);
				}
		
				if(!discovered.get(node)){
					discovered.put(node, true);
					queue.add(node);
					parent.put(node, n);
				}
				
				
			}
			
			processed.put(n, true);
		}
		
		
	}
	
	public void process_edge(String n1, String n2){
		System.out.println("Processing edge : "+n1+" "+n2);
	}
	
	public void process_edge_colored(String n1, String n2){
		if(colors.get(n1) == colors.get(n2)){
			bipartite = false;
			System.out.println("Graph is not bipartite");
			return;
		}
		
		colors.put(n2, compliment(colors.get(n1)));
	}
	
	public color compliment(color c){
		if(c == color.BLACK) return color.WHITE;
		else if (c == color.WHITE) return color.BLACK;
		
		return color.UNCOLORED;
	}
	
	public void process_vertex(String n){
		System.out.println("Processing vertex : "+n);
	}
	
	public void initialize(){
		discovered = new HashMap<String,Boolean>();
		processed = new HashMap<String,Boolean>();
		parent = new HashMap<String,String>();
		colors = new HashMap<String,color>();
		
		for(int i = 0; i<g.vertices.size();++i){
			discovered.put(g.vertices.get(i),false);
			processed.put(g.vertices.get(i),false);
			parent.put(g.vertices.get(i),null);
			colors.put(g.vertices.get(i),color.UNCOLORED);
		}
	}
	
	public void find_path(String start, String end){
		if(start.equals(end) || end==null){
			System.out.print(start+" ");
			return;
		}
		find_path(start,parent.get(end));
		System.out.print(end+" ");
		
	}
	
	public void connected_components(){
		int c = 1;
		initialize();
	
		Set<String> keyset = discovered.keySet();
		for(String key : keyset){
			if(!discovered.get(key)){
				System.out.println("Component : "+c);
				traverse(key);
				c++;
				
				
			}
		}
	}
	
	public void twoColor(){
		initialize();
		bipartite = true;
		Set<String> keyset = discovered.keySet();
		for(String key : keyset){
			if(!discovered.get(key)){
				
				traverse(key);

			}
		}
		
		Set<String> ks = colors.keySet();
		for(String key : ks){
			
				System.out.println(key+" - "+colors.get(key));

		
		}
	}
}
