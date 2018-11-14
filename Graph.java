
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set; 
  
// A directed graph using 
// adjacency list representation 
public class Graph { 
  
    // No. of vertices in graph 
    private int v;  
      
    // adjacency list  
    private ArrayList<Integer>[] adjList; 
    ArrayList<Integer> makerList = new ArrayList<>(); 
    private ArrayList<Integer> allvertices = new ArrayList<>();
    Set<Integer> hs = new HashSet<>();
    
      
    //Constructor 
    public Graph(int vertices){ 
          
        //initialise vertex count 
        this.v = vertices; 
          
        // initialise adjacency list 
        initAdjList();  
    } 
      
    // utility method to initialise 
    // adjacency list 
    @SuppressWarnings("unchecked") 
    private void initAdjList() 
    { 
        adjList = new ArrayList[v]; 
          
        for(int i = 0; i < v; i++) 
        { 
            adjList[i] = new ArrayList<>();
        } 
        for(int i=0; i<8; i++) {
        	allvertices.add(i);
        }
    } 
      
    // add edge from u to v 
    public void addEdge(int u, int v, int w) 
    { 
    	
    	if(w==1) {
        // Add v to u's list. 
    		adjList[u].add(v); 
        	makerList.add(v);
        	hs.addAll(makerList);
        	makerList.clear();
        	makerList.addAll(hs);
        }
    } 
    public int sizeOfGraph(){

        return makerList.size();

    }
      
    // Prints all paths from 
    // 's' to 'd' 
    public void printAllPaths(int s, int d)  
    { 
        boolean[] isVisited = new boolean[v]; 
          
        //Call recursive utility 
        printAllPathsUtil(s, d, isVisited); 
    } 
  
    // A recursive function to print 
    // all paths from 'u' to 'd'. 
    // isVisited[] keeps track of 
    private void printAllPathsUtil(Integer u, Integer d, 
                                    boolean[] isVisited) { 
          
        // Mark the current node 
        isVisited[u] = true; 
        
        if (u.equals(d)) {
        	System.out.println(makerList);
        	if(makerList.size()==8) {
        		System.out.println("Maker wins");
        	}
        	
       	}
         
          
        // Recur for all the vertices 
        // adjacent to current vertex 
        for (Integer i : adjList[u])  
        { 
            if (!isVisited[i]) 
            {  
                printAllPathsUtil(i, d, isVisited); 
            } 
        } 
          
        // Mark the current node 
        isVisited[u] = false; 
    } 
  
    // Driver program 
    public static void main(String[] args)  
    { 
        // Create a sample graph 
        Graph g = new Graph(8); 
        g.addEdge(3,4,1);  
        g.addEdge(0,3,1); 
        g.addEdge(4,1,-1); 
        g.addEdge(1,2,1); 
        g.addEdge(2,0,1); 
        g.addEdge(0,4,1);
        g.addEdge(4,5,1);
        g.addEdge(5,1,1);
        g.addEdge(1,3,-1);
        g.addEdge(3,5,1);
        g.addEdge(5,0,1);
        g.addEdge(0,6,1);
        g.addEdge(6,7,1);
      
        // arbitrary source 
        int s = 0; 
      
        // arbitrary destination 
        int d = 7; 
        g.printAllPaths(s, d); 
  
    } 
}