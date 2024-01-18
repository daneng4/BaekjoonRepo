import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        List<Integer> result = new ArrayList<>();
		
		int[] one = {1, 2, 3, 4, 5};
		int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] thr = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		int[] score = {0,0,0};
        int[] answer = {};
        
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == one[i%5]) score[0]++;
            if(answers[i] == two[i%8]) score[1]++;
            if(answers[i] == thr[i%10]) score[2]++;
        }
        
        int max = Math.max(score[0], Math.max(score[1], score[2]));
        for(int i = 0; i<score.length; i++){
            if(max == score[i])
                result.add(i+1);
        }
        answer = new int[result.size()];
        for(int i = 0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
		
        return answer;
    }
}