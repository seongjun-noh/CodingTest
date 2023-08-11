import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        for(int i = citations.length; i > 0; i--) {
            if(citations[citations.length - i] >= i) {
                return i;
            }
        }
        return answer;
    }
}