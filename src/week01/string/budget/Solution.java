package week01.string.budget;

import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);

        for(int price: d) {
            if(budget-price < 0)
                break;
            budget -= price;
            answer++;
        }

        return answer;
    }
}