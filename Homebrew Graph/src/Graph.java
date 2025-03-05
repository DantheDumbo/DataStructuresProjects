import java.util.*;

class Graph {
    private final Map<Character, List<Character>> adjList;

    public Graph() {
        this.adjList = new HashMap<>();
    }

    public void addEdge(char src, char dest) {
        adjList.putIfAbsent(src, new ArrayList<>());
        adjList.putIfAbsent(dest, new ArrayList<>());
        adjList.get(src).add(dest);
        adjList.get(dest).add(src);
    }

    public void dfs(char start) {
        Set<Character> visited = new HashSet<>();
        Stack<Character> stack = new Stack<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            char node = stack.pop();
            if (!visited.contains(node)) {
                System.out.print(node + " ");
                visited.add(node);

                List<Character> neighbors = new ArrayList<>(adjList.getOrDefault(node, new ArrayList<>()));
                Collections.sort(neighbors, Collections.reverseOrder());

                for (char neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }

    public void bfs(char start) {
        Set<Character> visited = new HashSet<>();
        Queue<Character> queue = new LinkedList<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            char node = queue.poll();
            System.out.print(node + " ");

            List<Character> neighbors = adjList.getOrDefault(node, new ArrayList<>());

            for (char neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }
}