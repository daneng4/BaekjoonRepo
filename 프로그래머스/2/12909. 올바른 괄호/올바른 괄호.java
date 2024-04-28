import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int size = 0;
        char[] c = s.toCharArray();
        
        for(int i = 0; i<c.length; i++){
            if(c[i] == '('){
                size++;
            }else{
                size--;
            }
            
            if(size < 0)
                return false;
        }
        
        if(size != 0)
            return false;
        
        return answer;
    }
}