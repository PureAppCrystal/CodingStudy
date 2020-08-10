import java.util.*;


class Rule {
    int firstBox;
    int lastBox;
    int interval;

    public Rule() {

    }

    public Rule(int f, int l, int i) {
        this.firstBox = f;
        this.lastBox = l;
        this.interval = i;
    }
}

public class Main_15732 {

    public static void main(String[] args) {
        
        // 15732
        // 상자 갯수, 규칙 갯수, 도토리 갯수
        // 규칙 : 시작상자 번호, 종료상자 번호, 간격
        // -> 시간초과 : 이분탐색부터 할줄 알아야 한다.

        Scanner sc = new Scanner(System.in);
        
        int boxCnt = sc.nextInt();
        int ruleCnt = sc.nextInt();
        int dotCnt = sc.nextInt();
        // test
        // int boxCnt = 200;
        // int ruleCnt = 3;
        // int dotCnt = 1;

        ArrayList<Rule> arrRule = new ArrayList<Rule>();
        //Map<String, Object> arrRule = new HashMap<String, Object>();
        

        for(int i=0; i<ruleCnt; i++) {
            int fBox = sc.nextInt();
            int lBox = sc.nextInt();
            int intv = sc.nextInt();
            //arrRule.put(fBox, new Rule(fBox, lBox, intv));

        }

        
        //test
        // arrRule.add(new Rule(100, 150, 10));
        // arrRule.add(new Rule(110, 200, 20));
        // arrRule.add(new Rule(120, 200, 20));


        // logic 1
        // int nowBoxNum = 1000001;
        
        // int resultBoxNum =0;
        // int ruleNum = -1;

        // while(dotCnt > 0) {
        //     int tempNum = 1000001;

        //     for(int i=0; i<arrRule.size(); i++) {
        //         // System.out.println("sBox["+i+"] check : "+arrRule.get(i).firstBox+", " + +arrRule.get(i).lastBox+", "+ +arrRule.get(i).interval);
        //         int fb = arrRule.get(i).firstBox;
        //         int lb = arrRule.get(i).lastBox;
                
           

        //         if( nowBoxNum != 1000001 && nowBoxNum > boxCnt) {
        //             dotCnt = 0;
        //         }

        //         if( nowBoxNum != 1000001 && nowBoxNum > lb) {
        //             // System.out.println("over lb -> continue;");
        //             continue;
        //         }
        //         // System.out.println("tempNum : " + tempNum);
        //         // System.out.println("fb : " + fb);
        //         if( tempNum > fb ) {
        //             ruleNum = i;
        //             tempNum = fb;
        //         }
        //     }
            
        //     // System.out.println("ruleNum : "+ruleNum);
            
        //     nowBoxNum = arrRule.get(ruleNum).firstBox + arrRule.get(ruleNum).interval;
        //     resultBoxNum = arrRule.get(ruleNum).firstBox;
        //     arrRule.get(ruleNum).firstBox = arrRule.get(ruleNum).firstBox + arrRule.get(ruleNum).interval;
        //     dotCnt--;

        // }
        // System.out.println(resultBoxNum);



        


        
        sc.close();
    }
}