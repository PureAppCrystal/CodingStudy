package 프로그래머스;

// https://programmers.co.kr/learn/courses/30/lessons/1835
// 2	["N~F=0", "R~T>2"]	3648

// {A, C, F, J, M, N, R, T}
// {=, <, >}
public class 단체사진 {

    public static void main(String[] args) {
        int n = 2;
        String[] data = { "N~F=0", "R~T>2" };
        int result = solution2(n, data);
        System.out.println("result : " + result);
    }

    public static int answer = 0;
    public static String[] friends = { "A", "C", "F", "J", "M", "N", "R", "T" };

    
    /**
     * 구글 해설지 참조, 풀기보다는 이해 목적으로 작성
     * @param n
     * @param data
     * @return
     */
    public static int solution2(int n, String[] data) {
        boolean[] isVisited = new boolean[8];
        dfs("", isVisited, data);
        System.out.println(answer);
        return answer;
    }



    public static void dfs(String names, boolean[] isVisited, String[] datas) {
        if (names.length() == 7) {
            if (check(names, datas)) { // 조건만족 체크
                answer++;
            }
            return;
        }
        for (int i = 0; i < 8; i++) { // 조합
            if (!isVisited[i]) {
                isVisited[i] = true;
                String name = names + friends[i];
                dfs(name, isVisited, datas);
                isVisited[i] = false;
            }
        }
    }

    // 조건대로 섰는지 체크
    public static boolean check(String names, String[] datas) {
        for (String data : datas) {
            int position1 = names.indexOf(data.charAt(0)); // 프렌즈 포지션1
            int position2 = names.indexOf(data.charAt(2)); // 프렌즈 포지션2
            char op = data.charAt(3); // 수식
            int index = data.charAt(4) -'0'; // 간격
            if (op == '=') {
                if (!(Math.abs(position1 - position2) == index+1)) return false; //둘 포지션 차이를 구하기 위해선 index+1 을 해야함에 주의
            } else if (op == '>') {
                if (!(Math.abs(position1 - position2) > index+1)) return false;
            } else if (op == '<') {
                if (!(Math.abs(position1 - position2) < index+1)) return false;
            }
        }
        return true;
    }
















    //

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
