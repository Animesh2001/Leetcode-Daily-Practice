class Solution {

    public boolean isBipartite(int sv, int visited[], int graph[][]) {
        if (visited[sv] == -1) visited[sv] = 0;
        for (int ngb : graph[sv]) {
            if (visited[ngb] == -1) {
                visited[ngb] = visited[sv] == 1 ? 0 : 1;
                if (!isBipartite(ngb, visited, graph)) return false;
            } else {
                if (visited[sv] == visited[ngb]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean helper(int[][] graph) {
        int visited[] = new int[graph.length];
        Arrays.fill(visited, -1);
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == -1) {
                if (!isBipartite(i, visited, graph)) return false;
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        return helper(graph);
    }
}
