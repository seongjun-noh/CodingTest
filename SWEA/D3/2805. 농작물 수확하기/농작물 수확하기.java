import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T = Integer.parseInt(bf.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = Integer.parseInt(bf.readLine());
			int sum = 0;
			int k = n / 2;
			int[][] arr = new int[n][n];
			for(int i = 0; i < k; i++) {
				arr[i] = Stream.of(bf.readLine().split("")).mapToInt(Integer::parseInt).toArray();
				for(int j = k - i; j < k + i + 1; j++) {
					sum += arr[i][j];
				}
			}
			arr[k] = Stream.of(bf.readLine().split("")).mapToInt(Integer::parseInt).toArray();
			for(int i = 0; i < n; i++) {
				sum += arr[k][i];
			}
			for(int i = k + 1; i < n; i++) {
				arr[i] = Stream.of(bf.readLine().split("")).mapToInt(Integer::parseInt).toArray();
				for(int j = i - k; j < n - i + k; j++) {
					sum += arr[i][j];
				}
			}
			sb.append("#" + test_case + " " + sum + "\n");
		}
		
		System.out.println(sb);
	}
}