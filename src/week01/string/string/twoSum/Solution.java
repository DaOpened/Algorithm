package week01.string.string.twoSum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashmap = new HashMap<>();

        // key가 nums[idx], value가 idx 인 해시맵 생성
        for (int i = 0; i < nums.length; i++) {
            hashmap.put(nums[i], i);
        }

        // 정답 찾기
        for (int i = 0; i < nums.length; i++) {
            if(hashmap.containsKey(target - nums[i]) && hashmap.get(target-nums[i]) != i){
                return new int[]{i, hashmap.get(target-nums[i])};
            }
        }
        return new int[0];
    }
}
