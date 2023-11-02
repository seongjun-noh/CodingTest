import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution
{
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    static String[][] arr = new String[4][4];
    static Set<String> set;

    public static void main(String args[]) throws Exception
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T;
        T=Integer.parseInt(bf.readLine());


        for(int test_case = 1; test_case <= T; test_case++)
        {
            for(int i = 0; i < 4; i++) {
                arr[i] = bf.readLine().split(" ");
            }

            set = new HashSet<>();

            for(int i = 0; i < 4; i ++) {
                for(int j = 0; j < 4; j++) {
                    dfs(i, j, 0, arr[i][j]);
                }
            }

            sb.append("#" + test_case + " " + set.size() + "\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int x, int y, int depth, String str) {
        if(depth == 6) {
            set.add(str.concat(arr[x][y]));
        } else {
            for(int i = 0; i < 4; i++) {
                if(!(x+dx[i] < 0 || x + dx[i] > 3 || y + dy[i] < 0 || y + dy[i] > 3)) {
                    dfs(x + dx[i], y + dy[i], depth + 1, str.concat(arr[x][y]));
                }
            }
        }
    }
}