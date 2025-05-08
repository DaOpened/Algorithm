package week02.examples.countNetwork;

import java.util.*;

public class CountNetwork {
    public int countNetwork(Map<Integer, List<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        int count = 0;

        // bfs 이용
        for (int curVertex : graph.keySet()){
            // dfs(graph, visited, curVertex);
            count++;
        }
        return count;
    }

    public void solution() {
        // 인접 리스트로 그래프 표현
        Map<Integer, List<Integer>> graph = new HashMap<>() {{
            put(0, List.of(1, 3));
            put(1, List.of(0, 3, 5));
            put(2, List.of(4));
            put(3, List.of(0, 1));
            put(4, List.of(2));
            put(5, List.of(1));
        }};

        System.out.println(countNetwork(graph));
    }
}
