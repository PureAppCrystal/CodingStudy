
import java.util.*;

public class Main_10809 {

	public static void main(String[] args) {
        
        // 10809 
        // 입력받은 알파벳의 위치를 표현
        // 입력받을 알파벳이 아스키코드를 이용하여 소문자인지 체크 후 해당 문자의 위치를 표현
        // # input
        // hi
        // # output
        // -1 -1 -1 -1 -1 -1 -1 0 1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
		// https://www.acmicpc.net/problem/10809

		Scanner sc= new Scanner(System.in);
		String result = "";
		String input = sc.next();
		try {
			//97~122

			for(int i=97; i<=122; i++) {
				result = result + input.indexOf((char)i) + " ";
			}

			System.out.println(result);
		} catch (Exception e) {

		} finally {
			// if(sc != null) sc.close();
		}
		if(sc != null) sc.close();


	}

}