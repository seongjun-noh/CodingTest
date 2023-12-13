import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[][] node = new int[n + 1][n + 1];
		for(int i = 0; i < n + 1; i++) {
			Arrays.fill(node[i], Integer.MAX_VALUE);
			node[i][i] = 0;
		}

		for (int i = 0; i < n - 1; i++) {
			int source = sc.nextInt();
			int destination = sc.nextInt();
			int distance = sc.nextInt();

			node[source][destination] = distance;
			node[destination][source] = distance;
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				for (int k = 1; k < n + 1; k++) {
					if (node[i][j] == Integer.MAX_VALUE || node[i][k] == Integer.MAX_VALUE) {
						continue;
					}
					node[j][k] = Math.min(node[j][k], node[i][j] + node[i][k]);
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < m; i++) {
			int source = sc.nextInt();
			int destination = sc.nextInt();
			int distance = 0;

			distance = node[source][destination];
			sb.append(distance).append("\n");
		}

		System.out.println(sb);
	}
}