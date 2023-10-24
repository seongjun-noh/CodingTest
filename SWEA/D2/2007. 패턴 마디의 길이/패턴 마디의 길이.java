import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String str = bf.readLine();
			char firstChar = str.charAt(0);
			
			for (int i = 1; i < 10; i++) {
				if (firstChar == str.charAt(i)) {
					String temp = str.substring(0, i);
					
					if (temp.equals(str.substring(i * (30 / i - 1), i * (30 / i)))) {
						sb.append("#" + test_case + " " + i + "\n");
                        break;
					}
				}
			}
		}
		
		System.out.println(sb.toString());
	}
}