import java.util.*;

public class Graph {
    public void dfs() {
        Stack<Node> stack = new Stack<>();
        ArrayList<Node> visitedNodesList = new ArrayList<>();

        //Node current = adjNode.

        while (!stack.isEmpty()) {
            System.out.println();
        }
    }



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

    public void addNode(String str) {
        adjNode.putIfAbsent(new Node(str), new ArrayList<>());
    }

    public void addEdge(String str1, String str2) {
        adjNode.get(new Node(str1)).add(new Node(str2));
        adjNode.get(new Node(str2)).add(new Node(str1));
    }

    public void removeEdge(String str1, String str2) {
        adjNode.get(new Node(str1)).remove(new Node(str2));
        adjNode.get(new Node(str2)).remove(new Node(str1));
    }

    public void removeNode(String str) {
        adjNode.remove(new Node(str));
        for (List<Node> edges : adjNode.values()) {
            edges.remove(new Node(str));
        }
    }

    public List<Node> getVertices() {
        return new ArrayList<>(adjNode.keySet());
    }
} 