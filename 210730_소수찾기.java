package 소수찾기_42839;

import java.util.ArrayList;

// https://programmers.co.kr/learn/courses/30/lessons/42839
// https://skd03052.tistory.com/197

public class Solution {
	ArrayList<Integer> words = new ArrayList<>();
	boolean [] visit;
	
	public int solution(String numbers) {
		int answer = 0;
		visit = new boolean[numbers.length()];
		for (int i = 1; i <= numbers.length(); i++) {
			dfs(numbers, i, "");
		}
		
		for (int i = 0; i < words.size(); i++) {
			answer += checkPrimeNum(words.get(i));
		}
		
		return answer;
	}
	
	public void dfs(String numbers, int len, String tmp) {
		if (tmp.length() == len) {
			int n = Integer.parseInt(tmp);
			if (!words.contains(n)) {
				words.add(n);
			}
			return;
		}
		
		for (int i = 0; i < numbers.length(); i++) {
			if (!visit[i]) {
				tmp += numbers.charAt(i);
				visit[i] = true;
				dfs(numbers, len, tmp);
				tmp = tmp.substring(0, tmp.length() - 1);
				visit[i] = false;
			}
		}
	}
	
	public int checkPrimeNum(int n) {
		
		if (n == 0 || n == 1) return 0;
		for (int i = 2; i < n; i++) {
			if (n % i == 0) return 0;
		}
		
		return 1;
	}
}
