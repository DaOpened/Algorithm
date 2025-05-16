package week04.tree.examples.treeBuild.hashMap;
// 간선 리스트 -> 해시맵으로 변환하여 트리 구성
// 자식이 없는 노드가 Map에 포함되지 않을 수도 있음 주의
// => containsKey 또는 getOrDefault() 이용하여 탐색해야 함
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
        // 해시맵으로 트리 구성
        Map<Integer, List<Integer>> tree = new HashMap<>();

        for(int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];

            tree.putIfAbsent(parent, new ArrayList<>());
            tree.get(parent).add(child);
        }
    }
}
