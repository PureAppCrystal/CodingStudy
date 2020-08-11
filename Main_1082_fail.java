import java.util.*;

/**
 * 1082
 * 첫째줄 N 개의 숫자의 갯수가 주어진다.
 * 문방구에서 파는 숫자는 0보다 크거나같고 N-1 보다 작거나 같다.
 * N=4 이면 0,1,2,3
 * 둘째줄  각 숫자를 사는데 드는 비용이 작은숫자부터 주어진다. 50보다 작거나 같은 자연수
 * 마지막줄 백은진이 가지고 있는돈 50보다 작거나 같은 수 
 * 
 * -> 기회비용 계산이 되지 않았다.
 * 
 */
public class Main_1082_fail {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if ( N >10 || N < 0) {
            throw new NoSuchElementException();
        }
        
        ArrayList<Integer> arrCard = new ArrayList<Integer>();
        ArrayList<Integer> arrCoast = new ArrayList<Integer>();


        int card = N-1;
        for(int i=card; i>=0; i--){
            arrCard.add(i);
        }
        Collections.sort(arrCard);
        
		
        for(int i=0; i<N; i++) {
            int value = sc.nextInt();
			if(value >= 0 && value <= 50 ) {
                arrCoast.add(value);
			}
        }

        int money = sc.nextInt();


        String result = "";
        int cnt = arrCoast.size() - 1 ;

        while ( cnt >= 0 ) {
            // System.out.println(money+" / "+arrCoast.get(cnt)+" -> " + money / arrCoast.get(cnt));
            if(money / arrCoast.get(cnt) >= 1) {
                result = result + arrCard.get(cnt);
                money = money - arrCoast.get(cnt);
                // System.out.println("result : " + result);
            } else {
                cnt--;
            }
        }

     


        
        // System.out.println("N : " + N);
        // System.out.println("arrCard : " + arrCard);
        // System.out.println("arrCoast : " + arrCoast);
        // System.out.println("money : " + money);
        // System.out.println("result : " + result);
        System.out.println(result);

        sc.close();
    }
}