class Solution {

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> graph = createGraph(edges);
        Map<Integer, Boolean> visited = new HashMap<>();

        return dfs(graph, 0, hasApple, 0, visited);
    }

    private int dfs(Map<Integer, List<Integer>> graph, int node, List<Boolean> hasApple, int myCost, Map<Integer, Boolean> visited) {
        Boolean v = visited.getOrDefault(node, false);
        if (v) {
            return 0;
        }
        visited.put(node, true);

        int childrenCost = 0;

        for (int n : graph.getOrDefault(node, new ArrayList<>())) {
            childrenCost += dfs(graph, n, hasApple, 2, visited);
        }

        if (childrenCost == 0 && hasApple.get(node) == false) {
            return 0;
        }

        return childrenCost + myCost;
    }

    private Map<Integer, List<Integer>> createGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            List<Integer> list = graph.getOrDefault(edges[i][0], new ArrayList<>());
            list.add(edges[i][1]);
            graph.put(edges[i][0], list);

            list = graph.getOrDefault(edges[i][1], new ArrayList<>());
            list.add(edges[i][0]);
            graph.put(edges[i][1], list);
        }

        return graph;
    }
}
