import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        int[] answer = {-1};
        
        // 합이 s를 만족하는 n개의 자연수를 구해야한다. 어떻게?
        // 그 중 각 원소의 곱이 최대가 되는 집합을 구해야한다.
        
        if(n > s){
            return answer;
        }
        answer = new int[n];
        
        for(int i = 0; i<answer.length; i++){
            answer[i] = s/n;
        }
        
        for(int i = 0; i<s%n; i++){
            answer[i] += 1;
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}