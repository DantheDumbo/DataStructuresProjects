public class Main {
    public static void main(String[] args) {
        /*
     0
   /   \
  1 ——— 2
 / \   / \
3 - 5-6 - 4
  \______/

         */
        Graph graph = new Graph();
        graph.addEdge(4, 1);
        graph.addEdge(4, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 0);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        graph.addEdge(3, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 4);

        System.out.println("DFS Traversal:");
        graph.dfs(4);

        System.out.println("\nBFS Traversal:");
        graph.bfs(4);
    }
}