package week1.dsa;
import java.util.*;

public class exercise6 {


    class Graph {
        private int V;
        private LinkedList<Edge>[] adj;

        class Edge {
            int target, weight;

            Edge(int target, int weight) {
                this.target = target;
                this.weight = weight;
            }
        }

        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList<>();
        }

        void addEdge(int u, int v, int weight) {
            Edge edge1 = new Edge(v, weight);
            Edge edge2 = new Edge(u, weight);
            adj[u].add(edge1);
            adj[v].add(edge2);
        }

        void primMST() {
            boolean[] mstSet = new boolean[V];
            int[] key = new int[V];
            int[] parent = new int[V];

            for (int i = 0; i < V; i++) {
                key[i] = Integer.MAX_VALUE;
                mstSet[i] = false;
            }

            key[0] = 0;
            parent[0] = -1;

            for (int count = 0; count < V - 1; count++) {
                int u = minKey(key, mstSet);

                mstSet[u] = true;

                for (Edge edge : adj[u]) {
                    int v = edge.target;
                    int weight = edge.weight;
                    if (!mstSet[v] && weight < key[v]) {
                        parent[v] = u;
                        key[v] = weight;
                    }
                }
            }

            printMST(parent, key);
        }

        int minKey(int[] key, boolean[] mstSet) {
            int min = Integer.MAX_VALUE, minIndex = -1;

            for (int v = 0; v < V; v++) {
                if (!mstSet[v] && key[v] < min) {
                    min = key[v];
                    minIndex = v;
                }
            }

            return minIndex;
        }

        void printMST(int[] parent, int[] key) {
            System.out.println("Edge \tWeight");
            for (int i = 1; i < V; i++) {
                System.out.println(parent[i] + " - " + i + "\t" + key[i]);
            }
        }

        public void main(String[] args) {
            Graph g = new Graph(5);

            g.addEdge(0, 1, 2);
            g.addEdge(0, 3, 6);
            g.addEdge(1, 2, 3);
            g.addEdge(1, 3, 8);
            g.addEdge(1, 4, 5);
            g.addEdge(2, 4, 7);
            g.addEdge(3, 4, 9);

            g.primMST();
        }
    }


}
