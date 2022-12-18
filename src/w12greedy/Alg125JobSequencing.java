package w12greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * 
 * @author bahadr
 *
 */
public class Alg125JobSequencing {

	/*
	 * Greedy problem: Given an array of jobs where every job has a deadline and associated profit if the job is finished before the deadline. 
	 * It is also given that every job takes a single unit of time, so the minimum possible deadline for any job is 1.
	 * Maximize the total profit if only one job can be scheduled at a time.
	 * 
	 */

	private static char[] scheduleTheJobs(List<Alg125Job> jobs, int t) {
		char[] result = new char[t];
		Arrays.fill(result, ' ');

		for (int i = 0; i < jobs.size(); i++) {
			int pos = jobs.get(i).getDeadline() - 1;
			if (pos > t - 1)
				pos = t - 1;
			for (int j = pos; j >= 0; j--)
				if (result[j] == ' ') {
					result[j] = jobs.get(i).getId();
					break;
				}
		}

		return result;
	}

	public static void main(String[] args) {
        List<Alg125Job> jobs = new ArrayList<Alg125Job>();
        jobs.add(new Alg125Job('a', 2, 100));
        jobs.add(new Alg125Job('b', 1, 19));
        jobs.add(new Alg125Job('c', 2, 27));
        jobs.add(new Alg125Job('d', 1, 25));
        jobs.add(new Alg125Job('e', 3, 15));

//        jobs.add(new Alg125Job('a', 4, 20));
//        jobs.add(new Alg125Job('b', 1, 10));
//        jobs.add(new Alg125Job('c', 1, 40));
//        jobs.add(new Alg125Job('d', 1, 30));

        Collections.sort(jobs, (a, b) -> b.getProfit() - a.getProfit());

        Optional<Alg125Job> jobWithMaxDeadline = jobs.stream().max((j1, j2) -> Integer.compare(j1.getDeadline(), j2.getDeadline()));
        if (jobWithMaxDeadline.isPresent())
        	System.out.println(Arrays.toString(scheduleTheJobs(jobs, jobWithMaxDeadline.get().getDeadline())));
	}
}
