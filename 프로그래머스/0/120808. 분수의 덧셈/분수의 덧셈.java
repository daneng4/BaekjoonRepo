class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int numer = (numer1 * denom2) + (numer2 * denom1);
        int denom = denom1 * denom2;
        
        int div = 1;
        for(int i = 1; i<=numer && i<=denom; i++){
            if(numer % i == 0 && denom % i == 0){
                div = i;
            }
        }
        
        int[] answer = {numer / div, denom / div};
        return answer;
        
    }
}