package 프로그래머스;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

// https://programmers.co.kr/learn/courses/30/lessons/42888?language=java
public class 오픈채팅방 {
    


    public static void main(String[] args) {
        String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
                "Change uid4567 Ryan" };

        // String[] result = solution(record);
        String[] result = solution2(record);
        System.out.println("result : " + result);
    }


    /**
     * Second Challange
     * -> 첫번째 결과보다 결과적으로 조금더 빠르다. 
     * -> 적은 수의 결과는 첫번째 결과가 더 빠르지만
     * -> 첫번째에서 200이 넘는 결과들이 두번째에서는 절반정도의 결과가나왔다.
     * @param record
     * @return
     */
    public static String[] solution2(String[] record) {
        String[] answer = {};
        String ENTER = "Enter";
        String LEAVE = "Leave";
        String CHANGE = "Change";

        
        // 사용자 정보 클래스
        class User {
            String id;
            String nick;

            public User(String id, String nick) {
                this.id = id;
                this.nick = nick;
            }

            public void setNick(String nick) {
                this.nick = nick;
            }

            public String getNick() {
                return this.nick;
            }
        }

        HashMap<String, User> userList = new HashMap<String, User>();

        // 로그 히스토리 클래스 
        class History {
            String id;
            String action;

            public History(String id, String action) {
                this.id = id;
                this.action = action;
            }

            public String getHistoryMessage() {
                System.out.println(" action : + " + action);
                return userList.get(id).getNick() + "님이 " + (action.equals(ENTER) ? "들어왔습니다." : "나갔습니다.");
            }
        }
        
        ArrayList<History> historyList = new ArrayList<History>();
        


        // 이벤트 별로 User 및 History 정리 
        for (String event : record) {
            String[] datas = event.split(" ");
            String action = datas[0];
            String id = datas[1];

            if (action.equals(ENTER)) {
                if (userList.containsKey(id)) {
                    userList.get(id).setNick(datas[2]);
                } else {
                    userList.put(id, new User(id, datas[2]));
                }
                historyList.add(new History(id, action));
            } else if (action.equals(LEAVE)) {
                historyList.add(new History(id, action));
            } else if (action.equals(CHANGE)) {
                userList.get(id).setNick(datas[2]);
            }
        }
        
        // History 별로 결과물 작성
        answer = new String[historyList.size()];
        for (int i = 0; i < historyList.size(); i++) {
            answer[i] = historyList.get(i).getHistoryMessage();
        }
     
        return answer;
    }
    






    
    /**
     * First Challange
     * 첫번재 도전 : 간단한건 더 빠름. 복잡한건 느림 
     * @param record
     * @return
     */
    public static String[] solution(String[] record) {
        String[] answer = {};
        HashMap<String, String> accounts = new HashMap<String, String>();
        

        for (String event : record) {
            String[] datas = event.split(" ");
            if (datas[0].equals("Enter") || datas[0].equals("Change")) {
                if (checkReg(datas[2])) {
                    accounts.put(datas[1], datas[2]);
                }
            }
        }
        
        ArrayList<String> list = new ArrayList<String>();
        for (String event : record) {
            String[] datas = event.split(" ");
            if (datas[0].equals("Enter")) {
                list.add( accounts.get(datas[1]) + "님이 들어왔습니다.");
            } else if (datas[0].equals("Leave")) {
                list.add( accounts.get(datas[1]) + "님이 나갔습니다.");
            } 
        }
        
        answer = new String[list.size()];
        answer = list.toArray(answer);
        return answer;
    }
    
    /**
     * ID,NickName 포맷 확인
     * -> 필요 없는 함수였네?
     * @param value 체크 대상
     * @return 성공/실패
     */
    public static boolean checkReg(String value) {
        boolean returnValue = false;

        String regex = "^[0-9a-zA-Z]{1,10}$";
        if (Pattern.matches(regex, value)) {
            returnValue = true;
        }
        
        return returnValue;
    }


}
