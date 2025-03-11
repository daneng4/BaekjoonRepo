import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        boolean[][] check = new boolean[n][m];
        for(int i = 0; i<n; i++){
            String s = br.readLine();
            for(int j = 0; j<m; j++){
                map[i][j] = s.charAt(j);
            }
        }

        int answer = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(check[i][j])
                    continue;

                if(map[i][j] == '-'){
                    check[i][j] = true;
                    while (j + 1 < m && map[i][j + 1] == '-') {
                        check[i][j + 1] = true;
                        j += 1;
                    }
                    answer += 1;
                }
            }
        }

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(check[j][i])
                    continue;

                if(map[j][i] == '|'){
                    check[j][i] = true;
                    while (j + 1 < n && map[j + 1][i] == '|') {
                        check[j + 1][i] = true;
                        j += 1;
                    }
                    answer += 1;
                }
            }
        }

        System.out.println(answer);
    }
}
