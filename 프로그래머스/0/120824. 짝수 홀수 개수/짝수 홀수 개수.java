import java.util.*;
class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        
        int[] even = Arrays.stream(num_list).filter(x -> x % 2 == 0).toArray();
        answer[0] = even.length;
        answer[1] = num_list.length - answer[0];
        
        return answer;
    }
}