import java.util.*; 
  
class Graph 
{ 
    private int V;   // Number of vertices 
    static int count;
    private static int[][] M;
    private LinkedList<Integer> adj[]; // Array  of lists for Adjacency List Representation 
    ArrayList<Integer> makerList = new ArrayList<>(); // Array  of lists for Maker List Representation 
    ArrayList<Integer> breakerList = new ArrayList<>(); // Array  of lists for Breaker List Representation 
    static ArrayList<Integer> dfsList = new ArrayList<>();
    Set<Integer> hs = new HashSet<>();
    Set<Integer> hs1 = new HashSet<>();
    
    Graph(int v) { 
    	M = new int[v][v];
        V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    } 
    
    void addEdge(int v,int u, int w) { 
        adj[v].add(u); 
        adj[u].add(v);
        
        this.M[v][u] = w;
        this.M[u][v] = w;
        
        if(w==1) {         		 
            makerList.add(u);
            makerList.add(v);
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
    public void removeEdge(int v, int u){
    	this.M[u][v] = 0;
        this.M[v][u] = 0;
    }
    int getEdge(int v, int u) {
    	return M[v][u];
    }
    
    public boolean isEdge(int u, int v){ 
        if(this.M[u][v] != 0){
            return true;
        }else{
            return false;
        }
    }
    
    public int degree(int v){
        int counter = 0;
        for(int i = 0; i < this.M[v].length; ++i){
            if(this.M[v][i] != 0){
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
    public boolean isConnectedSpanningTree(int v,boolean visited[],int w) {  
        visited[v] = true; 
        //System.out.print(v+" "); 
        Iterator<Integer> i = adj[v].listIterator(); 
        while (i.hasNext()) { 
        	int n = i.next(); 
            if (!visited[n] && getEdge(v,n)==w) {
            	isConnectedSpanningTree(n, visited,w); 
            	count++;   
            }
            if(count==5){
            	return true;
            }
        } 
		return false;
    } 
   
    boolean DFS(int v,int w) { 
        boolean visited[] = new boolean[V]; 
        return isConnectedSpanningTree(v, visited,w);
    } 
  
    public static void main(String args[]) { 
        Graph g = new Graph(6); 
        
        g.addEdge(0, 2, 1); 
        g.addEdge(2, 1, 1); 
        g.addEdge(2, 3, 1); 
        g.addEdge(4, 3, 1); 
        g.addEdge(3, 5, -1); 
        g.addEdge(3, 1, -1); 
        g.addEdge(4, 5, 1);
  
        System.out.println(g.DFS(0,1));
        if(count==5) {
        	System.out.println("Maker wins");
        }
        else {
        	System.out.println("Breaker wins");
        }
         
    }
} 
