package 단어변환_43163;

// https://programmers.co.kr/learn/courses/30/lessons/43163

public class Solution {
	
	public static boolean [] visit;
	public static int min = 0;
	
	public int solution(String begin, String target, String[] words) {
		int answer = 0;
		visit = new boolean[words.length];
		answer = dfs(begin, target, words, 0, 0);
		return answer;
	}
	
	public static int dfs(String begin, String target, String[] words, int n, int count) {
		
		for (int i = 0; i < words.length; i++) {
			if (check(begin, words[i]) && !visit[i]) {
				visit[i] = true;
				min = dfs(words[i], target, words, i + 1, count + 1);
				visit[i] = false;
			}	
		}
		
		if (begin.equals(target)) {
			if (min == 0 || count < min && count != 0) {
				min = count;
			}
		}
		return min;

	}
	
	public static boolean check(String begin, String target) {
		int cnt = 0;
		for (int i = 0; i < begin.length(); i++) {
			if (begin.charAt(i) != target.charAt(i)) cnt++; 
		}
		if (cnt == 1) {
			return true;
		} else {
			return false;
		}
	}
	
}
