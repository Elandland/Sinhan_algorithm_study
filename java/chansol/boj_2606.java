package chansol;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class boj_2606 {

    static int node;
    static ArrayList<Integer>[] lin;  //그냥 내가 기억하기 쉽게 1번째 노드에 값 넣으려고 node+1개 만큼 배열 생성
    static boolean[] visit; //같은 이유(lin배열 만든거랑)
    static int virus_com = -1;  //무조건 1번 노드에서 시작할때 방문 안한 상태에서 시작하므로 1 더해져도 0 되게 설정

    public static void dfs(int node){
        if(!visit[node]){       //해당 노드의 방문 배열 값이 0 이면 -> 안 도착했으면
            virus_com++;
            visit[node]=true;
            //연결된 애들 lin[node]의 arraylist를 다 조사해야됨.
            for(int i=0; i<lin[node].size(); i++){      //이거 함수 밖으로 꺼내니까 stackoverflow겁나 뜨더라
                dfs(lin[node].get(i));
            }
        }
    }


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);


        node = sc.nextInt();        //노드 수를 받음
        int line = sc.nextInt();        //간선 수를 받음


        lin =  new ArrayList[node+1];
        visit = new boolean[node+1];

        for(int i=0; i<node+1; i++){        //똑같은 뜻. 1~7개 노드 만듦 (0번노드 비움)
            lin[i] = new ArrayList<>();     //각 노드 마다 arraylist로 만듦 (각 노드는 연결된 노드를 원소로 가짐)
        }

        for(int j=0; j<line; j++){
            int a = sc.nextInt();       //첫번째 연결될 노드
            int b = sc.nextInt();       //두번째 연결될 노드

            lin[a].add(b);      //1번째 적은애의 배열위치에 2번째 노드 연결
            lin[b].add(a);      //똑같이 2번째 적은애의 배열 위치에 1번째 노드 연결

        }

        dfs(1);     //1번 컴퓨터 걸렸을 때 몇개나 걸리나 출력

        System.out.println(virus_com);
    }

}
