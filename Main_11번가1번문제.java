import java.util.*;

public class Main_11번가1번문제 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        String S ="BAONXXOLL";
        S = S.toUpperCase();
        final String word = "BALLOON";
        int [] arrWord = new int[word.length()];;
        ArrayList<Integer> arrS = new ArrayList<Integer>();
        int result = 0;
        
        for(int i=0; i<word.length(); i++) {
            arrWord[i] = (int)word.charAt(i);
        }
        Arrays.sort(arrWord);
       
        
        System.out.println("----");
        for(int i=0; i<S.length(); i++) {
            arrS.add((int)S.charAt(i));
        }
        Collections.sort(arrS);
        

        

        // 이게 성공하면 있다는것. 

        while (arrS != null) {
            // for(int i=0; i<arrWord.length; i++) {
            //     // System.out.println("arrWord[i] : " + arrWord[i]);
            System.out.println("before arrS : " + arrS);
                arrS = compare(arrS, arrWord);
            //}
            System.out.println("cycle arrS : " + arrS);
            result = result + 1;
        }
        
        System.out.println("final result :  " + result);
        
        
        


        sc.close();
    }

    static ArrayList<Integer> compare(ArrayList<Integer> arrS, int[] arrWord) {
        ArrayList<Integer> returnValue = new ArrayList<>();
        for(int i=0; i<arrWord.length; i++) {
            int pc = binSearch(arrS, arrS.size(), arrWord[i]);
            if ( pc >= 0  ) {
                // 0보다 큰건 있다는 것이야.
                arrS.remove(pc);
                returnValue = arrS;
            } else {
                // 0보다 작으면 없어 -> 더이상 끝이야.
                returnValue = null;
                break;
            }
        }

        return returnValue;
    }

  
    static int binSearch(ArrayList<Integer> a, int n, int key) {
        int pl =0;
        int pr = n-1;

        do {
            int pc = (pl+pr) / 2;
            if(a.get(pc) == key) {
                return pc;
            } else if(a.get(pc) < key) {
                pl=pc + 1;
            } else {
                pr = pc -1;
            } 

            
        } while(pl <= pr);

        return -1;
    }
}