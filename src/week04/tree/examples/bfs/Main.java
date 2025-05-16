package week04.tree.examples.bfs;
// 레벨 순서 순회 (Level Order) - BFS
// 시간 복잡도 O(N)
import java.util.*;

public class Main {
    public static List<Integer> bfs(Node root) {
        if(root == null) return Collections.emptyList();

        List<Integer> result = new ArrayList<>();
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        while(!q.isEmpty()) {
            Node curNode = q.poll();

            // 방문 (출력/저장/연산 수행)
            result.add(curNode.value);

            // 왼쪽 자식이 존재하면 큐에 넣기
            if(curNode.left != null) q.add(curNode.left);

            // 오른쪽 자식이 존재하면 큐에 넣기
            if(curNode.right != null) q.add(curNode.right);
        }

        return result;
    }
}
