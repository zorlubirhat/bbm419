import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Player1{
	Graph g = new Graph(6);
	static Player1 p = new Player1();
	static minMax minMax = new minMax();
	static int count=0;
	private static LinkedList<Integer> adj[];
	static ArrayList<Integer> makerList = new ArrayList<>();
	static Set<Integer> hs = new HashSet<>();
	 
	 
	public boolean connectedComponents(int w) {
		// Mark all the vertices as not visited 
		boolean[] visited = new boolean[6]; 
		for(int v = 0; v < 6; ++v) { 
			if(!visited[v]) { 
				// print all reachable vertices 
				// from v 
				if(g.isConnectedSpanningTree(v,visited,1)==false) {
					makerList.add(v);}
					System.out.println(makerList); 
				} 
			}
		return false;
	} 
	public static Move chooseMove(Graph G) { 
		int max = -10000;
		Move best = new Move(5,4);
        for(int k = 5; k > 0; k--){
            for(int l = 5; l > 5; l--){
                if(G.isEdge(k, l) == false && k != l) {
                	p.connectedComponents(1);
                	if(!makerList.contains(k) || !makerList.contains(l)) {
                		best = new Move(k,l);
                		
                	}
                }
            }
        }

        for(int i = 0; i < G.sizeOfGraph(); i++){
          for(int j = i+1; j < G.sizeOfGraph(); j++){
            if(i != j && G.isEdge(i, j) == false){
           		System.out.print(i+" and ");
           		System.out.print(j + " are I and J");
           		G.addEdge(i, j, 1);
           		Move m = new Move(i, j);
           		int val = minMax.minmax( G, 1,true, 0, 0);
           		System.out.println(val + " | " + i +  " " + j);
           		if(count<5) {
            		if(val >= max) {
            			System.out.println("New best");
            			best = m;
            			max = val; 
            		}
            		G.removeEdge(i, j);
            	}
            }
          }
        }
        System.out.println("Best move: " +best);
        return best; 
	}
}
    
    
