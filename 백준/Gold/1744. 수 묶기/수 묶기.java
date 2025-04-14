import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> underOne = new ArrayList<>();
        ArrayList<Integer> overZero = new ArrayList<>();

        for(int i = 0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            if(num <= 0){
                underOne.add(num);
            }
            else
                overZero.add(num);
        }
        Collections.sort(underOne);
        overZero.sort(Collections.reverseOrder());

        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int num : underOne){
            if(stack.isEmpty()){
                stack.push(num);
            }else{
                answer += stack.pop() * num;
            }
        }
        while(!stack.isEmpty()){
            answer += stack.pop();
        }

        for(int num : overZero){
            if(num == 1){
                answer += num;
                continue;
            }
            if(stack.isEmpty()){
                stack.push(num);
            }else{
                answer += stack.pop() * num;
            }
        }
        while(!stack.isEmpty()){
            answer += stack.pop();
        }

        System.out.println(answer);
    }
}
