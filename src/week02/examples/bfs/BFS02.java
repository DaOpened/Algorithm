package week02.examples.bfs;

import java.util.*;

public class BFS02 {
    // visited를 List로 구현
    public void bfs(List<List<Integer>> graph, int startVertex) {
        Queue<Integer> queue = new LinkedList<>();
        final int N = graph.size();
        boolean[] visited = new boolean[N];

        queue.add(startVertex);
        visited[startVertex] = true;

        while(!queue.isEmpty()){
            int curVertex = queue.remove();
            for( int nextVertex : graph.get(curVertex)){
                if(!visited[nextVertex]){
                    queue.add(nextVertex);
                    visited[nextVertex] = true;
                }
            }
        }
    }

    public void solution(List<List<Integer>> graph) {
        bfs(graph, 0);
    }
}
