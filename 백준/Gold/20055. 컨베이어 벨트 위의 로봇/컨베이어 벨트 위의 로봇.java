import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Belt> belt;
	static int n,k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		belt = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<2*n; i++) {
			int durab = Integer.parseInt(st.nextToken());
			belt.add(new Belt(durab, false));
		}
		
		// 로봇은 올리는 위치에만 올릴 수 있고 내리는 위치에만 내릴 수 있다.
		// 올리는 위치는 0, 내리는 위치는 n-1이다.
		int count = 0;
		// count == k이면 종료
		while(isok()) {
			moveBelt();
			moveRobot();
			putRobot();
			
			count++;
		}
		
		System.out.println(count);
	}
	public static void moveBelt() {
		Belt temp = belt.get(belt.size()-1);
		belt.remove(belt.size()-1);
		belt.add(0, temp);
		
		belt.get(n-1).isrobot = false;
		belt.get(0).isrobot = false;
	}
	public static void moveRobot() {
		for(int i = n-1; i>0; i--) {
			// 이동하려는 곳의 내구도가 1이상이고, 로봇이 없다면
			if(belt.get(i-1).isrobot && belt.get(i).durab >= 1 && !belt.get(i).isrobot) {
				// 해당 칸 내구도 감소
				--belt.get(i).durab;
				belt.get(i).isrobot = true;
				belt.get(i-1).isrobot = false;
			}
		}
		
	}
	public static void putRobot() {
		if(belt.get(0).durab > 0) {
			belt.get(0).isrobot = true;
			--belt.get(0).durab;
		}
	}
	public static boolean isok() {
		int count = 0;
		for(int i = 0; i<belt.size(); i++) {
			if(belt.get(i).durab == 0) {
				count++;
			}
			if(count >= k) {
				return false;
			}
		}
		return true;
	}
}
class Belt{
	int durab;
	boolean isrobot;
	public Belt(int durab, boolean isrobot) {
		this.durab = durab;
		this.isrobot = isrobot;
	}
}