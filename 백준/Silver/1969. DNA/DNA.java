import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		ArrayList<String> dnas = new ArrayList<>();
		for(int i = 0; i<n; i++){
			dnas.add(br.readLine());
		}

		int hammingDistance = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<m; i++){
			Map<Character, Integer> cmap = new HashMap<>();
			for(int j = 0; j<n; j++){
				char c = dnas.get(j).charAt(i);
				cmap.put(c, cmap.getOrDefault(c, 0) + 1);
			}

			char targetKey = 'Z';
			int targetValue = 0;
			// key들 중 가장 value가 많은 것이 targetKey
			for(char key : cmap.keySet()){
				if(cmap.get(key) > targetValue){
					targetValue = cmap.get(key);
					targetKey = key;
				}else if(cmap.get(key) == targetValue){
					targetKey = (targetKey - '0' > key - '0' ? key : targetKey);
				}
			}

			hammingDistance += (n-targetValue);
			sb.append(targetKey);
		}

		sb.append("\n").append(hammingDistance);
		System.out.println(sb);
    }
}
