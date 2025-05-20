// 백준 1991번: 트리 순회
package week04.tree.baekJoon.num1991;

import java.util.*;
import java.io.*;

public class Main {
    public static class Node {
        String value;
        String left;
        String right;

        Node(String value, String left, String right) {
            this.value = value;
            this.left = left.equals(".")?null:left;
            this.right = right.equals(".")?null:right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Map<String, Node> tree = new HashMap<>();

        for (int i = 0 ; i < n ; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            String node = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();
            tree.put(node, new Node(node, left, right));
        }
        preorder(tree.get("A"), tree, bw);
        bw.newLine();
        inorder(tree.get("A"), tree, bw);
        bw.newLine();
        postorder(tree.get("A"), tree, bw);

        bw.flush();
    }

    public static void preorder(Node root, Map<String, Node> tree, BufferedWriter bw) throws IOException {
        bw.write(root.value);
        if(root.left != null)
            preorder(tree.get(root.left), tree, bw);
        if(root.right != null)
            preorder(tree.get(root.right), tree, bw);
    }

    public static void inorder(Node root, Map<String, Node> tree, BufferedWriter bw) throws IOException {
        if(root.left != null)
            inorder(tree.get(root.left), tree, bw);
        bw.write(root.value);
        if(root.right != null)
            inorder(tree.get(root.right), tree, bw);
    }

    public static void postorder(Node root, Map<String, Node> tree, BufferedWriter bw) throws IOException {
        if(root.left != null)
            postorder(tree.get(root.left), tree, bw);
        if(root.right != null)
            postorder(tree.get(root.right), tree, bw);
        bw.write(root.value);
    }
}
