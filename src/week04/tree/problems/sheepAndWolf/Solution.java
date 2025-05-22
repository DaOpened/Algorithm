// 프로그래머스 : 양과 늑대
package week04.tree.problems.sheepAndWolf;

import java.util.*;

class Solution {
    public int solution(int[] info, int[][] edges) {
        int answer = 1;

        boolean[] visited = new boolean[info.length];
        visited[0] = true;
        answer = dfs(edges, info, 1, 0, visited);
        return answer;
    }

    public static int dfs(int[][] edges, int[] info, int sheep, int wolf, boolean[] visited) {
        // sheep >= wolf 면 더이상 순회 불가
        if(wolf >= sheep)
            return sheep;

        int maxSheep = sheep;

        for(int[] edge: edges) {
            int parent = edge[0];
            int child = edge[1];

            if(visited[parent] && !visited[child]) {
                visited[child] = true;

                if(info[child] == 0)
                    maxSheep = Math.max(maxSheep, dfs( edges, info, sheep+1, wolf, visited));
                else
                    maxSheep = Math.max(maxSheep, dfs(edges, info, sheep, wolf+1,visited));

                // 원래대로 되돌려 두기
                visited[child] = false;
            }
        }

        return maxSheep;
    }

}