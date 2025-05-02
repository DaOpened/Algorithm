package week01.makePrimeNum;

import java.util.Arrays;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        Arrays.sort(nums);

        for(int i = 0 ; i < nums.length-2 ; i++){
            for(int j = i + 1 ; j < nums.length-1; j++){
                for(int k = j + 1 ; k < nums.length; k++){
                    if(isPrime(nums[i]+nums[j]+nums[k])){
                        answer++;
                    }
                }
            }
        }


        return answer;
    }

    boolean isPrime(int n){
        if ( n < 2 ) {
            return false;
        }

        for(int i = 2 ; i * i <= n ; i++) {
            if ( n % i == 0){
                return false;
            }
        }

        return true;
    }
}
