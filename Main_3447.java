import java.util.*;


/**
 * 3447
 * BUG를 삭제하는 알고리즘
 * 재귀문자 사용
 */
public class Main_3447 {
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while ( sc.hasNextLine() ) {
            String line = removeBug(sc.nextLine());
            System.out.println(line);
        }
        sc.close();
    }

    static String removeBug(String str) {
        str = str.replace("BUG", "");    
        if ( str.indexOf("BUG") > -1) {
            str = removeBug(str);
        } 
        return str;
    }
}