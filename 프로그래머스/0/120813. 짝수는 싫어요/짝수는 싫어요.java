import java.util.*;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 1; i<=n; i+=2){
            answer.add(i);
        }
        
        int[] result = answer.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }
}