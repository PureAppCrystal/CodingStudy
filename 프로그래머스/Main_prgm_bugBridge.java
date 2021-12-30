package 프로그래머스;
import java.util.ArrayList;

/**
 * 프로그래머스 스택/큐 다리를 건너는 버스 
 * 큐를 이용한 문제
 */

// 다리는 길이와 현재무게, 최고무게를 가지고 있는다.
class Bridge {

    
    // 트럭은 무게와 현재 위치정보를 가지고 있는다.
    class Truck {
        int weight;
        int position;
        public Truck(int weight, int position) {
            this.weight = weight;
            this.position = position;
        }

        // 움직일때마다 현재 위치정보가 감소한다
        public void move () {
            this.position = this.position - 1;
        }
    }


    int length;
    int nowWeight;
    int maxWeight;
    ArrayList<Truck> list = new ArrayList<Truck>();

    // 생성시 길이와 최대 무기를 설정한다.
    public Bridge(int length, int maxWeight) {
        this.length = length;
        this.maxWeight = maxWeight;
    }

    // 현재 다리 무게 + 트럭 무게가 최대 다리 무게를 넘지 않으면 추가한다.
    public boolean addTruck(int truckWeight) {
        boolean returnValue = false;
        if(this.nowWeight + truckWeight <= maxWeight ) {
            list.add(new Truck(truckWeight, this.length));
            this.nowWeight += truckWeight;
            returnValue = true;
        } 
        return returnValue;
    }

    // 매번 체크한다.  트럭들의 위치를 옮기며 다리 길이를 초과된 트럭은 삭제한다.
    public void check() {
        ArrayList<Truck> deleteBox = new ArrayList<Truck>();
        for(Truck truck : list) {
            truck.move();
            if(truck.position < 1) {
                this.nowWeight = this.nowWeight - truck.weight;
                deleteBox.add(truck);
            }
        }

        for(Truck truck: deleteBox) {
            list.remove(truck);
        }
    }
}

public class Main_prgm_bugBridge {
    public static void main(String[] args) {

        int [] truck_weights = {7,4,5,6};
        int result = solution(2, 10, truck_weights);
        
    }

    static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int truckCount = 0;

        Bridge bridge = new Bridge(bridge_length, weight);

        do  {
            answer += 1;
            bridge.check();
            if ( truckCount < truck_weights.length && bridge.addTruck(truck_weights[truckCount]) ) {
                truckCount += 1;
            }

        } while (bridge.list.size() > 0  ); 

        return answer;
    }
    
}
