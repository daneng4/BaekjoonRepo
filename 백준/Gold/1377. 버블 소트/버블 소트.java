import java.io.*;
import java.util.*;

public class Main {
	static class Data implements Comparable<Data>{
		int value;
		int index;
		public Data(int value, int index){
			this.value = value;
			this.index = index;
		}
		public int compareTo(Data d){
			return this.value - d.value;
		}
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Data[] a = new Data[n];
		for(int i = 0; i<n; i++){
			a[i] = new Data(Integer.parseInt(br.readLine()), i);
		}
		Arrays.sort(a);
		int max = 0;
		for(int i = 0; i<n; i++){
			int preIdx = a[i].index;
			max = Math.max(preIdx-i, max);
		}

		System.out.println(max + 1);
    }
}
