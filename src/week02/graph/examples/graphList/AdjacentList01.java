package week02.graph.examples.graphList;

import java.util.*;

public class AdjacentList01 {
    public static void main(String[] args) {
        // List 이용
        List<List<Integer>> graph = new ArrayList<>();

        int n = 8;
        int[][] edges = {{0, 1}, {1, 2}};

        // 인접 리스트 초기화
        // n : vertex 개수
        for(int i = 0 ; i < n ; i ++) {
            graph.add(new ArrayList<>());
        }

        // edge 추가
        // edges : 간선 정보가 저장된 배열
        for(int[] edge : edges ) {
            int x = edge[0];
            int y = edge[1];

            // 양방향 그래프
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
    }
}
