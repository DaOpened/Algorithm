package week04.tree.examples.dfs03;
// 이진 트리 DFS 순회
public class BinaryTreeDFS {
    // 트리 구조:
    //       1
    //      / \
    //     2   3
    //    / \
    //   4   5

    public static void dfs(Node node) {
        if(node == null) return;

        //pre, in, postfix order 순서에 따라 작성
        System.out.println(node.value);
        dfs(node.left);
        dfs(node.right);
    }

    public static void main(String[] args) {
        // 예제 트리 생성
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // dfs 실행
        System.out.println("DFS 순회 결과");
        dfs(root);
    }
}
