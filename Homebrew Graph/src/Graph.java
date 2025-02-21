import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private static class Node {
        String label;

        Node(String label) {
            this.label = label;
        }
    }
        private Map<Node, List<Node>> adjNode;

        public Graph() {
            adjNode = new HashMap<>();
        }

        public void addNode(Node Node) {
            adjNode.putIfAbsent(Node, new ArrayList<>());
        }

        public void addEdge(Node Node1, Node Node2) {
            adjNode.get(Node1).add(Node2);
            adjNode.get(Node2).add(Node1); // For undirected graph
        }

        public void removeEdge(Node Node1, Node Node2) {
            adjNode.get(Node1).remove(Node2);
            adjNode.get(Node2).remove(Node1); // For undirected graph
        }

        public void removeNode(Node Node) {
            adjNode.remove(Node);
            for (List<Node> edges : adjNode.values()) {
                edges.remove(Node);
            }
        }

        public List<Node> getVertices() {
            return new ArrayList<>(adjNode.keySet());
        }
} 