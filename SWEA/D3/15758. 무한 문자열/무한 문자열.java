import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T;
		T=Integer.parseInt(bf.readLine());


		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(bf.readLine());
			String str1 = st.nextToken();
			String str2 = st.nextToken();
			
			int str1Len = str1.length();
			int str2Len = str2.length();
			int lcm = LCM(str1Len, str2Len);
			
			String STR1 = str1;
			String STR2 = str2;
			
			for(int i = 1; i < lcm / str1Len; i ++) {
				STR1 += str1;
			}
			
			for(int i = 1; i < lcm / str2Len; i ++) {
				STR2 += str2;
			}
			
			if(STR1.equals(STR2)) {
				sb.append("#" + test_case + " yes\n");
			} else {
				sb.append("#" + test_case + " no\n");
			}
		}
		
		System.out.println(sb);
	}
	
	public static int GCD(int a, int b) {
		if(b == 0 ) {
			return a;
		} else {
			return GCD(b, a % b);
		}
	}
	
	public static int LCM(int a, int b) {
		return a * b / GCD(a, b);
	}
}