import java.util.*;

public class Main_1069 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> arrResult = new ArrayList<Double>();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (s.isEmpty()) { break; }
            String[] arr;
            arr = s.split(" ");
            
            // double x = sc.nextDouble(); // 
            // double y = sc.nextDouble(); // 
            // double d = sc.nextDouble(); // 점프
            // double t = sc.nextDouble(); // 초
            int x = Integer.parseInt(arr[0]); // 
            int y = Integer.parseInt(arr[1]);
            int d = Integer.parseInt(arr[2]);
            int t = Integer.parseInt(arr[3]);
            
    
    
            // x,y 에서 0,0 으로 오는 시간 최소값 구하기
            //double z = getLine(x,y);
            double z = Math.sqrt(x*x + y*y);
            double cntJump = Math.floor(z / d);
            double rest = z - cntJump*d;
            // System.out.println("z : " + z);
            // System.out.println("cntJump : " + cntJump);
            // System.out.println("rest : " + rest);
            // 1. 걷기만 한 경우
            double result = z;
            // 2. 점프가 포함된 경우
            result = Math.min(result, cntJump * t + rest);
            if(cntJump>0) {
                // 3. 점프가 있다면 오버 점프한것도 확인
                result = Math.min(result, (cntJump+1)*t  );  //+ (d - rest) 왜 오바된 부분은 안빼지? -> 점프를 한번더해서 오바되지 않는거구나 
            } else {
                // 
                // 4. 점프가 없다면 오버점프하고 돌아오는게 짧을 경우 경우 :  점프거리 - 남은거리 + 점프시간
                result = Math.min(result, d - rest + t );
                // 5. 길이가 점프보다 짧을때,  2번 점프한 것이 길이보다 짧으면 2번 점프한게 빠르다
                if( z < d ) {
                    result = Math.min(result, t*2.0);
                }
            }
            
            //System.out.println(result);
            arrResult.add(result);
        }

        for(Double result : arrResult) {
            System.out.println(result);
        }
        sc.close();
    }   

    // 빗변 구하기 
    static double getLine (double a, double b) {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }
}