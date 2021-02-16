import java.util.ArrayList;
import java.util.*;

public class Main_prgm_phoneBook {
    public static void main(String[] args) {


      String [] input = {"123","456","789"};
      boolean result = solution(input);
      System.out.println("result : "+ result);


    
    }
    
    static boolean solution(String[] phone_book) {
       boolean answer = true;

       Arrays.sort(phone_book);
       ArrayList<String> arrayList = new ArrayList<>();

       for (String temp : phone_book) {
          arrayList.add(temp);
       }

       for (int i = 0; i < phone_book.length - 1; i++) {
          ArrayList<String> tempList = new ArrayList<String>(arrayList);
          tempList.remove(phone_book[i]);
          System.out.println("list : " + tempList);
          System.out.println("key : " + phone_book[i]);
          int result = binSearch(tempList, phone_book[i]);
          if (result >= 0) {
             answer = false;
             break;
          }
       }

       return answer;
    }

    static int binSearch(ArrayList<String> list, String key) {
       int startNum = 0;
       int endNum = list.size() - 1;

       do {
          int count = (startNum + endNum) / 2;
          String target = list.get(count);
          int maxCut = target.length() < key.length() ? target.length() : key.length();
          if (target.indexOf(key) == 0) {
             return count;
          } else if (Integer.parseInt(target.substring(0, maxCut)) < Integer.parseInt(key)) {
             startNum = count + 1;
          } else {
             endNum = count - 1;
          }
       } while (startNum <= endNum);

       return -1;
    }
}
