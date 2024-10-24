import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        int size = 0;
        
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                size++;
            }else{
                size--;
            }
            
            if(size < 0){
                answer = false;
                break;
            }
        }
        
        if(size != 0){
            return false;
        }
        

        return answer;
    }
}