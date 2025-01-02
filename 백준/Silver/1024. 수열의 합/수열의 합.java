
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class Main {    
    public static void main(String args[]) throws Exception  {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	
    	int n = Integer.parseInt(st.nextToken());
    	int l = Integer.parseInt(st.nextToken());
    	boolean find = false;
    	
    	for(int i = l; i<=100; i++) {
    		
    		ArrayList<Integer> list = new ArrayList<>();
    		int num = n / i;
    		int sum = 0;
    		
    		if(i % 2 == 1) {
    			int r = i / 2;
    			for(int j = num-r; j<=num+r; j++) {
    				if(j < 0)
    					break;
    				sum += j;
    				list.add(j);
    			}
    		}else {
    			int r = i / 2;
    			for(int j = num-(r-1); j<=num+r; j++) {
    				if(j < 0)
    					break;
    				sum += j;
    				list.add(j);
    			}
    		}
    		
    		if(sum == n) {
    			for(int e : list) {
    				sb.append(e + " ");
    			}
    			find = true;
    			break;
    		}
    	}
    	
    	if(!find)
    		System.out.println(-1);
    	else 
    		System.out.println(sb.toString());
    }
}
