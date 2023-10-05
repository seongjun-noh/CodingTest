import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());
        int queueSize = 0;
        
        for (String operation: operations) {
            String[] params = operation.split(" ");
            if (params[0].equals("I")) {
                minHeap.add(Integer.parseInt(params[1]));
                maxHeap.add(Integer.parseInt(params[1]));
                queueSize+=1;
            } else {
                if (params[1].startsWith("-")) {
                    minHeap.poll();
                } else {
                    maxHeap.poll();
                }
                if (queueSize > 0) {
                    queueSize--;
                } 
                if (queueSize == 0) {
                    minHeap.clear();
                    maxHeap.clear();
                }
            }
        }
        
        if (queueSize == 0) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = maxHeap.poll();
            answer[1] = minHeap.poll();
        }
        
        return answer;
    }
}