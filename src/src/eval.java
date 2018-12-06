
public class eval {
	//eval - This method will assign values to each possibility within the tree and
    // dictate which move would be the best for the computer to make.
	static int eval(Graph G){
        int i = 0;
        for(int j = 0; j < G.sizeOfGraph(); j++){
          if(G.makerList.contains(j) && !G.breakerList.contains(j))
            i += 1;
          if(!G.makerList.contains(j) && G.breakerList.contains(j))
            i += 6;
        }
        if(G.DFS(0)	== true) {
        	i = 1000000000;}
        else {
        	i=-1000000000;
        }
          
        
          
        return i;
      }

}
