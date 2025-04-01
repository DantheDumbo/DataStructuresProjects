import java.util.*;

class Dijkstra {
    static class Edge {
        int destination, weight;

        Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node> {
        int vertex, distance;

        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public static void dijkstra(Map<Integer, List<Edge>> graph, int source) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Map<Integer, Integer> distances = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for (int vertex : graph.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(source, 0);
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (visited.contains(current.vertex)) continue;
            visited.add(current.vertex);

            for (Edge edge : graph.getOrDefault(current.vertex, new ArrayList<>())) {
                if (!visited.contains(edge.destination)) {
                    int newDist = distances.get(current.vertex) + edge.weight;
                    if (newDist < distances.get(edge.destination)) {
                        distances.put(edge.destination, newDist);
                        pq.add(new Node(edge.destination, newDist));
                    }
                }
            }
        }

        System.out.println("Shortest distances from source " + source + ":");
        for (var entry : distances.entrySet()) {
            System.out.println("To vertex " + entry.getKey() + " -> Distance: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(new Edge(1, 4), new Edge(2, 1)));
        graph.put(1, Arrays.asList(new Edge(3, 1)));
        graph.put(2, Arrays.asList(new Edge(1, 2), new Edge(3, 5)));
        graph.put(3, Arrays.asList());

        dijkstra(graph, 0);
    }
}
