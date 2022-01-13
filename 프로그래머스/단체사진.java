package 프로그래머스;

// https://programmers.co.kr/learn/courses/30/lessons/1835
// 2	["N~F=0", "R~T>2"]	3648

// {A, C, F, J, M, N, R, T}
// {=, <, >}
public class 단체사진 {

    public static void main(String[] args) {
        int n = 2;
        String[] data = { "N~F=0", "R~T>2" };

        int result = solution(n, data);
        System.out.println("result : " + result);
    }

    public static int solution(int n, String[] data) {
        int answer = 0;

        System.out.println("n : " + n);
        for (String condition : data) {
            System.out.println("condition : " + condition);
        }

        System.out.println(factorial(4));
        System.out.println(factorial(8));
        
        //N, F, R, ?, ?, ?, T, ?    factorial(4)
        //N, F, R, ?, ?, ?, ?, T    factorial(4)
        //?, N, F, R, ?, ?, ?, T    factorial(4)
        //R, N, F, T, ?, ?, ?, ?    factorial(4)
        //R, ?, N, F, T, ?, ?, ?    factorial(4)
        //R, ?, ?, N, F, T, ?, ?    factorial(4)
        //R, ?, ?, ?, N, F, T, ?    factorial(4)
        //R, ?, ?, ?, ?, N, F, T    factorial(4)
        //?, R, ?, ?, ?, N, F, T    factorial(4)
        //?, ?, R, ?, ?, N, F, T    factorial(4)
        //?, ?, ?, R, ?, N, F, T    factorial(4)




        return answer;
    }

    public static int factorial(int num) {
        if (num == 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }
}
