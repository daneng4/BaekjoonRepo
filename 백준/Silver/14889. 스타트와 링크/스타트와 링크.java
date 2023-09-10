import java.io.*;
import java.util.*;


public class Main {

    static int[][] map; // 능력치 표 배열
    static int n; // 모인 사람 수
    static boolean[] visited; // 방문 정보 저장 배열
    static int min = Integer.MAX_VALUE; // 최소 값을 저장하기 위해 정수 최대 값 저장
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n];

        // 능력치 표 배열에 능력치들 입력하기
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        function(0,0);
        System.out.println(min);
    }
    static void function(int index, int count){
        if(count == n/2){
            // count == n/2 ---> 팀 구성이 완료된 시점
            getDiff(); // 팀원 전력차를 구하기 위한 메서드
            return; // 재귀 함수 탈출
        }

        for(int i=index; i<n; i++){
            if(!visited[i]){ // 만약 해당 index 선수를 방문(팀으로 영입) 하지 않았다면
                visited[i] = true; // 방문 처리를 해주고
                function(i+1, count+1);
                visited[i] = false; // 연산을 마치고 비 방문 (false) 처리
            }
        }
    }

    static void getDiff(){

        int start = 0; // 각 팀의 전투력을 더하기 위한 변수
        int link = 0;

        // pair 전투력 측정은 언제나 2명씩 되기 마련
        // 1,2,3 팀이면 (1,2) (2,3) (1,3)..
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                if(visited[i] && visited[j]){ // visited = true인 선수는 start팀
                    start += map[i][j];
                    start += map[j][i];
                }else if(!visited[i] && !visited[j]){ // 그 외 선수는 link팀
                    link += map[i][j];
                    link += map[j][i];
                }
            }
        }

        //만약 이미 전투력 차가 0인 경우
        int val = Math.abs(start - link);
        if (val == 0) {
            System.out.println(val);
            System.exit(0);
        }

        // 아니면 전역 변수로 선언한 최솟값 min을 갱신한다
        min = Math.min(val, min);

    }
}