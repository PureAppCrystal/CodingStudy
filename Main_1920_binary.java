import java.util.*;

public class Main_1920_binary{

    // 1920
    // 이분탐색
    // N개의 정수가 주어질때 특정 정수가 존재하는지 확인
    // 1<=N<=100000
    // # input
    // 5
    // 4 1 5 2 3
    // 5
    // 1 3 7 9 5
    // # output
    // 1 / 1 / 0 / 0 / 1


    /**
     * 이진탐색 함수
     * 검색대상 배열, 배열의 갯수, 찾을 값
     * 성공시 찾은 값, 없으면 -1
     */
    static int binSearch(int[] a, int n, int key) {
        int pl =0;
        int pr = n-1;

        do {
            int pc = (pl+pr) / 2;
            if(a[pc] == key) {
                return pc;
            } else if(a[pc] < key) {
                pl=pc + 1;
            } else {
                pr = pc -1;
            } 

            
        } while(pl <= pr);

        return -1;
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

    public int binSearch(String[] list,  String key) {
        int startNum = 0;
        int endNum = list.length -1;
        
        do {
            int count = (startNum+endNum) / 2;
            if(list[count].indexOf(key) == 0) {
                return count;
            } else if( Integer.parseInt(list[count].substring(0, key.length())) < Integer.parseInt(key)) {
                startNum=count + 1;
            } else {
                endNum = count -1;
            } 
        } while(startNum <= endNum);

        return -1;
    }

    public int binSearch(ArrayList<String> list, String key) {
        int startNum = 0;
        int endNum = list.size() - 1;

        do {
            int count = (startNum + endNum) / 2;
            if (list.get(count).indexOf(key) == 0) {
                return count;
            } else if (Integer.parseInt(list.get(count).substring(0, key.length())) < Integer.parseInt(key)) {
                startNum = count + 1;
            } else {
                endNum = count - 1;
            }
        } while (startNum <= endNum);

        return -1;
    }
    public static void main(String[] args) {
        

        
        
        


        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        if( N < 1 || N > 100000) {
            throw new NoSuchElementException();
        }
        //int arrA[] = {sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt()};
        ArrayList<Integer> arrA = new ArrayList<Integer>();
        for(int i=0; i<N; i++) {
            arrA.add(sc.nextInt());
        }
        Collections.sort(arrA);

        int M = sc.nextInt();
        if( M < 1 || M > 100000) {
            throw new NoSuchElementException();
        }
        ArrayList<Integer> arrB = new ArrayList<Integer>();
        for(int i=0; i<M; i++) {
            arrB.add(sc.nextInt());
        }
        

        ArrayList<Integer> arrResult = new ArrayList<Integer>();
        


        for(int i=0; i<M; i++) {
            int tartget = arrB.get(i);
            int result = binSearch(arrA, N, tartget);
            arrResult.add(result == -1 ? 0 : 1);
        }

        for(int i=0; i<arrResult.size(); i++) {
            System.out.println(arrResult.get(i));
        }
        
        sc.close();
    }
}