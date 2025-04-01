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

    public static void dijkstra(Map<Character, List<Edge>> graph, char source) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Map<Character, Integer> distances = new HashMap<>();
        Set<Character> visited = new HashSet<>();

        for (char vertex : graph.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(source, 0);
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (visited.contains((char) current.vertex)) continue;
            visited.add((char) current.vertex);

            for (Edge edge : graph.getOrDefault((char) current.vertex, new ArrayList<>())) {
                if (!visited.contains((char) edge.destination)) {
                    int newDist = distances.get((char) current.vertex) + edge.weight;
                    if (newDist < distances.get((char) edge.destination)) {
                        distances.put((char) edge.destination, newDist);
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
        Map<Character, List<Edge>> graph = new HashMap<>();

        graph.put('A', Arrays.asList(new Edge('B', 4), new Edge('C', 2), new Edge('G', 7)));
        graph.put('B', Arrays.asList(new Edge('D', 2)));
        graph.put('C', Arrays.asList(new Edge('F', 8), new Edge('G', 3)));
        graph.put('D', Arrays.asList(new Edge('G', 5), new Edge('H', 6)));
        graph.put('F', Arrays.asList(new Edge('J', 3)));
        graph.put('G', Arrays.asList(new Edge('J', 4)));
        graph.put('H', Arrays.asList(new Edge('J', 2)));
        graph.put('J', new ArrayList<>());

        dijkstra(graph, 'A');
    }
}
