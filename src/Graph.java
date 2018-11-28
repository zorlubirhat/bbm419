// Java program to print DFS traversal from a given given graph 
import java.io.*; 
import java.util.*; 
  
// This class represents a directed graph using adjacency list 
// representation 
class Graph 
{ 
    private int V;   // No. of vertices 
    static int count;
  
    private static int[][] M;
    // Array  of lists for Adjacency List Representation 
    private LinkedList<Integer> adj[]; 
    static ArrayList<Integer> makerList = new ArrayList<>(); 
    ArrayList<Integer> breakerList = new ArrayList<>();
    static ArrayList<Integer> dfsList = new ArrayList<>();
    Set<Integer> hs = new HashSet<>();
    Set<Integer> hs1 = new HashSet<>();
    
    // Constructor 
    Graph(int v) 
    { 
    	M = new int[v][v];
        V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    } 
  
    //Function to add an edge into the graph 
    void addEdge(int v,int u, int w) 
    { 
        adj[v].add(u);  // Add w to v's list. 
        adj[u].add(v);
        
        this.M[v][u] = w;
        this.M[u][v] = w;
        //this.M[destination][source] = w;
        
        
        if(w==1) {
            // Add v to u's list. 
        		 
            makerList.add(u);
           	hs.addAll(makerList);
           	makerList.clear();
           	makerList.addAll(hs);
        }
        if(w==(-1)) {
        	breakerList.add(u);
        	hs1.addAll(breakerList);
        	breakerList.clear();
        	breakerList.addAll(hs1);
        }
    } 
    public void removeEdge(int v, int u){         // remove the edge from u to v and the (duplicate) edge from v to u
        adj[v].remove(u);
        adj[u].remove(v);
    	
    	this.M[u][v] = 0;
        this.M[v][u] = 0;
    }
    int getEdge(int v, int u) {
    	return M[v][u];
    }
    
    public boolean isEdge(int u, int v){            // return true or false depending on whether there is an edge (of either color) from u to v
        if(this.M[u][v] != 0){
            return true;
        }else{
            return false;
        }
    }
    
    public int degree(int v){                       // return the number of edges of either color connected to vertex v
        int counter = 0;
        for(int i = 0; i < this.M[v].length; ++i){
            if(this.M[v][i] != 0){
                counter++;
            }
        }
        return counter;
    }
    
    public int degree(int v, int w){                // return the number of edges of color w connected to vertex v
        int counter = 0;
        for(int i = 0; i < this.M[v].length; ++i){
            if(this.M[v][i] == w){
                counter++;
            }
        }
        return counter;
    }
    
    public int sizeOfGraph(){
        return M.length;
    }
    
    public boolean isFull(){
        for(int i = 0; i < M.length; i++){
            if(degree(i) < M.length - 1)
                return false;
        }
        return true;                
    }
    
  
    // A function used by DFS 
    public boolean DFSUtil(int v,boolean visited[]) 
    { 
        // Mark the current node as visited and print it 
        visited[v] = true; 
        //System.out.print(v+" "); 
  
        // Recur for all the vertices adjacent to this vertex 
        Iterator<Integer> i = adj[v].listIterator(); 
        while (i.hasNext()) 
        { 
            int n = i.next(); 
            if (!visited[n] && getEdge(v,n)==1) {
            	count++;
                DFSUtil(n, visited); }
        } 
        return false;
    } 
  
    // The function to do DFS traversal. It uses recursive DFSUtil() 
    boolean DFS(int v) 
    { 
        // Mark all the vertices as not visited(set as 
        // false by default in java) 
        boolean visited[] = new boolean[V]; 
  
        return DFSUtil(v, visited); 
    } 
  
    public static void main(String args[]) 
    { 
        Graph g = new Graph(6); 
        Player p = new Player();
  
        g.addEdge(0, 2,1); 
        g.addEdge(2, 0,-1); 
        g.addEdge(2, 1,1); 
        g.addEdge(2, 0,-1); 
        g.addEdge(2, 3,1); 
        g.addEdge(3, 4,1); 
        g.addEdge(4, 5,1);
        g.addEdge(5, 0,1);
        g.addEdge(1, 4,1);
  
        System.out.println("Following is Depth First Traversal "+ 
                           "(starting from vertex 0)");
        /*if(g.makerList.size()==6) {
        	//System.out.println(count);
        	//p.chooseMove(g);
        }
        	
        else {
        	System.out.println("Breakers win");
        }*/
        if(makerList.size()==6) {
        	g.DFS(0);
        	//System.out.println(g.count);
        	if(count>=5) {
        		System.out.println("Maker wins");
        	}
        	else {
        		System.out.println("Breaker wins");
        	}
        }
        else {
        	System.out.println("Breaker wins");
        }
  
         
    } 
} 
