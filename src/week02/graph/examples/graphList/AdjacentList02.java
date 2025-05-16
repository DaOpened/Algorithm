package week02.graph.examples.graphList;

import java.util.*;

public class AdjacentList02 {
    public static void main(String[] args) {
        // 실전 그래프 활용 - 인접 리스트(dict)
        int n = 8;
        int[][] edges = {{0, 1}, {1, 2}};

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i = 0 ; i < n ; i ++) {
            graph.put(i, new ArrayList<>());
        }

        for( int[] edge : edges ) {
            int x = edge[0];
            int y = edge[1];

            graph.get(x).add(y);
            graph.get(y).add(x);
        }
    }
}
