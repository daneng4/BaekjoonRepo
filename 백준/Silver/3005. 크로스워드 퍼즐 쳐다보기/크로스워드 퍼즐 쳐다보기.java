import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static int r,c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        for(int i = 0; i<r; i++){
            String s = br.readLine();
            for(int j = 0; j<c; j++){
                map[i][j] = s.charAt(j);
            }
        }

        String result = find();
        System.out.println(result);
    }
    static String find(){
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        // 왼쪽 -> 오른쪽 탐색
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                if(map[i][j] != '#'){
                    sb.append(map[i][j]);
                }else{
                    if(sb.length() >= 2){
                        list.add(sb.toString());
                    }
                    sb.setLength(0);
                }
            }
            if(sb.length() >= 2){
                list.add(sb.toString());
            }
            sb.setLength(0);
        }

        sb.setLength(0);
        // 위 -> 아래 탐색
        for(int i = 0; i<c; i++){
            for(int j = 0; j<r; j++){
                if(map[j][i] != '#'){
                    sb.append(map[j][i]);
                }else{
                    if(sb.length() >= 2){
                        list.add(sb.toString());
                    }
                    sb.setLength(0);
                }
            }
            if(sb.length() >= 2){
                list.add(sb.toString());
            }
            sb.setLength(0);
        }

        Collections.sort(list);
        return list.get(0);
    }
}
