package 백준;
import java.util.*;

/**
 * 11365
 * 글자 리버스
 * END 가 입력될때까지 입력받고 (500자 이하) 그대로 리버싱한다.
 */

public class Main_11365 {

    /**
     * String Reversing
     * 스트링 거꾸로
     */
    static String getStrReverse(String val) {
        String returnValue = "";
        for(int i=val.length() -1; i>=0; i--) {
            returnValue = returnValue + val.charAt(i);
        }
        return returnValue;
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ArrayList<String> arrStr = new ArrayList<String>();

        // 데이터 입력
        while (true) {
            String input = sc.nextLine();
            if (input.equals("END")) {
                break;
            }
            arrStr.add(input);
        }

        // 결과출력
        for(int i=0; i<arrStr.size(); i++) {
            System.out.println(getStrReverse(arrStr.get(i)));
        }

        sc.close();
    }
}