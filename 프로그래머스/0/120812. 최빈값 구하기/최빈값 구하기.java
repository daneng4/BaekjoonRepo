import java.util.*;
class Solution {
    public int solution(int[] array) {
        int[] a = new int[1000];
        
        for(int num : array){
            a[num]++;
        }
        
        int max = a[0];
        int answer = 0;
        for(int i = 1; i<a.length; i++){
            if(max < a[i]){
                max = a[i];
                answer = i;
            }else if(max == a[i]){
                answer = -1;
            }
        }
        
        return answer;
    }
}