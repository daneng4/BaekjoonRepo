
import java.util.*;
import java.io.*;

public class Main {
	static boolean[] hasConstructor = new boolean[10000];
    public static void main(String[] args) throws IOException {
       
    	for(int i = 1; i<10001; i++) {
    		function(i);
    	}
    	
    	for(int i = 1; i<hasConstructor.length; i++) {
    		if (hasConstructor[i] == false)
    			System.out.println(i);
    	}
    }
    public static void function(int i) {
    	int sum = i;
    	while(i != 0) {
    		sum = sum + (i%10);
    		i = i/10;
    	}
    	if (sum < 10000)
    		hasConstructor[sum] = true;
    	
    }
}
