package week02.problems.coinChange;

import java.util.*;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int count = -1;

        if(amount == 0) {
            return 0;
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[amount+1];

        visited[amount] = true;
        queue.add(new int[]{amount, 0});

        while(!queue.isEmpty()) {
            int[] cur = queue.remove();
            int curRemaining = cur[0];
            int coinCount = cur[1];

            if(curRemaining == 0) {
                return coinCount;
            }

            for(int coin : coins) {
                int next = curRemaining-coin;
                if(next >=0 && !visited[next]){
                    queue.add(new int[]{next, coinCount+1});
                    visited[next] = true;
                }
            }
        }


        return count;
    }
}
