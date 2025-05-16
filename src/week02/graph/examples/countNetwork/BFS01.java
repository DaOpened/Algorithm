package week02.graph.examples.countNetwork;

import java.util.*;

public class BFS01 {
    // visited를 set으로 구현
    public void bfs(List<List<Integer>> graph, int startVertex){
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(startVertex);
        visited.add(startVertex);

        while(!queue.isEmpty()){
            // 현재 노드 방문
            int curVertex = queue.remove();
            // 다음 노드 방문
            for(int nextVertex : graph.get(curVertex)){
                if(!visited.contains(nextVertex)){
                    queue.add(nextVertex);
                    visited.add(nextVertex);
                }
            }
        }
    }

    public void solution(List<List<Integer>> graph) {
        bfs(graph, 0);
    }
}
