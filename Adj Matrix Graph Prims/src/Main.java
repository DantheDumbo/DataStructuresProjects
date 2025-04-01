public class Main {
    public static void main(String[] args) {
        char[] nodes = {'A', 'B', 'C', 'D', 'E'};
        Graph graph = new Graph(nodes);

        graph.addEdge('A', 'B', 2);
        graph.addEdge('A', 'D', 6);
        graph.addEdge('B', 'C', 3);
        graph.addEdge('B', 'D', 8);
        graph.addEdge('B', 'E', 5);
        graph.addEdge('C', 'E', 7);
        graph.addEdge('D', 'E', 9);

        PrimThing.setNodes(nodes);
        PrimThing.primMST(graph.toAdjacencyMatrix());
    }
}