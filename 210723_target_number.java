package 타겟넘버_43165;

// https://programmers.co.kr/learn/courses/30/lessons/43165

class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        
        dfs(numbers, target, 0, 0);
        return answer;
    }
    public void dfs(int[] numbers, int target, int n, int sum) {
        if (sum == target && n == numbers.length) {
            answer++;
        }
        if (n < numbers.length) {
            dfs(numbers, target, n + 1, sum + numbers[n]);
            dfs(numbers, target, n + 1, sum - numbers[n]);
        }
        
    }
}