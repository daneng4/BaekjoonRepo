import java.util.*;
import java.io.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> hash = new HashMap<>();
        
        for(int i = 0; i<participant.length; i++){
            hash.put(participant[i], hash.getOrDefault(participant[i], 0) + 1);
        }
        
        for(String comp : completion){
            hash.put(comp, hash.get(comp)-1);
        }
        
        for(String key : hash.keySet()){
            if(hash.get(key) > 0){
                answer = key;
            }
        }
        
        return answer;
    }
}