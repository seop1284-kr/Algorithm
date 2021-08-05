package 디스크컨트롤러_42627;

import java.util.PriorityQueue;

// https://programmers.co.kr/learn/courses/30/lessons/42627

public class Solution {
	public static int solution(int[][] jobs) {
		int answer = 0;
		
		PriorityQueue<Job> pq = new PriorityQueue<>((Job job1, Job job2) -> {
			if (job1.rt > job2.rt) return 1;
			else return -1;
		});
		
		PriorityQueue<Job> pq2 = new PriorityQueue<>((Job job1, Job job2) -> {
			if (job1.wl > job2.wl) return 1;
			else return -1;
		});
	
		for (int i = 0; i < jobs.length; i++) {
			pq.add(new Job(jobs[i][0], jobs[i][1]));	
		}
		
		int wtime = 0;
		int time = 0;
		
		while (!(pq.isEmpty()) || !(pq2.isEmpty())) {	
			while (!pq.isEmpty()) {
				if (pq.peek().rt <= time) {
					pq2.add(pq.poll());
				} else {
					if (pq2.isEmpty()) time++;
					else break;
				}
			}
			if (!pq2.isEmpty()) {
				Job job = pq2.poll();
				wtime += time - job.rt + job.wl;
				time += job.wl; 
			}
			
		} 
		
		answer = wtime / jobs.length;
		return answer;
	}

}

class Job {
	int rt;
	int wl;
	
	Job(int rt, int wl) {
		this.rt = rt;
		this.wl = wl;
	}

}