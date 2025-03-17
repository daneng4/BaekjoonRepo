import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] map = new char[r][c];
        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i<r; i++){
            String s = br.readLine();
            for(int j = 0; j<s.length(); j++){
                map[i][j] = s.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                if(map[i][j] != '#'){
                    sb.append(map[i][j]);
                }else{
                    if(sb.length() <= 1){
                        sb.setLength(0);
                    }else{
                        list.add(sb.toString());
                        sb.setLength(0);
                    }
                }

            }
            if(sb.length() <= 1){
                sb.setLength(0);
                continue;
            }
            list.add(sb.toString());
            sb.setLength(0);
        }

        for(int i = 0; i<c; i++){
            for(int j = 0; j<r; j++){
                if(map[j][i] != '#'){
                    sb.append(map[j][i]);
                }else{
                    if(sb.length() <= 1){
                        sb.setLength(0);
                    }else{
                        list.add(sb.toString());
                        sb.setLength(0);
                    }
                }
            }
            if(sb.length() <= 1){
                sb.setLength(0);
                continue;
            }
            list.add(sb.toString());
            sb.setLength(0);
        }

        Collections.sort(list);
        System.out.println(list.get(0));
    }
}
