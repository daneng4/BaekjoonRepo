class Solution {
    public String solution(String number, int k) {
        int start = 0;
        int max = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i<number.length() - k; i++){
        	max = 0;
        	for(int j = start; j<=k+i; j++) {
        		if(max < number.charAt(j) - '0') {
                	max = number.charAt(j) - '0';
                	start = j+1;
                } 
        	}
            sb.append(max);
        }
    	
    	return sb.toString();
    }
}