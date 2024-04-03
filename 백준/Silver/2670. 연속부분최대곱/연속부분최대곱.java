
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static double[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new double[n];
		arr[0] = Double.parseDouble(br.readLine());
		double max = arr[0];
		
		for(int i = 1; i<n; i++) {
			double num = Double.parseDouble(br.readLine());
			double num2 = arr[i-1] * num;
			arr[i] = Math.max(num, num2);
			max = Math.max(max, arr[i]);
		}
		
		
		System.out.println(String.format("%.3f", max));
	}
}