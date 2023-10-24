import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T=Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int max = 0;
			int maxScore = 0;
			int num = Integer.parseInt(br.readLine());
			List<Integer> arr = Arrays.stream(br.readLine().split(" "))
					.map(Integer::parseInt)
					.collect(Collectors.toList());
			Set<Integer> set = new HashSet<Integer>(arr); 
			
			for (int score : set) {
				int temp = Collections.frequency(arr, score);
				if (temp > max) {
					max = temp;
					maxScore = score;
				} else if (temp == max && score > maxScore ) {
					maxScore = score;
				}
			}
			
			sb.append("#" + test_case + " " + maxScore + "\n");
		}
		
		System.out.println(sb);
	}
}