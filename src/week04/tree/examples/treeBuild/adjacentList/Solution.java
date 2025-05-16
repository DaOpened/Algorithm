package week04.tree.examples.treeBuild.adjacentList;
// 간선 리스트 -> 인접 리스트(2차원 리스트)로 변환하여 트리 구성

import java.util.*;
public class Solution {
    /*
     * 예시 입력 (간선 리스트 형태)
     * int[][] edges = {
     *     {0, 1},
     *     {0, 2},
     *     {2, 3},
     *     {2, 4}
     * };
     */
    public void solution(int[][] edges, int n) {
        // n : 노드 개수
        // 2차원 리스트로 트리 구성
        List<List<Integer>> tree = new ArrayList<>();

        for(int i = 0 ;i < n ; i++) {
            tree.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];

            tree.get(parent).add(child);
        }
    }
}
