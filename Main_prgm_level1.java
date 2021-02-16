import java.util.ArrayList;

public class Main_prgm_level1 {
    public static void main(String[] args) {

        boolean answer = true;
        int x = 30;
        int sum = 0;

        
        String[] list = Integer.toString(x).split("");
       

        for ( String item : list) {
            sum = sum + Integer.parseInt(item);
        }

        if (x % sum == 0) {
            answer = true;
        } else {
            answer = false;
        }
        
        System.out.println(answer);
    }
    
}
