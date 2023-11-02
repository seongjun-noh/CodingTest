import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    static int startX = 0;
    static int startY = 0;
    static int isAble;
    static int[] dx = { -1, 0 , 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= 10 ; test_case++) {
            int n = Integer.parseInt(bf.readLine());
            arr = new int[16][16];
            isAble = 0;

            for(int i = 0; i < 16; i++) {
                arr[i] = Arrays.stream(bf.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            }

            for(int i = 1; i < 14; i++) {
                for(int j = 1; j < 14; j++) {
                    if(arr[i][j] == 2) {
                        startX = i;
                        startY = j;
                    }
                    if(startX != 0) {
                        break;
                    }
                }
                if(startX != 0) {
                    break;
                }
            }

            arr[startX][startY] = 1;
            for(int i = 0; i < 4; i++) {
                dfs(startX + dx[i], startY + dy[i]);
            }

            sb.append("#" + test_case + " " + isAble + "\n");
        }

        System.out.println(sb);
    }

    static void dfs(int x, int y) {
        if(arr[x][y] == 1) {
            return;
        } else if (arr[x][y] == 3) {
            isAble = 1;
            return;
        }
        for(int i = 0; i < 4; i++) {
            arr[x][y] = 1;
            dfs(x + dx[i], y + dy[i]);
        }
    }
}