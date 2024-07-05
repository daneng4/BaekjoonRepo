import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        // participant 맵에 넣어놓고 completion이 맵에잇는지 확인
        // 잇으면 value -1, 마지막에 맵에 존재하는 key가 답이된다
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String p : participant){
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        for(String c : completion){
            map.put(c, map.get(c) - 1);
        }
        
        for(String s : map.keySet()){
            if(map.get(s) == 1)
                answer = s;
        }
        
        return answer;
    }
}