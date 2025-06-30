package week07.backtracking.targetNumber;
// https://campus.programmers.co.kr/tryouts/183409/challenges
class Solution {
    int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        backtrack(numbers, target, -1);
        return answer;
    }

    public void backtrack(int[] numbers, int target, int cur) {
        if(sum(numbers) == target) {
            answer++;
        }

        for(int i = cur+1 ; i < numbers.length; i++) {
            numbers[i] = -numbers[i];
            backtrack(numbers, target, i);
            numbers[i] = -numbers[i];
        }
    }

    public int sum(int[] numbers) {
        int result = 0;
        for(int x : numbers)
            result += x;
        return result;
    }
}
