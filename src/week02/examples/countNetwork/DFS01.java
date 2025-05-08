package week02.examples.countNetwork;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DFS01 {
    public void dfs(List<List<Integer>> graph, Set<Integer> visited, int curVertex) {
        // visited를 set으로 구현한 dfs 코드
        visited.add(curVertex);

        for(int nextVertex : graph.get(curVertex)) {
            if(!visited.contains(nextVertex)) {
                dfs(graph, visited, nextVertex);
            }
        }
    }

    public void solve(List<List<Integer>> graph){
        Set<Integer> visited = new HashSet<>();
        dfs(graph, visited, 0);
    }
}
