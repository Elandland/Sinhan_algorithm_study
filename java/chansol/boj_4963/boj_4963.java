package chansol.boj_4963;

import java.util.*;

public class boj_4963 {
    static int island_cnt;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {0,0,-1,1,-1,1,1,-1 };                 //상하좌우 왼쪽대각선부터 시계방향

    static int[] dy = {1,-1,0,0,1,1,-1,-1};

    static int w;
    static int h;
    private static void dfs(int x,int y){
        if(!visit[x][y]){
            visit[x][y] = true;
            for(int i=0; i<8; i++){
                if(x+dx[i]>=0 && y+dy[i]>=0 && x+dx[i]<w && y+dy[i]<h){
                    if(map[x+dx[i]][y+dy[i]]==1&& !visit[x+dx[i]][y+dy[i]]){
                        dfs(x+dx[i],y+dy[i]);
                    }
                }
            }
        }
    }
    public static void main(String[] ars){

        //섬 끼리 되는걸 어레이 리스트에 넣어서 인덱스 수를 섬 갯수로 하면 될듯?     그냥 dfs쓰면 굳이 인덱스 안하고 cnt로 해도되겠다.

        Scanner sc = new Scanner(System.in);


        while(true){
            island_cnt = 0;
            h = sc.nextInt();       //몇행인지
            w = sc.nextInt();       //몇열인지


            if(w==0&&h==0){         //exit
                break;
            }

            map = new int[w][h];        //h행w열
            visit = new boolean[w][h];

            for(int i=0; i<w; i++){
                for(int j=0; j<h; j++) {
                    map[i][j] = sc.nextInt();
                }
            }


            for(int i=0; i<w; i++){
                for(int j=0; j<h; j++) {


                    if(map[i][j]==1 && !visit[i][j]) {
                        dfs(i, j);       //돌면서 연결된 애들 다 방문하니까 섬 한개가 만들어짐
                        island_cnt++;
                    }
                }
            }

            System.out.println(island_cnt);
        }
    }
}
