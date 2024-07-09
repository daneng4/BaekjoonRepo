class Solution {
    public int solution(int num1, int num2) {
        double a = (double) num1;
        double b = (double) num2;
        double answer = a / b * 1000;
        return (int)answer;
    }
}