import java.io.*;
import java.util.*;

public class Main {

    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i<n-1; i++){
            for(int j = i+1; j<n; j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for(int i = 0; i<arr.length; i++){
            System.out.println(arr[i]);
        }

    }
}
