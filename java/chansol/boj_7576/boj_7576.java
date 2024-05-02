package chansol.boj_7576;

import java.util.*;

public class boj_7576 {

    private static int M;
    private static int N;
    static int min_date = 0;

    private static void bfs(int x, int y, int[][] graph, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<int[]>();
        int[] loc = {x, y};
        q.offer(loc);       //시작하는 위치.

        visited[x][y] = true;
        while (!q.isEmpty()) {
            int[] locate = q.poll();
            int i = locate[0];
            int j = locate[1];
            int count1 = 0;
            int count2 = 0;
            int count3 = 0;
            int count4 = 0;

            if (i - 1 >= 0) { //좌
                int[] temp = {i - 1, j};
                count1 = 0;
                if (!visited[i - 1][j]) {
                    count1++;
                    visited[i - 1][j] = true;
                    q.offer(temp);
                }
            }
            if (i + 1 < M) {        //우
                int[] temp = {i + 1, j};
                count2 = 0;
                if (!visited[i + 1][j]) {
                    count2++;
                    visited[i + 1][j] = true;
                    q.offer(temp);
                }
            }
            if (j - 1 >= 0) {       //상
                int[] temp = {i, j - 1};
                count3 = 0;
                if (!visited[i][j - 1]) {
                    count3++;
                    visited[i][j - 1] = true;
                    q.offer(temp);
                }
            }
            if (j + 1 < N) {        //하
                int[] temp = {i, j + 1};
                count4 = 0;
                if (!visited[i][j + 1]) {
                    count4++;
                    visited[i][j + 1] = true;
                    q.offer(temp);
                }
            }
            System.out.print(count1);
            System.out.print(count2);
            System.out.print(count3);
            System.out.println(count4);


            min_date += Math.max(Math.max(count1, count2), Math.max(count3, count4));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();   // 상자의 가로 칸 수
        N = sc.nextInt();   // 상자의 세로 칸 수

        int[][] tomato = new int[M][N];
        boolean[][] visit = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                tomato[i][j] = sc.nextInt();
                if (tomato[i][j] != 0) {
                    visit[i][j] = true;
                }
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (tomato[i][j] == 1) {
                    bfs(i, j, tomato, visit);       //시작점을 tomato의 배열값이 1인 좌표로 시작해야함.
                }
            }

            //bfs
            // tomato[][] ==1인 애부터 시작해서. 전후좌우 배열 검사. -1이면 검사 끝. 0인애들만 검사하도록 해서 visit한게 M*N - (-1이 있는 갯수) 가 다 되도록.


        }
        System.out.println(min_date);
    }
}


