import java.util.*;
import java.io.*;

class Solution {
    static int[][] arr;
    public int[] solution(int rows, int columns, int[][] queries) {
        
        arr = new int[rows][columns];
        int num = 1;
        // 배열에 rows X columns 만큼 숫자 삽입
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<columns; j++){
                arr[i][j] = num;
                num ++;
            }
        }
        int[] answer = new int[queries.length];
        for(int i = 0; i<queries.length; i++){
            answer[i] = function(queries[i]);
        }
        return answer;
    }
    
    public static int function(int[] queries){
        int x1 = queries[0]-1; int y1 = queries[1]-1;
        int x2 = queries[2]-1; int y2 = queries[3]-1;
        int saveNum = arr[x1][y2]; // 덮어 쓸 숫자
        int minNum = saveNum; // 덮어 쓸 숫자를 최소 숫자로 설정
        
        // 상단 숫자들 우측으로 이동
        for(int i = y2-1; i>=y1; i--){
            minNum = Math.min(minNum, arr[x1][i]);
            arr[x1][i+1] = arr[x1][i];
        }
        
        // 좌측 숫자들을 위로 이동
        for(int i = x1+1; i<=x2; i++){
            minNum = Math.min(minNum, arr[i][y1]);
            arr[i-1][y1] = arr[i][y1];
        }
        
        // 하단 숫자들을 좌측으로 이동
        for(int i = y1+1; i <= y2; i++){
            minNum = Math.min(minNum, arr[x2][i]);
            arr[x2][i-1] = arr[x2][i];
        }
        
        // 우측 숫자들을 아래로 이동
        for(int i = x2-1; i >= x1; i--){
            minNum = Math.min(minNum, arr[i][y2]);
            arr[i+1][y2] = arr[i][y2];
        }
    
        arr[x1+1][y2] = saveNum;
        
        int answer = minNum;
        return answer;
    }
}