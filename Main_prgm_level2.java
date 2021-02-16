import java.util.ArrayList;

public class Main_prgm_level2 {
    public static void main(String[] args) {

       String phoneNumber = "01033334444";
       String answer = "";

       String reverseNumber = new StringBuilder(phoneNumber).reverse().toString();


    //    String[] list = reverseNumber.split("");
    //    int count = 0;
    //    for (String item : list) {
    //     if(count < 4) {
    //         answer = answer + item;
    //     } else {
    //         answer = answer + "*";
    //     }
    //     count++;
    //    }

    //    answer = new StringBuilder(answer).reverse().toString();
    //    System.out.println(answer); 

       
       StringBuffer sb = new StringBuffer(reverseNumber);
       sb.replace(4, reverseNumber.length(), "*");
       sb.toString();

       answer = sb.reverse().toString();
       System.out.println(answer);
    
    }
    
}
