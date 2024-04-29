import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        // 인덱스 = 세로, value = 가로
        int[] yarr = new int[yellow+1];
        int size = brown + yellow;
        
        for(int i = 1; i<=Math.sqrt(yellow); i++){
            if(yellow % i == 0)
                yarr[i] = yellow/i;
        }
        
        for(int i = 1; i<=Math.sqrt(yellow); i++){
            if(yarr[i] == 0){
                continue;
            }
            int row = yarr[i]+2;
            if(size % row != 0)
                continue;
            else{
                if(size / row == 2)
                    continue;
                answer[0] = row;
                answer[1] = size/row;
                break;
            }
        }
        
        return answer;
    }
}