package 모의고사_42840;

import java.util.ArrayList;
import java.util.List;

// https://programmers.co.kr/learn/courses/30/lessons/42840

public class Solution {
	public static int[] solution(int[] answers) {
		int[] answer = {};
		int [] a = {1, 2, 3, 4, 5};
		int [] b = {2, 1, 2, 3, 2, 4, 2, 5};
		int [] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		
		int [] corNum = {0, 0, 0};
		
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == a[i % 5]) corNum[0]++;
			if (answers[i] == b[i % 8]) corNum[1]++;
			if (answers[i] == c[i % 10]) corNum[2]++;
		}
		
		// max 구하고
		int max = 0;
		for (int i = 0; i < 3; i++) {
			if (max < corNum[i]) {
				max = corNum[i];
			}
		}
		
		// max와 같은 애들 List에 넣고
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			if (corNum[i] == max) {
				ans.add(i + 1);
			}	
		}
		
		// List를 int 배열로 바꿈
		answer = new int[ans.size()];
		for (int i = 0; i < ans.size(); i++) {
			answer[i] = ans.get(i);
		}
		
		return answer;
	}

}
