class Solution {

    public boolean isPathExist(int n, ArrayList<ArrayList<Integer>> adj_list, boolean[] visited, int source, int destination) {
        if (source == destination) {
            return true;
        }

        visited[source] = true;

        for (int adj : adj_list.get(source)) {
            if (!visited[adj] && isPathExist(n, adj_list, visited, adj, destination)) return true;
        }

        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj_list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj_list.add(new ArrayList<>());
        }

        for (int[] row : edges) {
            int sv = row[0];
            int ev = row[1];

            adj_list.get(sv).add(ev);
            adj_list.get(ev).add(sv);
        }

        boolean[] visited = new boolean[n];

        return isPathExist(n, adj_list, visited, source, destination);
    }
}
