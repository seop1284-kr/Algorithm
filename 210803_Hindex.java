package Hindex_42747;

import java.util.Arrays;
import java.util.Comparator;

// https://programmers.co.kr/learn/courses/30/lessons/42747

public class Solution {
	public int solution(int[] citations) {
		int answer = 0;
		int h = 0;
		int pre = 0;
		Arrays.sort(citations);
		
		for (int i = citations.length - 1; i > 0 ; i--) {
			h = citations[i];
			pre = citations[i - 1];
			
			if (h == 0) return 0;
			
			for (int j = h; j > pre; j--) {
				if (citations.length - i >= j) {
					answer = j;
					return answer;
				}
			}
		}

		return citations.length;
	}
}
// 	[3, 0, 6, 1, 5] 3
// [0, 1, 3, 5, 6] 5
