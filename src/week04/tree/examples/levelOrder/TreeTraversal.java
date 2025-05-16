package week04.tree.examples.levelOrder;

import java.util.*;

public class TreeTraversal {
    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curNode = q.poll();
            System.out.println(curNode.value);

            for (Node child : curNode.children) {
                q.add(child);
            }

        }
    }

    public static void main(String[] args) {
        // 트리 노드 생성
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        // 자식 노드 연결
        root.children.add(node2);
        root.children.add(node3);
        root.children.add(node4);
        root.children.add(node5);

        // 레벨 순서 탐색 실행
        levelOrder(root);
    }
}
