package 기본;
import java.util.*;

/**
 * 진수변환
 */
public class Main_진수변환 {


    /**
     * 
     * @param decimal 10진수의 값
     * @param kind 변환할 진수의 값
     * @param result 결과 리턴값
     * @return
     */
    static int convert(int decimal, int kind, char[] result) {

        int digits = 0;
        String digitChar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        do {
            result[digits++] = digitChar.charAt(decimal % kind);
            decimal /= kind;
        } while( decimal != 0 );

        return digits;
    }
  
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int digitNum =0;
        char[] result = new char[32];

        System.out.println("intput decimal value");
        int decimal = sc.nextInt();

        // 10진수 to 2진수
        System.out.println("# 10 to 2 # ");
        digitNum = convert(decimal, 2, result);
        for(int i=digitNum-1; i>=0; i--) {
            System.out.print(result[i]);
        }
        System.out.println();
        
        // 10진수 to 8진수
        System.out.println("# 10 to 8 # ");
        digitNum = convert(decimal, 8, result);
        for(int i=digitNum-1; i>=0; i--) {
            System.out.print(result[i]);
        }
        System.out.println();

        // 10진수 to 16진수
        System.out.println("# 10 to 16 # ");
        digitNum = convert(decimal, 16, result);
        for(int i=digitNum-1; i>=0; i--) {
            System.out.print(result[i]);
        }
        System.out.println();

        sc.close();
    }
}