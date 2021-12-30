package 백준;
import java.util.*;

/**
 * 백준 4563
 * 리벤지 오브 피타고라스
 * a의 길이가 주어졌을때 b와 c가 자연수로 이루어질 수 있는 경우의 수 구하기
 * -> 어떡해 풀는지 정확한 공식 이해 못했다.
 * a2 + b2 = c2  ->>     a2 = b2 -c2    ->>  a2 = (b+c)(c-b)
 * a2 은 x*y 라  a 를 12라 할때  x * y = 144 가 되야하니 144의 약수를 구하고...
 * temp을 왜  2로 나누었을까? 그 리고 b-temp 가 어떡해 b 값이 됬을까 ?
 */

public class Main_4563 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> arrInt = new ArrayList<Double>();
        
        
        while(true) {
            Double input = sc.nextDouble();
            if(input == 0 ) { 
                break;
            } 
            arrInt.add(input);
        }

        for(Double a : arrInt) {
            // System.out.println("======= a : " + a);
            int result = 0;    
            double squ = a * a;
            double b, c =0;
            for(int i = 1; i< a; i++) {
                // System.out.println("----i : " + i);
                if(squ % i == 0) {
                    b = squ / i;
                    c = i;

                    
                    double temp = b + c;
                    if(temp % 2 == 0) {
                        temp /= 2;
                        
                        if (b - temp > a ){
                            // System.out.println("b : " + (b-temp));
                            // System.out.println("c : " + c);
                            // System.out.println("inc");
                            result++;
                        }
                    }
                }
            }
            System.out.println(result);
        }

        
        
            
           


        sc.close();
    }
}