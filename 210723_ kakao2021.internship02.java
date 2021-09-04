package kakao2021.internship02;
//https://programmers.co.kr/learn/courses/30/lessons/81302#fn1
//P는 응시자가 앉아있는 자리를 의미합니다.
//O는 빈 테이블을 의미합니다.
//X는 파티션을 의미합니다.

public class Solution3 {

	int num = 0;
	boolean visit[][];
	int[] answer;
	public void dfs(int x, int y, int count, String[] place) {
		if (count > 2) return;
		if (count > 0 && count <= 2 && place[x].charAt(y) == 'P') {
			answer[num] = 0;
			return;
		}
		if (x > 0) {
			if (place[x - 1].charAt(y) != 'X' && !visit[x - 1][y]) {
				visit[x - 1][y] = true;
				dfs(x - 1, y, count + 1, place);
				visit[x - 1][y] = false;
			}
		}
		if (x < 4) {
			if (place[x + 1].charAt(y) != 'X' && !visit[x + 1][y]) {
				visit[x + 1][y] = true;
				dfs(x + 1, y, count + 1, place);
				visit[x + 1][y] = false;
			}
		}
		if (y > 0) {
			if (place[x].charAt(y - 1) != 'X' && !visit[x][y - 1]) {
				visit[x][y - 1] = true;
				dfs(x, y - 1, count + 1, place);
				visit[x][y - 1] = false;
			}
		}
		if (y < 4) {
			if (place[x].charAt(y + 1) != 'X' && !visit[x][y + 1]) {
				visit[x][y + 1] = true;
				dfs(x, y + 1, count + 1, place);
				visit[x][y + 1] = false;
			}
		}		
	}
	public int[] solution(String[][] places) {
        answer = new int[] {1, 1, 1, 1, 1};
        
        for (int i = 0; i < 5; i++) {
        	visit = new boolean[5][5];
        	for (int j = 0; j < 5; j++) {
        		for (int k = 0; k < 5; k++) {
        			if (places[i][j].charAt(k) == 'P') {
        				visit[j][k] = true;
            			dfs(j, k, 0, places[i]);
            			visit[j][k] = false;
        			}
        			
        		}
        	}
        	num++;
        }
        
        return answer;
    }
}
