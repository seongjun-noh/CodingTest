import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
			int countRook = 0;
			char[][] arr = new char[8][8];
			String result = "yes";
			for(int i = 0; i < 8; i++) {
				arr[i] = bf.readLine().toCharArray();
			}
			for(int i = 0; i < 8; i++) {
				int countRowRook = 0;
				int countColRook = 0;
				for(int j = 0; j < 8; j++) {
					if(arr[i][j] == 'O') {
						countRowRook++;
					}
					if(arr[j][i] == 'O' ) {
						countColRook++;
					}
				}
				if(countRowRook != 1 || countColRook != 1) {
					result = "no";
					break;
				}
			}
			sb.append("#" + test_case + " " + result + "\n");
		}
		
		System.out.println(sb);
	}
}