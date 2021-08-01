package k번째수_42748;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;

// https://programmers.co.kr/learn/courses/30/lessons/42748
// ArrayList size() // array length // String length()
public class Solution {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		
		for (int i = 0; i < commands.length; i++) {
			answer[i] = func(array, commands[i]);
		}
		
		return answer;
	}
	
	public int func(int[] array, int[] commands) {
		List<Integer> list = new ArrayList<>();
		for (int i = commands[0] - 1; i < commands[1]; i++) {
			list.add(array[i]);
		}
		
		list.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return a - b;
			}

		});
		
		return list.get(commands[2] - 1);
		
	}
}
