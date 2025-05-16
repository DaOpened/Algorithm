package week02.graph.examples.dfs;

import java.util.*;

public class DFS02 {
    // visited를 array 로 구현
    public void dfs(List<List<Integer>> graph, boolean[] visited, int curVertex){
        visited[curVertex] = true;

        for(int nextVertex : graph.get(curVertex)){
            if(!visited[nextVertex]){
                dfs(graph, visited, nextVertex);
            }
        }
    }

    public void solution(List<List<Integer>> graph){
        final int N = graph.size();
        boolean[] visited = new boolean[N];
        dfs(graph, visited, 0);
    }

}
