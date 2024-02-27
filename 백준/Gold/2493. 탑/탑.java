
import java.io.*;
import java.util.*;

/*
 *  입력 받은 숫자들을 스택에 넣기
 *  스택에서 꺼내면 숫자들의 왼쪽부터 확인하는 셈
 *  수신 받을 수 있는 타워는 높이가 나보다 크거나 같은 타워만 가능
 *  맨 마지막 스택에서 꺼낸 것은 항상 수신 받을 타워가 없음
 */

public class Main {
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		
		StringBuilder sb = new StringBuilder();
		int [] tower = new int[n];
	    int [] ans = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			tower[i] = Integer.parseInt(st.nextToken());
		}
			
		Stack<Data> s = new Stack<>();
		s.push(new Data(n-1, tower[n-1]));
		
		for(int i=n-2; i>=0; i--){
	           if(s.isEmpty())
	               continue;
	           // 현재 탑의 높이가 top 보다 클 때
	           if(tower[i] > s.peek().height){
	               // 현재 높이보다 작은 탑들 모두 꺼내기
	               while(!s.isEmpty() && tower[i] > s.peek().height){
	                   ans[s.pop().index] = i+1;
	               }
	           }
	           s.add(new Data(i, tower[i]));
	       }
		
		for(int a : ans) {
			sb.append(a).append(" ");
		}
		System.out.println(sb);
	}
}
class Data{
    int index;
    int height;

    public Data(int index, int height){
        this.index = index;
        this.height = height;
    }
}
