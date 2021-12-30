package 프로그래머스;
import java.util.*;



 /**
  * 어떤 수 a를 b제곱한 결과를 구하는 것은 어렵지 않습니다. 하지만 컴퓨터에서 저장할 수 있는 숫자의 크기에는 제한이 있기 때문에 끝의 5자리만을 저장하기로 하였습니다. a, b가 주어질 때, a를 b제곱하여 끝의 5자리를 반환하도록 solution함수를 완성하세요. 단, 5자리 중 가장 앞부분의 0들은 반환하지 않아도 됩니다.
  */
public class Main_prgm_lotte_q2 {
    public static void main(String[] args) {

        int [] input = 	{2, 1, 3, 3};
        int[] result = solution(input);
        System.out.println("result : " + result);
    }
    
    static public int[] solution(int[] arr) {
        int answer[] = {0};
        Arrays.sort(arr);
        
        return answer;
    }
}

/**
 * 
   function sol(a,b) {
        var answer = 1;
            while(b > 0) {
                b = b -1;
                answer = multi(a,b, answer);
            }
    
    
    
    
        return answer;
    }

    function multi(a,b, result) {


  
  
  
        result = result * a;
        var temp = String(result);

        if (temp.length > 4 ) {
            temp = temp.substring(temp.length-4, temp.length);

        }
        result = parseInt(temp);

        return result;
    }

 * 
 */