package 백준;
import java.util.*;

public class Main_15122 {

    public static void main(String[] args) {
        
        // 15122
        // 0을 배운적이 없어.
        // 내가 숫자를 입력하면 다음 숫자를 출력하는데 0이 있으면 안되 -> 0이 없는 다음숫자를 보여줘야해

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        if( input < 1 || input > 999999) {
            sc.close();
            throw new NoSuchElementException();
        }

        while(true) {
            ++input;
            String str = Integer.toString(input);

            if ( !str.contains("0") ) {
                break;
            }
        }

        System.out.println(input);
        sc.close();
    }
}