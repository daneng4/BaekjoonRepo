import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int[][] d = {{0,1}, {1,0}, {1,1}, {-1,1}};
    public static void main(String[] args) throws Exception  {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[19][19];

        // map 정보 저장
        for(int i = 0; i<19; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<19; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        // 바둑 돌의 위치 정보를 기준으로 탐색
        for(int j = 0; j<19; j++){
            for(int i = 0; i<19; i++){
                if(map[i][j] == 1 || map[i][j] == 2){
                    for(int k = 0; k<4; k++){
                        int nx = i;
                        int ny = j;
                        int count = 1;

                        while(true){
                            nx = nx+d[k][0];
                            ny = ny+d[k][1];

                            if(0<= nx && nx < 19 && 0<= ny && ny < 19){
                                if(map[i][j] == map[nx][ny])
                                    count++;
                                else
                                    break;
                            } else
                                break;
                        }

                        nx = i;
                        ny = j;

                        while(true){
                            nx = nx - d[k][0];
                            ny = ny - d[k][1];

                            if(0<= nx && nx < 19 && 0<= ny && ny < 19){
                                if(map[i][j] == map[nx][ny])
                                    count++;
                                else
                                    break;
                            } else
                                break;
                        }
                        if(count == 5){
                            System.out.println(map[i][j]);
                            System.out.printf("%d %d", i+1, j+1);
                            return;
                        }

                    }
                }

            }

        }

        System.out.println(0);

    }

}
