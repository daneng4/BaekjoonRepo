import java.util.*;
class Solution {
    public int solution(int price) {
        int answer = 0;
        
        if(price >= 500000){
            answer = (int)(price * 0.8);
            return answer;
        }else if(price >= 300000){
            answer = (int)(price * 0.9);
            return answer;
        }else if(price >= 100000){
            answer = (int)(price * 0.95);
            return answer;
        }
        
        answer = price;
        return answer;
    }
}