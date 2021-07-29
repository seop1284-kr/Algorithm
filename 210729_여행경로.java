package 여행경로_43164;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/43164#

public class Solution {
	
	public static boolean [] visit;
	public static Solution ins = new Solution();
	public static boolean isGoal;
	
	public static String[] solution(String[][] tickets) {
		ArrayList<Pair> ans = new ArrayList<>();
		visit = new boolean[tickets.length];
		
		ans.add(ins.new Pair(0, "ICN"));

		dfs(0, "ICN", tickets, ans);
		
		String[] answer = new String[ans.size()];

		int i = 0;
		
		for (Pair p : ans) {
			answer[i++] = p.val;
		}
		
		return answer;
	}
	
	public static void dfs(int cnt, String start, String[][] tickets, ArrayList<Pair> res) {
		
		List<Pair> tmp = new ArrayList<>();
		
		if (cnt == tickets.length) {
			isGoal = true;
		}
		
		for (int i = 0; i < tickets.length; i++) {
			if (tickets[i][0].equals(start) && !visit[i]) {
				tmp.add(ins.new Pair(i, tickets[i][1]));
			}
		}
		
		tmp.sort(new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.val.compareTo(o2.val);
			}
		});
		
		for (int i = 0; i < tmp.size(); i++) {
			
			if (!isGoal) {
				visit[tmp.get(i).idx] = true;
				res.add(tmp.get(i));	
			}
			dfs(cnt + 1, tmp.get(i).val, tickets, res);		
			if (!isGoal) {
				visit[tmp.get(i).idx] = false;
				res.remove(tmp.get(i));				
			}
		}
		
	}

	class Pair {
		int idx;
		String val;
		public Pair(int idx, String val) {
			this.idx = idx;
			this.val = val;
		}
	}
}