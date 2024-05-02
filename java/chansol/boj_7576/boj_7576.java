package chansol.boj_7576;

import java.util.*;

public class boj_7576 {

    private static int M;
    private static int N;
    static int min_date = 0;


    private static void bfs(int[][]tomato,boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        int oneday_tomato =0; //하루에 동시에 익는 토마토 갯수.

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (tomato[i][j] == 1) {
                    int[] loc = {i, j};
                    q.offer(loc);
                }
            }
        }           //시작할때 1이 여러개면 q에 여러개가 들어가있는 상태 여야 함.




        while (!q.isEmpty()) {

            int size = q.size();        //큐 사이즈
            for(int k=0; k<size; k++) {
                int[] locate = q.poll();
                int i = locate[0];
                int j = locate[1];


                if (i - 1 >= 0) { //좌
                    int[] temp = {i - 1, j};
                    if (!visited[i - 1][j]) {
                        oneday_tomato++;
                        visited[i - 1][j] = true;
                        q.offer(temp);
                    }
                }
                if (i + 1 < M) {        //우
                    int[] temp = {i + 1, j};
                    if (!visited[i + 1][j]) {
                        oneday_tomato++;
                        visited[i + 1][j] = true;
                        q.offer(temp);
                    }
                }
                if (j - 1 >= 0) {       //상
                    int[] temp = {i, j - 1};
                    if (!visited[i][j - 1]) {
                        oneday_tomato++;
                        visited[i][j - 1] = true;
                        q.offer(temp);
                    }
                }
                if (j + 1 < N) {        //하
                    int[] temp = {i, j + 1};
                    if (!visited[i][j + 1]) {
                        oneday_tomato++;
                        visited[i][j + 1] = true;
                        q.offer(temp);
                    }
                }
            }

            if (oneday_tomato > 0) {
                min_date++;
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();   // 상자의 가로 칸 수  ->아니 이게 행인줄알았네;; 이게 열이네
        M = sc.nextInt();   // 상자의 세로 칸 수  ->아니 이게 열인줄 알았네, 이게 행이네

        int[][] tomato = new int[M][N];
        boolean[][] visit = new boolean[M][N];
        int check =0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                tomato[i][j] = sc.nextInt();
                if (tomato[i][j] != 0) {
                    visit[i][j] = true;
                }
            }
        }
        bfs(tomato, visit);       //시작점을 tomato의 배열값이 1인 좌표로 시작해야함.


            //bfs
            // tomato[][] ==1인 애부터 시작해서. 전후좌우 배열 검사. -1이면 검사 끝. 0인애들만 검사하도록 해서 visit한게 M*N - (-1이 있는 갯수) 가 다 되도록

        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(visit[i][j]){
                    check++;
                }
            }
        }
        if(check==(M*N)) {
            if(min_date>0) {
                System.out.println(min_date - 1);
            }
            else{
                System.out.println(min_date );
            }
        }

        else
            System.out.println("-1");
    }

}


