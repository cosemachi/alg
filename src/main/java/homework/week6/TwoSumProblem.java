package homework.week6;

import java.io.*;
import java.util.*;

public class TwoSumProblem {

	private final Set<Long> table = new HashSet<Long>();

	public TwoSumProblem(final File file) {
		try {
			System.out.println("Start reading file into Hashtable.");
			final BufferedReader br = new BufferedReader(new FileReader(file));

			String line;
			while ((line = br.readLine()) != null) {
				final long i = Long.valueOf(line);
				this.table.add(i);
			}
			br.close();
			System.out.println("Finished reading file into Hashtable.");
		} catch (final Exception e) {
			System.out.println(e.toString());
		}
	}

	public int findTwoSumProblem(final int small, final int big) {
		int num = 0;
		System.out.println("Start finding number that match x+y :" + small + "<x+y<" + big);

		for (int sum = small; sum <= big; sum++) {
			for (final long i : table) {
				final long j = Long.valueOf(sum) - i;
				if (i != j && this.table.contains(j)) {
					num++;
					System.out.println("found t=" + sum + ", i=" + i + ",j=" + j + ", num=" + num);
					break;
				}
			}
		}
		return num;
	}
}
