import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Krushkal {
    static class Edge {
        int s;
        int d;
        int w;

        public Edge(int s, int d, int w) {
            this.s = s;
            this.d = d;
            this.w = w;
        }
    }

    static class Graph {
        int vertices;
        ArrayList<Edge> allEdgesMaker = new ArrayList<>();
        ArrayList<Edge> allEdgesBreaker = new ArrayList<>();

        Graph(int vertices) {
            this.vertices = vertices;
        }

        public void addEgde(int s, int d, int w) {
            Edge edge = new Edge(s, d, w);
            if(w==1) {
            	allEdgesMaker.add(edge); //add to total edges
            }
            if(w==(-1)) {
            	allEdgesBreaker.add(edge); //add to total edges
            }
        }
        
        public void kruskal(){
            PriorityQueue<Edge> pq = new PriorityQueue<>(allEdgesMaker.size(), Comparator.comparingInt(o -> o.w));

            //add all the edges to priority queue, //sort the edges on weights
            for (int i = 0; i <allEdgesMaker.size() ; i++) {
                pq.add(allEdgesMaker.get(i));
            }

            //create a parent []
            int [] parent = new int[vertices];

            //makeset
            makeSet(parent);

            ArrayList<Edge> st = new ArrayList<>();

            //process vertices - 1 edges
            int index = 0;
            while(index<vertices-1){
                Edge edge = pq.remove();
                //check if adding this edge creates a cycle
                int x_set = find(parent, edge.s);
                int y_set = find(parent, edge.d);

                if(x_set==y_set){
                    //ignore, will create cycle
                }else {
                    //add it to our final result
                    st.add(edge);
                    index++;
                    union(parent,x_set,y_set);
                }
            }
            //print MST
            System.out.println("Spanning Tree: ");
            if(printGraph(st)) {
            	System.out.println("Maker wins");
            }
        }

        public void makeSet(int [] parent){
            //Make set- creating a new element with a parent pointer to itself.
            for (int i = 0; i <vertices ; i++) {
                parent[i] = i;
            }
        }

        public int find(int [] parent, int vertex){
            //chain of parent pointers from x upwards through the tree
            // until an element is reached whose parent is itself
            if(parent[vertex]!=vertex)
                return find(parent, parent[vertex]);;
            return vertex;
        }

        public void union(int [] parent, int x, int y){
            int x_set_parent = find(parent, x);
            int y_set_parent = find(parent, y);
            //make x as parent of y
            parent[y_set_parent] = x_set_parent;
        }

        public boolean printGraph(ArrayList<Edge> edgeList){
            for (int i = 0; i <edgeList.size() ; i++) {
                Edge edge = edgeList.get(i);
                System.out.println("Edge-" + i + " s: " + edge.s +" d: " + edge.d + " w: " + edge.w);
            }
			return true;
        }
    }
    public static void main(String[] args) {
            int vertices = 8;
            Graph graph = new Graph(vertices);
            graph.addEgde(0, 1, -1);
            graph.addEgde(0, 3, 1);
            graph.addEgde(1, 0, 1);
            graph.addEgde(1, 3, -1);
            graph.addEgde(2, 3, 1);
            graph.addEgde(3, 4, 1);
            graph.addEgde(4, 6, 1);
            graph.addEgde(6, 7, 1);
            graph.addEgde(7, 5, 1);
            graph.kruskal();
    }
}
