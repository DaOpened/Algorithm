package week04.tree.examples.dfs02;

import java.util.ArrayList;
import java.util.List;

public class Node {
    int value;
    List<Node> children= new ArrayList<Node>();;

    public Node(int value) {
        this.value = value;
    }
}
