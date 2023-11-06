import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    static int n;
    static int[][] arr;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(bf.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            n = Integer.parseInt(bf.readLine());
            arr = new int[n][n];
            int room = 1000;
            int movement = 0;

            for(int i = 0; i < n; i++) {
                arr[i] = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

           for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    int temp = move(i, j);
                    if(temp > movement || (temp == movement &&room > arr[i][j])) {
                        movement = temp;
                        room = arr[i][j];
                    }
                }
            }

            sb.append("#" + test_case + " " + room + " " + movement + "\n");
        }

        System.out.println(sb);
    }

    static int move(int x, int y) {
        for(int i = 0; i < 4; i++) {
            if(isRange(x + dx[i], y + dy[i]) && (arr[x + dx[i]][y + dy[i]] == arr[x][y] + 1)) {
                return move(x + dx[i], y + dy[i]) + 1;
            }
        }
        return 1;
    }

    static boolean isRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n ? true : false;
    }
}