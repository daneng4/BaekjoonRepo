import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int maxPick = nums.length / 2;
        
        Set<Integer> hash = new HashSet<>();
        for(int i = 0; i<nums.length; i++){
            hash.add(nums[i]);
        }
        
        if(hash.size() <= maxPick){
            answer = hash.size();
        }else{
            answer = maxPick;
        }
        
        return answer;
    }
}