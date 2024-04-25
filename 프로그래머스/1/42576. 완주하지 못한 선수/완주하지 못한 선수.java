import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> parti = new HashMap<>();
        
        for(String p : participant){
            parti.put(p, parti.getOrDefault(p, 0) + 1);
        }
        
        for(String c : completion){
            parti.put(c, parti.get(c)-1);
        }
        
        Set<String> pSet = parti.keySet();
        for(String name : pSet){
            if(parti.get(name) >= 1)
                answer = name;
        }
        
        return answer;
    }
}