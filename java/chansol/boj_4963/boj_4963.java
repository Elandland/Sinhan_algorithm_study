package chansol.boj_4963;

import java.util.*;

public class boj_4963 {
    public static void main(String[] ars){

        //섬 끼리 되는걸 어레이 리스트에 넣어서 인덱스 수를 섬 갯수로 하면 될듯?

        int island_cnt=0;
        Scanner sc = new Scanner(System.in);

        while(true){
            int w = sc.nextInt();       //몇열인지
            int h = sc.nextInt();       //몇행인지

            if(w==0&&h==0){         //exit
                break;
            }

            int[][] map = new int[h][w];        //h행w열

            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++) {
                    map[i][j] = sc.nextInt();
                }
            }



        }

        System.out.println(island_cnt);
    }
}
