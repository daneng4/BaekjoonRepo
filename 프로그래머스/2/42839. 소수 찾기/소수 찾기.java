import java.util.*;

class Solution {
    static boolean[] visit;
    static ArrayList<Integer> list = new ArrayList<>();
    
    public int solution(String numbers) {
        int answer = 0;
        visit = new boolean[numbers.length()];
        char[] c = numbers.toCharArray();
        
        for(int i = 0; i<c.length; i++) {
        	visit[i] = true;
        	solve("" + c[i], c);
        	visit[i] = false;
        }
        
        answer = list.size();
        return answer;
    }
    public static void solve(String str, char[] c){
    	int num = Integer.parseInt(str);
    	
        // 소수 판별
        if(num != 0 && num != 1){
    		if(isPrime(num)){
                if(!list.contains(num))
                    list.add(num);
            }
        }       
         
        for(int i = 0; i<c.length; i++){
            if(visit[i])
                continue;
            visit[i] = true;
            solve(str + c[i], c);
            visit[i] = false;
        }   
    }
        public static boolean isPrime(int num){
        for(int i = 1; i<= num; i++){
            if(i != 1 && i != num){
                if(num % i == 0)
                    return false;
            }
        }
        
        return true;  
    }
}