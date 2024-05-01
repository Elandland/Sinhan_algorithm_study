package chansol.boj_7576;
import java.util.*;

public class boj_7576 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();   // 상자의 가로 칸 수
        int N = sc.nextInt();   // 상자의 세로 칸 수

        int[][] tomato = new int[M][N];

        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                tomato[i][j] = sc.nextInt();
            }
        }





    }


}
