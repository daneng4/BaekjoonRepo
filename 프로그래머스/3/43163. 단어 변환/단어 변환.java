import java.util.*;
import java.io.*;
class Solution {
    static boolean[] visit;
    static int answer = 0;
    public int solution(String begin, String target, String[] words) {
        
        // target이 words 내에 없으면 return 0
        boolean exist = false;
        for(String w : words){
            if(w.equals(target)){
                exist = true;
            }
        }
        if(!exist)
            return 0;
        
        
        // bfs 탐색으로 begin -> target 최소 변환 횟수를 찾는다
        visit = new boolean[words.length];
        bfs(begin, target, words);
        
        return answer;
    }
    
    public static void bfs(String begin, String target, String[] words){
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(begin, 0));
        
        while(!q.isEmpty()){
            Info info = q.poll();
            String now = info.now;
            int change = info.change;
            
            if(now.equals(target)){
                answer = change;
                break;
            }
            
            for(int i = 0; i<words.length; i++){
                // w 와 now 의 단어가 1개만 차이나야함 그리고 방문했던 것이 아니어야 함
                if(visit[i]) continue;
                
                if(check(words[i], now)){
                    q.add(new Info(words[i], change+1));
                    visit[i] = true;
                }
            }
        }
    }
    
    public static boolean check(String word, String now){
        int count = 0;
        
        for(int i = 0; i<word.length(); i++){
            if(word.charAt(i) != now.charAt(i))
                count++;
        }
        

        
        if(count == 1){
            return true;
        }
        return false;
    }
}
class Info{
    String now;
    int change;
    Info(String now, int change){
        this.now = now; this.change = change;
    }
}