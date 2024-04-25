import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int take = nums.length/2;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        
        if(set.size() >= take)
            answer = take;
        else
            answer = set.size();
        
        return answer;
    }
}