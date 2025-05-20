package week04.tree.problems.treePartition;

import java.util.*;
class Solution {
    static int answer;
    static Map<Integer, List<Integer>> graph = new HashMap<>();

    public int solution(int n, int[][] wires) {
        answer = n;

        // graph 생성
        for(int i = 1 ; i <= n ; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int[] wire : wires) {
            int x = wire[0];
            int y = wire[1];

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        // DFS
        boolean[] visited = new boolean[n+1];
        dfs(visited, 1, n);

        return answer;
    }

    public static int dfs(boolean[] visited, int x, int n) {
        visited[x] = true;
        int count = 1;

        for(int nextNode : graph.get(x)) {
            if(!visited[nextNode]) {
                count += dfs(visited, nextNode, n);
            }
        }

        // answer update
        answer = Math.min(answer, Math.abs(n - 2 * count));

        return count;
    }
}
