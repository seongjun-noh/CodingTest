import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T=Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			String[] nm = br.readLine().split(" ");
			int n = Integer.parseInt(nm[0]);
			int m = Integer.parseInt(nm[1]);
			int max = 0;
			
			int[][] field = new int[n][n];
			
			for (int i = 0; i < n; i ++) {
				field[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
			}
			
			for (int i = 0; i < n - m + 1; i++) {
				for (int j = 0; j < n - m + 1; j++) {
					int temp = 0;
					for (int k = i; k < i + m; k++) {
						for (int l = j; l < j + m; l++) {
							temp += field[k][l];
						}
					}
					if (temp > max) { 
						max = temp;
					}
				}
			}
			
			sb.append("#" + test_case + " " + max + "\n");
		}
		
		System.out.println(sb);
	}
}