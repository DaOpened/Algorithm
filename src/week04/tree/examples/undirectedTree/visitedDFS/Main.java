package week04.tree.examples.undirectedTree.visitedDFS;
// 양방향 인접 리스트 (Undirected Tree) DFS 순회
// visited 이용하여 순회 (추천하는 방식)
import java.util.*;
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

    public static void dfs(int cur, Set<Integer> visited) {
        System.out.println(cur);
        visited.add(cur);

        for(int next: tree.get(cur)) {
            if(!visited.contains(next))
                dfs(next, visited);
        }
    }

    public static void main(String[] args) {
        System.out.println("무방향 트리 DFS (visited 이용)");
        Set<Integer> visited = new HashSet<>();
        dfs(1, visited);
    }
}
