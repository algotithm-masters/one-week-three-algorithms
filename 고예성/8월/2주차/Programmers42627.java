package programmers;

import java.util.*;

// 운영체제 시간에 배웠던, Shortest Job First(SJF) 알고리즘과 완전히 동일
public class Programmers42627 {

	public int solution(int[][] rawJobs) {
		Job[] jobs = new Job[rawJobs.length];
		for (int i = 0; i < jobs.length; i++) {
			jobs[i] = new Job(rawJobs[i][0], rawJobs[i][1]);
		}
		Arrays.sort(jobs, Comparator.comparingInt(job -> job.start));
		Queue<Job> queue = new LinkedList<>(Arrays.asList(jobs));
		PriorityQueue<Job> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(job -> job.duration));

		int executionTime = 0;
		int totalTime = 0;
		while (!queue.isEmpty() || !priorityQueue.isEmpty()) {
			while (!queue.isEmpty() && queue.peek().start <= totalTime) {
				priorityQueue.offer(queue.poll());
			}

			if (priorityQueue.isEmpty()) {
				totalTime = queue.peek().start;
				continue;
			}

			Job job = priorityQueue.poll();
			executionTime += totalTime + job.duration - job.start;
			totalTime += job.duration;
		}

		return executionTime / jobs.length;
	}

	private static class Job {
		public final int start;
		public final int duration;

		public Job(int start, int duration) {
			this.start = start;
			this.duration = duration;
		}
	}
}
