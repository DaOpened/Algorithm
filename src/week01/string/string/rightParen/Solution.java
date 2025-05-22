package week01.string.string.rightParen;

import java.util.*;

public class Solution {
    boolean solution(String s) {
        Deque<String> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()) {
            if(c == '(') {
                stack.push("(");
            }
            else if(c == ')') {
                if(stack.isEmpty()) {
                    return false;
                }
                else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
}