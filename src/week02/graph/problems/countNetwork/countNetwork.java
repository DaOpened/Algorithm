package week02.graph.problems.countNetwork;

import java.util.*;

import static week02.graph.problems.countNetwork.countNetwork.Solution.solution;

public class countNetwork {
    class Solution {
        public static int solution(int n, int[][] computers) {
            int answer = 0;
            final int N = computers.length;
            Map<Integer, List<Integer>> adjList = new HashMap<>();
            Set<Integer> visited = new HashSet<>();

            // 인접 행렬을 인접 리스트로 변환
            for(int i = 0 ; i < N ; i++) {
                adjList.put(i, new ArrayList<>());
                for(int j = 0 ; j < N ; j++) {
                    if(computers[i][j] == 1) {
                        adjList.get(i).add(j);
                    }
                }
            }

            System.out.println(adjList);

            // 네트워크 찾기
            for( int curVertex : adjList.keySet()) {
                if(!visited.contains(curVertex)) {
                    bfs(adjList, visited, curVertex);
                    answer++;
                }
            }

            return answer;
        }

        public static void bfs(Map<Integer, List<Integer>> graph, Set<Integer> visited, int curVertex) {
            visited.add(curVertex);
            for (int nextVertex : graph.get(curVertex)) {
                if (!visited.contains(nextVertex)) {
                    bfs(graph, visited, nextVertex);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int n = 3;

        System.out.println(solution(n, computers));
    }
}
