import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] buildings = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            int building = Integer.parseInt(st.nextToken());
            buildings[i] = building;
        }

        int answer = 0;

        // 기울기 = y변화량/x변화량
        for(int i = 1; i<=N; i++){
            int count = getCount(i, buildings, N);

            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }

    private static int getCount(int idx, int[] buildings, int N) {
        int count = 0;
        double preLean = 0;

        // 현재 빌딩 (I) 의 왼쪽 빌딩 체크
        for(int j = idx - 1; j >= 1; j--){
            double curLean = (double) (buildings[idx] - buildings[j]) / (idx - j);

            if(j == idx - 1 || preLean > curLean){
                count++;
                preLean = curLean;
            }
        }

        // 현재 빌딩 (I) 의 오른쪽 빌딩 체크
        for(int j = idx + 1; j <= N; j++){
            double curLean = (double) (buildings[idx] - buildings[j]) / (idx - j);

            if(j == idx + 1 || preLean < curLean){
                count++;
                preLean = curLean;
            }
        }
        return count;
    }
}