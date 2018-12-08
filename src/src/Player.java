public class Player{
      
      static minMax minMax = new minMax();

      //chooseMove - This method will utilize eval and minMax to decide what move
      // would be the best decision by the computer. It assesses different values for
      // every positibility of that the game could go to, and keep track of the best decision.
      public static Move chooseMove(Graph G) { 
        int max = -10000;

        Move best = new Move(0, 1);
        for(int k = 0; k < 6; k++){
            for(int l = 0; l < 6; l++){
                if(G.isEdge(k, l) == false && k != l){
                    best = new Move(k, l);
            }
          }
        }

        for(int i = 0; i < G.sizeOfGraph(); i++){
          for(int j = i+1; j < G.sizeOfGraph(); j++){
            if(i != j && G.isEdge(i, j) == false){
            	/*System.out.println(i);
            	System.out.println(j);*/
            	System.out.print(i+" and ");
            	System.out.print(j + " are I and J");
            	G.addEdge(i, j, 1);
            	Move m = new Move(i, j);
            	int val = minMax.minmax( G, 1,true, 0, 0);
            	System.out.println(val + " | " + i +  " " + j);
            	if(val >= max) {
            		System.out.println("New best");
            		best = m;
            		max = val; 
            	}
            	G.removeEdge(i, j);
            }
          }
        }
        System.out.println("Best move: " +best);
        return best; 
      }

    }
    
    
