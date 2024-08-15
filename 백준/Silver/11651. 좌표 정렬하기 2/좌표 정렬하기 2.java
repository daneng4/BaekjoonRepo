
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		List<Point> list = new ArrayList<>();
		StringTokenizer st;
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list.add(new Point(x,y));
		}
		
		Collections.sort(list);
		
		for(Point p : list) {
			bw.write(p.x + " " + p.y +"\n");
		}
		
		bw.flush();
	}

}
class Point implements Comparable<Point>{
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int compareTo(Point p) {
		if(this.y == p.y)
			return this.x - p.x;
		return this.y - p.y;
	}
}