import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T=Integer.parseInt(bf.readLine());
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char[] charArr = new char[63];
		charArr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
		for (int i = 0; i < 64; i++) {
			map.put(charArr[i], i);
		}

		for(int test_case = 1; test_case <= T; test_case++)
		{
			sb.append("#" + test_case + " ");
			String str = bf.readLine();
			String binary = "";
			
			for(char c : str.toCharArray()) {
				binary += String.format("%06d", Integer.parseInt(Integer.toBinaryString(map.get(c))));
			}

			for(int i = 0; i < binary.length() - 7; i += 8) {
				char c = (char)(Integer.parseInt(binary.substring(i, i + 8), 2));
				sb.append(c);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}