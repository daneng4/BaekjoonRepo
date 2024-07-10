class Solution {
    public int solution(int slice, int n) {
        int answer = 0;
        int i = 1;
        while(true){
            if(slice * i >= n){
                answer = i;
                break;
            }
                
            i++;
        }
        
        return answer;
    }
}