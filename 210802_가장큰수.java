package 가장큰수_42746;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// https://programmers.co.kr/learn/courses/30/lessons/42746
// 메모리 초과, 시간 초과

public class Solution {
	boolean [] visit;
	List<String> list = new ArrayList<String>();
	public String solution(int[] numbers) {
		visit = new boolean[numbers.length];
		
		attachNumber(0, "", numbers);
		
		list.sort(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s2.compareTo(s1);
			}
		});
		
		return list.get(0);
	}
	
	public void attachNumber(int idx, String tmp, int[] numbers) {
		if (idx == numbers.length) {
			list.add(tmp);
			return;
		}
		for (int i = 0; i < numbers.length; i++) {
			if (!visit[i]) {
				visit[i] = true;
				tmp += Integer.toString(numbers[i]);
				attachNumber(idx + 1, tmp, numbers);
				visit[i] = false;
				tmp = tmp.substring(0, tmp.length() - Integer.toString(numbers[i]).length());
			}
			
		}
	}
}

//https://programmers.co.kr/learn/courses/30/lessons/42746
//각 숫자의 문자열 비교 후 정렬

class Solution2 {
	boolean [] visit;
	List<String> list = new ArrayList<String>();
	public String solution(int[] numbers) {
		visit = new boolean[numbers.length];
		String answer = "";
		for (int i : numbers) {
			list.add(Integer.toString(i));
		}
		
		list.sort(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if (s2.length() == s1.length()) {
					return s2.compareTo(s1);
				} else {
					if (s2.length() > s1.length()) {
						if (s2.substring(0, s1.length()).compareTo(s1) == 0) {
							return compare(s1, s2.substring(s1.length()));
						} else {
							return s2.substring(0, s1.length()).compareTo(s1);
						}
					} else {
						if (s1.substring(0, s2.length()).compareTo(s2) == 0) {
							return compare(s1.substring(s2.length()), s2);
						} else {
							return s2.compareTo(s1.substring(0, s2.length()));
						}
					}
				}
			}
		});
		

		for (String s : list) {
			answer += s;
		}
		
		if (answer.charAt(0) == '0') return "0";
		return answer;
	}
}

//https://programmers.co.kr/learn/courses/30/lessons/42746
//다른 사람의 코드
//각 숫자의 문자열을 결합하여 비교하여 정렬

class Solution3 {
	public String solution(int[] numbers) {
		String[] nums = new String[numbers.length];

		for (int i = 0; i < nums.length; i++)
			nums[i] = numbers[i] + "";

		Arrays.sort(nums, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return (o2 + o1).compareTo(o1 + o2);
			}
		});

		String ans = "";
		for (int i = 0; i < numbers.length; i++)
			ans += nums[i];

		return ans.charAt(0) == '0' ? "0" : ans;
	}
}