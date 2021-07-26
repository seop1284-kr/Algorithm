package 네트워크_43162;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/43162

public class Solution {
	static boolean [] visit;
	static Queue<Integer> q = new LinkedList<>();
	static int answer = 0;
	
	public int solution(int n, int[][] computers) {
		visit = new boolean[n];
		for (int i = 0; i < n; i++) {
			bfs(i, computers, n);
		}
		return answer;
	}
	
	public static void bfs(int i, int[][] computers, int n) {
		
		if (visit[i]) return;
		visit[i] = true;
		q.add(i);
		while (!q.isEmpty()) {
			int temp = q.poll();
			for (int j = 0; j < n; j++) {
				if (j != temp && !visit[j] && computers[temp][j] == 1) {
					visit[j] = true;
					q.add(j);
				}
			}
		}
		answer++;
	}
}
