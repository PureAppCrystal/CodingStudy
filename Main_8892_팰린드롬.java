import java.util.*;


/**
 * 8892
 * 팰린드롬
 * 케이스 갯수 T 
 * 1<= K <= 100 개의 단어가 있다.
 * 두 단어를 합성하여 팰린드롬이 있는지 체크한다.
 * 단어는 a 부터 z까지 알파벳
 * 있다면 아무거나 출력, 없으면 0을 출력
 */

public class Main_8892_팰린드롬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        ArrayList<String> result = new ArrayList<String>();
        for(int i=0; i<T; i++) {
            int K = sc.nextInt();
            if(K<1 || K>100) {
                sc.close();
                throw new NoSuchElementException();
            }

            ArrayList<String> arrInput = new ArrayList<String>();
            for(int j=0; j<K; j++) {
                arrInput.add(sc.next());
            }

            String data ="0";
            loop:
            for(int k=0; k<arrInput.size(); k++) {
                for(int l=0; l<arrInput.size(); l++){
                    if( k==l) {
                        continue;
                    }
                    String item = arrInput.get(k) + arrInput.get(l);
                    data = palindrome(item);
                    if(!data.equals("0") ) {
                        break loop;
                    }
                    item = arrInput.get(l) + arrInput.get(k);
                    data = palindrome(item);
                    if(!data.equals("0") ) {
                        break loop;
                    }
                }
            }
            result.add(data);
        }

        for(String item : result) {
            System.out.println(item);
        }

        sc.close();
    }

    // 팰린드롬 함수 
    private static String palindrome(String str) {

        boolean match = true;
        double stdNo = Math.ceil(str.length() /2);
        int j= str.length()-1;

        for(int i=0; i<=stdNo; i++ , j--) {
            if (str.charAt(i) != str.charAt(j) ) {
                match = false;
            }
        } 
        return match ? str : "0";
    } 
}