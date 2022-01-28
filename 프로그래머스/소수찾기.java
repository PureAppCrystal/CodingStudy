package 프로그래머스;

import java.util.ArrayList;

// https://programmers.co.kr/learn/courses/30/lessons/42839

public class 소수찾기 {

    public static void main(String[] args) {

        numbers = "002";
        boolean[] isVisited = new boolean[numbers.length()];
        dfs("", isVisited);
        System.out.println(answer);
    }
        
    public static String numbers;
    public static int answer = 0;
    // 결과값을 저장하는 곳 
    public static ArrayList<Integer> arrList = new ArrayList<Integer>();
    

    public static void dfs(String number, boolean[] isVisited) {

        if (number.length() > 0 && 소수검사(Integer.parseInt(number))) {
            answer++;
        }
        
        // 모든 조합 만들기
        for (int i = 0; i < numbers.length(); i++) {
            if (isVisited[i] == false) {
                isVisited[i] = true;
                String name = number + Character.toString(numbers.charAt(i));
                dfs(name, isVisited);
                isVisited[i] = false;
            }
        }
    }

    public static boolean 소수검사(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        // 결과값 중복 방지
        if (arrList.indexOf(number) >= 0) {
            return false;
        }
        arrList.add(number);

        return true;
    }
    
    
}
