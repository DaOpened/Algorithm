package week02.problems.furthestNode;

import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        // 그래프 초기화
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0 ; i < n ; i++) {
            graph.add(new ArrayList<>());
        }

        // 인접 리스트로 저장
        for(int[] e : edge) {
            int x = e[0]-1;
            int y = e[1]-1;

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        // bfs로 그래프 탐색
        answer = bfs(graph, 0);

        return answer;
    }

    public int bfs(List<List<Integer>> graph, int startNode) {
        Queue<Integer> queue = new LinkedList<>();

        // visited의 key: Node 번호, value: 그래프의 depth
        Map<Integer, Integer> visited = new HashMap<>();

        queue.add(startNode);
        visited.put(startNode, 1);

        while(!queue.isEmpty()) {
            int curNode = queue.remove();

            for(int nextNode : graph.get(curNode)) {
                if(!visited.containsKey(nextNode)) {
                    queue.add(nextNode);
                    visited.put(nextNode, visited.get(curNode)+1);
                }
            }
        }

        // depth 가 최대인 것의 개수 구하기
        int maxValue = 0;
        int count = 0;
        for(int key : visited.keySet()){
            if(maxValue < visited.get(key)) {
                maxValue = visited.get(key);
                count = 1;
            } else if(maxValue == visited.get(key)) {
                count++;
            }
        }
        return count;
    }
}