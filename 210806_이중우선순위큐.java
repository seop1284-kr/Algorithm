package 이중우선순위큐_42628;

import java.util.PriorityQueue;

// https://programmers.co.kr/learn/courses/30/lessons/42628#

public class Solution {
	public int[] solution(String[] operation) {
		int[] answer = {0, 0};
		PriorityQueue<Integer> minq = new PriorityQueue<>((Integer i1, Integer i2) -> {
			return i1 - i2;
		});
		PriorityQueue<Integer> maxq = new PriorityQueue<>((Integer i1, Integer i2) -> {
			return i2 - i1;
		});
		
		for (int i = 0; i < operation.length; i++) {
			char c = operation[i].charAt(0);
			char n = operation[i].charAt(2);
			if (c == 'I') {
				minq.add(Integer.parseInt(operation[i].substring(2)));
				maxq.add(Integer.parseInt(operation[i].substring(2)));				
			} else if (c == 'D') {
				if (n == '-' && !minq.isEmpty()) {
					maxq.remove(minq.remove());
				} else if (n == '1' && !maxq.isEmpty()){
					minq.remove(maxq.remove());
				
				}
			}
		}
		if (!minq.isEmpty()) {
			answer[0] = maxq.poll();
			answer[1] = minq.poll();
		
		}		
		return answer;
	}
}
