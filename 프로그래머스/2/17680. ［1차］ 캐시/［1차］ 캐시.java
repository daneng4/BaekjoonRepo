import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        Queue<String> q = new ArrayDeque<>();
        
        if(cacheSize == 0){
            return cities.length * 5;
        }
        
        for(String city : cities){
            city = city.toLowerCase();
            
            // 캐시 힛
            if(q.contains(city)){
                answer+=1;
                q.remove(city);
                q.offer(city);
            } // 캐시 미스
            else{
                answer+=5;
                if(q.size() == cacheSize){
                    q.poll();
                }
                if(q.size() < cacheSize){
                  q.offer(city);  
                }
            }
        }
        
        return answer;
        
    }
}