package week04.tree.examples.completeBinaryTree;
// 완전이진트리(Complete Binary Tree), heap 순회
// 왼쪽 자식은 2*i+1, 오른쪽 자식은 2*i+2 임을 이용

import java.util.*;
public class Main {
    // 트리 (배열 표현)
    //       1
    //      / \
    //     2   3
    //    / \
    //   4   5
    static int[] arr = {1, 2, 3, 4, 5, -1, -1};

    public static void dfs(int idx) {
        // 해당 노드가 비어있는 경우
        if(idx >= arr.length || arr[idx] == -1) {
            return;
        }

        System.out.println(arr[idx]);

        dfs(2 * idx + 1);
        dfs(2 * idx + 2);
    }

    public static void main(String[] args) {
        System.out.println("완전이진트리 DFS 순회");
        dfs(0);
    }
}
