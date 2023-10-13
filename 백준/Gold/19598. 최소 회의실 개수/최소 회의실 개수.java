import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        List<int[]> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.add(new int[]{start, end});
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        pq.offer(list.get(0)[1]);
        int count = 1;

        for(int i = 1; i<n; i++){
            while(!pq.isEmpty() && pq.peek() <= list.get(i)[0]){
                pq.poll();
            }
            pq.offer(list.get(i)[1]);
            count = Math.max(count, pq.size());
        }


        System.out.println(count);
    }
}