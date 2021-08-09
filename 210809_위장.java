package 위장_42578;
import java.util.*;
import java.util.Map.Entry;

// https://programmers.co.kr/learn/courses/30/lessons/42578
public class Solution {
	public static int solution(String[][] clothes) {
		int answer = 1;
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1], 1) + 1);
        }
        
        for (Entry<String, Integer> entry : hm.entrySet()) {
        	answer *= entry.getValue();
        }
        
        return answer - 1;
	}
	
	public static void main(String[] args) {
		String[][] a = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
		System.out.println(solution(a));
	}
}
