// times의 배수들을 구해본다? 
// n = 6, times = 1 2 3 -> 1 2 3 4 6
// 예 에서는 최소한 한 창구에서 3명씩은 받아야 완전히 종료됨
// 각숫자들의 배수갯수는 -> n/times.length()가 될거다.
// 그 배수들을 list에 다 저장을한다.
import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long end = Long.MAX_VALUE / 100;
        long start = 0;
        
        while(start < end){
            long mid = (end+start)/2;
            long result = check(mid, times);
            if(n <= result){
                end = mid;
            }else
                start = mid+1;
        }
        
        return start;
    }
    public static long check(long mid, int[] times){
        long count = 0;
        
        for(int i = 0; i<times.length; i++){
            count += mid / times[i];
        }
        
        return count;
    }
}