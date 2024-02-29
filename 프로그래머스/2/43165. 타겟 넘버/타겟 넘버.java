import java.util.*;

class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        
        
        dfs(0, 0, target, numbers);
        
        
        return answer;
    }
    public static void dfs(int sum, int depth, int target, int[] numbers){
        if(depth == numbers.length){
            if(sum == target){
                answer++;
            }
            return;
        }
        
        dfs(sum+numbers[depth], depth+1, target, numbers);
        dfs(sum-numbers[depth], depth+1, target, numbers);
        
    }
}