import java.util.*;

public class Main_2750 {

	public static void main(String[] args) {
        
        // 2750 
        // 수 정렬하기 
        // # input
        // 5
        // 1 7 3 5 8
        // # output
        // 1 3 5 7 8
		
		Scanner sc=new Scanner(System.in);
		ArrayList<Integer> arrValue = new ArrayList<Integer>();

		int cnt = 0;
		int value = 0;
		cnt = sc.nextInt();
		
		
        for(int i=0; i<cnt; i++) {
			value = sc.nextInt();
			if(value > 0 || value <= 1000) {
				arrValue.add(value);
			}
		}

		Collections.sort(arrValue);
		

		for(int i=0; i<arrValue.size(); i++) {
			System.out.println(arrValue.get(i));
		}

		sc.close();
		
		


	}

}