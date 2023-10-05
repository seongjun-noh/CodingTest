import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] temp = new int[triangle.length][];
        temp[0] = triangle[0];
        
        for (int i = 1; i < triangle.length; i++) {
            temp[i] = triangle[i];
            
            temp[i][0] += temp[i - 1][0];
            for (int j = 1; j < triangle[i].length - 1; j++) {
                int num = 0;
                if(temp[i - 1][j - 1] > temp[i - 1][j]) {
                    num = temp[i - 1][j - 1];
                } else {
                    num = temp[i - 1][j];
                }
                temp[i][j] += num;
            }
            temp[i][triangle[i].length - 1] += temp[i - 1][triangle[i - 1].length - 1];
        }
        
        answer = Arrays.stream(temp[temp.length - 1]).max().getAsInt();
		
        return answer;
    }
}