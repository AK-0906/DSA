import java.util.*;

public class Graph {
    public static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int src, int dest, int wt) {
            source = src;
            destination = dest;
            weight = wt;
        }
    }

    public static class GraphStructure { 
        int length_of_graph;
        ArrayList<Edge>[] graph;

        public GraphStructure(int n) {
            length_of_graph = n;
            graph = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }
        }

        public void Make_Graph(int[][] arr) {
            int n = arr.length;
            if (n == 0) {
                return;
            } else {
                for (int i = 0; i < n; i++) {
                    Edge ed = new Edge(arr[i][0], arr[i][1], arr[i][2]);
                    graph[arr[i][0]].add(ed);
                }
            }
        }

        public void bfs_search() {
            boolean[] visited = new boolean[length_of_graph];
            Queue<Integer> q = new LinkedList<>();
            q.add(0);
            while (!q.isEmpty()) {
                int val = q.remove();
                if (!visited[val]) {
                    System.out.print(val + " ");
                    visited[val] = true;
                    for (int i = 0; i < graph[val].size(); i++) {
                        Edge e = graph[val].get(i);
                        q.add(e.destination);
                    }
                }
            }
        }
    }

    public static void main(String args[]) {
        int[][] arr = {
            {0, 1, 10},
            {1, 2, 20},
            {2, 3, 30}
        };



        int n = 4;
        GraphStructure g = new GraphStructure(n);
        g.Make_Graph(arr);
        g.bfs_search();
    }
}
