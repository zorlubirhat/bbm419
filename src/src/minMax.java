public class minMax {
	
	private static int D = 5;
	static eval e = new eval();
        static int MAX = 10000; 
	static int MIN = -10000; 

	int minmax(Graph G,int depth,Boolean maximizingPlayer, int alpha,int beta) { 
		if(depth == D || G.isFull())  
			return e.evaluate(G); 
		if (maximizingPlayer){ 
			int best = MIN; 
			for(int i = 0; i < G.sizeOfGraph(); i++){
				for(int j = i+1; j < G.sizeOfGraph(); j++){
					if(!G.isEdge(i, j)){
						alpha = Math.max(alpha, best); 
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
			for(int i = 0; i < G.sizeOfGraph(); i++){
				for(int j = i+1; j < G.sizeOfGraph(); j++){
					if(!G.isEdge(i, j)){				
						beta = Math.min(beta, best); 
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
