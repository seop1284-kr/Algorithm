package 여행경로_43164;

import java.util.*;

public class Solution2 {
	
	public static boolean [] visit;
	public static Solution2 ins = new Solution2();
	public static boolean isGoal;
	
	public static String[] solution(String[][] tickets) {
		ArrayList<String> ans = new ArrayList<>();
		visit = new boolean[tickets.length];
		
		ans.add("ICN");

		dfs(0, "ICN", tickets, ans);
		
		String[] answer = ans.toArray(new String[ans.size()]);
		
		return answer;
	}
	public static void dfs(int cnt, String start, String[][] tickets, ArrayList<String> res) {
		
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
				res.add(tmp.get(i).val);	
			}
			dfs(cnt + 1, tmp.get(i).val, tickets, res);		
			if (!isGoal) {
				visit[tmp.get(i).idx] = false;
				res.remove(tmp.get(i).val);				
			}
		}
		
	}
	public static void main(String[] args) {
		//String[][] a = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		//String[][] a = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		String[][] a = {{"ICN", "BBB"},{"ICN", "CCC"},{"BBB", "CCC"},{"CCC", "BBB"},{"CCC", "ICN"}};
		for (String s : solution(a)) System.out.println(s);
		System.out.println();
	}
// 입력
//[["ICN", "BBB"],["ICN", "CCC"],["BBB", "CCC"],["CCC", "BBB"],["CCC", "ICN"]]

//정답
//["ICN", "BBB", "CCC", "ICN", "CCC", "BBB"]
//실행한 결괏값 ["ICN","CCC","BBB","ICN","CCC","BBB"]
		
	class Pair {
		int idx;
		String val;
		public Pair(int idx, String val) {
			this.idx = idx;
			this.val = val;
		}
	}
}

