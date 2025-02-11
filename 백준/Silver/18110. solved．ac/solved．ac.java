import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception  {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	
    	int exclude = (int)Math.round(n * 0.15);
    	int[] scores = new int[n];
    	
    	for(int i = 0; i<n; i++) {
    		scores[i] = Integer.parseInt(br.readLine());
    	}
    	Arrays.sort(scores);
    	double sum = 0;
    	for(int i = exclude; i< n - exclude; i++) {
    		sum += scores[i];
    	}
    	
    	int size = n - 2 * exclude;
    	System.out.println(Math.round(sum / size));
    	
	}
}