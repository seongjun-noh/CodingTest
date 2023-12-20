import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] str = bf.readLine().split(" ");

		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);

		Integer[][] arr = new Integer[n][m];
		for (int i = 0; i < n; i++) {
			str = bf.readLine().split("");
			arr[i] = Arrays.stream(str).map(Integer::parseInt).toArray(Integer[]::new);
		}

		int minSide = Math.min(n, m);

		for (int k = minSide; k > 0; k--) {
			for (int i = 0; i < n - k + 1; i++) {
				for (int j = 0; j < m - k + 1; j++) {
					if (arr[i][j] == arr[i + k - 1][j] && arr[i][j] == arr[i][j + k - 1]
						&& arr[i][j] == arr[i + k - 1][j + k - 1]) {
						System.out.println(k * k);
						return;
					}
				}
			}
		}
	}
}
