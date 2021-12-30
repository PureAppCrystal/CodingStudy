package 프로그래머스;
import java.util.*;

//https://programmers.co.kr/learn/courses/30/lessons/12985?language=javascript
public class 예상대진표 {
    



    public static void main(String[] args) {

        
        int result = solution( (int)Math.pow(2, 20),4, 1);
        System.out.println("result : " + result);
    }


    /**
     * 
     * @param n 참가자의 수.  2^1 ~ 2^20
     * @param a 첫번재 대상의 index. n 이하의 자연수
     * @param b 두번째 대상의 index. n 이하의 자연수. a != b
     * @return a와 b 가 만나게 되는 라운드의 수
     */
    public static int solution(int n, int a, int b) {
        int answer = 0;

        if(a > b ) {
            int temp = a;
            a = b;
            b = temp;
        }

        // n 이 2의 몇제곱인지 -> 몇게임까지 있는지 계산
        int gameCount = 몇승구하기(n, 2, 0);
        System.out.println("maxGameCount : " + gameCount);

        // 중간값으로부터 분리되어 있는지 체크
        while(true) {

            int midValue = n / 2;
            System.out.println("midValue : " + midValue);
            if( a <= midValue && midValue < b)  {
                System.out.println("left and mid seperated");
                answer = gameCount;
                break;
            } else {
                // 일치하지 않아 반복되야해
                if( midValue < a) {
                    a = a - midValue;
                    b = b - midValue;
                }    
                n = n / 2 ;
                gameCount = gameCount - 1;
            }
        }

        return answer;
    }

    public static int 몇승구하기 (int targetNum, int divNum, int count) {
        int returnValue = 0;
        if ( targetNum % divNum != 0 ){
            returnValue = count;
        } else {
            count += 1;
            returnValue = 몇승구하기(targetNum / divNum, divNum, count);
        }
        return returnValue;
    }

    /**
     * 
     * @param n 참가자의 수.  2^1 ~ 2^20
     * @param a 첫번재 대상의 index. n 이하의 자연수
     * @param b 두번째 대상의 index. n 이하의 자연수. a != b
     * @return a와 b 가 만나게 되는 라운드의 수
     * 첫번재 완전 하드 로직 -> 시간초과
     */
    public static int solution_1(int n, int a, int b) {
        int answer = 0;
        System.out.println("Hello Java");

        System.out.println("n : " + n);
        System.out.println("a : " + a);
        System.out.println("b : " + b);


        int gameCount = 0;
        ArrayList<Integer> checkList = new ArrayList<Integer>();
        ArrayList<Integer> newList = new ArrayList<Integer>();
        for(int i = 1; i<=n; i++) {
            checkList.add(i);
        }
        while(true) {
            
            gameCount = gameCount + 1;
            
            
            
            System.out.println("checkList : " + checkList);
    
            int checkIndex = 0;
            while(checkIndex < checkList.size()) {
                System.out.println("============= game " + gameCount + " =================");
                System.out.println("checkList.size() : " + checkList.size());
                System.out.println("checkIndex : "+ checkIndex);
                int left = checkList.get(checkIndex);
                int right = checkList.get(checkIndex == checkList.size()-1 ? checkIndex : checkIndex + 1);
                System.out.println("left : " + left + ", right : " + right);
                int result = fight(left, right, a, b);
                System.out.println("result : " + result);
                
                if (result != 0 ) {
                    System.out.println("add");
                    newList.add(result);
                } else {
                    System.out.println("answer : " + answer);
                    answer = gameCount;
                    break;
                }
                checkIndex = checkIndex + 2;
            }
            // checkList = new ArrayList<Integer>();
            checkList = newList;
            newList = new ArrayList<Integer>();
            

            if(answer != 0 ) {
                break;
            }
        }
        
        return answer;
    }

    public static int fight(int left, int right, int a, int b) {
        int returnValue = 0;
        if(left == a && right == b) {
            returnValue = 0;
        } else if ( left == a || right == a) {
            returnValue = a;
        } else if ( left == b || right == b) {
            returnValue = b;
        } else {
            returnValue = left;
        }
        return returnValue ;
    }

}
