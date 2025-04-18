import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = convertToMinute(st.nextToken());
        int e = convertToMinute(st.nextToken());
        int q = convertToMinute(st.nextToken());


        Map<String, Integer> list = new HashMap<>();
        int answer = 0;
        String input = "";
		while ((input = br.readLine()) != null && !input.isEmpty()) {
			st = new StringTokenizer(input);
			String timeStr = st.nextToken();
			int time = convertToMinute(timeStr);
			String name = st.nextToken();

			if (time <= s) {
				list.put(name, 1);
			}
			if (time >= e && time <= q) {
				if(list.get(name) != null){
					answer++;
					list.remove(name);
				}
			}
		}

        System.out.println(answer);
    }
    static int convertToMinute(String time){
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}
