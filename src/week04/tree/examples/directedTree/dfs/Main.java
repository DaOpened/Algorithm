package week04.tree.examples.directedTree.dfs;
// 일방향 인접 리스트 순회(Directed Tree)
// 부모 -> 자식의 방향의 간선만 존재
import java.util.*;

public class Main {
    // 예) directed tree (일방향)
    // 트리 구조:
    //       1
    //      / \
    //     2   3
    //    / \
    //   4   5
    static Map<Integer, List<Integer>> tree = new HashMap<>() {{
        put(1, List.of(2, 3));
        put(2, List.of(4, 5));
        put(3, List.of());
        put(4, List.of());
        put(5, List.of());
    }};

    public static void dfs(int cur) {
        // 현재 노드 처리
        System.out.println(cur);

        for(int next : tree.get(cur)) {
            dfs(next);
        }
    }

    public static void main(String[] args) {
        System.out.println("일방향 트리 DFS 순회");
        dfs(1);
    }

}
