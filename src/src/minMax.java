
public class minMax {
	
	//D - This is our class variable to hold the depth that the method will search to
	private static int D = 5;
    static eval e = new eval();
    
    //minMax - This method will take in a couple of different parameters and construct
    // a tree with the different possibilities. This method will also preform alpha beta 
    // pruning to make the tree traversing more efficient.
	static int minMax(Graph G, int depth, int alpha, int beta ) {  
        if(depth == D || G.isFull())  
          return e.eval(G); // stop searching and return eval  
        else if(depth%2 == 0) {  
          int val = -100000000;  
          for(int i = 0; i < G.sizeOfGraph(); i++){
            for(int j = i+1; j < G.sizeOfGraph(); j++){
              if(!G.isEdge(i, j)){
                alpha = Math.max(alpha, val); // update alpha with max so far  
                if(beta < alpha) break; // terminate loop  
                G.addEdge(i, j, 1);
                val = Math.max(val, minMax( G, depth+1, alpha, beta ));
                G.removeEdge(i, j);
              }
            }
          }  
          return val;  
        } else { // is a min node  
          int val = 10000000;  
          for(int i = 0; i < G.sizeOfGraph(); i++){
            for(int j = i+1; j < G.sizeOfGraph(); j++){
              if(!G.isEdge(i, j)){
                beta = Math.min(beta, val); // update beta with min so far  
                if(beta < alpha) break; // terminate loop  
                G.addEdge(i, j, -1);
                val = Math.min(val, minMax( G, depth+1, alpha, beta ) );
                G.removeEdge(i, j);
              }
            }
          }
          return val;  
        } 
      }

}
