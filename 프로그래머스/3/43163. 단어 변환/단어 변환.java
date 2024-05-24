import java.util.*;

class Solution {
    static ArrayList<String> wordlist;
    static boolean[] visit;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        // 한번 바꿨던 단어로 다시 안바꾸기 위해 방문처리같은걸 해줘야함
        // 한번에 한 단어만 바꿀수있기 때문에
        // bfs탐색을 통해 처음의 begin단어와 한 단어만 다른 단어를 큐에 넣어주고
        // 단계를 1개씩 증가시키면 될듯하다.
        
        wordlist = new ArrayList<>();
        visit = new boolean[words.length];
        for(String word : words){
            wordlist.add(word);
        }
        
        // words 에 target이 없으면 return 0
        if(!wordlist.contains(target))
            return 0;
        
        answer = bfs(begin, target);
        
        return answer;
    }
    public static int bfs(String begin, String target){
        int result = 987654321;
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(begin, 0));
        // begin은 방문처리를 할 필요 없다
        
        while(!q.isEmpty()){
            Info poll = q.poll();
            String now = poll.word;
            int curCount = poll.count;
            
            if(now.equals(target)){
                result = Math.min(result, curCount);
            }
            
            for(int i = 0; i<wordlist.size(); i++){
                String listword = wordlist.get(i);
                // now와 listword가 단어 하나만 다를 경우 큐에 담는다.
                if(check(now, listword)){
                    if(visit[i])
                        continue;
                    q.add(new Info(listword, curCount+1));
                    visit[i] = true;
                }
            }
        }
        
        return result;
    }
    public static boolean check(String now, String listword){
        int diff = 0;
        // 단어가 하나만 달라야 true를 반환한다.
        for(int i = 0; i<now.length(); i++){
            if(now.charAt(i) != listword.charAt(i))
                diff++;
        }
        if(diff == 1)
            return true;
        else
            return false;
    }
}
class Info{
    String word;
    int count;
    Info(String word, int count){
        this.word = word;
        this.count = count;
    }
}