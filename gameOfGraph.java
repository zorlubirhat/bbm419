import java.util.*;


public class gameOfGraph {

    private int x;
    //arrays

    private static int[][] M;               // 0 = no edge;

    private static boolean [] isVisit;

    private ArrayList<Integer>[] adjList;
    ArrayList<Integer> makerList = new ArrayList<>(); 
    ArrayList<Integer> breakerList = new ArrayList<>(); 
    private ArrayList<Integer> allvertices = new ArrayList<>();
    Set<Integer> hs = new HashSet<>();
    Set<Integer> hs1 = new HashSet<>();

    public gameOfGraph(int N){ 

        M = new int[N][N];
        this.x = N;

        isVisit = new boolean[M.length];
        adjList = new ArrayList[x]; 
        
        for(int i = 0; i < x; i++) 
        { 
            adjList[i] = new ArrayList<>();
        } 
        for(int i=0; i<8; i++) {
        	allvertices.add(i);
        }

    }

    

    public void addEdge(int u, int v, int w){  
    	adjList[u].add(v);
    	// add an edge from vertex u to v with value w 
        this.M[u][v] = w;
        this.M[v][u] = w;
        if(w==1) {
            // Add v to u's list. 
        		 
            makerList.add(v);
           	hs.addAll(makerList);
           	makerList.clear();
           	makerList.addAll(hs);
        }
        if(w==(-1)) {
        	breakerList.add(v);
        	hs1.addAll(breakerList);
        	breakerList.clear();
        	breakerList.addAll(hs1);
        }
    }

    

    public void removeEdge(int u, int v){         // remove the edge from u to v and the (duplicate) edge from v to u
        this.M[u][v] = 0;
        this.M[v][u] = 0;
    }

    

    public int getEdge(int u, int v){

        return this.M[u][v];

    }

    

    public boolean isEdge(int u, int v){            // return true or false depending on whether there is an edge from u to v

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

    

    public int degreeOfColor(int v, int w){                // return the number of edges of color w connected to vertex v

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
    public void printAll(int s, int d)  
    {  
    	boolean[] isVisited = new boolean[x]; 
        //Call recursive utility 
        printAllUtil(s, d, isVisited); 
    } 
    private void printAllUtil(Integer u, Integer d, 
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
    			printAllUtil(i, d, isVisited); 
    		}
    	} 
    	
    	// Mark the current node
    	isVisited[u] = false; 
    } 


    

   
 

    public static void main(String[] args){

        gameOfGraph G = new gameOfGraph(8);

        

        //addEdge - add an edge from vertex u to v with value w

        System.out.println(); 

        G.addEdge(3,4,1);  
        G.addEdge(0,3,1); 
        G.addEdge(4,1,-1); 
        G.addEdge(1,2,1); 
        G.addEdge(2,0,1); 
        G.addEdge(0,4,1);
        G.addEdge(4,5,1);
        G.addEdge(5,1,1);
        G.addEdge(1,3,-1);
        G.addEdge(3,5,1);
        G.addEdge(5,0,1);
        G.addEdge(0,6,1);
        G.addEdge(6,7,1);
        int s = 0; 
        
        // arbitrary destination 
        int d = 7;

        G.printAll(s,d);

        

        //removeEdge - remove the edge from u to v and the (duplicate) edge from v to u

        /*System.out.println("Going to remove lines of red among points 2 and 3");

        System.out.println();

        G.removeEdge(1, 2);

        G.printEdges();*/

        

        //getEdge - return the value of the edge that goes from u to v

        /*System.out.println("Going to get the value of the edge from 1 to 2");

        System.out.println();

        G.printEdges();

        System.out.println("1");

        System.out.println(G.getEdge(0, 1));

        System.out.println();*/

        

        //isEdge - return true or false depending on whether there is an edge (of either color) from u to v

        /*System.out.println("Going to see if there is an edge between 1 and 2");

        System.out.println();

        G.printEdges();

        System.out.println("true");

        System.out.println(G.isEdge(0, 1));

        System.out.println();

        System.out.println("Going to see if there is an edge between 5 and 6");

        System.out.println();

        G.printEdges();

        System.out.println("false");

        System.out.println(G.isEdge(4, 5));

        System.out.println();

        

        System.out.println("Adding more vertices: Blue 4 to 5, Blue 5 to 6, and Blue 3 to 5");

        G.addEdge(3, 4, -1);

        G.addEdge(4, 5, -1);

        G.addEdge(2, 4, -1);

        System.out.println();

        

        //degree (with one parameter) - return the number of edges of either color connected to vertex v

        System.out.println("Going to see the number of edges connected to vertex 3");

        System.out.println();

        G.printEdges();

        System.out.println("2");*/

        System.out.println(G.degree(2));

        System.out.println();

        

        //degree (with two parameters) - return the number of edges of color w connected to vertex v

        /*System.out.println("Going to see the number of Blue edges connected to vertex 3");

        System.out.println();

        G.printEdges();

        System.out.println("1");*/

        System.out.println(G.degreeOfColor(4, 1));

        System.out.println();

    }

    

}
