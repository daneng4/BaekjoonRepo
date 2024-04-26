import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int answerIdx = 0;
        
        for(int[] com : commands){
            int from = com[0]-1;
            int to = com[1]-1;
            int target = com[2]-1;
            int idx = 0;
            int[] pieces = new int[to - from + 1];
            
            for(int i = from; i<=to; i++){
                pieces[idx++] = array[i];
            }
            Arrays.sort(pieces);
            answer[answerIdx++] = pieces[target];
        }
        
        return answer;
    }
}