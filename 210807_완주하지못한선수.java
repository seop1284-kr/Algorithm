package 완주하지못한선수_42576;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

// https://programmers.co.kr/learn/courses/30/lessons/42576

public class Solution {
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		
		Map<String, Integer> map = new HashMap<>();
		
		for (String p : participant) {
			map.put(p, map.getOrDefault(p, 0) + 1);
		}
		
		for (String c : completion) {
			map.replace(c, map.get(c) - 1);
		}
		
//		for (String p : map.keySet()) {
//			if (map.get(p) == 1) return p;
//		}
		
		// entrySet()
		for (Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) return entry.getKey();
		}
		
		return answer;
	}
}
