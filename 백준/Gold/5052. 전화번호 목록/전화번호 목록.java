import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		while(t-- > 0){
			ArrayList<String> phone = new ArrayList<>();
			int n = Integer.parseInt(br.readLine());
			boolean flag = false;

			for(int i = 0; i<n; i++){
				String num = br.readLine();
				phone.add(num);
			}

			Collections.sort(phone);

			if(isValid(phone)){
				bw.write("YES\n");
			}else{
				bw.write("NO\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();;
	}
	static boolean isValid(ArrayList<String> phone){
		for(int i = 0; i<phone.size()-1; i++){
			if(phone.get(i+1).startsWith(phone.get(i)))
				return false;
		}
		return true;
	}
}
