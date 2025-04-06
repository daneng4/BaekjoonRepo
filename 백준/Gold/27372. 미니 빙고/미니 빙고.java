import java.io.*;
import java.util.*;

public class Main {
    static char[] cArr;
    static char[][] map;
    static boolean[] used;
    static String TS;
    static boolean find;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            String origin = br.readLine();
            cArr = origin.toCharArray();
            map = new char[3][3];
            used = new boolean[origin.length()];
            find = false;

            Arrays.sort(cArr);

            for(int i = 0; i<3; i++){
                String s = br.readLine();
                for(int j = 0; j<3; j++){
                    map[i][j] = s.charAt(j);
                }
            }

            TS = checkScore(origin);
            sb.append(TS).append(" ");
            makeSentence(0, "");
        }

        System.out.println(sb);
    }
    public static void makeSentence(int count, String sentence){
        if(find)
            return;
        if (count == 9) {
            String ts = checkScore(sentence);
            if(TS.equals(ts)){
                sb.append(sentence).append("\n");
                find = true;
            }
            return;
        }

        for(int i = 0; i<cArr.length; i++){
            if(!used[i]){
                used[i] = true;
                makeSentence(count + 1, sentence + cArr[i]);
                used[i] = false;
            }
        }
    }

    public static String checkScore(String sentence){
        boolean[][] checked = new boolean[3][3];
        StringBuilder scoreSb = new StringBuilder();
        int preScore = 0;

        for(int i = 0; i<sentence.length(); i++){
            char c = sentence.charAt(i);

            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 3; k++){
                    if(map[j][k] == c){
                        checked[j][k] = true;
                        int curScore = cal(checked);
                        scoreSb.append(curScore - preScore);
                        preScore = curScore;
                    }
                }
            }
        }

        return scoreSb.toString();
    }

    public static int cal(boolean[][] checked){
        int score = 0;

        for(int i = 0; i<3; i++){
            if(checked[i][0] && checked[i][1] && checked[i][2])
                score += 1;
            if(checked[0][i] && checked[1][i] && checked[2][i])
                score += 1;
        }

        if(checked[0][0] && checked[1][1] && checked[2][2])
            score += 1;

        if(checked[2][0] && checked[1][1] && checked[0][2])
            score += 1;

        return score;
    }
}
