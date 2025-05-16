package week02.graph.problems.isGraphBipartite;

import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        Queue<Integer> queue = new LinkedList<>();
        final int n = graph.length;
        int[] visited = new int[n];

        for(int i = 0 ; i < n ; i++ ) {
            if(visited[i] == 0) {
                queue.add(i);
                visited[i] = 1;
                while(!queue.isEmpty()) {
                    int cur = queue.remove();
                    for(int next : graph[cur]) {
                        if(visited[next] == 0) {
                            visited[next] = -visited[cur];
                            queue.add(next);
                        } else if(visited[next] == visited[cur]){
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}