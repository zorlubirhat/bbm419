
public class minMax {
	
	//D - This is our class variable to hold the depth that the method will search to
	private static int D = 5;
    static eval e = new eval();
    
    //minMax - This method will take in a couple of different parameters and construct
    // a tree with the different possibilities. This method will also preform alpha beta 
    // pruning to make the tree traversing more efficient.
    static int MAX = 1000; 
	static int MIN = -1000; 

	// Returns optimal value for 
	// current player (Initially called 
	// for root and maximizer) 
	int minmax(Graph G,int depth,Boolean maximizingPlayer, int alpha,int beta) { 
		// Terminating condition. i.e 
		// leaf node is reached 
		if(depth == D || G.isFull())  
			return e.eval(G); 

		if (maximizingPlayer) 
		{ 
			int best = MIN; 

			// Recur for left and 
			// right children 
			 
		for(int i = 0; i < G.sizeOfGraph(); i++){
	            for(int j = i+1; j < G.sizeOfGraph(); j++){
	              if(!G.isEdge(i, j)){
		               
		              alpha = Math.max(alpha, best); 

		              // Alpha Beta Pruning 
		              if (beta <= alpha) 
		            	  break; 
		              G.addEdge(i, j, 1);
		              int val = minmax(G,depth + 1,false, alpha, beta);
		              best = Math.max(best, val);
		              G.removeEdge(i, j);
		           } 
		        }
			}
			
			
			
			
			return best; 
		} 
		else
		{ 
			int best = MAX; 

			// Recur for left and 
			// right children 
		for(int i = 0; i < G.sizeOfGraph(); i++){
	            for(int j = i+1; j < G.sizeOfGraph(); j++){
	              if(!G.isEdge(i, j)){
			 
	            	  beta = Math.min(beta, best); 
	            	  // Alpha Beta Pruning 
	            	  if (beta <= alpha) 
	            		  break; 
	            	  G.addEdge(i, j, 1);
	            	  int val = minmax(G,depth + 1,true, alpha, beta);
	            	  best = Math.min(best, val); 
	            	  G.removeEdge(i, j);
	              }
	            }
			} 
			return best; 
		} 


	} 
	
}
