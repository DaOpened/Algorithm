package week04.tree.examples.undirectedTree.parentDFS;
// 양방향 인접 리스트 (Undirected Tree) DFS 순회
// parent 이용 (메모리 사용이 적은 방식)

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    // 트리 구조:
    //       1
    //      / \
    //     2   3
    //    / \
    //   4   5
    // undirected tree (무방향) 트리 정의
    static Map<Integer, List<Integer>> tree = new HashMap<>() {{
        put(1, List.of(2, 3));
        put(2, List.of(1, 4, 5));
        put(3, List.of(1));
        put(4, List.of(2));
        put(5, List.of(2));
    }};

    public static void dfs(int cur, int parent) {
        // 현재 노드 처리 (출력 등)
        System.out.println(cur);

        for(int next: tree.get(cur)) {
            // 이미 방문했던 부모 노드로는 돌아가지 않도록 함
            if(next == parent) continue;
            dfs(next, cur);
        }
    }

    public static void main(String[] args) {
        System.out.println("무방향 트리 DFS (parent 이용)");
        dfs(1, -1);
    }

}
