import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        for(String[] cl : clothes){
            map.put(cl[1], map.getOrDefault(cl[1], 0) + 1);
        }
        
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            answer = answer * (entry.getValue()+1);
        }
        
        return answer-1;
    }
}