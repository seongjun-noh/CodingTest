import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bf.readLine().split(" ");
        int C = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        int[][] cityInfo = new int[N][2];
        int[] dp = new int[C + 101]; // 고객 수 C를 초과할 수 있으므로 버퍼를 추가

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // 초기값 설정

        for (int i = 0; i < N; i++) {
            cityInfo[i] = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < N; i++) {
            int cost = cityInfo[i][0];
            int customers = cityInfo[i][1];

            for (int j = customers; j < dp.length; j++) {
                if (dp[j - customers] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - customers] + cost);
                }
            }
        }

        int result = Arrays.stream(dp, C, dp.length).min().getAsInt();

        System.out.println(result);
    }
}
