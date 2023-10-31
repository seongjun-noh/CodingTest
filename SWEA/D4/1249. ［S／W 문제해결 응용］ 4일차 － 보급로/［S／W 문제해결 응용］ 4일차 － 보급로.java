import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Node {
    int x;
    int y;
    int weight;

    Node(int x, int y, int weight) {
        this.x = x;
        this.y = y;
        this.weight = weight;
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(bf.readLine());
            int result = 0;
            int[][] arr = new int[n][n];
            int[][] drdc = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            boolean[][] visited = new boolean[n][n];
            List<Node> nodeList = new ArrayList<>();
            visited[0][0] = true;
            nodeList.add(new Node(0, 0, 0));

            for (int i = 0; i < n; i++) {
                arr[i] = Arrays.stream(bf.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            }

            while (true) {
                int minWeightX = 0;
                int minWeightY = 0;
                int minWeight = Integer.MAX_VALUE;
                for (Node node : nodeList) {
                    for (int i = 0; i < 4; i++) {
                        int x = node.x + drdc[i][0];
                        int y = node.y + drdc[i][1];
                        if (!(x == -1 || x == n || y == -1 || y == n || visited[x][y])) {
                            if (minWeight > arr[node.x][node.y] + arr[x][y]) {
                                minWeight = arr[node.x][node.y] + arr[x][y];
                                minWeightX = x;
                                minWeightY = y;
                            }
                        }
                    }
                }
                visited[minWeightX][minWeightY] = true;
                arr[minWeightX][minWeightY] = minWeight;
                nodeList.add(new Node(minWeightX, minWeightY, minWeight));

                if (minWeightX == n - 1 && minWeightY == n - 1) {
                    result = minWeight;
                    break;
                }
            }

            sb.append("#" + test_case + " " + result + "\n");
        }

        System.out.println(sb);
    }
}
