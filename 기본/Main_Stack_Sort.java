package 기본;
import java.util.*;


// Stack Sort  - 2개의 스택으로만 정렬하기 
public class Main_Stack_Sort {
 
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<Integer>();
        s1.push(3);
        s1.push(5);
        s1.push(1);
        s1.push(6);
        sort(s1);
        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println(s1.pop());
        
    }

    /**
     * 스택 두개 이용해서 정렬하기 - 오름차순
     * tmp 비교값을 변경에 따라 asc/desc 변경가능
     * @param s1
     */
    private static void sort(Stack<Integer> s1) {
        Stack<Integer> s2 = new Stack<Integer>();

        while(!s1.isEmpty()) {
            int tmp = s1.pop();
            while(!s2.isEmpty() && s2.peek() > tmp) {
                s1.push(s2.pop());
            }
            s2.push(tmp);
        }
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }
}