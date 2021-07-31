package 카펫_42842;

// https://programmers.co.kr/learn/courses/30/lessons/42842

class Solution {
	public int[] solution(int brown, int yellow) {
		int[] answer = {0, 0};
		
		for (int i = 1; i <= yellow; i++) {
			if (yellow % i == 0) {
				if (brown == 4 + (2 * i) + (yellow / i) * 2) {
					answer[0] = yellow / i + 2;
					answer[1] = i + 2;
					break;
				}
			}
		}
		
		return answer;
	}
}

