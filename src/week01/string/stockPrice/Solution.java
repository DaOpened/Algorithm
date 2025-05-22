package week01.string.stockPrice;

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < prices.length; i++) {
            while(!stack.isEmpty()) {
                int j = stack.peek();
                if (prices[i] < prices[j]) {
                    answer[j] = i - j;
                    stack.pop();
                }
                else { break; }
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            int j = stack.pop();
            answer[j] = prices.length - 1 - j;
        }
        return answer;
    }
}
