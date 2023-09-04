import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        int count = 0; // 당첨 된 수 
        int zeroCount = 0; // 0인 숫자의 개수
        
        for(int i = 0; i<lottos.length; i++){
            if(lottos[i] == 0)
                zeroCount += 1;
        }
        
        for(int i = 0; i<win_nums.length; i++){
            for(int j = 0; j<lottos.length; j++){
                if(win_nums[i] == lottos[j]){
                    count += 1;
                }
            }
        }
        int[] answer = new int[2];
        // 최소 등수
        if (count == 6) answer[0] = 1;
        else if (count == 5) answer[0] = 2;
        else if (count == 4) answer[0] = 3;
        else if (count == 3) answer[0] = 4;
        else if (count == 2) answer[0] = 5;
        else answer[0] = 6;
        
        // 최대 등수
        if (count + zeroCount == 6) answer[1] = 1;
        else if (count + zeroCount == 5) answer[1] = 2;
        else if (count + zeroCount == 4) answer[1] = 3;
        else if (count + zeroCount == 3) answer[1] = 4;
        else if (count + zeroCount == 2) answer[1] = 5;
        else answer[1] = 6;

        Arrays.sort(answer);
        return answer;
    }
}