import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};
        
        int p1s = 0; int p2s = 0; int p3s = 0;
        for(int i = 0; i<answers.length; i++){
            if(answers[i] == p1[i % p1.length]){
                p1s++;
            }
            if(answers[i] == p2[i % p2.length]){
                p2s++;
            }
            if(answers[i] == p3[i % p3.length]){
                p3s++;
            }
        }
        int max = 0;
        max = Math.max(max, p1s);
        max = Math.max(max, p2s);
        max = Math.max(max, p3s);
        if(max == p1s)
            answer.add(1);
        if(max == p2s)
            answer.add(2);
        if(max == p3s)
            answer.add(3);
        
        return answer;
    }
}