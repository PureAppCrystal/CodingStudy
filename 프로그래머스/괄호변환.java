package 프로그래머스;

// https://programmers.co.kr/learn/courses/30/lessons/60058
/*

'(' 와 ')' 로만 이루어진 문자열이 있을 경우, '(' 의 개수와 ')' 의 개수가 같다면 이를 균형잡힌 괄호 문자열이라고 부릅니다.
그리고 여기에 '('와 ')'의 괄호의 짝도 모두 맞을 경우에는 이를 올바른 괄호 문자열이라고 부릅니다.
예를 들어, "(()))("와 같은 문자열은 "균형잡힌 괄호 문자열" 이지만 "올바른 괄호 문자열"은 아닙니다.
반면에 "(())()"와 같은 문자열은 "균형잡힌 괄호 문자열" 이면서 동시에 "올바른 괄호 문자열" 입니다.

'(' 와 ')' 로만 이루어진 문자열 w가 "균형잡힌 괄호 문자열" 이라면 다음과 같은 과정을 통해 "올바른 괄호 문자열"로 변환할 수 있습니다.



1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다. 
2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다. 
3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다. 
  3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다. 
4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다. 
  4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다. 
  4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다. 
  4-3. ')'를 다시 붙입니다. 
  4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다. 
  4-5. 생성된 문자열을 반환합니다.


p는 '(' 와 ')' 로만 이루어진 문자열이며 길이는 2 이상 1,000 이하인 짝수입니다.
문자열 p를 이루는 '(' 와 ')' 의 개수는 항상 같습니다.
만약 p가 이미 "올바른 괄호 문자열"이라면 그대로 return 하면 됩니다.
*/

public class 괄호변환 {
    
    public static void main(String[] args) {
        // String input = "(()())()";
        // String input = ")(";
        String input = "()))((()";
        // String input = "))(()(";
        // String input = ")()()()(";

        String result = 균형검사(input);
        System.out.println("result : " + result);
    }

    

    static  String L = "(";
    static String R = ")";
    
  
    public static String 균형검사(String word) {
        System.out.println("=========== 균형검사");
        String returnValue = "";

        // 1 빈문자열 반환
        if (word.length() == 0) {
            return word;
        }

        String u = "";
        String v = "";
        int left = 0;
        int right = 0;

        for (int i = 0; i < word.length(); i++) {
            String c = Character.toString(word.charAt(i));
            if (c.equals(L)) {
                left++;
            } else if (c.equals(R)) {
                right++;
            }

            // 2. w를 u, v 로 분리
            if (left == right) {
                
                // 균형잡힌 문자열
                u = word.substring(0, i + 1);
                // 나머지
                v = word.substring(i + 1, word.length());
                System.out.println("u : " + u);
                System.out.println("v : " + v);

                
                // 3 u가 올바른 문자열
                if (Character.toString(u.charAt(0)).equals(L)) {
                    returnValue = u + 균형검사(v);
                }
                // 4 u가 올바르지 못한 문자열 -> 시작이 ) 면 올바르지 못해
                else {
                     // 4-1, 4-2, 4-3
                     returnValue = L + 균형검사(v) + R;
                     // 4-4 u의 첫번째와 마지막을 제거한 나머지 문자열의 광호 방향을 뒤집어
                     String deletedU = u.substring(1, u.length() - 1);
                     for (int j = 0; j < deletedU.length(); j++) {
                         String unitDeleteU = Character.toString(deletedU.charAt(j));
                         returnValue = returnValue + (unitDeleteU.equals(L) ? R : L);
                     }
                }
                break;
            }
        }

        return returnValue;
    }
    


}
