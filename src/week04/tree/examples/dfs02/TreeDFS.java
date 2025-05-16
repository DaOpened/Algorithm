package week04.tree.examples.dfs02;

public class TreeDFS {
    // 트리 구조:
    //       1
    //      / \
    //     2   3
    //    / \
    //   4   5
    public static void dfs(Node node) {
        if(node == null) return;
        // 현재 노드 처리 (ex. 값 출력 등)
        System.out.println(node.value);

        // 자식 노드 재귀 호출
        for(Node child : node.children) {
            dfs(child);
        }
    }

    public static void main(String[] args) {
        // 트리 생성
        Node root = new Node(1);
        Node child1 = new Node(2);
        Node child2 = new Node(3);
        Node child3 = new Node(4);
        Node child4 = new Node(5);

        root.children.add(child1);
        root.children.add(child2);
        child1.children.add(child3);
        child2.children.add(child4);

        //DFS 실행
        System.out.println("DFS 순회 결과");
        dfs(root);
    }
}
