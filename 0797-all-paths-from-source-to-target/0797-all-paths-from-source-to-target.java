class Solution {

    public void f(int start, int[][] graph, List<List<Integer>> list, List<Integer> temp) {
        if (start == graph.length - 1) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int v : graph[start]) {
            temp.add(v);
            f(v, graph, list, temp);
            temp.remove(temp.size() - 1);
        }
        return;
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        boolean visited[] = new boolean[graph.length];
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        f(0, graph, list, temp);
        return list;
    }
}
