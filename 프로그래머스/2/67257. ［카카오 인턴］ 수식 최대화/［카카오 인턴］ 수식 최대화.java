import java.util.*;
class Solution {

    public long solution(String expression) {

        String[][] priority = {
            {"+","-","*"},
            {"+","*","-"},
            {"-","+","*"},
            {"-","*","+"},
            {"*","+","-"},
            {"*","-","+"}
        };

        long answer = 0;

        List<Long> numbers = new ArrayList<>();
        List<String> ops = new ArrayList<>();

        String num = "";

        for(char c : expression.toCharArray()) {
            if(Character.isDigit(c)) {
                num += c;
            } else {
                numbers.add(Long.parseLong(num));
                num="";
                ops.add(String.valueOf(c));
            }
        }
        numbers.add(Long.parseLong(num));

        for(String[] p : priority) {

            List<Long> nums = new ArrayList<>(numbers);
            List<String> opers = new ArrayList<>(ops);

            for(String op : p) {

                for(int i=0;i<opers.size();) {

                    if(opers.get(i).equals(op)) {

                        long a = nums.get(i);
                        long b = nums.get(i+1);
                        long result = 0;

                        if(op.equals("+")) result = a+b;
                        if(op.equals("-")) result = a-b;
                        if(op.equals("*")) result = a*b;

                        nums.set(i,result);
                        nums.remove(i+1);
                        opers.remove(i);

                    } else i++;
                }
            }

            answer = Math.max(answer, Math.abs(nums.get(0)));
        }

        return answer;
    }
}