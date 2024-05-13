import java.util.*;
import java.io.*;

public class Solution {
	static int[] nums;
	static int min;
	static int target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
        	nums = new int[10];
        	min = Integer.MAX_VALUE;
        	st = new StringTokenizer(br.readLine());
        	
        	for(int i = 0; i<10; i++) {
        		nums[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	target = Integer.parseInt(br.readLine());
        	
        	// 현재 사용 가능한 수들로 만들 수 있는 수인지 체크
        	int checkResult = check(target);
        	
        	// 만약 만들 수 있는 수라면 '계산' 버튼 누르는 횟수를 추가하고 end
        	if(checkResult != 0) {
        		checkResult++;
        		bw.write(String.format("#%d %d\n", tc, checkResult));
        		continue;
        	}
        	
        	// 만들 수 없다면
        	solve(target);
        	if(min == Integer.MAX_VALUE)
        		bw.write(String.format("#%d -1\n", tc));
        	else
        		bw.write(String.format("#%d %d\n", tc, min+1));
        }// tc
        bw.flush();
    }
    public static int check(int number) {
    	int len = 1;
    	
    	// 10으로 나눈 나머지를 구하며 각 자릿수가 무엇인지 파악
    	while(number >= 10) {
    		int curNum = number % 10;
    		number /= 10;
    		
    		if(nums[curNum] == 1) {
    			len++;
    		}else
    			return 0;
    	}
    	
    	if(nums[number] == 1)
    		return len;
    	else
    		return 0;
    }
    
    public static int solve(int num) {
    	// 2부터 target의 제곱근까지 나누어주어 약수를 구하고
    	// 해당 약수가 사용가능한 수로 만들 수 있는 수인지 체크한다.
    	int max = Integer.MAX_VALUE;
    	int b = check(num);
    	
    	// 만들수 있다면
    	if(b != 0) {
    		return b;
    	}
    	
    	int end = (int)Math.sqrt(num);
    	for(int i = 2; i<=end; i++) {
    		// 약수일 경우만 나눈다
    		if(num % i == 0) {
    			int a = check(i);
    			
    			// 이 약수를 현재 사용가능한 수들로 만들 수 있다면
    			if(a != 0) {
    				a += 1; // 곱하기 버튼을 추가해줌
    				b = solve(num / i);
    				// 리턴이 max가 아닌것은 target % i를 만들 수 있다는 뜻
    				if(b != Integer.MAX_VALUE) {
    					int r = a+b;
    					if(r < max)
    						max = r;
    					if(max < min && target == num)
    						min = max;
    				}
    			}
    		}
    	}
    	
    	return max;
    }
}

