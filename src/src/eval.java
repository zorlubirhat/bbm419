public class eval {
	
	int evaluate(Graph G) {
		int i=0;
		i += eval(G);
		return i;	
	}
	int eval(Graph G){
        int i = 0;
        for(int j = 0; j < G.sizeOfGraph(); j++){
          if(G.makerList.contains(j) && !G.breakerList.contains(j))
            i = -1;
          if(!G.makerList.contains(j) && G.breakerList.contains(j))
            i = 1;
        }
        G.DFS(0, 1);
        if(G.count==5) {
        	i=10000;
        }
        if(G.count<5) {
        	i=-10000;
        }     
        return i;
      }
}
