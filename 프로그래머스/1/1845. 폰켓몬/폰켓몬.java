import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+ 1);
        }
        int pick = nums.length / 2;
        if(map.size() > pick){
            answer = pick;
        }else{
            answer = map.size();
        }
        
        return answer;
    }
}