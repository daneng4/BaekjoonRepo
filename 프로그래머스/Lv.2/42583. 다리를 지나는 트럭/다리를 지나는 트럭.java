import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
		Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<bridge_length; i++) {
        	q.add(0);
        }
        
        // 0, 0 으로 q 초기화
        int curW = 0;
        int idx = 0;
        int turn = 0;
        while(true) {
        	curW -= q.poll();
        	// 현재 무게가 제한 무게를 초과하지 않고 idx가 트럭 배열보다 작으면
        	if(curW + truck_weights[idx] <= weight && idx < truck_weights.length) {
        		q.add(truck_weights[idx]);
        		if(idx == truck_weights.length - 1) {
        			answer++;
        			break;
        		}
        		curW += truck_weights[idx];
        		idx++;
        	}else
        		q.add(0);
        	answer++;
        }
		return answer + bridge_length;
    }
}