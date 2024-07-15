package week1.dsa;
import java.util.*;
public class exercise5 {


    class Graph {
        private int V;
        private LinkedList<Edge> adj[];

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
            Edge edge = new Edge(v, weight);
            adj[u].add(edge);
        }

        void dijkstra(int src) {
            int dist[] = new int[V];
            Boolean sptSet[] = new Boolean[V];

            for (int i = 0; i < V; i++) {
                dist[i] = Integer.MAX_VALUE;
                sptSet[i] = false;
            }

            dist[src] = 0;

            for (int count = 0; count < V - 1; count++) {
                int u = minDistance(dist, sptSet);

                sptSet[u] = true;

                for (Edge edge : adj[u]) {
                    if (!sptSet[edge.target] && dist[u] != Integer.MAX_VALUE &&
                            dist[u] + edge.weight < dist[edge.target]) {
                        dist[edge.target] = dist[u] + edge.weight;
                    }
                }
            }

            printSolution(dist);
        }

        int minDistance(int dist[], Boolean sptSet[]) {
            int min = Integer.MAX_VALUE, min_index = -1;

            for (int v = 0; v < V; v++)
                if (!sptSet[v] && dist[v] <= min) {
                    min = dist[v];
                    min_index = v;
                }

            return min_index;
        }

        void printSolution(int dist[]) {
            System.out.println("Vertex \t Distance from Source");
            for (int i = 0; i < V; i++)
                System.out.println(i + " \t\t " + dist[i]);
        }

        public void main(String[] args) {
            Graph g = new Graph(9);

            g.addEdge(0, 1, 4);
            g.addEdge(0, 7, 8);
            g.addEdge(1, 2, 8);
            g.addEdge(1, 7, 11);
            g.addEdge(2, 3, 7);
            g.addEdge(2, 8, 2);
            g.addEdge(2, 5, 4);
            g.addEdge(3, 4, 9);
            g.addEdge(3, 5, 14);
            g.addEdge(4, 5, 10);
            g.addEdge(5, 6, 2);
            g.addEdge(6, 7, 1);
            g.addEdge(6, 8, 6);
            g.addEdge(7, 8, 7);

            g.dijkstra(0);
        }
    }

}
