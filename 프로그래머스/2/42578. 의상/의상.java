import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> map = new HashMap<>();
        
        for(String[] c : clothes){
            String type = c[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        Set<String> key = map.keySet();
        for(String k : key){
            answer *= map.get(k) + 1;
        }
        
        return answer-1;
    }
}