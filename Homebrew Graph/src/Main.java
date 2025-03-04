public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addEdge('A', 'B');
        graph.addEdge('A', 'D');
        graph.addEdge('A', 'G');
        graph.addEdge('B', 'E');
        graph.addEdge('B', 'F');
        graph.addEdge('E', 'G');
        graph.addEdge('D', 'F');
        graph.addEdge('F', 'C');
        graph.addEdge('C', 'H');

        System.out.println("DFS Traversal:");
        graph.dfs('A');

        System.out.println("\nBFS Traversal:");
        graph.bfs('A');
    }
}