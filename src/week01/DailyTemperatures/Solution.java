//https://leetcode.com/problems/daily-temperatures/description/
package week01.DailyTemperatures;

import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < temperatures.length ; i++) {
            while(!stack.isEmpty()){
                int j = stack.peek();
                if(temperatures[i] > temperatures[j]){
                    result[j] = i-j;
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int j = stack.pop();
            result[j] = 0;
        }

        return result;
    }
}
