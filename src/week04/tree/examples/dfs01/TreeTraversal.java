package week04.tree.examples.dfs01;

public class TreeTraversal {
    void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        preorder(root.left);
        preorder(root.right);
    }

    void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.value);
        inorder(root.right);
    }

    void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.value);
    }
}
