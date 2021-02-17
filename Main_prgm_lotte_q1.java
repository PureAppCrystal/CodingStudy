import java.util.*;


/**
 * 자연수가 들어있는 배열 arr가 매개변수로 주어질 때, 
 * 배열 안의 숫자들 중 한 번씩만 나타나는(즉, 중복되어 나타나지 않는)
 *  숫자들만 오름차순으로 정렬하여 return 하도록 solution 함수를 완성해주세요. 
 * 만약 그러한 숫자가 없다면 배열에 -1을 채워서 return 하세요.
 */
public class Main_prgm_lotte_q1 {
    public static void main(String[] args) {

        int [] input = 	{2, 1, 3, 3};
        // int [] input = 	{3, 5, 3, 5, 7, 5, 7};
        int[] result = solution(input);
        System.out.println("result : " + result);
    }
    
    static public int[] solution(int[] arr) {
       int [] answer = new int[1] ;

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {

        }

        // for (int i = 0; i < list.length; i++) {
        //     int val1 = list[i];
        //     for (int j = 0; j < list.length; j++) {
        //         if (i == j) continue;
        //         int val2 = list[j];
        //         if (val1 == val2) {
        //             System.out.println("중복 => " + i + ". " + val1);
        //             break;
        //         }
        //     }
        // }




        // ArrayList<Integer> arrayList = new ArrayList<>();
        // ArrayList<Integer> resultList = new ArrayList<>();

        // for(int temp : arr){
        //     arrayList.add(temp);
        // }


        // while(true) {
        //     Arrays.copyOfRange(arr, from, to)
        // }





    
    
    
    






        // int [] temp = new int[arr.length+1];
        // int [] result = new int[arr.length];
        
        
        // for(int i=0; i<arr.length; i++){
        //     System.out.println("## " +i);
        //     temp[arr[i]] += 1;
        // }

        // int findCount = 0;
        // for(int i=0; i<temp.length; i++) {
        //     if ( temp[i] == 1 ) {
        //         result[findCount] = i;
        //         findCount += 1;
        //     }
        // }

        // if(findCount ==0) {
        //     answer[0] = -1;
        // } else {
        //     answer = new int[findCount];
        //     for(int i=0; i<findCount; i++) {
        //         answer[i] = result[i];
        //         System.out.println(answer[i]);
        //     }
        // }


       
        return answer;
    }
}


// 자바스크립트로 제출
/**
 * function solution(arr) {
    var answer = [];
    var duplicate =[];
    arr = arr.sort();
    arr.sort(function (f, s) { return f-s; });

    console.log(arr)
    return;
    console.log(arr);
    var tempArr = JSON.parse(JSON.stringify(arr));
    
    for(var i=0; i<arr.length; i++) {
      console.log("======")
      
    	console.log("target value  : " , arr[i])
      
      
      tempArr = tempArr.splice(1, arr.length);
      if(duplicate.indexOf(arr[i]) >=0 ) continue;
      console.log("tempArr : ", tempArr)
      
      var findIndex = tempArr.lastIndexOf(arr[i]);
      console.log("findIndex: ", findIndex)
      if (findIndex < 0 ) {
      	answer.push(arr[i])
      } else {
      	duplicate.push(arr[i]);
      }
    }
    
    if(answer.length==0) answer.push(-1)
    
    return answer;
}
 */