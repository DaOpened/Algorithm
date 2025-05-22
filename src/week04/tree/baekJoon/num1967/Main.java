// 백준 1967번: 트리의 지름
package week04.tree.baekJoon.num1967;

import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited;
    static int farthestNode = 0;
    static int maxCost = 0;
    static Map<Integer, List<Integer>> tree;
    static int[][] costList;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        costList = new int[n+1][n+1];
        tree = new HashMap<>();

        for(int i = 1 ; i <= n ; i++){
            tree.put(i, new ArrayList<>());
        }

        for(int i = 0; i < n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            costList[parent][child] = cost;
            costList[child][parent] = cost;

            tree.get(parent).add(child);
        }

        visited = new boolean[n+1];
        dfs(1, 0);

        maxCost = 0;
        visited = new boolean[n+1];
        dfs(farthestNode, 0);
        bw.write(maxCost + "\n");
    }

    public static void dfs(int node, int cost) {
        visited[node] = true;
        if(cost > maxCost) {
            maxCost = cost;
            farthestNode = node;
        }

        for(int next : tree.get(node)) {
            if(!visited[next]) {
                dfs(next, cost+costList[node][next]);
            }
        }
    }
}
