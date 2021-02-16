import java.util.*;



public class Main_prgm_theif {
    public static void main(String[] args) {

      String [][] input = 	{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
      Integer result = solution(input);
      System.out.println("result : " + result);
    
    }
    
    static int solution(String[][] clothes) {
      int answer = 1;

      Map<String, Integer> clothesMap = new HashMap<>();

      for(int i=0; i<clothes.length; i++ ) {
         clothesMap.put(clothes[i][1], clothesMap.getOrDefault(clothes[i][1], 0) + 1);
      }

      System.out.println("clothesMap : "+ clothesMap);
      for (int val : clothesMap.values()){
         answer = answer * (val+1);
     }

     System.out.println("anwer : " + answer);




       return answer -1;
    }
    
}
