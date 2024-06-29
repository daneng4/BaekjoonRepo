
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int startx = 0;
		int starty = 0;
		int myx = Integer.parseInt(st.nextToken());
		int myy = Integer.parseInt(st.nextToken());
		int endx = Integer.parseInt(st.nextToken());
		int endy = Integer.parseInt(st.nextToken());
		
		int min = Integer.MAX_VALUE;
		min = Math.min(myx - startx, min);
		min = Math.min(myy - starty, min);
		min = Math.min(endx - myx, min);
		min = Math.min(endy - myy, min);
		
		System.out.println(min);
	}
}