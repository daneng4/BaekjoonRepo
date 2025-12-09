import java.io.*;
import java.util.*;

public class Main {
    static int L;
    static int C;
    static ArrayList<Code> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<C; i++){
            char c = st.nextToken().charAt(0);
            list.add(new Code(c, false));
        }

        Collections.sort(list);
        process("", 0, 0);
    }

    private static void process(String str, int length, int pointer){
        // 문자열을 완성했다면 검사
        if(length == L){
            check(str);
            return;
        }

        for(int i = pointer; i<list.size(); i++){
            if(list.get(i).used)
                continue;

            list.get(i).used = true;
            process(str + list.get(i).alphabet, length + 1, i + 1);
            list.get(i).used = false;
        }

    }

    private static void check(String str){
        int moum = 0;
        int jaum = 0;

        for(int i = 0; i<str.length(); i++){
            char alphabet = str.charAt(i);
            if(alphabet == 'a' || alphabet == 'e' || alphabet == 'i' || alphabet == 'o' || alphabet == 'u')
                moum++;
            else
                jaum++;
        }

        if(moum >= 1 && jaum >= 2){
            System.out.println(str);
        }
    }

    static class Code implements Comparable<Code>{
        char alphabet;
        boolean used;

        public Code(char alphabet, boolean used){
            this.alphabet = alphabet;
            this.used = used;
        }

        // 알파벳 오름차순 정렬을 위한 메서드
        @Override
        public int compareTo(Code o) {
            return this.alphabet - o.alphabet;
        }
    }
}