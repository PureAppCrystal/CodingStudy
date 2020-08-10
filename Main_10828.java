
import java.util.*;

public class Main_10828 {

	public static void main(String[] args) {
        
        // 10828
        // 스택 구현
        // 명령어 갯수를 입력후, push/pop/size/empty/top 명령어를 이용해서 입력및 데이터 조회
        // # input
        // 5
        // push 3
        // pop
        // top
        // empty
        // # output
        // 3 / -1 / 1 


        ArrayList<Integer> arrResult = new ArrayList<Integer>();
        ArrayList<Integer> stack = new ArrayList<Integer>();

        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        
        try {
	
			for(int i=0; i<cnt; i++) {
				String cmd = sc.nextLine();
	
				if(cmd.contains("push")  ) {
					int value = Integer.parseInt(cmd.substring(5));
					//System.out.println("value : " + value);
					stack.add(value);
				} else if(cmd.contains("pop")  ) {
					if(stack.size() == 0 ) {
						arrResult.add(-1);
					} else {
						arrResult.add(stack.get(stack.size()-1));
						stack.remove(stack.size()-1);
	
					}
				} else if(cmd.contains("size")) {
					arrResult.add(stack.size());
				} else if(cmd.contains("empty")) {
					arrResult.add(stack.size() == 0 ? 1 : 0);
				} else if(cmd.contains("top")) {
					arrResult.add(stack.size() == 0 ? -1 : stack.get(stack.size()-1));
				}
			}
			
	
			for(int i=0; i<arrResult.size(); i++) {
				System.out.println(arrResult.get(i));
			}

		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {

			if (sc!=null)sc.close();
		}



	}

}