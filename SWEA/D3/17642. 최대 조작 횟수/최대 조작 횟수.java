import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T=Integer.parseInt(bf.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			long result = 0;
			String[] str = bf.readLine().split(" ");
			long a = Long.parseLong(str[0]);
			long b = Long.parseLong(str[1]);
			
			long c = b - a;
			
			if(c == 0) {
				result = 0;
			} else if(c == 1 || c < 0) {
				result = -1;
			} else if(c % 2 == 0) {
				result = c / 2;
			} else {
				result = c == 3 ? 1 : (c - 3) / 2 + 1;
			}
			
			
			sb.append("#" + test_case + " " + result + "\n");
		}
		
		System.out.println(sb);
	}
}