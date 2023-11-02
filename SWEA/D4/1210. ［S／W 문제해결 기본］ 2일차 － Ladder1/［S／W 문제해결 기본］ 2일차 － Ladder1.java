import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= 10; test_case++) {
            int n = Integer.parseInt(bf.readLine());
            int[][] arr = new int[100][100];

            for (int i = 0; i < 100; i++) {
                arr[i] = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int x = 0;
            for (int i = 0; i < 100; i++) {
                if (arr[99][i] == 2) {
                    x = i;
                    break;
                }
            }

            for (int i = 98; i > -1; i--) {
                if (x - 1 > 0 && arr[i][x - 1] == 1) {
                    while (x - 1 > 0 && arr[i][x - 1] == 1) {
                        x = x - 1;
                    }
                } else if(x + 1 < 100 && arr[i][x + 1] == 1) {
                    while (x + 1 < 100 && arr[i][x + 1] == 1) {
                        x = x + 1;
                    }
                }
            }

            sb.append("#" + test_case + " " + x + "\n");
        }

        System.out.println(sb);
    }
}
