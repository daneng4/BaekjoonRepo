import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        ArrayList<String> word = new ArrayList<>();
        int phase = 1;
        word.add(words[0]);
        
        for(int i = 1; i<words.length; i++){
            if(i % n == 0)
                phase++;
            
            if(word.contains(words[i]) || word.get(i-1).charAt(word.get(i-1).length()-1) != words[i].charAt(0)){
                answer[0] = (i % n) + 1;
                answer[1] = phase;
                break;
            }
            
            word.add(words[i]);
        }

        return answer;
    }
}