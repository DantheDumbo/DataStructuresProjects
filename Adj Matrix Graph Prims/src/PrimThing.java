class PrimThing {
    private static final int INF = Integer.MAX_VALUE;
    private static char[] NODES;

    public static void setNodes(char[] nodes) {
        NODES = nodes;
    }

    public static void primMST(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        int[] key = new int[n];

        for (int i = 0; i < n; i++) {
            key[i] = INF;
        }
        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < n - 1; count++) {
            int u = minKey(key, visited, n);
            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && !visited[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        printMST(parent, graph, n);
    }

    private static int minKey(int[] key, boolean[] visited, int n) {
        int min = INF, minIndex = -1;

        for (int v = 0; v < n; v++) {
            if (!visited[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    private static void printMST(int[] parent, int[][] graph, int n) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < n; i++) {
            System.out.println(NODES[parent[i]] + " - " + NODES[i] + "\t" + graph[i][parent[i]]);
        }
    }
}