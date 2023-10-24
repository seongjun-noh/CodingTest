import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T;
		T = Integer.parseInt(bf.readLine());
			
		for(int test_case = 1; test_case <= T; test_case++)
		{
			double[] arr = Arrays.stream(bf.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
			double a = arr[0];
			double b = arr[1];
			double c = arr[2];
			double x = (Math.abs((c + a - b * 2) / 2));
			sb.append("#" + test_case + " " + String.format("%.1f", x) + "\n");
		}
		
		System.out.println(sb);
	}
}