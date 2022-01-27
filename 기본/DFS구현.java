package 기본;

import java.util.LinkedList;
import java.util.Stack;

public class DFS구현 {

    public static void main(String[] args) {
        //
        //  DPS_탐색선수.dfs(1);
        //
        // DfsGraph dfsGraph = new DfsGraph(8);
        // dfsGraph.put(1, 2);
        // dfsGraph.put(1, 3);
        // dfsGraph.put(2, 4);
        // dfsGraph.put(2, 5);
        // dfsGraph.put(3, 6);
        // dfsGraph.put(3, 7);
        // dfsGraph.put(4, 8);
        // dfsGraph.put(5, 8);
        // dfsGraph.put(6, 8);
        // dfsGraph.put(7, 8);
        // dfsGraph.printGraphToAdjArr();
        // System.out.print("정점 1부터 탐색 : ");
        // dfsGraph.dfs(1);

        //
        Graph g = new Graph(6);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 5);
		
		// g.dfs(0);
        g.dfs(1);
        







    }

}



class Graph {

    class Node {
        int data;
        LinkedList<Node> adj;
        boolean marked;

        public Node(int data) {
            this.data = data;
            this.marked = false;
            adj = new LinkedList<Node>();
        }
    }

    Node[] nodes;

    Graph(int size) {
        nodes = new Node[size];
        for (int i=0; i<size; i++) {
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        if(!n1.adj.contains(n2)) {
            n1.adj.add(n2);
        }
        if(!n2.adj.contains(n1)) {
            n2.adj.add(n1);
        }
    }

    void dfs() {
        dfs(0);
    }

    void dfs(int index) {
        Node root = nodes[index];
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        root.marked = true;

        while (!stack.isEmpty()) {
            Node r = stack.pop();
            for(Node n : r.adj) {
                if(n.marked == false ) {
                    n.marked = true;
                    stack.push(n);
                }
            }
            // visit(r);
            System.out.println("["+r.data+"]");
        }
    }
}


/**
 * 2번재
 */
class DfsGraph {
    private int n; // 노드의 개수?
    private int[][] dfsGraph; // 그래프
    private boolean[] visited; // 방문여부

    public DfsGraph(int n) {
        this.n = n;

        // 그래프 초기화
        this.dfsGraph = new int[n + 1][n + 1];

        // 방문 초기화
        this.visited = new boolean[n + 1];
    }

    // 그래프 얻기
    public int[][] getGraph() {
        return this.dfsGraph;
    }

    // 그래프 추가(양방향)
    public void put(int x, int y) {
        this.dfsGraph[x][y] = this.dfsGraph[y][x] = 1;
    }

    // 그래프 추가 (단방향)
    public void putSingle(int x, int y) {
        this.dfsGraph[x][y] = 1;
    }

    // 그래프 출력 (인접행렬) 
    public void printGraphToAdjArr() {
        for (int i = 0; i < this.dfsGraph.length; i++) {
            for (int j = 0; j < this.dfsGraph[i].length; j++) {
                System.out.print(" " + this.dfsGraph[i][j]);
            }
            System.out.println();
        }
    }

    // 정점 방문 여부 확인 배열 초기화 -> 다 false로
    public void clearVisitedArr() {
        for (int i = 0; i < this.visited.length; i++) {
            this.visited[i] = false;
        }
    }

    // 그래프 탐색 ( 재귀호출 )
    public void dfs(int val) {
        this.visited[val] = true;
        System.out.print(val + " ");

        // 인접행렬로 구현된...그래프에서 정점의 개수 만큼 탁색
        for (int i = 1; i <= this.n; i++) {
            if (dfsGraph[val][i] == 1 && visited[i] == false) {
                dfs(i);
            }
        }
    }


}


/**
 * 1번째 탐색순서 확인
 */
class DPS_탐색선수 {
    static boolean[] visited = new boolean[9];
    static int[][] graph = { {}, { 2, 3, 8 }, { 1, 6, 8 }, { 1, 5 }, { 5, 7 }, { 3, 4, 7 }, { 2 }, { 4, 5 }, { 1, 2 } };

    static void dfs(int nodeIndex) {
        // 방문 처리
        visited[nodeIndex] = true;
        // 방문 노드 출력
        System.out.print(nodeIndex + " -> ");
        // 방문한 노드에 인접한 노드 찾기
        for (int node : graph[nodeIndex]) {
            // 인접한 노드가 방문한 적이 없다면 DFS 수행
            if (!visited[node]) {
                dfs(node);
            }
        }
    }
}

