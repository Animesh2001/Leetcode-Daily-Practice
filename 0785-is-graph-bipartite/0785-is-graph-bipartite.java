class Solution {

    public boolean isBipartite(int sv, int visited[], int graph[][]) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sv);
        visited[sv] = 0;
        while (!queue.isEmpty()) {
            int pop = queue.poll();
            for (int i : graph[pop]) {
                if (visited[i] == -1) {
                    visited[i] = visited[pop] == 1 ? 0 : 1;
                    queue.add(i);
                } else {
                    if (visited[i] == visited[pop]) return false;
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
