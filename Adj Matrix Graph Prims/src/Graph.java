import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Graph {
    private final int numVertices;
    private final Map<Character, Integer> vertexIndex;
    private final List<Edge> edges;

    public Graph(char[] vertices) {
        this.numVertices = vertices.length;
        this.vertexIndex = new HashMap<>();
        this.edges = new ArrayList<>();
        for (int i = 0; i < vertices.length; i++) {
            vertexIndex.put(vertices[i], i);
        }
    }

    public void addEdge(char u, char v, int weight) {
        edges.add(new Edge(u, v, weight));
    }

    public int[][] toAdjacencyMatrix() {
        int[][] matrix = new int[numVertices][numVertices];
        for (Edge edge : edges) {
            int i = vertexIndex.get(edge.u);
            int j = vertexIndex.get(edge.v);
            matrix[i][j] = edge.weight;
            matrix[j][i] = edge.weight; // Undirected graph
        }
        return matrix;
    }

    static class Edge {
        char u, v;
        int weight;

        Edge(char u, char v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }
}