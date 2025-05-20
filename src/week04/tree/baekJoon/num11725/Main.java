// 백준 11725번: 트리의 부모 찾기
package week04.tree.baekJoon.num11725;

import java.awt.desktop.SystemEventListener;
import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Map<Integer, List<Integer>> tree = new HashMap<>();

        for(int i = 1; i <= n; i++) {
            tree.put(i, new ArrayList<>());
        }

        for(int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            tree.get(x).add(y);
            tree.get(y).add(x);
        }

        parent = new int[n+1];

        findParent(tree, n);
        for(int i = 2; i <= n; i++) {
            bw.write(parent[i]+"\n");
        }

        bw.flush();
    }
    public static void findParent(Map<Integer, List<Integer>> tree, int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        // child, parent 순으로 저장
        q.offer(1);

        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int node : tree.get(cur)) {
                if(!visited[node]) {
                    q.offer(node);
                    parent[node] = cur;
                    visited[node] = true;
                }
            }
        }
    }
}
