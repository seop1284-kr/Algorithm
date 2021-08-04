package 더맵게_42626;

import java.util.ArrayList;
import java.util.PriorityQueue;

//https://programmers.co.kr/learn/courses/30/lessons/42626

public class Solution2 {
	public int solution(int[] scoville, int k) {
		int answer = 0;
		// 내림차순 PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i : scoville) {
			pq.add(i);
		}
		
		int cnt = 0;
		while (true) {
			cnt++;
			pq.add(pq.poll() + (pq.poll() * 2));
			if (pq.peek() >= k) return cnt;
			if (pq.size() == 1) return -1;
		}
		
	}
}