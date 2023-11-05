import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static String[][] arr;
    static int[][] intArr;
    static int n;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(bf.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            n = Integer.parseInt(bf.readLine());
            result = 0;
            arr = new String[n][n];
            intArr = new int[n][n];
            for(int i = 0; i < n; i++) {
                arr[i] = bf.readLine().split("");
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(isMine(arr[i][j])) {
                        for(int k = i - 1; k < i + 2; k++) {
                            for(int l = j - 1; l < j + 2; l++) {
                                if(isRange(k, l) && !isMine(arr[k][l])) {
                                    intArr[k][l]++;
                                }
                            }
                        }
                    }
                }
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(!isMine(arr[i][j]) && !isChecked(arr[i][j]) && intArr[i][j] == 0) {
                        checkZero(i, j);
                        result++;
                    }
                }
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if (!isMine(arr[i][j]) && !isChecked(arr[i][j])) {
                        arr[i][j] = "c";
                        result++;
                    }
                }
            }

            sb.append("#" + test_case + " " + result + "\n");
        }

        System.out.println(sb);
    }

    static void checkZero(int x, int y) {
        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {
                if (isRange(i, j) && !isMine(arr[i][j]) && !isChecked(arr[i][j])) {
                    arr[i][j] = "c";
                    if (intArr[i][j] == 0) {
                        checkZero(i, j);
                    }
                }
            }
        }
    }

    static boolean isRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n ? true : false;
    }

    static boolean isMine(String s) {
        return s.equals("*") ? true : false;
    }

    static boolean isChecked(String s) {
        return  s.equals("c") ? true : false;
    }
}
