package week02.graph.examples.graphList;

import java.util.*;

public class AdjacentList03 {
    public static void main(String[] args) {
        // 인접 행렬을 인접 리스트로 변환
        int[][] graph = {
                {0, 1, 0, 1, 0, 0, 1, 0},
                {1, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 1},
                {1, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0}
        };

        List<List<Integer>> adjList = new ArrayList<>();
        int n = graph.length;

        for(int i = 0 ; i < n ; i++) {
            adjList.add(new ArrayList<>());

            for(int j = 0 ; j < n ; j++){
                if(graph[i][j] == 1)
                    adjList.get(i).add(j);
            }
        }
    }
}
