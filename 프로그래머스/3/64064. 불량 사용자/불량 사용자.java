import java.io.*;
import java.util.*;

class Solution {
    static HashSet<HashSet<String>> set;
    public int solution(String[] user_id, String[] banned_id) {        
        set = new HashSet<>();
        
        find(user_id, banned_id, 0, new HashSet<>());
        
        return set.size();
    }
    public static void find(String[] user_id, String[] banned_id, int count, HashSet<String> list){
        if(count == banned_id.length){
            set.add(list);
            return;
        }
        
        for(int i = 0; i<user_id.length; i++){
            if(list.contains(user_id[i])) continue;
            
            if(check(user_id[i], banned_id[count])){
                list.add(user_id[i]);
                find(user_id, banned_id, count+1, new HashSet<>(list));
                list.remove(user_id[i]);
            }
        }
        
    }
    public static boolean check(String user_id, String banned_id){
        if(user_id.length() != banned_id.length()) return false;
        
        for(int i = 0; i<banned_id.length(); i++){
            if(banned_id.charAt(i) == '*') continue;
            
            if(user_id.charAt(i) != banned_id.charAt(i))
                return false;
        }
        
        return true;
    }
}